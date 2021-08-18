package com.live.mall.oms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.live.mall.oms.mapper.OrderSettingMapper;
import com.live.mall.oms.pojo.entity.OmsOrderSetting;
import com.live.mall.oms.service.IOrderSettingService;
import org.springframework.stereotype.Service;


@Service
public class OrderSettingServiceImpl extends ServiceImpl<OrderSettingMapper, OmsOrderSetting> implements IOrderSettingService {

}
