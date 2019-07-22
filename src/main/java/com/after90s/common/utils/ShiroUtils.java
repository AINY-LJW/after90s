/**============================================================
 * 包： com.after90s.common.utils
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月19日       LJW        
 * ============================================================*/

package com.after90s.common.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.after90s.core.project.user.domin.UserEntity;
import com.after90s.frame.shiro.realm.UserRealm;

/**
 * <p>
 * TODO Shiro工具类
 * </p>
 *
 * @author LJW
 * @version 2019年7月19日
 */

public class ShiroUtils {

	public static Subject getSubjct() {
		return SecurityUtils.getSubject();
	}

	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	public static void logout() {
		getSubjct().logout();
	}
	/**
	 * 
	 * 返回当前登录用户  没有则为null
	 * @return UserEntity
	 */
	public static UserEntity getUser() {
		return (UserEntity) getSubjct().getPrincipal();
	}

	public static void setUser(UserEntity user) {
		Subject subject = getSubjct();
		PrincipalCollection principalCollection = subject.getPrincipals();
		String realmName = principalCollection.getRealmNames().iterator().next();
		PrincipalCollection newPrincipalCollection = new SimplePrincipalCollection(user, realmName);
		// 重新加载Principal
		subject.runAs(newPrincipalCollection);
	}

	public static void clearCachedAuthorizationInfo() {
		RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
		UserRealm realm = (UserRealm) rsm.getRealms().iterator().next();
		realm.clearCachedAuthorizationInfo();
	}

	/**
	 * 
	 * 获取用户ID
	 * @return Long
	 */
	public static Long getUserId() {
		return getUser().getUserId().longValue();
	}

	public static String getLoginName() {
		return getUser().getLoginName();
	}

	public static String getIp() {
		return getSubjct().getSession().getHost();
	}

	public static String getSessionId() {
		return String.valueOf(getSubjct().getSession().getId());
	}

}
