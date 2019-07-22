/**============================================================
 * 包： com.after90s.frame.shiro.realm
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月19日       LJW        
 * ============================================================*/

package com.after90s.frame.shiro.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.after90s.common.exception.roleException.RoleBlockedException;
import com.after90s.common.exception.userException.UserBlockedException;
import com.after90s.common.exception.userException.UserNotExistsException;
import com.after90s.common.exception.userException.UserPasswordNotMatchException;
import com.after90s.common.exception.userException.UserPasswordRetryLimitExceedException;
import com.after90s.common.exception.userException.UserVerificationErrorException;
import com.after90s.common.utils.ShiroUtils;
import com.after90s.core.project.menu.service.IMenuService;
import com.after90s.core.project.role.service.IRoleService;
import com.after90s.core.project.user.domin.UserEntity;
import com.after90s.frame.shiro.service.LoginService;

/**
 * <p>TODO 自定义用户Realm
 * 提供了=验证用户和用户是否拥有权限数据支持</p>
 *
 * @author LJW
 * @version 2019年7月19日
 */

public class UserRealm extends AuthorizingRealm{
	 private static final Logger log = LoggerFactory.getLogger(UserRealm.class);
	 @Autowired
	    private IMenuService menuService;

	    @Autowired
	    private IRoleService roleService;

	    @Autowired
	    private LoginService loginService;

	/**
	 * 授权
	 */
	 @Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		 Long userId = ShiroUtils.getUserId();
	        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
	        // 角色加入AuthorizationInfo认证对象
	        info.setRoles(roleService.selectRoleKeys(userId));
	        // 权限加入AuthorizationInfo认证对象
	        info.setStringPermissions(menuService.selectPermsByUserId(userId));
	        return info;
	}
	/**
	 * 认证  
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        String password = "";
        if (upToken.getPassword() != null)
        {
            password = new String(upToken.getPassword());
        }

        UserEntity user = null;
        try
        {
            user = loginService.login(username, password);
        }
        catch (UserVerificationErrorException e)
        {
            throw new AuthenticationException(e.getMessage(), e);
        }
        catch (UserNotExistsException e)
        {
            throw new UnknownAccountException(e.getMessage(), e);
        }
        catch (UserPasswordNotMatchException e)
        {
            throw new IncorrectCredentialsException(e.getMessage(), e);
        }
        catch (UserPasswordRetryLimitExceedException e)
        {
            throw new ExcessiveAttemptsException(e.getMessage(), e);
        }
        catch (UserBlockedException e)
        {
            throw new LockedAccountException(e.getMessage(), e);
        }
        catch (RoleBlockedException e)
        {
            throw new LockedAccountException(e.getMessage(), e);
        }
        catch (Exception e)
        {
            log.info("对用户[" + username + "]进行登录验证..验证未通过{}", e.getMessage());
            throw new AuthenticationException(e.getMessage(), e);
        }
        //返回认证信息由父类AuthorizingRealm进行认证
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    
	}
	/* 
	 * 判断token是否支持   
	 */
	@Override
	public boolean supports(AuthenticationToken token) {
		// TODO Auto-generated method stub
		return super.supports(token);
	}
	  /**
     * 清理缓存权限
     */
    public void clearCachedAuthorizationInfo()
    {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }

}
