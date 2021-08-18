package com.live.admin.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.live.admin.pojo.entity.SysDept;
import com.live.admin.pojo.vo.DeptVO;
import com.live.admin.pojo.vo.TreeVO;

import java.util.List;

public interface ISysDeptService extends IService<SysDept> {

    List<DeptVO> listDeptVO(LambdaQueryWrapper<SysDept> baseQuery);

    List<TreeVO> listTreeVO(LambdaQueryWrapper<SysDept> baseQuery);
}
