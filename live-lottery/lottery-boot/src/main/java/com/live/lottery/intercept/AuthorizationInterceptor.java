package com.live.lottery.intercept;

import com.alibaba.fastjson.JSONObject;
import com.live.common.annotation.AllowAccess;
import com.live.common.constant.AppConstants;
import com.live.common.constant.AuthConstants;
import com.live.common.pojo.bo.LoginInfo;
import com.live.common.redis.utils.RedisUtils;
import com.live.common.result.ResultCode;
import com.live.common.utils.BaseUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取用户凭证
        String token = request.getHeader(AuthConstants.AUTHORIZATION_KEY);
        Object userObj = redisUtils.get(AppConstants.USER_LOGIN_ACCTOKEN + token);
        AllowAccess annotation;
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(AllowAccess.class);
        } else {
            return true;
        }
        if (annotation != null) {
            return super.preHandle(request, response, handler);
        } else if (StringUtils.isEmpty(token)) {
            BaseUtil.writer401Response(response, ResultCode.LIVE_ERROR_401);
            return false;
        } else if (null == userObj) {
            BaseUtil.writer401Response(response, ResultCode.LIVE_ERROR_401);
            return false;
        } else {
            LoginInfo loginInfo = JSONObject.parseObject((String) userObj, LoginInfo.class);
            if (loginInfo != null) {
                String newToken = (String) redisUtils.get(AppConstants.USER_LOGIN_INFO_KEY + loginInfo.getAccount());
                if (StringUtils.isEmpty(newToken)) {
                    BaseUtil.writer401Response(response, ResultCode.LIVE_ERROR_401);
                    return false;
                }
                if (!token.equals(newToken)) {
                    BaseUtil.writer401Response(response, ResultCode.RESOURCE_NOT_FOUND2);
                    redisUtils.del(token);
                    return false;
                }
                return super.preHandle(request, response, handler);
            }
        }
        return false;
    }
}
