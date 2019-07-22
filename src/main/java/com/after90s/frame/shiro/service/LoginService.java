/**============================================================
 * 包： com.after90s.frame.shiro.service
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月19日       LJW        
 * ============================================================*/

package com.after90s.frame.shiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.after90s.common.constant.CommonConstant;
import com.after90s.common.constant.ShiroConstants;
import com.after90s.common.constant.UserConstants;
import com.after90s.common.exception.userException.UserBlockedException;
import com.after90s.common.exception.userException.UserNotExistsException;
import com.after90s.common.exception.userException.UserPasswordNotMatchException;
import com.after90s.common.exception.userException.UserVerificationErrorException;
import com.after90s.common.utils.DateUtils;
import com.after90s.common.utils.MessageUtils;
import com.after90s.common.utils.ServletUtils;
import com.after90s.common.utils.ShiroUtils;
import com.after90s.common.utils.SystemLogUtils;
import com.after90s.core.project.user.domin.UserEntity;
import com.after90s.core.project.user.service.IUserService;

/**
 * <p>
 * TODO 用户登录相关service
 * </p>
 *
 * @author LJW
 * @version 2019年7月19日
 */
@Component
public class LoginService {
	@Autowired
	private PasswordService passwordService;
	@Autowired
	private IUserService userService;

	/**
	 * 登录
	 */
	public UserEntity login(String username, String password) {
		// 验证码校验
		if (!StringUtils.isEmpty(ServletUtils.getStrAttribute(ShiroConstants.CURRENT_CAPTCHA))) {
			SystemLogUtils.log(username, CommonConstant.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.error"));
			throw new UserVerificationErrorException();
		}
		// 用户名或密码为空 错误
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			SystemLogUtils.log(username, CommonConstant.LOGIN_FAIL, MessageUtils.message("not.null"));
			throw new UserNotExistsException();
		}
		// 密码如果不在指定范围内 错误
		if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
				|| password.length() > UserConstants.PASSWORD_MAX_LENGTH) {
			SystemLogUtils.log(username, CommonConstant.LOGIN_FAIL, MessageUtils.message("user.password.not.match"));
			throw new UserPasswordNotMatchException();
		}

		// 用户名不在指定范围内 错误
		if (username.length() < UserConstants.USERNAME_MIN_LENGTH
				|| username.length() > UserConstants.USERNAME_MAX_LENGTH) {
			SystemLogUtils.log(username, CommonConstant.LOGIN_FAIL, MessageUtils.message("user.password.not.match"));
			throw new UserPasswordNotMatchException();
		}

		// 查询用户信息
		UserEntity user = userService.selectUserByLoginName(username);

		if (user == null && maybeMobilePhoneNumber(username)) {
			user = userService.selectUserByPhoneNumber(username);
		}

		if (user == null && maybeEmail(username)) {
			user = userService.selectUserByEmail(username);
		}

		if (user == null) {
			SystemLogUtils.log(username, CommonConstant.LOGIN_FAIL, MessageUtils.message("user.not.exists"));
			throw new UserNotExistsException();
		}

		passwordService.validate(user, password);

		if (UserConstants.USER_BLOCKED == user.getStatus()) {
			SystemLogUtils.log(username, CommonConstant.LOGIN_FAIL,
					MessageUtils.message("user.blocked", user.getRefuseDes()));
			throw new UserBlockedException(user.getRefuseDes());
		}
		SystemLogUtils.log(username, CommonConstant.LOGIN_SUCCESS, MessageUtils.message("user.login.success"));
		recordLoginInfo(user);
		return user;
	}

	private boolean maybeEmail(String username) {
		if (!username.matches(UserConstants.EMAIL_PATTERN)) {
			return false;
		}
		return true;
	}
	/**
	 * 是否用手机号登录
	 * 
	 * @param username
	 * @return boolean
	 */
	private boolean maybeMobilePhoneNumber(String username) {
		if (!username.matches(UserConstants.MOBILE_PHONE_NUMBER_PATTERN)) {
			return false;
		}
		return true;
	}

	/**
	 * 记录登录信息
	 */
	public void recordLoginInfo(UserEntity user) {
		user.setLoginIp(ShiroUtils.getIp());
		user.setLoginDate(DateUtils.getNowDate());
		userService.updateUser(user);
	}

}
