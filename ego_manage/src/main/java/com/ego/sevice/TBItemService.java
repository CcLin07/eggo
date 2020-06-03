package com.ego.sevice;

import com.ego.commons.pojo.UIdatagrid;

/**
 * 完成视图逻辑
 *
 * @author Lin
 */
public interface TBItemService {

    /**
     * 方法的返回值为页面要的东西
     * 方法的参数为页面传递过来的东西
     */

    /**
     *  分页查询商品信息
     * @param page 页面
     * @param rows 每页大小
     * @return easy要的返回值
     */
    UIdatagrid showItem(int page,int rows);


}
