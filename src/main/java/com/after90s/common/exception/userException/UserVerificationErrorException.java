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
 * <p>
 * TODO 用户验证码错误异常
 * </p>
 *
 * @author LJW
 * @version 2019年7月20日
 */

public class UserVerificationErrorException extends UserException {

	private static final long serialVersionUID = 1L;

	public UserVerificationErrorException() {
		super("user.jcaptcha.error", null);
	}

}
