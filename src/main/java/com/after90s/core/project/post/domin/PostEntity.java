/**============================================================
 * 包： com.after90s.core.project.post.domin
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月19日       LJW        
 * ============================================================*/

package com.after90s.core.project.post.domin;

import com.after90s.frame.web.domin.BaseEntity;

/**
 * <p>TODO 岗位实体类 </p>
 * sys_post
 * @author LJW
 * @version 2019年7月19日
 */

public class PostEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8041736422452415884L;
	 /** 岗位ID */
    private Long postId;
    /** 岗位编码 */
    private String postCode;
    /** 岗位名称 */
    private String postName;
    /** 岗位排序 */
    private String postSort;
    /** 状态（0正常 1停用） */
    private int status;
    /** 用户是否存在此岗位标识 默认不存在 */
    private boolean flag = false;
	/**
	 * @return the postId
	 */
	public Long getPostId() {
		return postId;
	}
	/**
	 * @param postId the postId to set
	 */
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	/**
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}
	/**
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	/**
	 * @return the postName
	 */
	public String getPostName() {
		return postName;
	}
	/**
	 * @param postName the postName to set
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}
	/**
	 * @return the postSort
	 */
	public String getPostSort() {
		return postSort;
	}
	/**
	 * @param postSort the postSort to set
	 */
	public void setPostSort(String postSort) {
		this.postSort = postSort;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the flag
	 */
	public boolean isFlag() {
		return flag;
	}
	/**
	 * @param flag the flag to set
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
