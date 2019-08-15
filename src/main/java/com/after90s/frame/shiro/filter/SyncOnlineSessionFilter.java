/**============================================================
 * 版权： 
 * 包： com.after90s.frame.shiro.filter
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月21日       lijiawen        
 * ============================================================*/

package com.after90s.frame.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.after90s.common.constant.ShiroConstants;
import com.after90s.core.monitor.online.domin.OnlineUserSessionEntity;
import com.after90s.frame.shiro.session.OnlineSessionDAO;

/**
 * <p>TODO 类描述</p>
 *
 * <p>
 * </p>
 *
 * @author lijiawen
 * @version 2019年7月21日
 */

public class SyncOnlineSessionFilter extends PathMatchingFilter{

    @Autowired
    private OnlineSessionDAO onlineSessionDAO;

    /**
     * 同步会话数据到DB 一次请求最多同步一次 防止过多处理 需要放到Shiro过滤器之前
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception
    {
    	OnlineUserSessionEntity session = (OnlineUserSessionEntity) request.getAttribute(ShiroConstants.ONLINE_SESSION);
        // 如果session stop了 也不同步
        // session停止时间，如果stopTimestamp不为null，则代表已停止
        if (session != null && session.getUserId() != null && session.getStopTimestamp() == null)
        {
            onlineSessionDAO.syncToDb(session);
        }
        return true;
    }

}
