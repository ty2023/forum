package com.bysj.dao;

import com.bysj.entity.Topic;

import java.util.List;

public interface ITopicMapper {
    List<Topic> getList();

    Topic getById(Integer id);

}
