package com.yangjiayu.audio.account.client;

import com.yangjiayu.audio.account.client.impl.UserAccountDegradeFeignClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * 产品列表API接口
 * </p>
 *
 */
@FeignClient(value = "service-account", fallback = UserAccountDegradeFeignClient.class)
public interface UserAccountFeignClient {

}