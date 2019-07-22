/**============================================================
 * 版权： 
 * 包： com.after90s.core.project.role.controller
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月21日       lijiawen        
 * ============================================================*/

package com.after90s.core.project.role.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.after90s.core.project.role.domin.RoleEntity;
import com.after90s.core.project.role.service.IRoleService;
import com.after90s.frame.web.controller.BaseController;
import com.after90s.frame.web.domin.MessageEntity;
import com.after90s.frame.web.page.domin.TableDataInfoEntity;

/**
 * <p>TODO 角色相关Controller</p>
 *
 *
 * @author lijiawen
 * @version 2019年7月21日
 */
@Controller
@RequestMapping("/system/role")
public class RoleController extends BaseController{


    private String prefix = "system/role";

    @Autowired
    private IRoleService roleService;

    @RequiresPermissions("system:role:view")
    @GetMapping()
    public String role()
    {
        return prefix + "/role";
    }

    @RequiresPermissions("system:role:list")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfoEntity list(RoleEntity role)
    {
        startPage();
        List<RoleEntity> list = roleService.selectRoleList(role);
        return getDataTable(list);
    }

    /**
     * 新增角色
     */
    @RequiresPermissions("system:role:add")
//    @Log(title = "系统管理", action = "角色管理-新增角色")
    @GetMapping("/add")
    public String add(Model model)
    {
        return prefix + "/add";
    }

    /**
     * 修改角色
     */
    @RequiresPermissions("system:role:edit")
//    @Log(title = "系统管理", action = "角色管理-修改角色")
    @GetMapping("/edit/{roleId}")
    public String edit(@PathVariable("roleId") Long roleId, Model model)
    {
        RoleEntity role = roleService.selectRoleById(roleId);
        model.addAttribute("role", role);
        return prefix + "/edit";
    }

    /**
     * 保存角色
     */
    @RequiresPermissions("system:role:save")
//    @Log(title = "系统管理", action = "角色管理-保存角色")
    @PostMapping("/save")
    @Transactional(rollbackFor=Exception.class)
    @ResponseBody
    public MessageEntity save(RoleEntity role)
    {
        if (roleService.saveRole(role) > 0)
        {
            return MessageEntity.success();
        }
        return MessageEntity.error();
    }

    @RequiresPermissions("system:role:remove")
//    @Log(title = "系统管理", action = "角色管理-删除角色")
    @RequestMapping("/remove/{roleId}")
    @Transactional(rollbackFor=Exception.class)
    @ResponseBody
    public MessageEntity remove(@PathVariable("roleId") Long roleId)
    {
        RoleEntity role = roleService.selectRoleById(roleId);
        if (role == null)
        {
            return MessageEntity.error("角色不存在");
        }
        if (roleService.selectCountUserRoleByRoleId(roleId) > 0)
        {
            return MessageEntity.error("角色已分配,不能删除");
        }
        if (roleService.deleteRoleById(roleId) > 0)
        {
            return MessageEntity.success();
        }
        return MessageEntity.error();
    }

    @RequiresPermissions("system:role:batchRemove")
//    @Log(title = "系统管理", action = "角色管理-批量删除")
    @PostMapping("/batchRemove")
    @ResponseBody
    public MessageEntity batchRemove(@RequestParam("ids[]") Long[] ids)
    {
        int rows = roleService.batchDeleteRole(ids);
        if (rows > 0)
        {
            return MessageEntity.success();
        }
        return MessageEntity.error();
    }

    /**
     * 校验角色名称
     */
    @PostMapping("/checkRoleNameUnique")
    @ResponseBody
    public String checkRoleNameUnique(RoleEntity role)
    {
        String uniqueFlag = "0";
        if (role != null)
        {
            uniqueFlag = roleService.checkRoleNameUnique(role);
        }
        return uniqueFlag;
    }

    /**
     * 选择菜单树
     */
    @GetMapping("/selectMenuTree")
    public String selectMenuTree()
    {
        return prefix + "/tree";
    }


}
