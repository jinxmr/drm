package com.ddl.web.system.user.controller;

import java.util.List;

import com.ddl.model.AjaxResult;
import com.ddl.model.TableDataInfo;
import com.ddl.utils.PasswordEncryptionUtil;
import com.ddl.web.enums.BusinessType;
import com.ddl.web.system.controller.BaseController;
import com.ddl.web.system.generater.domain.TableInfo;
import com.ddl.web.system.user.domain.SysRole;
import com.ddl.web.system.user.domain.SysUser;
import com.ddl.web.system.user.service.IUserService;
import com.ddl.web.system.user.service.SysRoleService;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 用户 信息操作处理
 *
 * @author drm
 * @date 2019-09-02
 */
@Api(description = "用户User")
@Controller
@RequestMapping("back/sysUser" )
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @Autowired
    private SysRoleService sysRoleService;

    @Value("${initialize.password}")
    private String initPassword;

    @RequiresPermissions("system:user:view" )
    @GetMapping("")
    public String user() {
        return "system/user/user" ;
    }

    /**
     * 查询用户列表
     */
    @ApiOperation(value = "获取用户列表")
    @RequiresPermissions("system:user:list" )
    @GetMapping("/list" )
    @ResponseBody
    public TableDataInfo list(SysUser user, TableDataInfo<TableInfo> param) {

        PageHelper.startPage(param.getPage(), param.getLimit());
        List<SysUser> list = userService.selectUserList(user);
        TableDataInfo dataTable = getDataTable(list);
        return dataTable;
    }

    /**
     * 新增用户
     */
    @GetMapping("/add" )
    public String add(Model model) {
        //查询所有权限
        SysRole role = new SysRole();
        List<SysRole> sysRoleList = sysRoleService.selectRoleList(role);
        model.addAttribute("roles", sysRoleList);
        return "system/user/add" ;
    }

    /**
     * 新增保存用户
     */
    @RequiresPermissions("system:user:add" )
    @PostMapping("/add" )
    @ResponseBody
    public AjaxResult addSave(SysUser user, String roleId) {
        int res = 0;
        try {
            res = userService.insertUser(user, roleId);
        } catch (RuntimeException r) {
            return AjaxResult.error(r.getMessage());
        }
        return toAjax(res);
    }

    /**
     * 修改用户
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id" ) Integer id, ModelMap mmap) {
        SysUser user =userService.selectUserById(id);
        mmap.put("user" , user);

        //根据用户ID查询角色绑定信息
        SysRole role = new SysRole();
        List<SysRole> sysRoleList = sysRoleService.selectRoleListByUserId(id);
        mmap.addAttribute("roles", sysRoleList);
        return "system/user/edit" ;
    }

    /**
     * 修改保存用户
     */
    @RequiresPermissions("system:user:edit" )
    @PostMapping("/edit" )
    @ResponseBody
    public AjaxResult editSave(SysUser user, String roleId) {
        int res = 0;
        try {
            res = userService.updateUser(user, roleId);
        } catch (RuntimeException r) {
            return AjaxResult.error(r.getMessage());
        }
        return toAjax(res);
    }

    /**
     * 删除用户
     */
    @RequiresPermissions("system:user:remove" )
    @PostMapping("/remove" )
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(userService.deleteUserByIds(ids));
    }

    /**
     * 重置密码
     * @param user
     * @return
     */
    @RequiresPermissions("system:user:reset" )
    @PostMapping("/reset" )
    @ResponseBody
    public AjaxResult pwdReset(SysUser user) {
        SysUser sysUser = userService.selectUserById(user.getId());
        String pwd = PasswordEncryptionUtil.encryptPassword(initPassword, sysUser.getLoginName());
        user.setPassword(pwd); //赋初始化密码
        return toAjax(userService.updateUser(user, null));
    }

}
