/**============================================================
 * 包： com.after90s.core.project.menu.domin
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月19日       LJW        
 * ============================================================*/

package com.after90s.core.project.menu.domin;

import java.util.ArrayList;
import java.util.List;

import com.after90s.frame.web.domin.BaseEntity;

/**
 * <p>TODO 菜单实体类</p>
 * sys_menu
 * @author LJW
 * @version 2019年7月19日
 */

public class MenuEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2001734658651993481L;
	 /** 菜单ID */
    private Long menuId;
    /** 菜单名称 */
    private String menuName;
    /** 父菜单名称 */
    private String parentName;
    /** 父菜单ID */
    private Long parentId;
    /** 显示顺序 */
    private String orderNum;
    /** 菜单URL */
    private String url;
    /** 类型:0目录,1菜单,2按钮 */
    private String menuType;
    /** 菜单状态:0显示,1隐藏 */
    private int visible;
    /** 权限字符串 */
    private String perms;
    /** 菜单图标 */
    private String icon;
    /** 子菜单 */
    private List<MenuEntity> children = new ArrayList<MenuEntity>();
    
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

	/**
	 * @return the menuName
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * @param menuName the menuName to set
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * @return the parentName
	 */
	public String getParentName() {
		return parentName;
	}

	/**
	 * @param parentName the parentName to set
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	/**
	 * @return the parentId
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the orderNum
	 */
	public String getOrderNum() {
		return orderNum;
	}

	/**
	 * @param orderNum the orderNum to set
	 */
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the menuType
	 */
	public String getMenuType() {
		return menuType;
	}

	/**
	 * @param menuType the menuType to set
	 */
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	/**
	 * @return the visible
	 */
	public int getVisible() {
		return visible;
	}

	/**
	 * @param visible the visible to set
	 */
	public void setVisible(int visible) {
		this.visible = visible;
	}

	/**
	 * @return the perms
	 */
	public String getPerms() {
		return perms;
	}

	/**
	 * @param perms the perms to set
	 */
	public void setPerms(String perms) {
		this.perms = perms;
	}

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * @return the children
	 */
	public List<MenuEntity> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<MenuEntity> children) {
		this.children = children;
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
        return "Menu [menuId=" + menuId + ", menuName=" + menuName + ", parentName=" + parentName + ", parentId="
                + parentId + ", orderNum=" + orderNum + ", url=" + url + ", menuType=" + menuType + ", visible="
                + visible + ", perms=" + perms + ", icon=" + icon + ", children=" + children + "]";
    }
}
