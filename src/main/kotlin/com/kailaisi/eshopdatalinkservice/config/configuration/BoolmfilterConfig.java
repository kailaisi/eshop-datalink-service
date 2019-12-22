package com.kailaisi.eshopdatalinkservice.config.configuration;

import com.kailaisi.eshopdatalinkservice.config.intercepter.BoomFilter;
import com.kailaisi.eshopdatalinkservice.config.intercepter.CorrectRatio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BoolmfilterConfig {
    @Value("${boolmfilter.inputnum.pow}")
    private Long pow;

    @Bean
    public BoomFilter getBoomfilter() {
        //输入数据量cap=输入数据量 * hash个数
        // hash个数就是seed数 所以要求seed个数为2的幂次方 输入量也要是2的幂次方 详情参考hashMap容量为什么为2的幂次方
        BoomFilter boolmfilter = new BoomFilter(CorrectRatio.HIGH, (long) 1 << pow);
        return boolmfilter;
    }
}