package com.live.mall.oms.pojo.dto;

import com.live.mall.oms.pojo.entity.OmsOrder;
import com.live.mall.oms.pojo.entity.OmsOrderItem;
import com.live.mall.ums.pojo.dto.MemberDTO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author huawei
 * @desc
 * @email huawei_code@163.com
 * @date 2021/1/19
 */
@Data
@Accessors(chain = true)
public class OrderDTO {

    private OmsOrder order;

    private List<OmsOrderItem> orderItems;

    private MemberDTO member;

}
