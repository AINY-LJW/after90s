/**============================================================
 * 包： com.after90s.core.project.role.service
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月19日       LJW        
 * ============================================================*/

package com.after90s.core.project.role.service;

import java.util.List;
import java.util.Set;

import com.after90s.core.project.role.domin.RoleEntity;


/**
 * <p>TODO 角色相关Service</p>
 *
 * @author LJW
 * @version 2019年7月19日
 */

public interface IRoleService {


    /**
     * 根据条件分页查询角色数据
     * 
     * @param role 角色信息
     * @return 角色数据集合信息
     */
    public List<RoleEntity> selectRoleList(RoleEntity role);

    /**
     * 根据用户ID查询角色
     * 
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectRoleKeys(Long userId);

    /**
     * 根据用户ID查询角色
     * 
     * @param userId 用户ID
     * @return 角色列表
     */
    public List<RoleEntity> selectRolesByUserId(Long userId);

    /**
     * 查询所有角色
     * 
     * @return 角色列表
     */
    public List<RoleEntity> selectRoleAll();

    /**
     * 通过角色ID查询角色
     * 
     * @param roleId 角色ID
     * @return 角色对象信息
     */
    public RoleEntity selectRoleById(Long roleId);

    /**
     * 通过角色ID删除角色
     * 
     * @param roleId 角色ID
     * @return 结果
     */
    public int deleteRoleById(Long roleId);

    /**
     * 批量删除角色用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int batchDeleteRole(Long[] ids);

    /**
     * 保存角色信息
     * 
     * @param role 角色信息
     * @return 结果
     */
    public int saveRole(RoleEntity role);
    
    /**
     * 校验角色名称是否唯一
     * 
     * @param role 角色信息
     * @return 结果
     */
    public String checkRoleNameUnique(RoleEntity role);
    
    /**
     * 通过角色ID查询角色使用数量
     * 
     * @param roleId 角色ID
     * @return 结果
     */
    public int selectCountUserRoleByRoleId(Long roleId);


}
