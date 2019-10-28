package com.service;

import com.vo.VeiwInfo;

import java.util.ArrayList;

public interface InfoService {
    ArrayList<VeiwInfo>selectAllInfo();

    VeiwInfo getByInfoId(Integer infoId);
}
