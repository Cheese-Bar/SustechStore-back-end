package com.example.SustechStore.controller;


import com.example.SustechStore.annotations.NeedEncrypt;
import com.example.SustechStore.bean.ResponseBean;
import com.example.SustechStore.service.CollectService;
import com.example.SustechStore.util.AESUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;

@Api(tags = "我的界面数据调用接口")
@RestController
@RequestMapping("/Collect")
public class CollectController {
    private static final byte[] key = "9f5d54580044d478".getBytes(StandardCharsets.UTF_8);
    @Autowired
    private CollectService collectService;

    @ApiOperation(value = "界面初始化")
    @NeedEncrypt
    @GetMapping(value = "/init/{userId}")
    public ResponseBean<Object> initStatic(
            @ApiParam(value = "用户的userId", required = true) @PathVariable String userId) {
        AESUtil aesUtil = new AESUtil();
        userId = aesUtil.decryptHex(userId, key);
        System.out.println(userId);
        return ResponseBean.success(collectService.collectInit(new Timestamp(System.currentTimeMillis()), Integer.parseInt(userId)));
    }

    @ApiOperation(value = "获取用户喜欢的商品列表,并根据所选参数排序")
    @NeedEncrypt
    @RequestMapping(value = "/favorite/{userId}/{time}/{pageNum}/{pageSize}/{orderNum}/{goodState}/{type}", method = RequestMethod.GET)
    public ResponseBean<Object> getFavorite(
            @PathVariable String userId,
            @ApiParam(value = "时间戳", required = true) @PathVariable String time,
            @PathVariable String pageNum,
            @PathVariable String pageSize,
            @ApiParam(value = "排序方法码：10时间降序/11时间升序/20价格降序/21价格升序", required = true) @PathVariable String orderNum,
            @ApiParam(value = "商品状态码： -1不适用该属性筛选/1在售商品/2已完成交易的商品/3主动下架的商品", required = true) @PathVariable String goodState,
            @ApiParam(value = "商品类别： -1不使用该属性筛选/1货架商品/2求购商品", required = true) @PathVariable String type) {
        AESUtil aesUtil = new AESUtil();
        userId = aesUtil.decryptHex(userId, key);
        time = aesUtil.decryptHex(time, key);
        pageNum = aesUtil.decryptHex(pageNum, key);
        pageSize = aesUtil.decryptHex(pageSize, key);
        orderNum = aesUtil.decryptHex(orderNum, key);
        goodState = aesUtil.decryptHex(goodState, key);
        type = aesUtil.decryptHex(type, key);

        Timestamp timestamp = Timestamp.valueOf(time);
        return ResponseBean.success(
                collectService.getFavorite(timestamp, Integer.parseInt(userId),
                        Integer.parseInt(pageNum), Integer.parseInt(pageSize),
                        Integer.parseInt(orderNum), Integer.parseInt(goodState),
                        Integer.parseInt(type)
                ));
    }

    @ApiOperation(value = "获取用户浏览足迹的商品列表,并根据所选参数排序")
    @NeedEncrypt
    @RequestMapping(value = "/footPrint/{userId}/{time}/{pageNum}/{pageSize}/{orderNum}/{goodState}/{type}", method = RequestMethod.GET)
    public ResponseBean<Object> getFootPrint(
            @PathVariable String userId,
            @ApiParam(value = "时间戳", required = true) @PathVariable String time,
            @PathVariable String pageNum,
            @PathVariable String pageSize,
            @ApiParam(value = "排序方法码：10时间降序/11时间升序/20价格降序/21价格升序", required = true) @PathVariable String orderNum,
            @ApiParam(value = "商品状态码： -1不适用该属性筛选/1在售商品/2已完成交易的商品/3主动下架的商品", required = true) @PathVariable String goodState,
            @ApiParam(value = "商品类别： -1不使用该属性筛选/1货架商品/2求购商品", required = true) @PathVariable String type) {
        AESUtil aesUtil = new AESUtil();
        userId = aesUtil.decryptHex(userId, key);
        time = aesUtil.decryptHex(time, key);
        pageNum = aesUtil.decryptHex(pageNum, key);
        pageSize = aesUtil.decryptHex(pageSize, key);
        orderNum = aesUtil.decryptHex(orderNum, key);
        goodState = aesUtil.decryptHex(goodState, key);
        type = aesUtil.decryptHex(type, key);


        Timestamp timestamp = Timestamp.valueOf(time);
        return ResponseBean.success(
                collectService.getFootPrint(timestamp, Integer.parseInt(userId),
                        Integer.parseInt(pageNum), Integer.parseInt(pageSize),
                        Integer.parseInt(orderNum), Integer.parseInt(goodState),
                        Integer.parseInt(type)));
    }

    @ApiOperation(value = "更新当前用户-商品的喜欢状态")
    @NeedEncrypt
    @RequestMapping(value = "/updateFavorite/{userId}/{goodId}", method = RequestMethod.GET)
    public ResponseBean<Object> updateFavorite(@PathVariable String userId, @PathVariable String goodId) {
        AESUtil aesUtil = new AESUtil();
        userId = aesUtil.decryptHex(userId, key);
        goodId = aesUtil.decryptHex(goodId, key);
        return ResponseBean.success(collectService.updateFavorite(Integer.parseInt(userId), Integer.parseInt(goodId)));
    }

    @ApiOperation(value = "下架商品")
    @NeedEncrypt
    @RequestMapping(value = "/deleteGood/{userId}/{goodId}", method = RequestMethod.GET)
    public ResponseBean<Object> deleteGood(@PathVariable String userId, @PathVariable String goodId) {
        AESUtil aesUtil = new AESUtil();
        userId = aesUtil.decryptHex(userId, key);
        goodId = aesUtil.decryptHex(goodId, key);
        return ResponseBean.success(collectService.deleteGood(Integer.parseInt(userId), Integer.parseInt(goodId)));
    }

    @ApiOperation(value = "重新发布商品")
    @NeedEncrypt
    @RequestMapping(value = "/resubmitGood/{userId}/{goodId}", method = RequestMethod.GET)
    public ResponseBean<Object> resubmitGood(@PathVariable String userId, @PathVariable String goodId) {
        AESUtil aesUtil = new AESUtil();
        userId = aesUtil.decryptHex(userId, key);
        goodId = aesUtil.decryptHex(goodId, key);
        return ResponseBean.success(collectService.resubmitGood(Integer.parseInt(userId), Integer.parseInt(goodId)));
    }


}
