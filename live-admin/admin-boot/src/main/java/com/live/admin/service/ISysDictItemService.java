package com.live.admin.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.live.admin.pojo.entity.SysDictItem;


public interface ISysDictItemService extends IService<SysDictItem> {

    IPage<SysDictItem> list(Page<SysDictItem> page, SysDictItem dict);


}
