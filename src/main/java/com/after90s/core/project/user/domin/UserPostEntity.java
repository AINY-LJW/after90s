/**============================================================
 * 包： com.after90s.core.project.user.domin
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月19日       LJW        
 * ============================================================*/

package com.after90s.core.project.user.domin;

/**
 * <p>TODO 用户岗位对应关系实体类</p>
 *
 * @author LJW
 * @version 2019年7月19日
 */

public class UserPostEntity {

    /** 用户ID */
    private Long userId;
    /** 岗位ID */
    private Long postId;

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getPostId()
    {
        return postId;
    }

    public void setPostId(Long postId)
    {
        this.postId = postId;
    }

    @Override
    public String toString()
    {
        return "UserPost [userId=" + userId + ", postId=" + postId + "]";
    }


}
