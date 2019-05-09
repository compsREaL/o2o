package com.real.o2o.dao;

import com.real.o2o.BaseTest;
import com.real.o2o.entity.PersonInfo;
import com.real.o2o.entity.Product;
import com.real.o2o.entity.Shop;
import com.real.o2o.entity.UserProductMap;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: mabin
 * @create: 2019/5/5 20:51
 */
public class UserProductMapDaoTest extends BaseTest {

    @Autowired
    private UserProductMapDao userProductMapDao;

    @Test
    public void testInsertUserProductMap() {
        PersonInfo user = new PersonInfo();
        user.setUserId(1L);
        Product product = new Product();
        product.setProductId(21L);
        Shop shop = new Shop();
        shop.setShopId(2L);
        PersonInfo operator = new PersonInfo();
        operator.setUserId(2L);
        UserProductMap userProductMap = new UserProductMap();
        userProductMap.setCreateTime(new Date());
        userProductMap.setPoint(3);
        userProductMap.setUser(user);
        userProductMap.setShop(shop);
        userProductMap.setProduct(product);
        userProductMap.setOperator(operator);
        int effectRows = userProductMapDao.insertUserProductMap(userProductMap);
        assertEquals(1,effectRows);
        user.setUserId(3L);
        operator.setUserId(4L);
        product.setProductId(2L);
        shop.setShopId(1L);
        effectRows = userProductMapDao.insertUserProductMap(userProductMap);
        assertEquals(1,effectRows);
    }

    @Test
    public void testQueryUserProductMapList(){
        UserProductMap userProductMap = new UserProductMap();
        List<UserProductMap> userProductMapList = userProductMapDao.queryUserProductMapList(userProductMap,0,3);
        assertEquals(2,userProductMapList.size());
        int count = userProductMapDao.queryUserProductMapCount(userProductMap);
        assertEquals(2,count);
    }
}