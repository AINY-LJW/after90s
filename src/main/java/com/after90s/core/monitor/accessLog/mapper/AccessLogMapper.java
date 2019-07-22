/**============================================================
 * 版权： 
 * 包： com.after90s.core.monitor.accessLog.mapper
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月20日       lijiawen        
 * ============================================================*/

package com.after90s.core.monitor.accessLog.mapper;

import java.util.List;

import com.after90s.core.monitor.accessLog.domin.AccessLogEntity;


/**
 * <p>TODO 系统访问日志情况信息Mapper</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2008<br>
 * Company: 久其</p>
 *
 * @author lijiawen
 * @version 2019年7月20日
 */

public interface AccessLogMapper {

    /**
     * 新增系统登录日志
     * 
     * @param logininfor 访问日志对象
     */
    public void insertLogininfor(AccessLogEntity logininfor);

    /**
     * 查询系统登录日志集合
     * 
     * @param logininfor 访问日志对象
     * @return 登录记录集合
     */
    public List<AccessLogEntity> selectLogininforList(AccessLogEntity logininfor);

    /**
     * 批量删除系统登录日志
     * 
     * @param ids 需要删除的数据
     * @return
     */
    public int batchDeleteLogininfor(Long[] ids);

}
