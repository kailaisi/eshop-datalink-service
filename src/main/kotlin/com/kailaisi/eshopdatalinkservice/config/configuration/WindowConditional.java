package com.kailaisi.eshopdatalinkservice.config.configuration;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 描述：测试condition注解方法
 * <p/>作者：wu
 * <br/>创建时间：2019/12/21 22:00
 */
public class WindowConditional implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        return true;
    }
}
