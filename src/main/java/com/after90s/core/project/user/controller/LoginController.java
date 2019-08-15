/**============================================================
 * 版权： 
 * 包： com.after90s.core.project.user
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月21日       lijiawen        
 * ============================================================*/

package com.after90s.core.project.user.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.after90s.common.utils.StringUtils;
import com.after90s.frame.web.controller.BaseController;
import com.after90s.frame.web.domin.MessageEntity;

/**
 * <p>TODO 登陆相关</p>
 *
 *
 * @author lijiawen
 * @version 2019年7月21日
 */
@Controller
public class LoginController extends BaseController{


    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
	/**
	 * 
	 * 
	 * @param username
	 * @param password
	 * @param rememberMe
	 * @return MessageEntity
	 */
    @PostMapping("/login")
    @ResponseBody
    public MessageEntity ajaxLogin(String username, String password, Boolean rememberMe)
    {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try
        {
            subject.login(token);
            return MessageEntity.success();
        }
        catch (AuthenticationException e)
        {
            String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage()))
            {
                msg = e.getMessage();
            }
            return MessageEntity.error(msg);
        }
    }

    @GetMapping("/unauth")
    public String unauth()
    {
        return "/error/unauth";
    }

}
