package com.live.lottery.controller;

import com.alibaba.fastjson.JSON;
import com.live.common.annotation.LoginUser;
import com.live.common.pojo.bo.LoginInfo;
import com.live.common.redis.utils.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "demo接口")
@RestController
@RequestMapping("/demo")
@Slf4j
@AllArgsConstructor
public class DemoController {

    @ApiOperation(value = "demo接口")
    @GetMapping("/hello")
    public String detail(@LoginUser LoginInfo loginInfo) {
        System.out.println(JSON.toJSONString(loginInfo));
        return "ok";
    }

}
