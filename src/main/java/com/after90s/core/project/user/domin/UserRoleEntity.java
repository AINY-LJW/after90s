/**============================================================
 * 包： com.after90s.core.project.user.domin
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月19日       LJW        
 * ============================================================*/

package com.after90s.core.project.user.domin;

/**
 * <p>
 * TODO 用户角色对应关系实体类
 * </p>
 *
 * @author LJW
 * @version 2019年7月19日
 */

public class UserRoleEntity {

	/** 用户ID */
	private Long userId;
	/** 角色ID */
	private Long roleId;

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the roleId
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "UserRole [userId=" + userId + ", roleId=" + roleId + "]";
	}

}
