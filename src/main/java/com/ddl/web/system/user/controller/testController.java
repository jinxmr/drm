package com.ddl.web.system.user.controller;

import com.ddl.config.target.TargetDataSource;
import com.ddl.web.system.user.domain.SysUser;
import com.ddl.web.system.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class testController {

    @Autowired
    private IUserService userService;

    @GetMapping()
    @ResponseBody
    public String test() {
        SysUser user = userService.selectUserById(1);
        return user.toString();
    }

    @GetMapping("test1")
    @TargetDataSource("datasource2")
    @ResponseBody
    public String test1() {
        SysUser user = userService.selectUserById(1);
        return user.toString();
    }
}
