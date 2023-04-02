package com.qf.zlp.service.impl;

import com.qf.zlp.mapper.BookTypesMapper;
import com.qf.zlp.model.BookTypes;
import com.qf.zlp.service.BookTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookTypesServiceImpl implements BookTypesService {

    @Autowired
    BookTypesMapper bookTypesMapper;
    @Override
    public List<BookTypes> AllBookTypes() {
        return bookTypesMapper.AllBookTypes();
    }

    @Override
    public int UpDateBookType(BookTypes bookTypes) {
        return bookTypesMapper.UpDateBookType(bookTypes);
    }

    @Override
    public BookTypes AddBookTypes(BookTypes bookTypes) {
        return bookTypesMapper.AddBookTypes(bookTypes);
    }
}
