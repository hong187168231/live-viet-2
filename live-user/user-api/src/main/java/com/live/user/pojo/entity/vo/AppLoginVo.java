package com.live.user.pojo.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName : LoginVo
 * @Description : 登陆后返回值
 * @Author :
 * @Date: 2020-07-02 14:17
 */
@Data
@ApiModel(value = "App登陆后返回类")
public class AppLoginVo {
    @ApiModelProperty(value = "登录后token")
    private String token="";
    @ApiModelProperty(value = "用户id")
    private String uid="";
    @ApiModelProperty(value = "用户账号")
    private String account="";
    @ApiModelProperty(value = "员工名称")
    private String nickName="";
    @ApiModelProperty(value = "手机号码")
    private String mobilePhone="";
    @ApiModelProperty(value = "头像url")
    private String headImage;
    @ApiModelProperty(value = "性别 0男 1女")
    private Integer sex=1;
    @ApiModelProperty(value = "等级")
    private Integer level =1;
    @ApiModelProperty(value = "是否是vip 0否1是")
    private Integer isVip =0;
    @ApiModelProperty(value = "房间id")
    private Long roomId;
    @ApiModelProperty(value = "注册天数")
    private Integer registerDay;

}
