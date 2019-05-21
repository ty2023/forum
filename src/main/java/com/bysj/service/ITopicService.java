package com.bysj.service;

import com.bysj.entity.Topic;

import java.util.List;

public interface ITopicService {
    List<Topic> getList();

    Topic getById(Integer id);
}
