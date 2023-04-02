package com.qf.zlp.mapper;

import com.qf.zlp.model.Books;
import com.qf.zlp.model.User;

import java.util.List;
import java.util.Set;

public interface UserMapper {
    User SelectUser(String uname);
    Set<String> getUserPermissionsByUsername(String username);

    Set<String> getUserRname(String username);

    Integer addUser(User user);

    List<Books> Allbook();

    Books selectbooksbyid(Integer id);
}
