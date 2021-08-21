package com.live.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.live.common.constant.AppConstants;
import com.live.common.pojo.bo.LoginInfo;
import com.live.common.redis.utils.RedisUtils;
import com.live.common.result.Result;
import com.live.common.utils.CopyUtils;
import com.live.common.utils.RandomUtil;
import com.live.common.utils.encrypt.MD5;
import com.live.user.common.constant.UserConstants;
import com.live.user.mapper.MemBaseInfoMapper;
import com.live.user.pojo.entity.MemBaseInfo;
import com.live.user.pojo.entity.vo.AppLoginVo;
import com.live.user.pojo.req.LoginReq;
import com.live.user.service.MemBaseInfoService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemBaseInfoServiceImpl extends ServiceImpl<MemBaseInfoMapper, MemBaseInfo> implements MemBaseInfoService {

    @Resource
    private MemBaseInfoMapper memBaseInfoMapper;
    @Resource
    private RedisUtils redisUtils;

    @Override
    public Result<AppLoginVo> appLogin(LoginReq req) {
        if (StringUtils.isBlank(req.getAccount())) {
            return Result.failed("请填写账号！");
        }
        if (StringUtils.isBlank(req.getPassword())) {
            return Result.failed("请填写密码！");
        }
        req.setPassword(req.getPassword().toLowerCase());
        MemBaseInfo userInfo = memBaseInfoMapper.
                selectOne(new LambdaQueryWrapper<MemBaseInfo>().eq(MemBaseInfo::getAccount, req.getAccount()));
        //判断密码是否正确
        if (!req.getPassword().equals(userInfo.getPassword())) {
            return Result.failed("密码错误！");
        }

        String seckey = req.getAccount() + RandomUtil.uuid();
        String accToken = MD5.md5(seckey, "UTF-8");

        redisUtils.set(AppConstants.USER_LOGIN_ACCTOKEN + accToken, JSON.toJSONString(userInfo), 60 * 60 * 24 * 7);
        redisUtils.set(AppConstants.USER_LOGIN_INFO_KEY + req.getAccount(), accToken, 60 * 60 * 24 * 7);
        //返回登录信息
        LoginInfo loginInfo = new LoginInfo();
        try {
            CopyUtils.conver(userInfo,loginInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        AppLoginVo appLoginVo = this.getAppLoginVo(accToken, userInfo);
        return Result.success(appLoginVo);
    }


    /**
     * 功能描述: 返回登录信息
     *
     * @auther:
     * @param: [token, userInfo]
     * @return: com.cp.common.vo.AppLoginVo
     * @date: 2020/8/5 14:59
     */
    private AppLoginVo getAppLoginVo(String token, MemBaseInfo memBaseInfo) {
        AppLoginVo appLoginVo = new AppLoginVo();
        appLoginVo.setToken(token);
//        appLoginVo.setNickName(userInfo.getNickname());
//        appLoginVo.setAccount(userInfo.getAccount());
//        appLoginVo.setMobilePhone(userInfo.getMobilePhone());
//        appLoginVo.setUid(userInfo.getId().toString());
//        appLoginVo.setSex(userInfo.getSex() == null ? 1 : userInfo.getSex());
//        appLoginVo.setHeadImage(minioConfig.getBaseUrl(userInfo.getHeadImage()));
//        Optional<Anchor> anchor = Optional.ofNullable(anchorRepositoryImpl.findAnchorByUid(userInfo.getId()));
//        if (anchor.isPresent()) {
//            appLoginVo.setRoomId(anchor.get().room_id);
//        }
//        Long days = DateUtils.getPastDaysWithNow(userInfo.getCreateTime().getTime());
//        appLoginVo.setRegisterDay(days.intValue());
        return appLoginVo;
    }

}
