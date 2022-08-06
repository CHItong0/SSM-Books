package com.qf.zlp.service;

import com.qf.zlp.model.Author;

public interface AuthorService {

    int UpdateAuthor(String aname);

    int addAuthor(Author author);

    Author selectAuthor(Author author);

    int deleteAuthor(Integer aid);
}
