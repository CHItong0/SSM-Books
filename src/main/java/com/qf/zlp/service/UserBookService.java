package com.qf.zlp.service;

import com.qf.zlp.model.Book;
import com.qf.zlp.model.UserBook;

import java.util.List;

public interface UserBookService {

    List<Book> SelectBookByid (Integer uid);

    int AddUserbookByid(UserBook userBook);

    int DeleteUserBook(int bid);

    UserBook selectUserBook(UserBook userBook);
}
