package com.yangjiayu.audio.system.client.impl;


import com.yangjiayu.audio.system.client.SecurityLoginFeignClient;
import com.yangjiayu.audio.common.result.Result;
import com.yangjiayu.audio.model.system.SysUser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecurityLoginDegradeFeignClient implements SecurityLoginFeignClient {


    @Override
    public Result<SysUser> getByUsername(String username) {
        return null;
    }

    @Override
    public Result<List<String>> findUserPermsList(Long userId) {
        return null;
    }
}
