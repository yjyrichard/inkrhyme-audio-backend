package com.yangjiayu.audio.system.client.impl;


import com.yangjiayu.audio.system.client.SysOperLogFeignClient;
import com.yangjiayu.audio.common.result.Result;
import com.yangjiayu.audio.model.system.SysOperLog;
import org.springframework.stereotype.Component;

@Component
public class SysOperLogDegradeFeignClient implements SysOperLogFeignClient {


    @Override
    public Result saveSysLog(SysOperLog sysOperLog) {
        return null;
    }
}
