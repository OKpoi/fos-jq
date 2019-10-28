package com.service.Impl;

import com.dao.InfoDao;
import com.service.InfoService;
import com.vo.VeiwInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoDao infoDao;

    @Override
    public ArrayList<VeiwInfo> selectAllInfo() {
        return infoDao.queryAllInfo();
    }

    @Override
    public VeiwInfo getByInfoId(Integer infoId) {
        return infoDao.queryByInfoId(infoId);
    }
}
