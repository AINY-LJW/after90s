/**============================================================
 * 包： com.after90s.frame.shiro.service
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月19日       LJW        
 * ============================================================*/

package com.after90s.frame.shiro.service;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.after90s.common.constant.CommonConstant;
import com.after90s.common.exception.userException.UserPasswordNotMatchException;
import com.after90s.common.exception.userException.UserPasswordRetryLimitExceedException;
import com.after90s.common.utils.MessageUtils;
import com.after90s.common.utils.SystemLogUtils;
import com.after90s.core.project.user.domin.UserEntity;

/**
 * <p>
 * TODO 登录密码方法
 * </p>
 *
 * @author LJW
 * @version 2019年7月19日
 */
@Component
public class PasswordService {
	/**
	 * 
	 * 缓存可以避免需要授权信息时频繁的调用数据库查询的问题。 以自己定义CacheManager的实现，可以是ehcache、redis等
	 */
	@Autowired
//	@Cacheable(key = "key", cacheManager = CacheManagerConfig.CacheManagerNames.EHCACHE_CACHE_MAANGER, cacheNames = CacheManagerConfig.EhCacheNames.CACHE_10MINS)
	private CacheManager cacheManager;
	private Cache<String, AtomicInteger> loginRecordCache;
	/**
	 * #密码错误{maxRetryCount}次锁定10分钟
	 */
	@Value(value = "${user.password.maxRetryCount}")
	private String maxRetryCount;

	/**
	 * void
	 */
	@PostConstruct
	public void init() {
		loginRecordCache = cacheManager.getCache("loginRecordCache");
	}

	public void validate(UserEntity user, String password) {
		String loginName = user.getLoginName();

		AtomicInteger retryCount = loginRecordCache.get(loginName);

		if (retryCount == null) {
			retryCount = new AtomicInteger(0);
			loginRecordCache.put(loginName, retryCount);
		}
		if (retryCount.incrementAndGet() > Integer.valueOf(maxRetryCount).intValue()) {
			SystemLogUtils.log(loginName, CommonConstant.LOGIN_FAIL,
					MessageUtils.message("user.password.retry.limit.exceed", maxRetryCount));
			throw new UserPasswordRetryLimitExceedException(Integer.valueOf(maxRetryCount).intValue());
		}

		if (!matches(user, password)) {
			SystemLogUtils.log(loginName, CommonConstant.LOGIN_FAIL,
					MessageUtils.message("user.password.retry.limit.count", retryCount, password));
			loginRecordCache.put(loginName, retryCount);
			throw new UserPasswordNotMatchException();
		} else {
			clearLoginRecordCache(loginName);
		}
	}

	public boolean matches(UserEntity user, String newPassword) {
		return user.getPassword().equals(encryptPassword(user.getLoginName(), newPassword, user.getSalt()));
	}

	/**
	 * 清理用户登录缓存
	 * 
	 * @param username void
	 */
	public void clearLoginRecordCache(String username) {
		loginRecordCache.remove(username);
	}

	/**
	 * 密码加密
	 * 
	 * @param username
	 * @param password
	 * @param salt
	 * @return String
	 */
	public String encryptPassword(String username, String password, String salt) {
		return new Md5Hash(username + password + salt).toHex().toString();
	}

	public static void main(String[] args) {
//	        System.out.println(new PasswordService().encryptPassword("ly", "admin123", "123456"));
	}
}
