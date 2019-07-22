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

import com.after90s.core.monitor.online.domin.OnlineUserEntity;


/**
 * <p>TODO 在线用户Service接口</p>
 *
 * @author LJW
 * @version 2019年7月21日
 */

public interface IOnlineUserService {

    /**
     * 通过会话序号查询信息
     * 
     * @param sessionId 会话ID
     * @return 在线用户信息
     */
    public OnlineUserEntity selectOnlineById(String sessionId);

    /**
     * 通过会话序号删除信息
     * 
     * @param sessionId 会话ID
     * @return 在线用户信息
     */
    public void deleteOnlineById(String sessionId);

    /**
     * 通过会话序号删除信息
     * 
     * @param sessions 会话ID集合
     * @return 在线用户信息
     */
    public void batchDeleteOnline(List<String> sessions);

    /**
     * 保存会话信息
     * 
     * @param online 会话信息
     */
    public void saveOnline(OnlineUserEntity online);

    /**
     * 查询会话集合
     * 
     * @param userOnline 分页参数
     * @return 会话集合
     */
    public List<OnlineUserEntity> selectUserOnlineList(OnlineUserEntity userOnline);

    /**
     * 强退用户
     * 
     * @param sessionId 会话ID
     */
    public void forceLogout(String sessionId);

    /**
     * 查询会话集合
     * 
     * @param expiredDate 有效期
     * @return 会话集合
     */
    public List<OnlineUserEntity> selectOnlineByExpired(Date expiredDate);

}
