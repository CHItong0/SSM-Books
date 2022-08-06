package com.qf.zlp.mapper;

import com.qf.zlp.model.Book;
import com.qf.zlp.model.Books;
import com.qf.zlp.model.User;
import com.qf.zlp.model.UserBook;

import java.util.List;

public interface UserBookMapper {

    List<Book> SelectBookByid (Integer uid);

    int AddUserbookByid(UserBook userBook);

    int DeleteUserBook(int bid);

    UserBook selectUserBook(UserBook userBook);
}
