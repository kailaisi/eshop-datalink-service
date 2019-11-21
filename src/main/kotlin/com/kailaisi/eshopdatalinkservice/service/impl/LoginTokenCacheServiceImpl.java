package com.kailaisi.eshopdatalinkservice.service.impl;

import com.kailaisi.eshopdatalinkservice.model.LoginToken;
import com.kailaisi.eshopdatalinkservice.model.enums.CacheKeyEnum;
import com.kailaisi.eshopdatalinkservice.service.LoginTokenService;
import com.kailaisi.eshopdatalinkservice.util.LoginTokenHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.Assert;

import java.util.concurrent.TimeUnit;

@Slf4j
public class LoginTokenCacheServiceImpl implements LoginTokenService {

    private ValueOperations<String, LoginToken> loginTokenValueOps;

    private RedisTemplate<String, LoginToken> loginTokenTemplate;

    private String loginTokenCacheKeyPrefix;

    public LoginTokenCacheServiceImpl(RedisTemplate<String, LoginToken> loginTokenTemplate, String loginTokenCacheKeyPrefix) {
        Assert.notNull(loginTokenTemplate, "loginTokenTemplate is not null.");
        Assert.notNull(loginTokenCacheKeyPrefix, "loginTokenCacheKeyPrefix is not null.");

        this.loginTokenTemplate = loginTokenTemplate;
        this.loginTokenCacheKeyPrefix = loginTokenCacheKeyPrefix;
        this.loginTokenValueOps = loginTokenTemplate.opsForValue();
    }

    private String getLoginTokenCacheKey(String token) {
        return loginTokenCacheKeyPrefix + token;
    }

    @Override
    public LoginToken add(LoginToken loginToken) {
        Assert.notNull(loginToken, "loginToken is not null");
        Assert.notNull(loginToken.getLoginUser(), "loginToken.getLoginUser() is not null");

        String token = LoginTokenHelper.INSTANCE.generateToken(loginToken);
        loginToken.setId(token);
        loginTokenValueOps.set(this.getLoginTokenCacheKey(loginToken.getId()), loginToken, CacheKeyEnum.VALUE_LOGIN_TOKENS.getSec(), TimeUnit.SECONDS);
        return loginToken;
    }

    @Override
    public void deleteById(String id) {
        Assert.notNull(id, "id is not null");

        loginTokenTemplate.delete(this.getLoginTokenCacheKey(id));
    }

    @Override
    public LoginToken getById(String id) {
        Assert.notNull(id, "id is not null");

        return loginTokenValueOps.get(this.getLoginTokenCacheKey(id));
    }

    @Override
    public long ttl(String id) {
        Assert.notNull(id, "id is not null");

        return loginTokenTemplate.getExpire(this.getLoginTokenCacheKey(id), TimeUnit.SECONDS);
    }

}
