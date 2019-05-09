package com.real.o2o.service;

import com.real.o2o.BaseTest;
import com.real.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author: mabin
 * @create: 2019/4/12 18:36
 */
public class AreaServiceTest extends BaseTest {

    @Autowired
    private AreaService areaService;

    @Test
    public void testGetAreaList(){
        List<Area> areaList = areaService.getAreaList();
        assertEquals("西苑",areaList.get(0).getAreaName());
    }
}
