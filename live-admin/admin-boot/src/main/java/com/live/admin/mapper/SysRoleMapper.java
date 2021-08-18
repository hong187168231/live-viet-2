package com.live.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.live.admin.pojo.entity.SysRole;
import com.live.admin.pojo.entity.SysUser;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {


}
