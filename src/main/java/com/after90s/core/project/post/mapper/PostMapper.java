/**============================================================
 * 包： com.after90s.core.project.post.mapper
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月19日       LJW        
 * ============================================================*/

package com.after90s.core.project.post.mapper;

import java.util.List;

import com.after90s.core.project.post.domin.PostEntity;

/**
 * <p>TODO 岗位相关mapper</p>
 *
 * @author LJW
 * @version 2019年7月19日
 */

public interface PostMapper {


    /**
     * 查询岗位数据集合
     * 
     * @param post 岗位信息
     * @return 岗位数据集合
     */
    public List<PostEntity> selectPostList(PostEntity post);

    /**
     * 查询所有岗位
     * 
     * @return 岗位列表
     */
    public List<PostEntity> selectPostAll();

    /**
     * 根据用户ID查询岗位
     * 
     * @param userId 用户ID
     * @return 岗位列表
     */
    public List<PostEntity> selectPostsByUserId(Long userId);

    /**
     * 通过岗位ID查询岗位信息
     * 
     * @param postId 岗位ID
     * @return 角色对象信息
     */
    public PostEntity selectPostById(Long postId);

    /**
     * 通过岗位ID删除岗位信息
     * 
     * @param postId 岗位ID
     * @return 结果
     */
    public int deletePostById(Long postId);

    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int batchDeletePost(Long[] ids);

    /**
     * 修改岗位信息
     * 
     * @param post 岗位信息
     * @return 结果
     */
    public int updatePost(PostEntity post);

    /**
     * 新增岗位信息
     * 
     * @param post 岗位信息
     * @return 结果
     */
    public int insertPost(PostEntity post);


}
