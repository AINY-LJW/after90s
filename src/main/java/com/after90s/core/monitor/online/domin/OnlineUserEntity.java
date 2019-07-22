/**============================================================
 * 版权： 
 * 包： com.after90s.core.monitor.online.domin
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月21日       LJW        
 * ============================================================*/

package com.after90s.core.monitor.online.domin;

import java.util.Date;

import com.after90s.core.monitor.online.domin.OnlineUserSessionEntity.OnlineStatus;
import com.after90s.frame.web.domin.BaseEntity;

/**
 * <p>TODO 当前在线会话 s
 * sys_user_online</p>
 *
 * @author LJW
 * @version 2019年7月21日
 */

public class OnlineUserEntity extends BaseEntity{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2952884272724357465L;

	/** 用户会话id */
    private String sessionId;

    /** 部门名称 */
    private String deptName;

    /** 登录名称 */
    private String loginName;

    /** 登录IP地址 */
    private String ipaddr;

    /** 浏览器类型 */
    private String browser;

    /** 操作系统 */
    private String os;

    /** session创建时间 */
    private Date startTimestamp;

    /** session最后访问时间 */
    private Date lastAccessTime;

    /** 超时时间，单位为分钟 */
    private Long expireTime;

    /** 在线状态 */
    private OnlineStatus status = OnlineStatus.on_line;

    /** 备份的当前用户会话 */
    private OnlineUserSessionEntity session;

    /**
     * 设置session对象
     */
    public static final OnlineUserEntity fromOnlineSession(OnlineUserSessionEntity session)
    {
    	OnlineUserEntity online = new OnlineUserEntity();
        online.setSessionId(String.valueOf(session.getId()));
        online.setDeptName(session.getDeptName());
        online.setLoginName(session.getLoginName());
        online.setStartTimestamp(session.getStartTimestamp());
        online.setLastAccessTime(session.getLastAccessTime());
        online.setExpireTime(session.getTimeout());
        online.setIpaddr(session.getHost());
        online.setBrowser(session.getBrowser());
        online.setOs(session.getOs());
        online.setStatus(session.getStatus());
        online.setSession(session);
        return online;
    }

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * @return the ipaddr
	 */
	public String getIpaddr() {
		return ipaddr;
	}

	/**
	 * @param ipaddr the ipaddr to set
	 */
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	/**
	 * @return the browser
	 */
	public String getBrowser() {
		return browser;
	}

	/**
	 * @param browser the browser to set
	 */
	public void setBrowser(String browser) {
		this.browser = browser;
	}

	/**
	 * @return the os
	 */
	public String getOs() {
		return os;
	}

	/**
	 * @param os the os to set
	 */
	public void setOs(String os) {
		this.os = os;
	}

	/**
	 * @return the startTimestamp
	 */
	public Date getStartTimestamp() {
		return startTimestamp;
	}

	/**
	 * @param startTimestamp the startTimestamp to set
	 */
	public void setStartTimestamp(Date startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	/**
	 * @return the lastAccessTime
	 */
	public Date getLastAccessTime() {
		return lastAccessTime;
	}

	/**
	 * @param lastAccessTime the lastAccessTime to set
	 */
	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	/**
	 * @return the expireTime
	 */
	public Long getExpireTime() {
		return expireTime;
	}

	/**
	 * @param expireTime the expireTime to set
	 */
	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
	}

	/**
	 * @return the status
	 */
	public OnlineStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(OnlineStatus status) {
		this.status = status;
	}

	/**
	 * @return the session
	 */
	public OnlineUserSessionEntity getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(OnlineUserSessionEntity session) {
		this.session = session;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
