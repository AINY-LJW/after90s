/**============================================================
 * 版权： 
 * 包： com.after90s.core.project.user.controller
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月21日       lijiawen        
 * ============================================================*/

package com.after90s.core.project.user.controller;

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

import com.after90s.core.project.post.domin.PostEntity;
import com.after90s.core.project.post.service.IPostService;
import com.after90s.core.project.role.domin.RoleEntity;
import com.after90s.core.project.role.service.IRoleService;
import com.after90s.core.project.user.domin.UserEntity;
import com.after90s.core.project.user.service.IUserService;
import com.after90s.frame.web.controller.BaseController;
import com.after90s.frame.web.domin.MessageEntity;
import com.after90s.frame.web.page.domin.TableDataInfoEntity;


/**
 * <p>TODO 用户相关Controller</p>
 *
 *
 * @author lijiawen
 * @version 2019年7月21日
 */
@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController{


    private String prefix = "system/user";

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPostService postService;

    @RequiresPermissions("system:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    @RequiresPermissions("system:user:list")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfoEntity list(UserEntity user)
    {
        startPage();
        List<UserEntity> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    /**
     * 修改用户
     */
    @RequiresPermissions("system:user:edit")
//    @Log(title = "系统管理", action = "用户管理-修改用户")
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, Model model)
    {
        UserEntity user = userService.selectUserById(userId);
        List<RoleEntity> roles = roleService.selectRolesByUserId(userId);
        List<PostEntity> posts = postService.selectPostsByUserId(userId);
        model.addAttribute("roles", roles);
        model.addAttribute("posts", posts);
        model.addAttribute("user", user);
        return prefix + "/edit";
    }

    /**
     * 新增用户
     */
    @RequiresPermissions("system:user:add")
//    @Log(title = "系统管理", action = "用户管理-新增用户")
    @GetMapping("/add")
    public String add(Model model)
    {
        List<RoleEntity> roles = roleService.selectRoleAll();
        List<PostEntity> posts = postService.selectPostAll();
        model.addAttribute("roles", roles);
        model.addAttribute("posts", posts);
        return prefix + "/add";
    }

    @RequiresPermissions("system:user:resetPwd")
//    @Log(title = "系统管理", action = "用户管理-重置密码")
    @GetMapping("/resetPwd/{userId}")
    public String resetPwd(@PathVariable("userId") Long userId, Model model)
    {
        UserEntity user = userService.selectUserById(userId);
        model.addAttribute("user", user);
        return prefix + "/resetPwd";
    }

    @RequiresPermissions("system:user:resetPwd")
//    @Log(title = "系统管理", action = "用户管理-重置密码")
    @PostMapping("/resetPwd")
    @ResponseBody
    public MessageEntity resetPwd(UserEntity user)
    {
        int rows = userService.resetUserPwd(user);
        if (rows > 0)
        {
            return MessageEntity.success();
        }
        return MessageEntity.error();
    }

    @RequiresPermissions("system:user:remove")
//    @Log(title = "系统管理", action = "用户管理-删除用户")
    @RequestMapping("/remove/{userId}")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public MessageEntity remove(@PathVariable("userId") Long userId)
    {
        UserEntity user = userService.selectUserById(userId);
        if (user == null)
        {
            return MessageEntity.error("用户不存在");
        }
        if (userService.deleteUserById(userId) > 0)
        {
            return MessageEntity.success();
        }
        return MessageEntity.error();
    }

    @RequiresPermissions("system:user:batchRemove")
//    @Log(title = "系统管理", action = "用户管理-批量删除")
    @PostMapping("/batchRemove")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public MessageEntity batchRemove(@RequestParam("ids[]") Long[] ids)
    {
        int rows = userService.batchDeleteUser(ids);
        if (rows > 0)
        {
            return MessageEntity.success();
        }
        return MessageEntity.error();
    }

    /**
     * 保存用户
     */
    @RequiresPermissions("system:user:save")
//    @Log(title = "系统管理", action = "用户管理-保存用户")
    @PostMapping("/save")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public MessageEntity save(UserEntity user)
    {
        if (userService.saveUser(user) > 0)
        {
            return MessageEntity.success();
        }
        return MessageEntity.error();
    }

    /**
     * 校验用户名
     */
    @PostMapping("/checkLoginNameUnique")
    @ResponseBody
    public String checkLoginNameUnique(UserEntity user)
    {
        String uniqueFlag = "0";
        if (user != null)
        {
            uniqueFlag = userService.checkLoginNameUnique(user.getLoginName());
        }
        return uniqueFlag;
    }


    /**
     * 校验手机号码
     */
    @PostMapping("/checkPhoneUnique")
    @ResponseBody
    public String checkPhoneUnique(UserEntity user)
    {
        String uniqueFlag = "0";
        if (user != null)
        {
            uniqueFlag = userService.checkPhoneUnique(user);
        }
        return uniqueFlag;
    }

    /**
     * 校验手机号码
     */
    @PostMapping("/checkEmailUnique")
    @ResponseBody
    public String checkEmailUnique(UserEntity user)
    {
        String uniqueFlag = "0";
        if (user != null)
        {
            uniqueFlag = userService.checkEmailUnique(user);
        }
        return uniqueFlag;
    }

}
