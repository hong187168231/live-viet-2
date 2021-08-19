package com.live.mall.oms.api;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author puff
 * @description TODO
 * @createTime 2021/3/13 11:59
 */
@FeignClient("mall-oms")
public interface OrderFeignClient {
}
