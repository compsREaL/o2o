package com.real.o2o.dao;

import com.real.o2o.BaseTest;
import com.real.o2o.entity.Award;
import com.real.o2o.entity.PersonInfo;
import com.real.o2o.entity.Shop;
import com.real.o2o.entity.UserAwardMap;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: mabin
 * @create: 2019/5/5 19:50
 */
public class UserAwardMapDaoTest extends BaseTest {

    @Autowired
    private UserAwardMapDao userAwardMapDao;

    @Test
    public void testInsertUserAwardMap(){
        PersonInfo user = new PersonInfo();
        user.setUserId(1L);
        Shop shop = new Shop();
        shop.setShopId(1L);
        Award award = new Award();
        award.setAwardId(4L);
        PersonInfo operator = new PersonInfo();
        operator.setUserId(2L);
        UserAwardMap userAwardMap = new UserAwardMap();
        userAwardMap.setCreateTime(new Date());
        userAwardMap.setPoint(5);
        userAwardMap.setUsedStatus(0);
        userAwardMap.setUser(user);
        userAwardMap.setShop(shop);
        userAwardMap.setAward(award);
        userAwardMap.setOperator(operator);
        int effectRows = userAwardMapDao.insertUserAwardMap(userAwardMap);
        assertEquals(1,effectRows);
        user.setUserId(3L);
        shop.setShopId(2L);
        award.setAwardId(5L);
        operator.setUserId(4L);
        effectRows = userAwardMapDao.insertUserAwardMap(userAwardMap);
        assertEquals(1,effectRows);
    }

    @Test
    public void testQueryUserAwardMapList(){
        UserAwardMap userAwardMap = new UserAwardMap();
        List<UserAwardMap> userAwardMapList = userAwardMapDao.queryUserAwardMapList(userAwardMap,0,3);
        assertEquals(2,userAwardMapList.size());
        int account = userAwardMapDao.queryUserAwardMapCount(userAwardMap);
        assertEquals(2,account);
    }

    @Test
    public void testQueryUserAwardMapById(){
        UserAwardMap userAwardMap = userAwardMapDao.queryUserAwardMapById(1L);
        assertEquals(1L,userAwardMap.getUser().getUserId().longValue());
    }

    @Test
    public void testUpdateUserAwardMap(){
        UserAwardMap userAwardMap = new UserAwardMap();
        userAwardMap.setUsedStatus(1);
        PersonInfo user = new PersonInfo();
        user.setUserId(1L);
        userAwardMap.setUserAwardId(1L);
        userAwardMap.setUser(user);
        int effectRows = userAwardMapDao.updateUserAwardMap(userAwardMap);
        assertEquals(1,effectRows);
    }
}