package com.bysj.dao;

import com.bysj.entity.Threads;

import java.util.List;

public interface IThreadsMapper {

   List<Threads> getList(Integer id);

   Integer insertThreads(Threads threads);

   Integer deleteThreads(Integer id);

}
