package com.ego.sevice.impl;

import com.ego.commons.pojo.UIdatagrid;
import com.ego.dubbo.service.TBItemDubboService;
import com.ego.pojo.TbItem;
import com.ego.sevice.TBItemService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TBItemServiceImpl implements TBItemService {

    @Reference
    private TBItemDubboService tbItemDubboService;

    @Override
    public UIdatagrid showItem(int page, int rows) {
        List<TbItem> list = tbItemDubboService.selectByPage(rows, page);
        long total = tbItemDubboService.selectCount();
        return new UIdatagrid(list, total);
    }
}
