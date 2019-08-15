/**============================================================
 * 版权： 
 * 包： com.after90s.frame.web.page.util
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月21日       lijiawen        
 * ============================================================*/

package com.after90s.frame.web.page.util;

import com.after90s.common.constant.CommonConstant;
import com.after90s.common.utils.ServletUtils;
import com.after90s.frame.web.page.domin.PageEntity;

/**
 * <p>TODO 表格数据封装</p>
 *
 * <p>
 * </p>
 *
 * @author lijiawen
 * @version 2019年7月21日
 */

public class TableSupportUtils {

    /**
     * 封装分页对象
     */
    public static PageEntity getPageDomain()
    {
        PageEntity pageDomain = new PageEntity();
        pageDomain.setPageNum(ServletUtils.getIntParameter(CommonConstant.PAGENUM));
        pageDomain.setPageSize(ServletUtils.getIntParameter(CommonConstant.PAGESIZE));
        pageDomain.setOrderByColumn(ServletUtils.getStrParameter(CommonConstant.ORDERBYCOLUMN));
        pageDomain.setIsAsc(ServletUtils.getStrParameter(CommonConstant.ISASC));
        return pageDomain;
    }

    public static PageEntity buildPageRequest()
    {
        return getPageDomain();
    }


}
