package com.example.SustechStore.service;

import com.example.SustechStore.mapper.UsersMapper;
import com.example.SustechStore.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void modifyImg(String image_url, String user_id) {
        Users newUser = new Users();
        newUser.setHeadImage(image_url);
        System.out.println(image_url);
        newUser.setUserId(Integer.parseInt(user_id));
        usersMapper.updateByPrimaryKeySelective(newUser);
    }

    @Override
    public void modifyNickname(String nickname, String user_id) {
        Users newUser = new Users();
        newUser.setUserNickname(nickname);
        newUser.setUserId(Integer.parseInt(user_id));
        usersMapper.updateByPrimaryKeySelective(newUser);
    }

    @Override
    public double topUp(int user_id, double money) {
        Users users = new Users();
        users.setUserId(user_id);
        double m = usersMapper.selectByPrimaryKey(user_id).getBalance() + money;
        users.setBalance(m);
        usersMapper.updateByPrimaryKeySelective(users);
        return usersMapper.selectByPrimaryKey(user_id).getBalance();
    }

    public boolean isLogout(int user_id) {
        Users users = usersMapper.selectByPrimaryKey(user_id);
        if (users == null) return true;
        return users.getUserRealname().length() == 32;
    }


}
