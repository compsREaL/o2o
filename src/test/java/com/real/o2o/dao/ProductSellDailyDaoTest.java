package com.real.o2o.dao;

import com.real.o2o.BaseTest;
import com.real.o2o.entity.ProductSellDaily;
import com.real.o2o.entity.Shop;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: mabin
 * @create: 2019/5/5 21:34
 */
public class ProductSellDailyDaoTest extends BaseTest {

    @Autowired
    private ProductSellDailyDao productSellDailyDao;

    @Test
    public void testInsertProductSellDaily(){
        int effectRows = productSellDailyDao.insertProductSellDaily();
        System.out.println(effectRows);
    }

    @Test
    public void testQueryProductSellDailyList(){
        ProductSellDaily productSellCondition = new ProductSellDaily();
        Shop shop = new Shop();
        shop.setShopId(1L);
        productSellCondition.setShop(shop);
        List<ProductSellDaily> productSellDailyList = productSellDailyDao.queryProductSellDailyList(productSellCondition,null,null);
        for (ProductSellDaily productSellDaily:productSellDailyList){
            System.out.println(productSellDaily.getTotal());
        }
        assertEquals(2,productSellDailyList.size());
    }

}