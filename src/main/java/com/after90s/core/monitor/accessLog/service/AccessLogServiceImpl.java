/**============================================================
 * 版权： 
 * 包： com.after90s.core.monitor.accessLog.service
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月20日       lijiawen        
 * ============================================================*/

package com.after90s.core.monitor.accessLog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.after90s.core.monitor.accessLog.domin.AccessLogEntity;
import com.after90s.core.monitor.accessLog.mapper.AccessLogMapper;



/**
 * <p>TODO 系统访问日志情况信息Service</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2008<br>
 * Company: 久其</p>
 *
 * @author lijiawen
 * @version 2019年7月20日
 */
@Service("accessLogService")
public class AccessLogServiceImpl implements IAccessLogService{


    @Autowired
    private AccessLogMapper logininforMapper;

    /**
     * 新增系统登录日志
     * 
     * @param logininfor 访问日志对象
     */
    @Override
    public void insertLogininfor(AccessLogEntity logininfor)
    {
        logininforMapper.insertLogininfor(logininfor);
    }

    /**
     * 查询系统登录日志集合
     * 
     * @param logininfor 访问日志对象
     * @return 登录记录集合
     */
    @Override
    public List<AccessLogEntity> selectLogininforList(AccessLogEntity logininfor)
    {
        return logininforMapper.selectLogininforList(logininfor);
    }

    /**
     * 批量删除系统登录日志
     * 
     * @param ids 需要删除的数据
     * @return
     */
    @Override
    public int batchDeleteLogininfor(Long[] ids)
    {
        return logininforMapper.batchDeleteLogininfor(ids);
    }

}
