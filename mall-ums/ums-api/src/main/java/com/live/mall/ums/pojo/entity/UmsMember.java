package com.live.mall.ums.pojo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.live.common.base.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.List;

@Data
@Accessors(chain = true)
public class UmsMember extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Integer gender;

    private String nickName;

    private String mobile;

    private LocalDate birthday;

    private String avatarUrl;

    private String openid;

    private String sessionKey;

    private Integer status;

    private Integer point;

    private Integer deleted;

    @TableField(exist = false)
    private List<UmsAddress> addressList;

    private Long balance;

    private String city;

    private String country;

    private String language;

    private String province;

}
