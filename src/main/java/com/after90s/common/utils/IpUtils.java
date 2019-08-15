/**============================================================
 * 版权： 
 * 包： com.after90s.common.utils
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月20日       lijiawen        
 * ============================================================*/

package com.after90s.common.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>TODO 获取IP地址</p>
 *
 * <p>
 * </p>
 *
 * @author lijiawen
 * @version 2019年7月20日
 */

public class IpUtils {
	/**
	 * 获取IP地址
	 * 
	 * @param request
	 * @return String
	 */
	  public static String getIpAddr(HttpServletRequest request)
	    {
	        if (request == null)
	        {
	            return "unknown";
	        }
	        String ip = request.getHeader("x-forwarded-for");
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
	        {
	            ip = request.getHeader("Proxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
	        {
	            ip = request.getHeader("X-Forwarded-For");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
	        {
	            ip = request.getHeader("WL-Proxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
	        {
	            ip = request.getHeader("X-Real-IP");
	        }

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
	        {
	            ip = request.getRemoteAddr();
	        }
	        return ip;
	    }
}
