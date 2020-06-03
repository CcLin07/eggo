package com.ego.dubbo.service;

import com.ego.pojo.Manager;

/**
 *  对manage 表进行操作
 * @author Lin
 */
public interface ManagerDubboService {

    /**
     * 根据用户名查询后台用户信息
     * @param username 用户名
     * @return 用户详情
     */
    Manager selectManagerByUsername(String username);
}
