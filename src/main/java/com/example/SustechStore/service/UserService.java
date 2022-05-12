package com.example.SustechStore.service;

public interface UserService {

    void modifyImg(String image_url, String user_id);

    void modifyNickname(String nickname, String user_id);

    double topUp(int user_id, double money);

}
