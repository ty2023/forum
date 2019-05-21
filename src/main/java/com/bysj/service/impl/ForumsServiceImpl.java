package com.bysj.service.impl;

import com.bysj.dao.IForumsMapper;
import com.bysj.entity.Forums;
import com.bysj.service.IForumsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 29029
 * @Version 1.0
 * @Time 9:14
 */
@Service
public class ForumsServiceImpl implements IForumsService {

    @Autowired
    private IForumsMapper forumsMapper;

    @Override
    public List<Forums> getList(String type) {
        return forumsMapper.getList(type);
    }
}
