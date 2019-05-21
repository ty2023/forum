package com.bysj.service;

import com.bysj.entity.Threads;

import java.util.List;

public interface IThreadsService {

    List<Threads> getList(Integer id);

    Integer insertThreads(Threads threads);

    Integer deleteThreads(Integer id);
}
