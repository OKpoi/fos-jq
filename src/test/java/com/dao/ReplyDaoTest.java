package com.dao;

import com.BaseTest;
import com.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.plaf.ViewportUI;
import java.util.ArrayList;
import java.util.List;

public class ReplyDaoTest extends BaseTest {
    @Autowired
    private ReplyDao replyDao;

    @Test
    public void queryRelyByUserId(){
        List list=new ArrayList();
        list=replyDao.queryRelyByUserId(1004);

    }
}
