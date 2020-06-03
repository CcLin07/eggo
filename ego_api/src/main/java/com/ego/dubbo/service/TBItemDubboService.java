package com.ego.dubbo.service;


import com.ego.pojo.TbItem;

import java.util.List;

/**
 * 对商品表数据库操作
 * @author Lin
 */
public interface TBItemDubboService {

    /**
     * 分页查询
     * @param pageSize  每页大小
     * @param pageNumber 页码
     * @return 当前页显示数据
     */
    List<TbItem> selectByPage(int pageSize,int pageNumber);

    /**
     * 查询总条数
     * @return 总条数
     */
    long selectCount();

    /**
     * 批量修改 商品状态
     * 事务一定要子啊provider方
     * @param id 所有要修改的id
     * @param status 所有要修改的状态
     * @return 修改状态 成功1 失败 0
     */
    int updateStatusByIds(long[] ids,byte status);
}
