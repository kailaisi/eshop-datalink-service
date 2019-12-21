package com.kailaisi.eshopdatalinkservice.datasource;

import com.kailaisi.eshopdatalinkservice.EshopDatalinkServiceApplication;
import com.kailaisi.eshopdatalinkservice.mgb.mapper.UmsAdminMapper;
import com.kailaisi.eshopdatalinkservice.mgb.model.UmsAdmin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {EshopDatalinkServiceApplication.class})// 指定启动类
public class DaoTest {
    @Autowired
    UmsAdminMapper mapper;

    @Test
    public void test01() {
        mapper.insert(new UmsAdmin());
        mapper.selectByPrimaryKey(12);
    }
}