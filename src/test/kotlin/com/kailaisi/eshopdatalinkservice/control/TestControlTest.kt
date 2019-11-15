package com.kailaisi.eshopdatalinkservice.control

import org.junit.Test

import org.junit.runner.RunWith
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


/**
 * 描述：
 *
 * 作者：wu
 * <br></br>创建时间：2019/11/5 22:45
 */
@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class TestControlTest {
    @Autowired
    private lateinit var mvc: MockMvc
    @Test
    fun testString() {
        val request= post("/test/testString")
        mvc.perform(request)
                .andExpect { status().isOk }
                .andExpect { content().toString().contentEquals("{\n" +
                        "    \"model\": null,\n" +
                        "    \"code\": 40001,\n" +
                        "    \"msg\": \"系统请稍后重试\"\n" +
                        "}") }
    }

    @Test
    fun testBean() {
    }

    @Test
    fun testException() {
    }

    @Test
    fun testBusinessException() {
    }
}