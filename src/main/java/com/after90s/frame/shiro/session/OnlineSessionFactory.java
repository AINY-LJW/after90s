package com.after90s.frame.shiro.session;

import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.web.session.mgt.WebSessionContext;
import org.springframework.stereotype.Component;

import com.after90s.common.utils.IpUtils;
import com.after90s.common.utils.ServletUtils;
import com.after90s.common.utils.StringUtils;
import com.after90s.core.monitor.online.domin.OnlineUserEntity;
import com.after90s.core.monitor.online.domin.OnlineUserSessionEntity;

import eu.bitwalker.useragentutils.UserAgent;

/**
 * 自定义sessionFactory会话
 * 
 * @author 
 */
@Component
public class OnlineSessionFactory implements SessionFactory
{
    public Session createSession(OnlineUserEntity userOnline)
    {
    	OnlineUserSessionEntity onlineSession = userOnline.getSession();
        if (StringUtils.isNotNull(onlineSession) && onlineSession.getId() == null)
        {
            onlineSession.setId(userOnline.getSessionId());
        }
        return userOnline.getSession();
    }

    @Override
    public Session createSession(SessionContext initData)
    {
    	OnlineUserSessionEntity session = new OnlineUserSessionEntity();
        if (initData != null && initData instanceof WebSessionContext)
        {
            WebSessionContext sessionContext = (WebSessionContext) initData;
            HttpServletRequest request = (HttpServletRequest) sessionContext.getServletRequest();
            if (request != null)
            {
                UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
                // 获取客户端操作系统
                String os = userAgent.getOperatingSystem().getName();
                // 获取客户端浏览器
                String browser = userAgent.getBrowser().getName();
                session.setHost(IpUtils.getIpAddr(request));
                session.setBrowser(browser);
                session.setOs(os);
            }
        }
        return session;
    }
}
