package com.example.SustechStore.controller;

import com.example.SustechStore.annotations.NeedEncrypt;
import com.example.SustechStore.bean.ResponseBean;
import com.example.SustechStore.service.GoodService;

import com.example.SustechStore.util.AESUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Api(tags = "首页接口")
@RestController
@RequestMapping("/toppage")
public class ToppageController {
    private static final byte[] key = "9f5d54580044d478".getBytes(StandardCharsets.UTF_8);
    @Autowired
    private GoodService goodService;

    @NeedEncrypt
    @RequestMapping(value = "/nextPage/{time}/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public ResponseBean<Object> nextPage(@PathVariable String time, @PathVariable String pageNum, @PathVariable String pageSize) {
        AESUtil aesUtil = new AESUtil();
        time = aesUtil.decryptHex(time, key);
        pageNum = aesUtil.decryptHex(pageNum, key);
        pageSize = aesUtil.decryptHex(pageSize, key);
        Timestamp timestamp = Timestamp.valueOf(time);
        return ResponseBean.success(goodService.selectGoodByPage(timestamp, Integer.parseInt(pageNum), Integer.parseInt(pageSize)));
    }
}

