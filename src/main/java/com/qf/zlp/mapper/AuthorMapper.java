package com.qf.zlp.mapper;

import com.qf.zlp.model.Author;

public interface AuthorMapper {


    int UpdateAuthor(String aname);

    int addAuthor(Author author);

    Author selectAuthor(Author author);


}
