package com.qf.zlp.service;

import com.qf.zlp.model.User;
import com.qf.zlp.model.Books;
import com.qf.zlp.model.UserPermission;

import java.util.List;
import java.util.Set;

public interface UserService  {

    User SelectUser(String uname);

    Set<String> getUserRname(String username);

    Set<String> getUserPermissionsByUsername(String username);

    Integer addUser(User user);

    List<Books> Allbook();

    Books selectbooksbyid(Integer id);

    int UpdateUser(User user);

    List<UserPermission> selectUserPermission();

}
