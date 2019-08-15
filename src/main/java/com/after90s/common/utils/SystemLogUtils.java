/**============================================================
 * 版权： 
 * 包： com.after90s.common.utils
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月20日       lijiawen        
 * ============================================================*/

package com.after90s.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.after90s.common.constant.CommonConstant;
import com.after90s.core.monitor.accessLog.domin.AccessLogEntity;
import com.after90s.core.monitor.accessLog.service.AccessLogServiceImpl;

import eu.bitwalker.useragentutils.UserAgent;

/**
 * <p>TODO 类描述</p>
 *
 * <p>
 * </p>
 *
 * @author lijiawen
 * @version 2019年7月20日
 */

public class SystemLogUtils {


    private static final Logger sys_user_logger = LoggerFactory.getLogger("sys-user");

    /**
     * 记录格式 [ip][用户名][操作][错误消息]
     * <p/>
     * 注意操作如下： loginError 登录失败 loginSuccess 登录成功 passwordError 密码错误 changePassword 修改密码 changeStatus 修改状态
     *
     * @param username
     * @param op
     * @param msg
     * @param args
     */
    public static void log(String username, String status, String msg, Object... args)
    {
        StringBuilder s = new StringBuilder();
        s.append(LogUtils.getBlock(ShiroUtils.getIp()));
        s.append(LogUtils.getBlock(username));
        s.append(LogUtils.getBlock(status));
        s.append(LogUtils.getBlock(msg));

        sys_user_logger.info(s.toString(), args);

        if (CommonConstant.LOGIN_SUCCESS.equals(status) || CommonConstant.LOGOUT.equals(status))
        {
            saveOpLog(username, msg, CommonConstant.SUCCESS);
        }
        else if (CommonConstant.LOGIN_FAIL.equals(status))
        {
            saveOpLog(username, msg, CommonConstant.FAIL);
        }
    }

    public static void saveOpLog(String username, String message, String status)
    {
        UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        // 获取客户端操作系统
        String os = userAgent.getOperatingSystem().getName();
        // 获取客户端浏览器
        String browser = userAgent.getBrowser().getName();
        AccessLogServiceImpl logininforService = SpringUtils.getBean(AccessLogServiceImpl.class);
        AccessLogEntity logininfor = new AccessLogEntity();
        logininfor.setLoginName(username);
        logininfor.setStatus(status);
        logininfor.setIpaddr(ShiroUtils.getIp());
        logininfor.setBrowser(browser);
        logininfor.setOs(os);
        logininfor.setMsg(message);
        logininforService.insertLogininfor(logininfor);
    }

}
