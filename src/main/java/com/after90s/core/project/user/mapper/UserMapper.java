/**============================================================
 * 包： com.after90s.core.project.user.mapper
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月19日       LJW        
 * ============================================================*/

package com.after90s.core.project.user.mapper;

import java.util.List;

import com.after90s.core.project.user.domin.UserEntity;


/**
 * <p>TODO 用户相关mapper</p>
 *
 * @author LJW
 * @version 2019年7月19日
 */

public interface UserMapper {


    /**
     * 根据条件分页查询用户对象
     * 
     * @param user 用户信息
     * @return UserEntity
     */
    public List<UserEntity> selectUserList(UserEntity user);

    /**
     * 通过用户名查询用户
     * 
     * @param userName 用户名
     * @return UserEntity
     */
    public UserEntity selectUserByLoginName(String userName);
    
    /**
     * 通过手机号码查询用户
     * 
     * @param phoneNumber 手机号码
     * @return UserEntity
     */
    public UserEntity selectUserByPhoneNumber(String phoneNumber);
    
    /**
     * 通过邮箱查询用户
     * 
     * @param email 邮箱
     * @return UserEntity
     */
    public UserEntity selectUserByEmail(String email);

    /**
     * 通过用户ID查询用户
     * 
     * @param userId 用户ID
     * @return UserEntity
     */
    public UserEntity selectUserById(Long userId);

    /**
     * 通过用户ID删除用户
     * 
     * @param userId 用户ID
     * @return int
     */
    public int deleteUserById(Long userId);

    /**
     * 批量删除用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return int
     */
    public int batchDeleteUser(Long[] ids);

    /**
     * 修改用户信息
     * 
     * @param user 用户信息
     * @return int
     */
    public int updateUser(UserEntity user);

    /**
     * 新增用户信息
     * 
     * @param user 用户信息
     * @return int
     */
    public int insertUser(UserEntity user);

    /**
     * 校验用户名称是否唯一
     * 
     * @param loginName 登录名称
     * @return int
     */
    public int checkLoginNameUnique(String loginName);


    /**
     * 校验手机号码是否唯一
     *
     * @param phonenumber 手机号码
     * @return 结果
     */
    public UserEntity checkPhoneUnique(String phonenumber);


    /**
     * 校验email是否唯一
     *
     * @param email 用户邮箱
     * @return 结果
     */
    public UserEntity checkEmailUnique(String email);

}
