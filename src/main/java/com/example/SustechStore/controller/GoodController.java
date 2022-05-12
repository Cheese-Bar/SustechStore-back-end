package com.example.SustechStore.controller;

import com.example.SustechStore.annotations.NeedEncrypt;
import com.example.SustechStore.bean.ResponseBean;
import com.example.SustechStore.service.GoodService;
import com.example.SustechStore.util.AESUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@Api(tags = "商品详情接口")
@RestController
public class GoodController {
    private static final byte[] key = "9f5d54580044d478".getBytes(StandardCharsets.UTF_8);
    @Autowired
    private GoodService goodService;

    @ApiOperation(value = "为当前用户获得该商品的详细信息")
    @NeedEncrypt
    @GetMapping(value = "/good_detail/{user_id}/{good_id}")
    ResponseBean<Object> getGoodDetail2(@PathVariable String user_id,
                                @PathVariable String good_id){
        AESUtil aesUtil = new AESUtil();
        user_id=aesUtil.decryptHex(user_id,key);
        good_id=aesUtil.decryptHex(good_id,key);
        return ResponseBean.success(goodService.findGoodDetail(user_id==null?-1:Integer.parseInt(user_id), Integer.parseInt(good_id)));
    }
}
