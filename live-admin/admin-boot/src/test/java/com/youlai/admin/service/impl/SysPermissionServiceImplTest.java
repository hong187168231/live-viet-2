package com.live.admin.service.impl;

import com.live.admin.mapper.SysPermissionMapper;
import com.live.admin.pojo.entity.SysPermission;
import com.live.admin.service.ISysPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author puff
 * @description TODO
 * @createTime 2021/5/30 23:19
 */
@SpringBootTest
@Slf4j
class SysPermissionServiceImplTest {

    @Autowired
    SysPermissionMapper sysPermissionMapper;

    ISysPermissionService iSysPermissionService;

    @Test
    void listPermissionRoles() {
        List<SysPermission> sysPermissions = sysPermissionMapper.listPermRoles();
        log.info(sysPermissions.toString());
    }

    @Test
    void refreshPermRolesRules(){

    }
}
