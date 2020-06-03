package com.ego.sevice.impl;

import com.ego.dubbo.service.ManagerDubboService;
import com.ego.pojo.Manager;

/**
 * 考虑视图逻辑
 * 页面需要啥    页面要的就是返回值参数
 * 页面传过来啥  就是方法的参数
 * @author Lin
 */
public class ManagerServiceImpl implements ManagerDubboService {
    @Override
    public Manager selectManagerByUsername(String username) {
        return null;
    }
}
