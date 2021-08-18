package com.live.mall.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.live.mall.oms.mapper.OrderItemMapper;
import com.live.mall.oms.pojo.entity.OmsOrderItem;
import com.live.mall.oms.service.IOrderItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OmsOrderItem> implements IOrderItemService {


}
