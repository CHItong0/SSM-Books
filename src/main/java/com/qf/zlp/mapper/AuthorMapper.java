package com.qf.zlp.mapper;

import com.qf.zlp.model.Author;
import com.qf.zlp.model.Types;

public interface AuthorMapper {


    int UpdateAuthor(String aname);

    int addAuthor(Author author);

    Author selectAuthor(Author author);

    int deleteAuthor(Integer aid);


}
