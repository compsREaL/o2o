package com.real.o2o.dao;

import com.real.o2o.BaseTest;
import com.real.o2o.entity.PersonInfo;
import com.real.o2o.entity.Shop;
import com.real.o2o.entity.UserShopMap;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: mabin
 * @create: 2019/5/6 14:43
 */
public class UserShopMapDaoTest extends BaseTest {

    @Autowired
    private UserShopMapDao userShopMapDao;

    @Test
    public void insertUserShopMap(){
        UserShopMap userShopMap = new UserShopMap();
        Shop shop = new Shop();
        shop.setShopId(1L);
        PersonInfo user = new PersonInfo();
        user.setUserId(1L);
        userShopMap.setShop(shop);
        userShopMap.setUser(user);
        userShopMap.setPoint(5);
        userShopMap.setCreateTime(new Date());
        int effectRows = userShopMapDao.insertUserShopMap(userShopMap);
        assertEquals(1,effectRows);
        shop.setShopId(2L);
        userShopMap.setPoint(10);
        effectRows = userShopMapDao.insertUserShopMap(userShopMap);
        assertEquals(1,effectRows);
        shop.setShopId(1L);
        user.setUserId(2L);
        userShopMap.setPoint(15);
        effectRows = userShopMapDao.insertUserShopMap(userShopMap);
        assertEquals(1,effectRows);
    }

    @Test
    public void testQueryUserShopMapList(){
        UserShopMap userShopMap = new UserShopMap();
        List<UserShopMap> userShopMaps = userShopMapDao.queryUserShopMapList(userShopMap,0,2);
        assertEquals(2,userShopMaps.size());
        int count = userShopMapDao.queryUserShopMapCount(userShopMap);
        assertEquals(3,count);
    }

    @Test
    public void testQueryUserShopMaop(){
        UserShopMap userShopMap = userShopMapDao.queryUserShopMap(1L,2L);
        assertEquals(10,userShopMap.getPoint().intValue());
    }

    @Test
    public void testUpdateUserShopMap(){
        UserShopMap userShopMap = new UserShopMap();
        Shop shop = new Shop();
        PersonInfo user = new PersonInfo();
        shop.setShopId(1L);
        user.setUserId(1L);
        userShopMap.setShop(shop);
        userShopMap.setUser(user);
        userShopMap.setPoint(7);
        int effectRows = userShopMapDao.updateUserShopMapPoint(userShopMap);
        assertEquals(1,effectRows);
    }
}