/**============================================================
 * 包： com.after90s.core.project.role.domin
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月19日       LJW        
 * ============================================================*/

package com.after90s.core.project.role.domin;

/**
 * <p>TODO 角色和菜单对应关系实体类</p>
 * sys_role_menu
 * @author LJW
 * @version 2019年7月19日
 */

public class RoleMenuEntity {
	 /** 角色ID */
    private Long roleId;
    /** 菜单ID */
    private Long menuId;
    
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
	 * @return the menuId
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	@Override
    public String toString()
    {
        return "RoleMenu [roleId=" + roleId + ", menuId=" + menuId + "]";
    }
}
