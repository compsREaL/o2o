package com.real.o2o.service;

import com.real.o2o.BaseTest;
import com.real.o2o.dto.WechatAuthExexution;
import com.real.o2o.entity.PersonInfo;
import com.real.o2o.entity.WechatAuth;
import com.real.o2o.enums.WechatAuthStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author: mabin
 * @create: 2019/5/3 0:46
 */
public class WechatAuthServiceTest extends BaseTest {

    @Autowired
    private WechatAuthService wechatAuthService;

    @Test
    public void testRegister(){
        WechatAuth wechatAuth = new WechatAuth();
        PersonInfo personInfo = new PersonInfo();
        personInfo.setName("jacky");
        personInfo.setGender("男");
        personInfo.setEmail("xxx@xxx.com");
        personInfo.setEnableStatus(1);
        personInfo.setUserType(1);
        personInfo.setCreateTime(new Date());
        personInfo.setLastEditTime(new Date());
        wechatAuth.setPersonInfo(personInfo);
        wechatAuth.setCreateTime(new Date());
        wechatAuth.setOpenId("asdadadsadada");
        WechatAuthExexution wechatAuthExexution = wechatAuthService.register(wechatAuth);
        assertEquals(WechatAuthStateEnum.SUCCESS.getState(),wechatAuthExexution.getState());
        WechatAuth wechatAuth1 = wechatAuthService.getWechatAuthByOpenId("asdadadsadada");
        System.out.println(wechatAuth1.getPersonInfo().getName());
    }

}