package com.studio.yishujutan.service;

import com.studio.yishujutan.entity.User;

import java.util.List;

public interface UserService {

    //获得关注列表所需要显示的用户信息
    User getUserIconAndNickNameById(String user_id);

    User getUserPageInfo(String user_id);

    User isRegister(String user_id);

    void register(User user);

    List<User> getAlluser();
}
