package com.live.mall.oms.pojo.vo;

import com.live.common.base.BaseVO;
import com.live.mall.oms.pojo.dto.OrderItemDTO;
import com.live.mall.ums.pojo.entity.UmsAddress;
import lombok.Data;

import java.util.List;


@Data
public class OrderConfirmVO extends BaseVO {

    private String orderToken;

    private List<OrderItemDTO> orderItems;

    private List<UmsAddress> addresses;

}
