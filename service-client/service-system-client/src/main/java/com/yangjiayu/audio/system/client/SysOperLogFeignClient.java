package com.yangjiayu.audio.system.client;

import com.yangjiayu.audio.system.client.impl.SysOperLogDegradeFeignClient;
import com.yangjiayu.audio.common.result.Result;
import com.yangjiayu.audio.model.system.SysOperLog;
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
@FeignClient(value = "service-system", fallback = SysOperLogDegradeFeignClient.class)
public interface SysOperLogFeignClient {

    /**
     * 记录日志
     * @param sysOperLog
     * @return
     */
    @PostMapping("/admin/system/sysOperLog/saveSysLog")
    public Result saveSysLog(@RequestBody SysOperLog sysOperLog);
}