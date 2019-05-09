package com.real.o2o.dao;

import com.real.o2o.BaseTest;
import com.real.o2o.entity.PersonInfo;
import com.real.o2o.entity.Shop;
import com.real.o2o.entity.ShopAuthMap;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: mabin
 * @create: 2019/5/6 16:21
 */
public class ShopAuthMapDaoTest extends BaseTest {

    @Autowired
    private ShopAuthMapDao shopAuthMapDao;

    @Test
    public void testInsertShopAuthMap(){
        ShopAuthMap shopAuthMap = new ShopAuthMap();
        PersonInfo employee = new PersonInfo();
        employee.setUserId(5L);
        Shop shop = new Shop();
        shop.setShopId(1L);
        shopAuthMap.setEmployee(employee);
        shopAuthMap.setShop(shop);
        shopAuthMap.setTitle("店长");
        shopAuthMap.setTitleFlag(2);
        shopAuthMap.setEnableStatus(0);
        shopAuthMap.setCreateTime(new Date());
        shopAuthMap.setLastEditTime(new Date());
        int effectRows = shopAuthMapDao.insertShopAuthMap(shopAuthMap);
        assertEquals(1,effectRows);
        shop.setShopId(2L);
        employee.setUserId(4L);
        shopAuthMap.setTitle("店长");
        shopAuthMap.setTitleFlag(2);
        shopAuthMap.setEnableStatus(0);
        effectRows = shopAuthMapDao.insertShopAuthMap(shopAuthMap);
        assertEquals(1,effectRows);
    }

    @Test
    public void testQueryShopAuthMapList(){
        List<ShopAuthMap> shopAuthMapList = shopAuthMapDao.queryShopAuthMapList(1L,0,3);
        assertEquals(2,shopAuthMapList.size());
        int count = shopAuthMapDao.queryShopAuthMapCount(1L);
        assertEquals(2,count);
    }

    @Test
    public void testQueryShopAuthMapById(){
        ShopAuthMap shopAuthMap = shopAuthMapDao.queryShopAuthMapById(1L);
        assertEquals("CEO",shopAuthMap.getTitle());
    }

    @Test
    public void testUpdateShopAuthMap(){
        ShopAuthMap shopAuthMap = new ShopAuthMap();
        shopAuthMap.setShopAuthId(4L);
        shopAuthMap.setEnableStatus(1);
        int effectRows = shopAuthMapDao.updateShopAuthMap(shopAuthMap);
        assertEquals(1,effectRows);
    }

    @Test
    public void testDeleteShopAuthMap(){
        int effectRows = shopAuthMapDao.deleteShopAuthMap(2L);
        assertEquals(1,effectRows);
    }

}