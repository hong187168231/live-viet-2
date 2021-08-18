package com.live.mall.pms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.live.mall.pms.pojo.dto.admin.GoodsFormDTO;
import com.live.mall.pms.pojo.entity.PmsSpu;
import com.live.mall.pms.pojo.vo.admin.GoodsDetailVO;

import java.util.List;


public interface IPmsSpuService extends IService<PmsSpu> {

    IPage<PmsSpu> list(Page<PmsSpu> page,  String name,Long categoryId);

    boolean addGoods(GoodsFormDTO goodsFormDTO);

    boolean removeByGoodsIds(List<Long> spuIds);

    boolean updateGoods(GoodsFormDTO goodsFormDTO);

    GoodsDetailVO getGoodsById(Long id);
}
