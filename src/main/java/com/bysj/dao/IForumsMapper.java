package com.bysj.dao;

import com.bysj.entity.Forums;

import java.util.List;

public interface IForumsMapper {

    List<Forums> getList(String type);
}
