/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2012
 * 包： com.after90s.frame.shiro.filter
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月21日       lijiawen        
 * ============================================================*/

package com.after90s.frame.shiro.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.after90s.common.constant.ShiroConstants;
import com.after90s.common.utils.ShiroUtils;
import com.after90s.core.monitor.online.domin.OnlineUserSessionEntity;
import com.after90s.core.project.user.domin.UserEntity;
import com.after90s.frame.shiro.session.OnlineSessionDAO;


/**
 * <p>TODO 自定义访问控制</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2008<br>
 * Company: 久其</p>
 *
 * @author lijiawen
 * @version 2019年7月21日
 */

public class OnlineSessionFilter extends AccessControlFilter{


    /**
     * 强制退出后重定向的地址
     */
    @Value("${shiro.user.loginUrl}")
    private String loginUrl;

    @Autowired
    private OnlineSessionDAO onlineSessionDAO;

    /**
     * 表示是否允许访问；mappedValue就是[urls]配置中拦截器参数部分，如果允许访问返回true，否则false；
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
            throws Exception
    {
        Subject subject = getSubject(request, response);
        if (subject == null || subject.getSession() == null)
        {
            return true;
        }
        Session session=null;
		try {
			session = onlineSessionDAO.readSession(subject.getSession().getId());
		} catch (Exception e) {
			
			e.printStackTrace();
//			WebUtils.issueRedirect(request, response, loginUrl);
			/***
			 * 
			 * 
			 * 注释     修改      
			 * org.apache.shiro.session.UnknownSessionException: 
			 * There is no session with id [XXXS]
			 * 
			 * 
			 * 
			 */
			return false;
		}
        if (session != null && session instanceof OnlineUserSessionEntity)
        {
            OnlineUserSessionEntity onlineSession = (OnlineUserSessionEntity) session;
            request.setAttribute(ShiroConstants.ONLINE_SESSION, onlineSession);
            // 把user对象设置进去
            boolean isGuest = onlineSession.getUserId() == null || onlineSession.getUserId() == 0L;
            if (isGuest == true)
            {
                UserEntity user = ShiroUtils.getUser();
                if (user != null)
                {
                    onlineSession.setUserId(user.getUserId());
                    onlineSession.setLoginName(user.getLoginName());
                    onlineSession.setDeptName(user.getDept().getDeptName());
                    onlineSession.markAttributeChanged();
                }
            }
            //下线用户
            if (onlineSession.getStatus() == OnlineUserSessionEntity.OnlineStatus.off_line)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * 表示当访问拒绝时是否已经处理了；如果返回true表示需要继续处理；如果返回false表示该拦截器实例已经处理了，将直接返回即可。
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception
    {
        Subject subject = getSubject(request, response);
        if (subject != null)
        {
            subject.logout();
        }
        saveRequestAndRedirectToLogin(request, response);
        return true;
    }

    // 跳转到登录页
    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException
    {
        WebUtils.issueRedirect(request, response, loginUrl);
    }


}
