package com.real.o2o.service;

import com.real.o2o.BaseTest;
import com.real.o2o.dto.LocalAuthExecution;
import com.real.o2o.entity.LocalAuth;
import com.real.o2o.entity.PersonInfo;
import com.real.o2o.enums.LocalAuthStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author: mabin
 * @create: 2019/5/3 7:08
 */
public class LocalAuthServiceTest extends BaseTest {

    @Autowired
    private LocalAuthService localAuthService;

    @Test
    public void testBindLocalAuth(){
        LocalAuth localAuth = new LocalAuth();
        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserId(1L);
        localAuth.setPersonInfo(personInfo);
        localAuth.setUsername("aaaaaa");
        localAuth.setPassword("bbbbbb");
        LocalAuthExecution localAuthExecution = localAuthService.bindLocalAuth(localAuth);
        assertEquals(LocalAuthStateEnum.SUCCESS.getState(),localAuthExecution.getState());
        personInfo.setUserId(2L);
        localAuthExecution = localAuthService.bindLocalAuth(localAuth);
        assertEquals(LocalAuthStateEnum.ONLY_ONE_ACCOUNT.getState(),localAuthExecution.getState());
    }

    @Test
    public void testModifyLocalAuth(){

        LocalAuthExecution localAuthExecution = localAuthService.modifyLocalAuth(2L,"aaa","bbb","ccc");
        assertEquals(LocalAuthStateEnum.SUCCESS.getState(),localAuthExecution.getState());
    }
}