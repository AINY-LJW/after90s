/**============================================================
 * 版权： 
 * 包： com.after90s.frame.web.controller
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月21日       lijiawen        
 * ============================================================*/

package com.after90s.frame.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.after90s.core.project.menu.domin.MenuEntity;
import com.after90s.core.project.menu.service.IMenuService;
import com.after90s.core.project.user.domin.UserEntity;

/**
 * <p>TODO 首页Controller</p>
 *
 *
 * @author lijiawen
 * @version 2019年7月21日
 */
@Controller
public class HomePageController extends BaseController{

    @Autowired
    private IMenuService menuService;

//    @Autowired
//    private RuoYiConfig ruoYiConfig;

    // 系统首页
    @GetMapping("/index")
    public String index(Model model)
    {
        // 取身份信息
        UserEntity user = getUser();
        // 根据用户id取出菜单
        List<MenuEntity> menus = menuService.selectMenusByUserId(user.getUserId());
        model.addAttribute("menus", menus);
        model.addAttribute("user", user);
//        model.addAttribute("copyrightYear", ruoYiConfig.getCopyrightYear());
        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(Model model)
    {
//        model.addAttribute("version", ruoYiConfig.getVersion());
        return "main";
    }


}
