package com.live.user.intercept;

import com.live.common.annotation.AllowAccess;
import com.live.common.constant.AuthConstants;
import com.live.common.web.exception.BizException;
import com.live.common.web.util.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        AllowAccess annotation;
        if(handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(AllowAccess.class);
        }else{
            return true;
        }

        if(annotation == null){
            return true;
        }

        //获取用户凭证
        String token = request.getHeader(AuthConstants.AUTHORIZATION_KEY);
        if(StringUtils.isBlank(token)){
            token = request.getParameter(AuthConstants.AUTHORIZATION_KEY);
        }

        //凭证为空
        if(StringUtils.isBlank(token)){
            throw new BizException("凭证不能为空");
        }


        //设置userId到request里，后续根据userId，获取用户信息
//        request.setAttribute(USER_KEY, Long.parseLong(claims.getSubject()));

        return true;
    }
}
