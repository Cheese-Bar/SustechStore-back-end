package com.example.SustechStore.service;

import com.example.SustechStore.pojo.Users;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface LoginService {
    List<String> selectRealNameByWX(String wx_id);

    boolean register1(String s_id);

    int register2(String s_id,String code,String nickname,String wx_id);

    boolean login1(String s_id);

    Users login2(String s_id,String code,String wx_id);

    void logOut(String s_id);

    Users initInfo(String s_id);

    boolean quit(String wx_id,String s_id);
}
