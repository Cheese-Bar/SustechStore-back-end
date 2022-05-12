package com.example.SustechStore.controller;

import com.example.SustechStore.annotations.NeedEncrypt;
import com.example.SustechStore.bean.ResponseBean;
import com.example.SustechStore.service.UserService;
import com.example.SustechStore.util.AESUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@Api(tags = "用户信息修改接口")
@RestController
@RequestMapping(value = "settings")
public class SettingsController {
    private static final byte[] key = "9f5d54580044d478".getBytes(StandardCharsets.UTF_8);
    @Autowired
    private UserService userService;

    @NeedEncrypt
    @GetMapping(value = "/modify_image/{image_url}/{user_id}")
    ResponseBean<Object> modifyImg(@PathVariable String image_url, @PathVariable String user_id) {
        AESUtil aesUtil = new AESUtil();
        user_id = aesUtil.decryptHex(user_id, key);
        image_url = aesUtil.decryptHex(image_url, key);
        userService.modifyImg(image_url, user_id);
        return ResponseBean.success();
    }

    @NeedEncrypt
    @GetMapping(value = "/modify_nickname/{nickname}/{user_id}")
    ResponseBean<Object> modifyNickname(@PathVariable String nickname, @PathVariable String user_id) {
        AESUtil aesUtil = new AESUtil();
        user_id = aesUtil.decryptHex(user_id, key);
        nickname = aesUtil.decryptHex(nickname, key);
        userService.modifyNickname(nickname, user_id);
        return ResponseBean.success();
    }

    @NeedEncrypt
    @GetMapping(value = "/topUp/{user_id}/{money}")
    ResponseBean<Object> topUp(@PathVariable String user_id, @PathVariable String money) {
        AESUtil aesUtil = new AESUtil();
        user_id = aesUtil.decryptHex(user_id, key);
        money = aesUtil.decryptHex(money, key);
        return ResponseBean.success(userService.topUp(Integer.parseInt(user_id), Double.parseDouble(money)));
    }
}

