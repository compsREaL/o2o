package com.real.o2o.dao;

import com.real.o2o.BaseTest;
import com.real.o2o.entity.PersonInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author: mabin
 * @create: 2019/5/2 12:28
 */
public class PersonInfoDaoTest extends BaseTest {

    @Autowired
    private PersonInfoDao personInfoDao;

    @Test
    public void testQueryPersonInfoById(){
        PersonInfo personInfo = personInfoDao.queryPersonInfoById(2);
        assertEquals("lucy",personInfo.getName());
    }

    @Test
    public void testInsertPersonInfo(){
        PersonInfo personInfo = new PersonInfo();
        personInfo.setName("lucy");
        personInfo.setGender("女");
        personInfo.setEmail("xxx@xxx.com");
        personInfo.setEnableStatus(1);
        personInfo.setUserType(1);
        personInfo.setCreateTime(new Date());
        personInfo.setLastEditTime(new Date());
        int efectRows = personInfoDao.insertPersonInfo(personInfo);
        assertEquals(1,efectRows);
    }
}