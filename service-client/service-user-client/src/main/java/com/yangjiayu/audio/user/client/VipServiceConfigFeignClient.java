package com.yangjiayu.audio.user.client;

import com.yangjiayu.audio.user.client.impl.VipServiceConfigDegradeFeignClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * 产品列表API接口
 * </p>
 *
 * 
 */
@FeignClient(value = "service-user", fallback = VipServiceConfigDegradeFeignClient.class)
public interface VipServiceConfigFeignClient {


}