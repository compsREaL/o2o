package com.real.o2o.dao;

import com.real.o2o.BaseTest;
import com.real.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * @author: mabin
 * @create: 2019/4/12 18:19
 */
public class AreaDaoTest extends BaseTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea(){
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2,areaList.size());
    }
}