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
    public BookTypes AllBookTypes(Integer bid) {
        return bookTypesMapper.AllBookTypes(bid);
    }

    @Override
    public int UpDateBookType(BookTypes bookTypes) {
        return bookTypesMapper.UpDateBookType(bookTypes);
    }

    @Override
    public int AddBookTypes(BookTypes bookTypes) {
        return bookTypesMapper.AddBookTypes(bookTypes);
    }

    @Override
    public int deleteBookTypes(Integer bid) {
        return bookTypesMapper.deleteBookTypes(bid);
    }
}
