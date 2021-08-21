package com.live.user.controller;

import com.live.common.redis.utils.RedisUtils;
import com.live.user.pojo.entity.MemBaseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "会员接口")
@RestController
@RequestMapping("/test")
@Slf4j
@AllArgsConstructor
public class TestController {

    @Resource
    private RedisUtils redisUtils;

    @ApiOperation(value = "hello")
    @GetMapping("/hello")
    public String detail() {
        MemBaseInfo memBaseInfo = new MemBaseInfo();
        memBaseInfo.setAccount("dd");
        memBaseInfo.setBalance(2000L);
        redisUtils.set("dsd",memBaseInfo);
        return "ok";
    }


}
