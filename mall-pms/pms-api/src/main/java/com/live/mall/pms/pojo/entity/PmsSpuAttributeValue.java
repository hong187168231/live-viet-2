package com.live.mall.pms.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.live.common.base.BaseEntity;
import lombok.Data;

/**
 * @author puff
 * @date 2020-11-06
 */
@Data
public class PmsSpuAttributeValue extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long spuId;
    private Long attributeId;
    private String name;
    private String value;
    private Integer type;
    private String picUrl;

}
