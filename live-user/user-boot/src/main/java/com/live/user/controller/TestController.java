package com.live.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "会员接口")
@RestController
@RequestMapping("/test")
@Slf4j
@AllArgsConstructor
public class TestController {


    @ApiOperation(value = "hello")
    @GetMapping("/hello")
    public String detail() {

        return "ok";
    }


}
