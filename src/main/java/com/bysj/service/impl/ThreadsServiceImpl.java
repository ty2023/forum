package com.bysj.service.impl;

import com.bysj.dao.IThreadsMapper;
import com.bysj.entity.Threads;
import com.bysj.service.IThreadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 29029
 * @Version 1.0
 * @Time 12:08
 */
@Service
public class ThreadsServiceImpl implements IThreadsService {

    @Autowired
    private IThreadsMapper threadsMapper;


    @Override
    public List<Threads> getList(Integer id) {
        return threadsMapper.getList(id);
    }

    @Override
    public Integer insertThreads(Threads threads) {
        return threadsMapper.insertThreads(threads);
    }

    @Override
    public Integer deleteThreads(Integer id) {
        return threadsMapper.deleteThreads(id);
    }
}
