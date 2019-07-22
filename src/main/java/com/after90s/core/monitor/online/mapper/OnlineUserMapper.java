/**============================================================
 * 版权： 
 * 包： com.after90s.core.monitor.online.mapper
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月21日       LJW        
 * ============================================================*/

package com.after90s.core.monitor.online.mapper;

import java.util.List;

import com.after90s.core.monitor.online.domin.OnlineUserEntity;


/**
 * <p>TODO 在线用户mapper</p>
 *
 * @author LJW
 * @version 2019年7月21日
 */

public interface OnlineUserMapper {

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
    public int deleteOnlineById(String sessionId);

    /**
     * 保存会话信息
     * 
     * @param online 会话信息
     * @return 结果
     */
    public int saveOnline(OnlineUserEntity online);

    /**
     * 查询会话集合
     * 
     * @param userOnline 会话参数
     * @return 会话集合
     */
    public List<OnlineUserEntity> selectUserOnlineList(OnlineUserEntity userOnline);

    /**
     * 查询过期会话集合
     * 
     * @param lastAccessTime 过期时间
     * @return 会话集合
     */
    public List<OnlineUserEntity> selectOnlineByExpired(String lastAccessTime);

}
