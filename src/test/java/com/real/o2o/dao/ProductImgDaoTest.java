package com.real.o2o.dao;

import com.real.o2o.BaseTest;
import com.real.o2o.entity.ProductImg;
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
 * @create: 2019/4/18 18:59
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductImgDaoTest extends BaseTest {

    @Autowired
    private ProductImgDao productImgDao;

    @Test
    public void testABatchInsertProductImg(){
        ProductImg productImg = new ProductImg();
        productImg.setImgAddr("图片1");
        productImg.setImgDesc("描述图片1");
        productImg.setPriority(1);
        productImg.setCreateTime(new Date());
        productImg.setProductId(1L);
        ProductImg productImg1 = new ProductImg();
        productImg1.setImgAddr("图片2");
        productImg1.setImgDesc("描述图片2");
        productImg1.setPriority(2);
        productImg1.setCreateTime(new Date());
        productImg1.setProductId(1L);
        List<ProductImg> productImgList = new ArrayList<>();
        productImgList.add(productImg);
        productImgList.add(productImg1);
        int effectRows = productImgDao.batchInsertProductImg(productImgList);
        assertEquals(2,effectRows);
    }

    @Test
    public void testBDeleteProductImgByProductId(){
        int effectRows = productImgDao.deleteProductImgByProductId(1L);
        assertEquals(2,effectRows);
    }
}