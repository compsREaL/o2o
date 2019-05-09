package com.real.o2o.dao;

import com.real.o2o.BaseTest;
import com.real.o2o.entity.ProductCategory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: mabin
 * @create: 2019/4/18 9:49
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCategoryDaoTest extends BaseTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;


    @Test
    public void testBQueryProductCategoryList(){
        long shopId=1L;
        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
        System.out.println(productCategoryList.size());
    }

    @Test
    public void testABatchInsertProductCategory(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryName("批量添加1");
        productCategory.setPriority(5);
        productCategory.setCreateTime(new Date());
        productCategory.setShopId(1L);
        ProductCategory productCategory1 = new ProductCategory();
        productCategory1.setProductCategoryName("批量添加2");
        productCategory1.setPriority(6);
        productCategory1.setCreateTime(new Date());
        productCategory1.setShopId(1L);
        List<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList.add(productCategory);
        productCategoryList.add(productCategory1);
        int i = productCategoryDao.batchInsertProductCategory(productCategoryList);
        System.out.println(i);
    }

    @Test
    public void testCDeleteProductCategory(){
        long shopId = 1L;
        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
        for(ProductCategory productCategory:productCategoryList){
            if ("批量添加1".equals(productCategory.getProductCategoryName()) || "批量添加2".equals(productCategory.getProductCategoryName())){
                int effectRows = productCategoryDao.deleteProductCategory(productCategory.getProductCategoryId(),shopId);
                assertEquals(1,effectRows);
            }
        }
    }
}