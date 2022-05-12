package com.example.SustechStore.controller;

import com.example.SustechStore.annotations.NeedEncrypt;
import com.example.SustechStore.bean.ResponseBean;
import com.example.SustechStore.service.CatService;
import com.example.SustechStore.util.AESUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;

@Api(tags = "分类界面接口")
@RestController
public class CatController {
    private static final byte[] key = "9f5d54580044d478".getBytes(StandardCharsets.UTF_8);
    @Autowired
    private CatService catService;

    @ApiOperation(value = "商品简略信息显示")
    @NeedEncrypt
    @GetMapping(value = "/category/buy/{cat_id}/{pageNum}/{pageSize}/{type}/{time}")
    ResponseBean<Object> findCatPageDetail2(
            @ApiParam(value = "分类编号", required = true) @PathVariable String cat_id,
            @PathVariable String pageNum,
            @PathVariable String pageSize,
            @PathVariable String type,
            @PathVariable String time) {
        AESUtil aesUtil = new AESUtil();
        cat_id = aesUtil.decryptHex(cat_id, key);
        pageNum = aesUtil.decryptHex(pageNum, key);
        pageSize = aesUtil.decryptHex(pageSize, key);
        type = aesUtil.decryptHex(type, key);
        time = aesUtil.decryptHex(time, key);
        return ResponseBean.success(catService.findCatPageDetail(
                (cat_id), time != null ? Timestamp.valueOf(time) : new Timestamp(System.currentTimeMillis()), Integer.parseInt(pageNum), Integer.parseInt(pageSize), Integer.parseInt(type)));
    }

    @ApiOperation(value = "分类界面初始化")
    @NeedEncrypt
    @GetMapping(value = "/init/{type}")
    ResponseBean<Object> init(@PathVariable String type) {
        AESUtil aesUtil = new AESUtil();
        type = aesUtil.decryptHex(type, key);
        return ResponseBean.success(catService.init(Integer.parseInt(type)));
    }


}
