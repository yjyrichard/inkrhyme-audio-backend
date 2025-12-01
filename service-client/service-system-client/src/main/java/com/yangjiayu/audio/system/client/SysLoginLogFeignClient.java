package com.yangjiayu.audio.system.client;

import com.yangjiayu.audio.system.client.impl.SysLoginLogDegradeFeignClient;
import com.yangjiayu.audio.common.result.Result;
import com.yangjiayu.audio.model.system.SysLoginLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 * 产品列表API接口
 * </p>
 *
 * 
 */
@FeignClient(value = "service-system", fallback = SysLoginLogDegradeFeignClient.class)
public interface SysLoginLogFeignClient {

    /**
     * 记录登录日志
     * @param sysLoginLog
     * @return
     */
    @PostMapping("/admin/system/sysLoginLog/recordLoginLog")
    Result recordLoginLog(@RequestBody SysLoginLog sysLoginLog);
}