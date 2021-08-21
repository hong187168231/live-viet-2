package com.live.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.live.common.result.Result;
import com.live.user.pojo.entity.MemBaseInfo;
import com.live.user.pojo.entity.vo.AppLoginVo;
import com.live.user.pojo.req.LoginReq;

public interface MemBaseInfoService extends IService<MemBaseInfo> {

    Result<AppLoginVo> appLogin(LoginReq req);

}
