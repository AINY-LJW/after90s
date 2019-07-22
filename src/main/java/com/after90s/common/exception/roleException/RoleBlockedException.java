/**============================================================
 * 版权： 
 * 包： com.after90s.common.exception.roleException
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月20日       LJW        
 * ============================================================*/

package com.after90s.common.exception.roleException;

import com.after90s.common.exception.baseException.BaseException;

/**
 * <p>TODO 角色锁定异常</p>
 *
 * @author LJW
 * @version 2019年7月20日
 */

public class RoleBlockedException extends BaseException{


    private static final long serialVersionUID = 1L;

    public RoleBlockedException(String reason)
    {
        super("role.blocked", new Object[] { reason });
    }


}
