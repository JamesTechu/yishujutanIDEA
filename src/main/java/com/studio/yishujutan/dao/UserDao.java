package com.studio.yishujutan.dao;

import com.studio.yishujutan.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    //获得关注列表所需要显示的用户信息
    User getUserIconAndNickNameById(String user_id);
}
