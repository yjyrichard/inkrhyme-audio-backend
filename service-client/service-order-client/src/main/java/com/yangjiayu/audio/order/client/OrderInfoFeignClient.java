package com.yangjiayu.audio.order.client;

import com.yangjiayu.audio.order.client.impl.OrderInfoDegradeFeignClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * 产品列表API接口
 * </p>
 *
 */
@FeignClient(value = "service-order", fallback = OrderInfoDegradeFeignClient.class)
public interface OrderInfoFeignClient {


}