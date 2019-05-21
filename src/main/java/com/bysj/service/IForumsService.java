package com.bysj.service;

import com.bysj.entity.Forums;

import java.util.List;

public interface IForumsService {
    List<Forums> getList(String type);
}
