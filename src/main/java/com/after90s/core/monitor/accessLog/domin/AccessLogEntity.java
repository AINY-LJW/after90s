/**============================================================
 * 版权： 
 * 包： com.after90s.core.monitor.accessLog.domin
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月20日       lijiawen        
 * ============================================================*/

package com.after90s.core.monitor.accessLog.domin;

import java.util.Date;

import com.after90s.frame.web.domin.BaseEntity;

/**
 * <p>TODO 系统访问日志情况信息</p>
 * sys_logininfor 
 * sys_accesslog
 * <p>
 * </p>
 *
 * @author lijiawen
 * @version 2019年7月20日
 */

public class AccessLogEntity extends BaseEntity{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2800090666562882596L;
	/** ID */
    private Integer infoId;
    /** 用户账号 */
    private String loginName;
    /** 登录状态 0成功 1失败 */
    private String status;
    /** 登录IP地址 */
    private String ipaddr;
    /** 浏览器类型 */
    private String browser;
    /** 操作系统 */
    private String os;
    /** 提示消息 */
    private String msg;
    /** 访问时间 */
    private Date loginTime;


    /**
	 * @return the infoId
	 */
	public Integer getInfoId() {
		return infoId;
	}


	/**
	 * @param infoId the infoId to set
	 */
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}


	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}


	/**
	 * @return the loginTime
	 */
	public Date getLoginTime() {
		return loginTime;
	}


	/**
	 * @param loginTime the loginTime to set
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
    public String toString()
    {
        return "Logininfor [infoId=" + infoId + ", loginName=" + loginName + ", status=" + status + ", ipaddr=" + ipaddr
                + ", browser=" + browser + ", os=" + os + ", msg=" + msg + ", loginTime=" + loginTime + "]";
    }


}
