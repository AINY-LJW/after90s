/**============================================================
 * 版权： 
 * 包： com.after90s.common.utils
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月20日       LJW        
 * ============================================================*/

package com.after90s.common.utils;

import org.springframework.context.MessageSource;

/**
 * <p>TODO 暂时</p>
 *
 * @author LJW
 * @version 2019年7月20日
 */

public class MessageUtils {


    /**
     * 根据消息键和参数 获取消息 委托给spring messageSource
     *
     * @param code 消息键
     * @param args 参数
     * @return
     */
    public static String message(String code, Object... args)
    {
        MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
        return messageSource.getMessage(code, args, null);
    }


}
