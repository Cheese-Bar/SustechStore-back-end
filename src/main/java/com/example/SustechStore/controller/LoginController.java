package com.example.SustechStore.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.SustechStore.annotations.NeedDecrypt;
import com.example.SustechStore.annotations.NeedEncrypt;
import com.example.SustechStore.bean.ResponseBean;
import com.example.SustechStore.pojo.Users;
import com.example.SustechStore.service.LoginService;
import com.example.SustechStore.util.AESUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@Api(tags = "用户信息接口")
@RestController
public class LoginController {
    private static final byte[] key = "9f5d54580044d478".getBytes(StandardCharsets.UTF_8);
    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登录初始化")
    @NeedEncrypt
    @GetMapping(value = "/login/init/{wx_id}")
    ResponseBean<Object> selectRealNameByWX(@PathVariable String wx_id) {
        AESUtil aesUtil = new AESUtil();
        wx_id = aesUtil.decryptHex(wx_id, key);
        return ResponseBean.success(loginService.selectRealNameByWX(wx_id));
    }

    @NeedEncrypt
    @GetMapping(value = "/login/register1/{s_id}")
    ResponseBean<Object> register1(@PathVariable String s_id) {
        AESUtil aesUtil = new AESUtil();
        s_id = aesUtil.decryptHex(s_id, key);
        return ResponseBean.success(loginService.register1(s_id));
    }

    @NeedEncrypt
    @GetMapping(value = "/login/register2/{s_id}/{code}/{nickname}/{wx_id}")
    ResponseBean<Object> register2(@PathVariable String s_id, @PathVariable String code, @PathVariable String nickname, @PathVariable String wx_id) {
        AESUtil aesUtil = new AESUtil();
        s_id = aesUtil.decryptHex(s_id, key);
        code = aesUtil.decryptHex(code, key);
        nickname = aesUtil.decryptHex(nickname, key);
        wx_id = aesUtil.decryptHex(wx_id, key);
        return ResponseBean.success(loginService.register2(s_id, code, nickname, wx_id));
    }

    @NeedEncrypt
    @NeedDecrypt
    @PostMapping(value = "/login/register2Test")
    ResponseBean<Object> register2Test(@RequestBody String stringJson){
        JSONObject jsonObject = JSONObject.parseObject(stringJson);
        String s_id = jsonObject.getString("sid");
        String code = jsonObject.getString("code");
        String wx_id = jsonObject.getString("wxId");
        String nickname = jsonObject.getString("nickname");
        return ResponseBean.success(loginService.register2(s_id, code, nickname, wx_id));
    }

    @NeedEncrypt
    @GetMapping(value = "/login/login1/{s_id}")
    ResponseBean<Object> login1(@PathVariable String s_id) {
        AESUtil aesUtil = new AESUtil();
        s_id = aesUtil.decryptHex(s_id, key);
        return ResponseBean.success(loginService.login1(s_id));
    }
//    @GetMapping(value = "/login/login1/{s_id}")
//    ResponseBean<Object> login1(@PathVariable String s_id) {
//
//        return ResponseBean.success(loginService.login1(s_id));
//    }

    @NeedEncrypt
    @GetMapping(value = "/login/login2/{s_id}/{code}/{wx_id}")
    ResponseBean<Object> login2(@PathVariable String s_id, @PathVariable String code, @PathVariable String wx_id){
        AESUtil aesUtil = new AESUtil();
        s_id=aesUtil.decryptHex(s_id,key);
        code=aesUtil.decryptHex(code,key);
        wx_id=aesUtil.decryptHex(wx_id,key);
        return ResponseBean.success(loginService.login2(s_id,code,wx_id));
    }

    @NeedEncrypt
    @NeedDecrypt
    @PostMapping(value = "/login/login2Test")
    ResponseBean<Object> login2Test(@RequestBody String stringJson){
        JSONObject jsonObject = JSONObject.parseObject(stringJson);
        String s_id = jsonObject.getString("sid");
        String code = jsonObject.getString("code");
        String wx_id = jsonObject.getString("wxId");
        return ResponseBean.success(loginService.login2(s_id,code,wx_id));
    }

//    @GetMapping(value = "/login/login2/{s_id}/{code}/{wx_id}")
//    Users login2(@PathVariable String s_id, @PathVariable String code, @PathVariable String wx_id) {
//        return loginService.login2(s_id, code, wx_id);
//    }

    @NeedEncrypt
    @GetMapping(value = "/login/logout/{s_id}")
    ResponseBean<Object> logOut(@PathVariable String s_id) {
        AESUtil aesUtil = new AESUtil();
        s_id=aesUtil.decryptHex(s_id,key);
        loginService.logOut(s_id);
        return ResponseBean.success();
    }

    @NeedEncrypt
    @GetMapping(value = "/login/init_info/{s_id}")
    ResponseBean<Object> initInfo(@PathVariable String s_id) {
        AESUtil aesUtil = new AESUtil();
        s_id=aesUtil.decryptHex(s_id,key);
        return ResponseBean.success(loginService.initInfo(s_id));
    }

    @NeedEncrypt
    @GetMapping(value = "/quit/{wx_id}/{s_id}")
    ResponseBean<Object> quit(@PathVariable String wx_id,@PathVariable String s_id){
        AESUtil aesUtil = new AESUtil();
        s_id=aesUtil.decryptHex(s_id,key);
        wx_id=aesUtil.decryptHex(wx_id,key);
        return ResponseBean.success(loginService.quit(wx_id,s_id));
    }

}
