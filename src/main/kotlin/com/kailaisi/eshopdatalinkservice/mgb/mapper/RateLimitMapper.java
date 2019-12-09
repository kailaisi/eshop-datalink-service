package com.kailaisi.eshopdatalinkservice.mgb.mapper;

import com.kailaisi.eshopdatalinkservice.config.mapper.CrudMapper;
import com.kailaisi.eshopdatalinkservice.mgb.model.RateLimit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface RateLimitMapper extends CrudMapper<RateLimit> {
    @Nullable
    RateLimit selectByName(@NotNull String uri);
}