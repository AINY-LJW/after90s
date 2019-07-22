/**============================================================
 * 版权： 
 * 包： com.after90s.core.monitor.accessLog.controller
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月22日       lijiawen        
 * ============================================================*/

package com.after90s.core.monitor.accessLog.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.after90s.core.monitor.accessLog.domin.AccessLogEntity;
import com.after90s.core.monitor.accessLog.service.IAccessLogService;
import com.after90s.frame.web.controller.BaseController;
import com.after90s.frame.web.domin.MessageEntity;
import com.after90s.frame.web.page.domin.TableDataInfoEntity;

/**
 * <p>TODO 访问日志Controller</p>
 *
 *
 * @author lijiawen
 * @version 2019年7月22日
 */
@Controller
@RequestMapping("/monitor/logininfor")
public class AccessLogController extends BaseController{

    private String prefix = "monitor/logininfor";

    @Autowired
    private IAccessLogService accessLogService;

    @RequiresPermissions("monitor:logininfor:view")
    @GetMapping()
    public String logininfor()
    {
        return prefix + "/logininfor";
    }

    @RequiresPermissions("monitor:logininfor:list")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfoEntity list(AccessLogEntity logininfor)
    {
        startPage();
        List<AccessLogEntity> list = accessLogService.selectLogininforList(logininfor);
        return getDataTable(list);
    }

    @RequiresPermissions("monitor:logininfor:batchRemove")
//    @Log(title = "监控管理", action = "登录日志-批量删除")
    @PostMapping("/batchRemove")
    @ResponseBody
    public MessageEntity batchRemove(@RequestParam("ids[]") Long[] ids)
    {
        int rows = accessLogService.batchDeleteLogininfor(ids);
        if (rows > 0)
        {
            return MessageEntity.success();
        }
        return MessageEntity.error();
    }

}
