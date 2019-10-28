package com.dao;

import com.BaseTest;
import com.entity.Info;
import com.vo.VeiwInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class InfoDaoTest extends BaseTest {
    @Autowired
    private InfoDao infoDao;

    @Test
    public void queryAllInfoTest(){
        List<VeiwInfo> list=new ArrayList<VeiwInfo>();
        list=infoDao.queryAllInfo();
        System.out.println(list.size());
    }


    @Test
    public void queryByInfoIdTest(){
        VeiwInfo veiwInfo=infoDao.queryByInfoId(5001);

    }
}
