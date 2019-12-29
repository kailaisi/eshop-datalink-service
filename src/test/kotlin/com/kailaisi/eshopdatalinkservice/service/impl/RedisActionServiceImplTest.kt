package com.kailaisi.eshopdatalinkservice.service.impl

import com.kailaisi.eshopdatalinkservice.service.RedisActionService
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


/**
 * 描述：
 *
 * 作者：wu
 * <br></br>创建时间：2019/12/29 1:49
 */
@SpringBootTest
class RedisActionServiceImplTest {
    @Autowired
    lateinit var redisActionServiceImpl:RedisActionServiceImpl

    @Test
    fun rob() {
        redisActionServiceImpl.rob("hongbao_3_1577544229779")
    }
}