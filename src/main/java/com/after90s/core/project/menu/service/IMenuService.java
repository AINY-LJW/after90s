/**============================================================
 * 包： com.after90s.core.project.menu.service
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月19日       LJW        
 * ============================================================*/

package com.after90s.core.project.menu.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.after90s.core.project.menu.domin.MenuEntity;
import com.after90s.core.project.role.domin.RoleEntity;

/**
 * <p>TODO 菜单相关Service接口</p>
 *
 * @author LJW
 * @version 2019年7月19日
 */

public interface IMenuService {


    /**
     * 根据用户ID查询菜单
     * 
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<MenuEntity> selectMenusByUserId(Long userId);

    /**
     * 查询菜单集合
     * 
     * @return 所有菜单信息
     */
    public List<MenuEntity> selectMenuAll();

    /**
     * 根据用户ID查询权限
     * 
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectPermsByUserId(Long userId);

    /**
     * 根据角色ID查询菜单
     * 
     * @param role 角色对象
     * @return 菜单列表
     */
    public List<Map<String, Object>> roleMenuTreeData(RoleEntity role);

    /**
     * 查询所有菜单信息
     * 
     * @return 菜单列表
     */
    public List<Map<String, Object>> menuTreeData();

    /**
     * 查询系统所有权限
     * 
     * @return 权限列表
     */
    public Map<String, String> selectPermsAll();

    /**
     * 删除菜单管理信息
     * 
     * @param menuId 菜单ID
     * @return 结果
     */
    public int deleteMenuById(Long menuId);

    /**
     * 根据菜单ID查询信息
     * 
     * @param menuId 菜单ID
     * @return 菜单信息
     */
    public MenuEntity selectMenuById(Long menuId);

    /**
     * 查询菜单数量
     * 
     * @param parentId 菜单父ID
     * @return 结果
     */
    public int selectCountMenuByParentId(Long parentId);

    /**
     * 查询菜单使用数量
     * 
     * @param menuId 菜单ID
     * @return 结果
     */
    public int selectCountRoleMenuByMenuId(Long menuId);

    /**
     * 保存菜单信息
     * 
     * @param menu 菜单信息
     * @return 结果
     */
    public int saveMenu(MenuEntity menu);

    /**
     * 校验菜单名称是否唯一
     * 
     * @param menu 菜单信息
     * @return 结果
     */
    public String checkMenuNameUnique(MenuEntity menu);


}
