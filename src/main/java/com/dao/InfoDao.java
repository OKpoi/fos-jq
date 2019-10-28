package com.dao;

import com.vo.VeiwInfo;

import java.util.ArrayList;

public interface InfoDao {
    ArrayList<VeiwInfo> queryAllInfo();

    VeiwInfo queryByInfoId(Integer infoId);
}
