/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2012
 * 包： com.after90s.frame.web.controller
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月21日       lijiawen        
 * ============================================================*/

package com.after90s.frame.web.controller;

import java.util.List;

import com.after90s.common.utils.ShiroUtils;
import com.after90s.common.utils.StringUtils;
import com.after90s.core.project.user.domin.UserEntity;
import com.after90s.frame.web.page.domin.PageEntity;
import com.after90s.frame.web.page.domin.TableDataInfoEntity;
import com.after90s.frame.web.page.util.TableSupportUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
 * <p>TODO 类描述</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2008<br>
 * Company: 久其</p>
 *
 * @author lijiawen
 * @version 2019年7月21日
 */

public class BaseController {

    /**
     * 设置请求分页数据
     */
    protected void startPage()
    {
        PageEntity pageDomain = TableSupportUtils.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize))
        {
            String orderBy = pageDomain.getOrderBy();
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfoEntity getDataTable(List<?> list)
    {
    	TableDataInfoEntity rspData = new TableDataInfoEntity();
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    public UserEntity getUser()
    {
        return ShiroUtils.getUser();
    }

    public void setUser(UserEntity user)
    {
        ShiroUtils.setUser(user);
    }

    public Long getUserId()
    {
        return getUser().getUserId();
    }

    public String getLoginName()
    {
        return getUser().getLoginName();
    }

}
