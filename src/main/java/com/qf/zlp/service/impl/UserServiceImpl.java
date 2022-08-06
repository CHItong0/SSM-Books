package com.qf.zlp.service.impl;

import com.qf.zlp.mapper.UserMapper;
import com.qf.zlp.model.User;
import com.qf.zlp.model.Books;
import com.qf.zlp.model.UserPermission;
import com.qf.zlp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User SelectUser(String uname) {
        return userMapper.SelectUser(uname);
    }

    @Override
    public Set<String> getUserRname(String username) {
        return getUserPermissionsByUsername(username);
    }

    @Override
    public Set<String> getUserPermissionsByUsername(String username) {
        return userMapper.getUserPermissionsByUsername(username);
    }

    @Override
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public List<Books> Allbook() {
        return userMapper.Allbook();
    }

    @Override
    public Books selectbooksbyid(Integer id) {
        return userMapper.selectbooksbyid(id);
    }

    @Override
    public int UpdateUser(User user) {
        return userMapper.UpdateUser(user);
    }

    @Override
    public List<UserPermission> selectUserPermission() {
        return userMapper.selectUserPermission();
    }
}
