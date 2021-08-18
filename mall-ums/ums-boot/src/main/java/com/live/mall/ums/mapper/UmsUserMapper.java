package com.live.mall.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.live.mall.ums.pojo.entity.UmsMember;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UmsUserMapper extends BaseMapper<UmsMember> {


    @Select("<script>" +
            " SELECT * from ums_member " +
            " <if test ='user.nickname !=null and user.nickname.trim() neq \"\" ' >" +
            "       AND nickname like concat('%',#{user.nickname},'%')" +
            " </if>" +
            " ORDER BY gmt_modified DESC, gmt_create DESC" +
            "</script>")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "addressList", column = "id", many = @Many(select = "com.live.mall.ums.mapper.UmsAddressMapper.listByUserId"))
    })
    List<UmsMember> list(Page<UmsMember> page, UmsMember user);


}
