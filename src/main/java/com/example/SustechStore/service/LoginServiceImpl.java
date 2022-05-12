package com.example.SustechStore.service;

import com.example.SustechStore.cachePool.CachePool;
import com.example.SustechStore.mapper.BindingMapper;
import com.example.SustechStore.mapper.UsersMapper;
import com.example.SustechStore.pojo.Binding;
import com.example.SustechStore.pojo.BindingExample;
import com.example.SustechStore.pojo.Users;
import com.example.SustechStore.pojo.UsersExample;
import com.example.SustechStore.util.SendEmail;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private BindingMapper bindingMapper;
    @Autowired
    private UsersMapper usersMapper;

    private final int t = 1200000;


    @Override
    public List<String> selectRealNameByWX(String wx_id) {
        BindingExample bindingExample = new BindingExample();
        BindingExample.Criteria criteria = bindingExample.createCriteria();
        criteria.andWxIdEqualTo(wx_id);
        List<Binding> bindings = bindingMapper.selectByExample(bindingExample);
        List<String> realNames = new ArrayList<>();
        for (Binding binding : bindings) {
            realNames.add(binding.getRealName());
        }
        return realNames;
    }

    @Override
    public boolean register1(String s_id) {
        boolean flag = checkS_id(s_id) != -1;
        if (flag) return false;
        sendEmail(s_id);
        return true;
    }

    @Override
    public int register2(String s_id, String code, String nickname, String wx_id) {
        boolean isChecked = isChecked(s_id, Integer.parseInt(code));
        if (!isChecked) return -1;
        int tmp = checkS_id(s_id);
        if (tmp != -1) return tmp;

        Users users = new Users();
        users.setUserNickname(nickname);
        users.setUserRealname(s_id);
        usersMapper.insertSelective(users);

        Binding binding = new Binding();
        binding.setRealName(s_id);
        binding.setWxId(wx_id);
        bindingMapper.insertSelective(binding);
        return users.getUserId();
    }

    @Override
    public boolean login1(String s_id) {
        boolean flag = checkS_id(s_id) == -1;
        if (flag) return false;
        sendEmail(s_id);
        return true;
    }

    @Override
    public Users login2(String s_id, String code, String wx_id) {
        boolean isChecked = isChecked(s_id, Integer.parseInt(code));
        if (!isChecked) return null;
        Binding binding = new Binding();
        binding.setRealName(s_id);
        binding.setWxId(wx_id);
        try {
            bindingMapper.insertSelective(binding);
        }catch (Exception ignored){}
        return usersMapper.selectByPrimaryKey(checkS_id(s_id));
    }

    @Override
    public void logOut(String s_id) {
        BindingExample bindingExample=new BindingExample();
        BindingExample.Criteria criteria=bindingExample.createCriteria();
        criteria.andRealNameEqualTo(s_id);
        bindingMapper.deleteByExample(bindingExample);

        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria2 = usersExample.createCriteria();
        criteria2.andUserRealnameEqualTo(s_id);
        Users newUser=new Users();
        newUser.setUserRealname(generateRandom());
        newUser.setUserNickname("已注销");

        usersMapper.updateByExampleSelective(newUser,usersExample);

    }

    @Override
    public Users initInfo(String s_id) {
        int id = checkS_id(s_id);
        if (id==-1)return null;
        return usersMapper.selectByPrimaryKey(id);
    }


    int checkS_id(String s_id) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUserRealnameEqualTo(s_id);
        List<Users> users = usersMapper.selectByExample(usersExample);
        if (users.isEmpty()) return -1;
        return users.get(0).getUserId();
    }

    public void sendEmail(String to) {
        int code = SendEmail.sendEmail(to);
        CachePool cachePool = CachePool.getInstance();
        cachePool.putCacheItem(to, code, t);

        if (cachePool.getSize() > 100) cachePool.clearExpiredItems();
    }

    public boolean isChecked(String id, int code) {
        CachePool cachePool = CachePool.getInstance();
        Integer real_code = cachePool.getCacheItem(id);
        if (real_code == null) return false;
        return real_code == code;
    }

    public String generateRandom() {
        String s = String.valueOf(System.currentTimeMillis() + new Random().nextInt());
        return Hashing.md5().hashBytes(s.getBytes(StandardCharsets.UTF_8)).toString();
    }

    @Override
    public boolean quit(String wx_id, String s_id) {
        try {
            BindingExample bindingExample = new BindingExample();
            BindingExample.Criteria criteria = bindingExample.createCriteria();
            criteria.andRealNameEqualTo(s_id);
            criteria.andWxIdEqualTo(wx_id);
            bindingMapper.deleteByExample(bindingExample);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
