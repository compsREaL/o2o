package com.real.o2o.quartz;

import com.real.o2o.service.ProductSellDailyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 统计商铺商品的前一日销量
 *
 * @author: mabin
 * @create: 2019/5/8 23:46
 */
public class ProductSellDailyQuartz {

    @Autowired
    private ProductSellDailyService productSellDailyService;

    private static Logger logger = LoggerFactory.getLogger(ProductSellDailyQuartz.class);

    public void calculateProductSellDaily(){
        logger.info("ProductSellDailyQuartz Running ...");
        productSellDailyService.dailyCalculate();
    }
}
