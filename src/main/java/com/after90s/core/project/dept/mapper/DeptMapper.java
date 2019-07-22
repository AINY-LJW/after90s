/**============================================================
 * 版权： 
 * 包： com.after90s.core.project.dept.mapper
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月20日       LJW        
 * ============================================================*/

package com.after90s.core.project.dept.mapper;

import java.util.List;

import com.after90s.core.project.dept.domin.DeptEntity;

/**
 * <p>TODO 部门管理相关Mapper</p>
 *
 * @author LJW
 * @version 2019年7月20日
 */

public interface DeptMapper {

    /**
     * 查询部门人数
     * 
     * @param dept 部门信息
     * @return 结果
     */
    public int selectDeptCount(DeptEntity dept);

    /**
     * 查询部门是否存在用户
     * 
     * @param deptId 部门ID
     * @return 结果
     */
    public int checkDeptExistUser(Long deptId);

    /**
     * 查询部门管理集合
     * 
     * @return 所有部门信息
     */
    public List<DeptEntity> selectDeptAll();

    /**
     * 删除部门管理信息
     * 
     * @param deptId 部门ID
     * @return 结果
     */
    public int deleteDeptById(Long deptId);

    /**
     * 新增部门信息
     * 
     * @param dept 部门信息
     * @return 结果
     */
    public int insertDept(DeptEntity dept);

    /**
     * 修改部门信息
     * 
     * @param dept 部门信息
     * @return 结果
     */
    public int updateDept(DeptEntity dept);

    /**
     * 根据部门ID查询信息
     * 
     * @param deptId 部门ID
     * @return 部门信息
     */
    public DeptEntity selectDeptById(Long deptId);

    /**
     * 校验部门名称是否唯一
     * 
     * @param deptName 部门名称
     * @return 结果
     */
    public DeptEntity checkDeptNameUnique(String deptName);

}
