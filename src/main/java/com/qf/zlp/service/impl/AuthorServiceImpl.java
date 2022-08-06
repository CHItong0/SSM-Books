package com.qf.zlp.service.impl;

import com.qf.zlp.mapper.AuthorMapper;
import com.qf.zlp.model.Author;
import com.qf.zlp.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorMapper authorMapper;
    @Override
    public int UpdateAuthor(String aname) {
        return authorMapper.UpdateAuthor(aname);
    }
    @Override
    public int addAuthor(Author author) {
        return authorMapper.addAuthor(author);
    }

    @Override
    public Author selectAuthor(Author author) {
        return authorMapper.selectAuthor(author);
    }

    @Override
    public int deleteAuthor(Integer aid) {
        return authorMapper.deleteAuthor(aid);
    }


}
