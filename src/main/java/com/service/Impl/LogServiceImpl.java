package com.service.Impl;

import com.dao.LogDao;
import com.entity.Log;
import com.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogDao logDao;
    @Override
    public int addLog(Log log) {

        return logDao.insertLog(log);
    }
}
