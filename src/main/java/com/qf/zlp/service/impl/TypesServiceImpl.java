package com.qf.zlp.service.impl;

import com.qf.zlp.mapper.TypesMapper;
import com.qf.zlp.model.Types;
import com.qf.zlp.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypesServiceImpl implements TypesService {

    @Autowired
    TypesMapper typesMapper;

    @Override
    public Types selectTypes(Types types) {
        return typesMapper.selectTypes(types);
    }

    @Override
    public int UpdateTypes(String tname) {
        return typesMapper.UpdateTypes(tname);
    }




    @Override
    public int AddTypes(Types types) {
        return typesMapper.AddTypes(types);
    }
}
