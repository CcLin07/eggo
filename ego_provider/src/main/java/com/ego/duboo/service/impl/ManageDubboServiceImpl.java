package com.ego.duboo.service.impl;

import com.ego.dubbo.service.ManagerDubboService;
import com.ego.mapper.ManagerMapper;
import com.ego.pojo.Manager;
import com.ego.pojo.ManagerExample;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 * @author Lin
 */
@Service
public class ManageDubboServiceImpl implements ManagerDubboService {
    @Autowired
   private ManagerMapper managerMapper;

    @Override
    public Manager selectManagerByUsername(String username) {
        ManagerExample managerExample = new ManagerExample();
        managerExample.createCriteria().andUsernameEqualTo(username);

        List<Manager> list = managerMapper.selectByExample(managerExample);
        if (list !=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
