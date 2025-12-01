package com.yangjiayu.audio.search.client;

import com.yangjiayu.audio.search.client.impl.SearchDegradeFeignClient;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * 产品列表API接口
 * </p>
 *
 * 
 */
@FeignClient(value = "service-search", fallback = SearchDegradeFeignClient.class)
public interface SearchFeignClient {

}