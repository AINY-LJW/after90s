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
 * <p>TODO 用户密码不正确或格式不对异常</p>
 *
 * @author LJW
 * @version 2019年7月20日
 */

public class UserPasswordNotMatchException extends UserException{


    private static final long serialVersionUID = 1L;

    public UserPasswordNotMatchException()
    {
        super("user.password.not.match", null);
    }

}
