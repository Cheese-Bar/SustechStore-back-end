package com.example.SustechStore.controller;

import com.example.SustechStore.annotations.NeedEncrypt;
import com.example.SustechStore.bean.ResponseBean;
import com.example.SustechStore.service.OrderService;
import com.example.SustechStore.util.AESUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Api(tags = "订单接口")
@RestController
@RequestMapping("/order")
public class OrderController {
    private static final byte[] key = "9f5d54580044d478".getBytes(StandardCharsets.UTF_8);
    @Autowired
    OrderService orderService;

    @ApiOperation(value = "我卖出的")
    @NeedEncrypt
    @GetMapping(value = "/bySeller/{id}/{pageNum}/{pageSize}/{timestamp}/{type}/{orderNum}/{goodState}")
    ResponseBean<Object> selectBySellerId2(@PathVariable String id,
                                           @PathVariable String pageNum,
                                           @PathVariable String pageSize,
                                           @PathVariable String timestamp,
                                           @PathVariable String type,
                                           @PathVariable String orderNum,
                                           @PathVariable String goodState) {
        AESUtil aesUtil = new AESUtil();
        id = aesUtil.decryptHex(id, key);
        pageNum = aesUtil.decryptHex(pageNum, key);
        pageSize = aesUtil.decryptHex(pageSize, key);
        timestamp = aesUtil.decryptHex(timestamp, key);
        type = aesUtil.decryptHex(type, key);

        orderNum = aesUtil.decryptHex(orderNum, key);
        goodState = aesUtil.decryptHex(goodState, key);
        return ResponseBean.success(orderService.selectBySellerId(Integer.parseInt(id), pageNum == null ? 0 : Integer.parseInt(pageNum),
                pageSize == null ? 999 : Integer.parseInt(pageSize),
                timestamp != null ? Timestamp.valueOf(timestamp) : new Timestamp(System.currentTimeMillis()),
                type == null ? -1 : Integer.parseInt(type), Integer.parseInt(orderNum),
                Integer.parseInt(goodState)));
    }

    @ApiOperation(value = "我买入的")
    @NeedEncrypt
    @GetMapping(value = "/byBuyer/{id}/{pageNum}/{pageSize}/{timestamp}/{type}/{orderNum}/{goodState}")
    ResponseBean<Object> selectByBuyerId2(@PathVariable String id,
                                          @PathVariable String pageNum,
                                          @PathVariable String pageSize,
                                          @PathVariable String timestamp,
                                          @PathVariable String type,
                                          @PathVariable String orderNum,
                                          @PathVariable String goodState) {
        AESUtil aesUtil = new AESUtil();
        id = aesUtil.decryptHex(id, key);
        pageNum = aesUtil.decryptHex(pageNum, key);
        pageSize = aesUtil.decryptHex(pageSize, key);
        timestamp = aesUtil.decryptHex(timestamp, key);
        type = aesUtil.decryptHex(type, key);
        orderNum = aesUtil.decryptHex(orderNum, key);
        goodState = aesUtil.decryptHex(goodState, key);

        return ResponseBean.success(orderService.selectByBuyerId(Integer.parseInt(id), pageNum == null ? 0 : Integer.parseInt(pageNum),
                pageSize == null ? 999 : Integer.parseInt(pageSize),
                timestamp != null ? Timestamp.valueOf(timestamp) : new Timestamp(System.currentTimeMillis()),
                type == null ? -1 : Integer.parseInt(type), Integer.parseInt(orderNum),
                Integer.parseInt(goodState))
        );
    }

    @ApiOperation(value = "购买商品")
    @NeedEncrypt
    @GetMapping(value = "/buyGood/{userId}/{goodId}")
    ResponseBean<Object> buyGood(@PathVariable String userId,
                                 @PathVariable String goodId) {
        AESUtil aesUtil = new AESUtil();
        userId = aesUtil.decryptHex(userId, key);
        goodId = aesUtil.decryptHex(goodId, key);
        return ResponseBean.success(orderService.buyGood(Integer.parseInt(userId), Integer.parseInt(goodId)));
    }

}
