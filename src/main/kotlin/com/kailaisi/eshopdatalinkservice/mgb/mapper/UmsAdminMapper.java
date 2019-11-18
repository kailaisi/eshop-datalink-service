package com.kailaisi.eshopdatalinkservice.mgb.mapper;

import com.kailaisi.eshopdatalinkservice.config.mapper.CrudMapper;
import com.kailaisi.eshopdatalinkservice.mgb.model.UmsAdmin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface UmsAdminMapper extends CrudMapper<UmsAdmin> {
    List<UmsAdmin> getAdminByUserName(@NotNull String username);
}