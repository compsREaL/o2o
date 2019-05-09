package com.real.o2o.dao;

import com.real.o2o.BaseTest;
import com.real.o2o.entity.HeadLine;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: mabin
 * @create: 2019/4/29 15:39
 */
@FixMethodOrder
public class HeadLineDaoTest extends BaseTest {

    @Autowired
    private HeadLineDao headLineDao;

    @Test
    public void testQueryHeadLine(){

        List<HeadLine> headLineList = headLineDao.queryHeadLine(new HeadLine());
        assertEquals(1,headLineList.size());
    }
}