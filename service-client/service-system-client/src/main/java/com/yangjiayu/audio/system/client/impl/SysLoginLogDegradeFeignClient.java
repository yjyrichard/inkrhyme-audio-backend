package com.yangjiayu.audio.system.client.impl;


import com.yangjiayu.audio.system.client.SysLoginLogFeignClient;
import com.yangjiayu.audio.common.result.Result;
import com.yangjiayu.audio.model.system.SysLoginLog;
import org.springframework.stereotype.Component;

@Component
public class SysLoginLogDegradeFeignClient implements SysLoginLogFeignClient {


    @Override
    public Result recordLoginLog(SysLoginLog sysLoginLog) {
        return null;
    }
}
