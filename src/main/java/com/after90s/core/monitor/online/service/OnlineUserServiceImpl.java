/**============================================================
 * 版权： 
 * 包： com.after90s.core.monitor.online.service
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月21日       LJW        
 * ============================================================*/

package com.after90s.core.monitor.online.service;

import java.util.Date;
import java.util.List;

import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.after90s.common.utils.DateUtils;
import com.after90s.core.monitor.online.domin.OnlineUserEntity;
import com.after90s.core.monitor.online.mapper.OnlineUserMapper;
import com.after90s.frame.shiro.session.OnlineSessionDAO;

/**
 * <p>TODO 在线用户service</p>
 *
 * @author LJW
 * @version 2019年7月21日
 */
@Service("userOnlineService")
public class OnlineUserServiceImpl implements IOnlineUserService{

    @Autowired
    private OnlineUserMapper userOnlineDao;

    @Autowired
    private OnlineSessionDAO onlineSessionDAO;

    /**
     * 通过会话序号查询信息
     * 
     * @param sessionId 会话ID
     * @return 在线用户信息
     */
    @Override
    public OnlineUserEntity selectOnlineById(String sessionId)
    {
        return userOnlineDao.selectOnlineById(sessionId);
    }

    /**
     * 通过会话序号删除信息
     * 
     * @param sessionId 会话ID
     * @return 在线用户信息
     */
    @Override
    public void deleteOnlineById(String sessionId)
    {
    	OnlineUserEntity userOnline = selectOnlineById(sessionId);
        if (userOnline != null)
        {
            userOnlineDao.deleteOnlineById(sessionId);
        }
    }

    /**
     * 通过会话序号删除信息
     * 
     * @param sessions 会话ID集合
     * @return 在线用户信息
     */
    @Override
    public void batchDeleteOnline(List<String> sessions)
    {
        for (String sessionId : sessions)
        {
        	OnlineUserEntity userOnline = selectOnlineById(sessionId);
            if (userOnline != null)
            {
                userOnlineDao.deleteOnlineById(sessionId);
            }
        }
    }

    /**
     * 保存会话信息
     * 
     * @param online 会话信息
     */
    @Override
    public void saveOnline(OnlineUserEntity online)
    {
        userOnlineDao.saveOnline(online);
    }

    /**
     * 查询会话集合
     * 
     * @param pageUtilEntity 分页参数
     */
    @Override
    public List<OnlineUserEntity> selectUserOnlineList(OnlineUserEntity userOnline)
    {
        return userOnlineDao.selectUserOnlineList(userOnline);
    }

    /**
     * 强退用户
     * 
     * @param sessionId 会话ID
     */
    @Override
    public void forceLogout(String sessionId)
    {
        Session session = onlineSessionDAO.readSession(sessionId);
        if (session == null)
        {
            return;
        }
        session.setTimeout(1000);
        userOnlineDao.deleteOnlineById(sessionId);
    }

    /**
     * 查询会话集合
     * 
     * @param online 会话信息
     */
    @Override
    public List<OnlineUserEntity> selectOnlineByExpired(Date expiredDate)
    {
        String lastAccessTime = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, expiredDate);
        return userOnlineDao.selectOnlineByExpired(lastAccessTime);
    }

}
