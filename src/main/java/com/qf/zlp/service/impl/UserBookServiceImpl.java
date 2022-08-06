package com.qf.zlp.service.impl;

import com.qf.zlp.mapper.UserBookMapper;
import com.qf.zlp.model.Book;
import com.qf.zlp.model.UserBook;
import com.qf.zlp.service.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBookServiceImpl implements UserBookService {

    @Autowired
    UserBookMapper userBookMapper;

    @Override
    public List<Book> SelectBookByid(Integer uid) {
        return userBookMapper.SelectBookByid(uid) ;
    }

    @Override
    public int AddUserbookByid(UserBook userBook) {
        return userBookMapper.AddUserbookByid(userBook);
    }

    @Override
    public int DeleteUserBook(int bid) {
        return userBookMapper.DeleteUserBook(bid);
    }

    @Override
    public UserBook selectUserBook(UserBook userBook) {
        return userBookMapper.selectUserBook(userBook);
    }
}
