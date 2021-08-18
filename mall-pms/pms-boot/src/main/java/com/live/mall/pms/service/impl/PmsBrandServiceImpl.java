package com.live.mall.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.live.mall.pms.pojo.entity.PmsBrand;
import com.live.mall.pms.mapper.PmsBrandMapper;
import com.live.mall.pms.service.IPmsBrandService;
import org.springframework.stereotype.Service;

@Service
public class PmsBrandServiceImpl extends ServiceImpl<PmsBrandMapper, PmsBrand> implements IPmsBrandService {
}
