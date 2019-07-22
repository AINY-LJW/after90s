/**============================================================
 * 版权： 
 * 包： com.after90s.common.exception.userException
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月20日       LJW        
 * ============================================================*/

package com.after90s.common.exception.userException;

/**
 * <p>TODO 不存在用户异常</p>
 *
 * @author LJW
 * @version 2019年7月20日
 */

public class UserNotExistsException extends UserException{


    private static final long serialVersionUID = 1L;

    public UserNotExistsException()
    {
        super("user.not.exists", null);
    }

}
