package com.live.mall.pms.api;

import com.live.common.result.Result;
import com.live.mall.pms.pojo.dto.app.SkuDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "mall-pms",contextId = "goods")
public interface GoodsFeignClient {

    /**
     * 获取商品信息
     */
    @GetMapping("/app-api/v1/stocks/{id}")
    Result<SkuDTO> getSkuById(@PathVariable Long id);
}
