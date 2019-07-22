/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2012
 * 包： com.after90s.frame.web.page.domin
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2019年7月21日       lijiawen        
 * ============================================================*/

package com.after90s.frame.web.page.domin;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * TODO 表格分页数据实体类
 * </p>
 *
 * <p>
 * Copyright: 版权所有 (c) 2002 - 2008<br>
 * Company: 久其
 * </p>
 *
 * @author lijiawen
 * @version 2019年7月21日
 */

public class TableDataInfoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1675720375766197215L;
	/** 总记录数 */
	private long total;
	/** 列表数据 */
	private List<?> rows;

	/**
	 * 表格数据对象
	 */
	public TableDataInfoEntity() {
	}

	/**
     * 分页
     * 
     * @param list 列表数据
     * @param total 总记录数
     */
    public TableDataInfoEntity(List<?> list, int total)
    {
        this.rows = list;
        this.total = total;
    }

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
