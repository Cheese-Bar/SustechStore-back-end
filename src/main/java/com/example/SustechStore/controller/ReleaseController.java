package com.example.SustechStore.controller;

import com.example.SustechStore.annotations.NeedEncrypt;
import com.example.SustechStore.bean.ResponseBean;
import com.example.SustechStore.service.GoodService;
import com.example.SustechStore.service.GoodsImageService;
import com.example.SustechStore.util.AESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@RestController
public class ReleaseController {
    private static final byte[] key = "9f5d54580044d478".getBytes(StandardCharsets.UTF_8);
    @Autowired
    private GoodService goodService;

//    @GetMapping(value = "/myRelease")
//    List<Map<String, Object>> findMyRelease(@RequestParam("id") int id,
//                                            @RequestParam(value = "pageNum", required = false) Integer pageNum,
//                                            @RequestParam(value = "pageSize", required = false) Integer pageSize,
//                                            @RequestParam(value = "timestamp", required = false) String timestamp,
//                                            @RequestParam(value = "type", required = false) Integer type) {
//        return goodService.findMyRelease(id, pageNum == null ? 0 : pageNum, pageSize == null ? 999 : pageSize, timestamp != null ? Timestamp.valueOf(timestamp) : new Timestamp(System.currentTimeMillis()), type == null ? -1 : type);
//    }

    @NeedEncrypt
    @GetMapping(value = "/myRelease/{id}/{pageNum}/{pageSize}/{timestamp}/{type}/{orderNum}/{goodState}")
    ResponseBean<Object> findMyRelease2(@PathVariable String id,
                                @PathVariable String pageNum,
                                @PathVariable String pageSize,
                                @PathVariable String timestamp,
                                @PathVariable String type,
                                        @PathVariable String orderNum,
                                        @PathVariable String goodState) {
        AESUtil aesUtil = new AESUtil();
        id=aesUtil.decryptHex(id,key);
        pageNum=aesUtil.decryptHex(pageNum,key);
        pageSize=aesUtil.decryptHex(pageSize,key);
        timestamp=aesUtil.decryptHex(timestamp,key);
        type=aesUtil.decryptHex(type,key);
        orderNum = aesUtil.decryptHex(orderNum, key);
        goodState = aesUtil.decryptHex(goodState, key);
        return ResponseBean.success(goodService.findMyRelease(Integer.parseInt(id), pageNum == null ? 0 : Integer.parseInt(pageNum), pageSize == null ? 999 : Integer.parseInt(pageSize), timestamp != null ? Timestamp.valueOf(timestamp) : new Timestamp(System.currentTimeMillis()), type == null ? -1 : Integer.parseInt(type),Integer.parseInt(orderNum),
                Integer.parseInt(goodState)));
    }

}
