/**============================================================
 * 包： com.after90s.core.project.menu.mapper
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月19日       LJW        
 * ============================================================*/

package com.after90s.core.project.menu.mapper;

import java.util.List;

import com.after90s.core.project.menu.domin.MenuEntity;


/**
 * <p>TODO 菜单相关Mapper</p>
 *
 * @author LJW
 * @version 2019年7月19日
 */

public interface MenuMapper {


    /**
     * 根据用户ID查询菜单
     * 
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<MenuEntity> selectMenusByUserId(Long userId);

    /**
     * 根据用户ID查询权限
     * 
     * @param userId 用户ID
     * @return 权限列表
     */
    public List<String> selectPermsByUserId(Long userId);

    /**
     * 根据角色ID查询菜单
     * 
     * @param roleId 角色ID
     * @return 菜单列表
     */
    public List<String> selectMenuTree(Long roleId);

    /**
     * 查询系统所有菜单
     * 
     * @return 菜单列表
     */
    public List<MenuEntity> selectMenuAll();

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
     * 新增菜单信息
     * 
     * @param menu 菜单信息
     * @return 结果
     */
    public int insertMenu(MenuEntity menu);
    
    /**
     * 修改菜单信息
     * 
     * @param menu 菜单信息
     * @return 结果
     */
    public int updateMenu(MenuEntity menu);
    
    /**
     * 校验菜单名称是否唯一
     * 
     * @param menuName 菜单名称
     * @return 结果
     */
    public MenuEntity checkMenuNameUnique(String menuName);


}
