package com.real.o2o.dao;

import com.real.o2o.BaseTest;
import com.real.o2o.entity.Award;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: mabin
 * @create: 2019/5/5 18:03
 */
public class AwardDaoTest extends BaseTest {

    @Autowired
    private AwardDao awardDao;

    @Test
    public void testInsertAward(){
        Award award1 = new Award();
        award1.setAwardName("测试奖品1");
        award1.setAwardDesc("test1");
        award1.setCreateTime(new Date());
        award1.setEnableStatus(0);
        award1.setPoint(3);
        award1.setShopId(1L);
        award1.setPriority(20);
        award1.setLastEditTime(new Date());
        int effectRows = awardDao.insertAward(award1);
        assertEquals(1,effectRows);
        Award award2 = new Award();
        award2.setAwardName("测试奖品2");
        award2.setAwardDesc("test2");
        award2.setCreateTime(new Date());
        award2.setEnableStatus(1);
        award2.setPoint(5);
        award2.setShopId(1L);
        award2.setPriority(10);
        award2.setLastEditTime(new Date());
        effectRows = awardDao.insertAward(award2);
        assertEquals(1,effectRows);
    }

    @Test
    public void testQueryAwardById(){
        Award award = awardDao.queryAwardById(3L);
        assertEquals("测试奖品1",award.getAwardName());
    }

    @Test
    public void testQueryAwardList(){
        Award awardCondition = new Award();
        awardCondition.setEnableStatus(1);
        awardCondition.setShopId(1L);
        awardCondition.setAwardName("测试");
        List<Award> awardList = awardDao.queryAwardList(awardCondition,0,3);
        assertEquals(2,awardList.size());
        int count = awardDao.queryAwardCount(awardCondition);
        assertEquals(2,count);
    }

    @Test
    public void testUpdateAward(){
        Award award = new Award();
        award.setAwardId(3L);
        award.setAwardDesc("test1");
        award.setEnableStatus(1);
        award.setShopId(1L);
        int effectRows = awardDao.updateAward(award);
        assertEquals(1,effectRows);
    }

    @Test
    public void testDeleteAward(){
        int effectRows = awardDao.deleteAward(3l,1l);
        assertEquals(1,effectRows);
    }

}