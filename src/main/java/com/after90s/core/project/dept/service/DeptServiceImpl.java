/**============================================================
 * 版权： 
 * 包： com.after90s.core.project.dept.service
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月20日       LJW        
 * ============================================================*/

package com.after90s.core.project.dept.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.after90s.common.constant.UserConstants;
import com.after90s.common.utils.ShiroUtils;
import com.after90s.common.utils.StringUtils;
import com.after90s.core.project.dept.domin.DeptEntity;
import com.after90s.core.project.dept.mapper.DeptMapper;

/**
 * <p>TODO 类描述</p>
 *
 * @author LJW
 * @version 2019年7月20日
 */
@Service("deptService")
@Repository("deptService")
public class DeptServiceImpl implements IDeptService{

    @Autowired
    private DeptMapper deptMapper;

    /**
     * 查询部门管理集合
     * 
     * @return 所有部门信息
     */
    @Override
    public List<DeptEntity> selectDeptAll()
    {
        return deptMapper.selectDeptAll();
    }

    /**
     * 查询部门管理树
     * 
     * @return 所有部门信息
     */
    @Override
    public List<Map<String, Object>> selectDeptTree()
    {
        List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
        List<DeptEntity> deptList = deptMapper.selectDeptAll();

        for (DeptEntity dept : deptList)
        {
            if (UserConstants.DEPT_NORMAL == dept.getStatus())
            {
                Map<String, Object> deptMap = new HashMap<String, Object>();
                deptMap.put("id", dept.getDeptId());
                deptMap.put("pId", dept.getParentId());
                deptMap.put("name", dept.getDeptName());
                trees.add(deptMap);
            }
        }
        return trees;
    }

    /**
     * 查询部门人数
     * 
     * @param parentId 部门ID
     * @return 结果
     */
    @Override
    public int selectDeptCount(Long parentId)
    {
    	DeptEntity dept = new DeptEntity();
        dept.setParentId(parentId);
        return deptMapper.selectDeptCount(dept);
    }

    /**
     * 查询部门是否存在用户
     * 
     * @param deptId 部门ID
     * @return 结果 true 存在 false 不存在
     */
    @Override
    public boolean checkDeptExistUser(Long deptId)
    {
        int result = deptMapper.checkDeptExistUser(deptId);
        return result > 0 ? true : false;
    }

    /**
     * 删除部门管理信息
     * 
     * @param deptId 部门ID
     * @return 结果
     */
    @Override
    public int deleteDeptById(Long deptId)
    {
        return deptMapper.deleteDeptById(deptId);
    }

    /**
     * 保存部门信息
     * 
     * @param dept 部门信息
     * @return 结果
     */
    @Override
    public int saveDept(DeptEntity dept)
    {
        if (StringUtils.isNotNull(dept.getDeptId()))
        {
            dept.setUpdateBy(ShiroUtils.getLoginName());
            return deptMapper.updateDept(dept);
        }
        else
        {
            dept.setCreateBy(ShiroUtils.getLoginName());
            return deptMapper.insertDept(dept);
        }
    }

    /**
     * 根据部门ID查询信息
     * 
     * @param deptId 部门ID
     * @return 部门信息
     */
    @Override
    public DeptEntity selectDeptById(Long deptId)
    {
        return deptMapper.selectDeptById(deptId);
    }

    /**
     * 校验部门名称是否唯一
     * 
     * @param dept 部门信息
     * @return 结果
     */
    @Override
    public String checkDeptNameUnique(DeptEntity dept)
    {
        if (dept.getDeptId() == null)
        {
            dept.setDeptId(-1L);
        }
        Long deptId = dept.getDeptId();
        DeptEntity info = deptMapper.checkDeptNameUnique(dept.getDeptName());
        if (StringUtils.isNotNull(info) && StringUtils.isNotNull(info.getDeptId())
                && info.getDeptId().longValue() != deptId.longValue())
        {
            return UserConstants.DEPT_NAME_NOT_UNIQUE;
        }
        return UserConstants.DEPT_NAME_UNIQUE;
    }

}
