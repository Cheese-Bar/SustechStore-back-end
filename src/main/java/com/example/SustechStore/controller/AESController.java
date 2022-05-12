package com.example.SustechStore.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.SustechStore.annotations.NeedDecrypt;
import com.example.SustechStore.annotations.NeedEncrypt;
import com.example.SustechStore.bean.ResponseBean;
import com.example.SustechStore.service.CatService;
import com.example.SustechStore.service.GoodService;
import com.example.SustechStore.util.AESUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "AES加解密测试接口")
@RestController
public class AESController {
    @Autowired
    private CatService catService;
    @Autowired
    private GoodService goodService;

    private static final byte[] key = "9f5d54580044d478".getBytes(StandardCharsets.UTF_8);


    @NeedEncrypt
    @GetMapping(value = "/generateJsonObjTest")
    public ResponseBean<Object> getEncrypt() {
        Map<String, Object> map = new HashMap();
        map.put("id", 1);
        map.put("name", "zxw");
        return ResponseBean.success(map);
    }

    @NeedEncrypt
    @GetMapping(value = "/generateJsonArrayTest")
    ResponseBean<Object> initen() {
        return ResponseBean.success(catService.init(1));
    }

    @NeedEncrypt
    @GetMapping(value = "/initen/{type}")
    ResponseBean<Object> initen2(@PathVariable int type) {
        return ResponseBean.success(catService.init(type));
    }


    @GetMapping(value = "/getParamHexDecryptTest/{param}")
    String getParamHexDecryptTest(@PathVariable String param) throws Exception {
        AESUtil aesUtil = new AESUtil();
        return aesUtil.decryptHex(param, key);
    }

    @NeedEncrypt
    @RequestMapping(value = "/nextPageEn/{time}/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public ResponseBean<Object> nextPageEn(@PathVariable String time, @PathVariable String pageNum, @PathVariable String pageSize) {
        AESUtil aesUtil = new AESUtil();
        time = aesUtil.decryptHex(time, key);
        pageNum = aesUtil.decryptHex(pageNum, key);
        pageSize = aesUtil.decryptHex(pageSize, key);
        Timestamp timestamp = Timestamp.valueOf(time);
        return ResponseBean.success(goodService.selectGoodByPage(timestamp, Integer.parseInt(pageNum), Integer.parseInt(pageSize)));
    }

    @NeedEncrypt
    @PostMapping(value = "/encryptParamTest")
    ResponseBean<Object> encryptParamTest(@RequestBody String s) {
        return ResponseBean.success(s);
    }

    @NeedDecrypt
    @PostMapping(value = "/postParamDecryptTest")
    String testPost3(@RequestBody String s) {
        return s;
    }

    @NeedDecrypt
    @PostMapping(value = "/postJsonArrayDecryptTest")
    String testPost(@RequestBody String s) {
        JSONArray jsonobject = JSONArray.parseArray(s);
        return jsonobject.toJSONString();
    }

    @NeedDecrypt
    @PostMapping(value = "/postJsonObjDecryptTest")
    String testPost2(@RequestBody String s) {
        JSONObject jsonobject = JSONObject.parseObject(s);
        return jsonobject.toJSONString();
    }

}
