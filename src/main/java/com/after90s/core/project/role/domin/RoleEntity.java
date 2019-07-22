/**============================================================
 * 包： com.after90s.core.project.role.domin
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月19日       LJW        
 * ============================================================*/

package com.after90s.core.project.role.domin;

import java.util.Arrays;

import com.after90s.frame.web.domin.BaseEntity;

/**
 * <p>TODO 用户实体类</p>
 *sys_role
 * @author LJW
 * @version 2019年7月19日
 */

public class RoleEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1762426160902641786L;
	 /** 角色ID */
    private Long roleId;
    /** 角色名 */
    private String roleName;
    /** 角色权限 */
    private String roleKey;
    /** 角色排序 */
    private String roleSort;
    /** 角色状态:0正常,1禁用 */
    private int status;
    /** 用户是否存在此角色标识 默认不存在 */
    private boolean flag = false;
    /** 菜单组 */
    private Long[] menuIds;
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
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the roleKey
	 */
	public String getRoleKey() {
		return roleKey;
	}
	/**
	 * @param roleKey the roleKey to set
	 */
	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}
	/**
	 * @return the roleSort
	 */
	public String getRoleSort() {
		return roleSort;
	}
	/**
	 * @param roleSort the roleSort to set
	 */
	public void setRoleSort(String roleSort) {
		this.roleSort = roleSort;
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
	 * @return the menuIds
	 */
	public Long[] getMenuIds() {
		return menuIds;
	}
	/**
	 * @param menuIds the menuIds to set
	 */
	public void setMenuIds(Long[] menuIds) {
		this.menuIds = menuIds;
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
	        return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleKey=" + roleKey + ", roleSort=" + roleSort
	                + ", status=" + status + ", flag=" + flag + ", menuIds=" + Arrays.toString(menuIds) + "]";
	    }
}
