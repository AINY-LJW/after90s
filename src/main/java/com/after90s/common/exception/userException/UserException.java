/**============================================================
 * 版权： 
 * 包： com.after90s.common.exception.userException
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月20日       LJW        
 * ============================================================*/

package com.after90s.common.exception.userException;

import com.after90s.common.exception.baseException.BaseException;

/**
 * <p>TODO 用户相关异常基类</p>
 *
 * @author LJW
 * @version 2019年7月20日
 */

public class UserException extends BaseException{

    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
