package com.bysj.service.impl;

import com.bysj.dao.ITopicMapper;
import com.bysj.entity.Topic;
import com.bysj.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 29029
 * @Version 1.0
 * @Time 10:22
 */
@Service
public class TopicServiceImpl implements ITopicService {

    @Autowired
    private ITopicMapper topicMapper;

    @Override
    public List<Topic> getList() {
        return topicMapper.getList();
    }

    @Override
    public Topic getById(Integer id) {
        return topicMapper.getById(id);
    }
}
