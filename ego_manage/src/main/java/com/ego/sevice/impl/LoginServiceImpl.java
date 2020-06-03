package com.ego.sevice.impl;


import com.ego.dubbo.service.ManagerDubboService;
import com.ego.pojo.Manager;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sun.security.util.Password;

/**
 * 用的是spring的
 * @author Lin
 */
@Service
public class LoginServiceImpl implements UserDetailsService {

    @Reference
    //使用apache的注解 ,如果是jdk就会出现空指针
    private ManagerDubboService managerDubboService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Manager manager = managerDubboService.selectManagerByUsername(username);
        if (manager==null){
          throw new UsernameNotFoundException("此用户不存在");
        }{
            return new User(username, manager.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("不涉及权限"));
        }

    }
}
