/**============================================================
 * 版权： 
 * 包： com.after90s.frame.web.domin
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月21日       lijiawen        
 * ============================================================*/

package com.after90s.frame.web.domin;

import java.util.HashMap;


/**
 * <p>TODO 操作提示信息封装类</p>
 *
 *
 * @author lijiawen
 * @version 2019年7月21日
 */

public class MessageEntity extends HashMap<String, Object>{

    private static final long serialVersionUID = 1L;

    /**
     * 初始化一个新创建的 Message 对象
     */
    public MessageEntity()
    {
    }

    /**
     * 返回错误消息
     * 
     * @return 错误消息
     */
    public static MessageEntity error()
    {
        return error(1, "操作失败");
    }

    /**
     * 返回错误消息
     * 
     * @param msg 内容
     * @return 错误消息
     */
    public static MessageEntity error(String msg)
    {
        return error(500, msg);
    }

    /**
     * 返回错误消息
     * 
     * @param code 错误码
     * @param msg 内容
     * @return 错误消息
     */
    public static MessageEntity error(int code, String msg)
    {
    	MessageEntity json = new MessageEntity();
        json.put("code", code);
        json.put("msg", msg);
        return json;
    }

    /**
     * 返回成功消息
     * 
     * @param msg 内容
     * @return 成功消息
     */
    public static MessageEntity success(String msg)
    {
    	MessageEntity json = new MessageEntity();
        json.put("msg", msg);
        json.put("code", 0);
        return json;
    }
    
    /**
     * 返回成功消息
     * 
     * @return 成功消息
     */
    public static MessageEntity success()
    {
        return MessageEntity.success("操作成功");
    }

    /**
     * 返回成功消息
     * 
     * @param key 键值
     * @param value 内容
     * @return 成功消息
     */
    @Override
    public MessageEntity put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }

}
