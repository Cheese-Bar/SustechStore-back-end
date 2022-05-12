package com.example.SustechStore.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.SustechStore.annotations.NeedDecrypt;
import com.example.SustechStore.annotations.NeedEncrypt;
import com.example.SustechStore.bean.ResponseBean;
import com.example.SustechStore.service.ReceiveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "接收发布表单")
@RestController
@RequestMapping("/receive")
public class ReceiveController {

    @Autowired
    ReceiveService receiveService;

    @ApiOperation(value = "发布商品")
    @NeedEncrypt
    @NeedDecrypt
    @PostMapping(value = "/add-goods-detail")
    public ResponseBean<Object> addGoodDetail(@RequestBody String stringJson) {
        System.out.println("1:" + stringJson);
        JSONObject jsonObject = JSONObject.parseObject(stringJson);
        return ResponseBean.success(receiveService.addGoodDetail(jsonObject));
    }

    @ApiOperation(value = "获取所有地址")
    @NeedEncrypt
    @GetMapping(value = "/getAddresses")
    public ResponseBean<Object> getAddresses() {
        return ResponseBean.success(receiveService.getAllAddress());
    }

    @NeedEncrypt
    @ApiOperation(value = "获取所有地址")
    @GetMapping(value = "/getLabels")
    public ResponseBean<Object> getLabels() {
        return ResponseBean.success(receiveService.getAllLabels());
    }
}
