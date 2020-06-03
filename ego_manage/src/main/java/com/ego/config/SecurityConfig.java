package com.ego.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 密码解析器
     * @return
     */
    @Bean
    protected PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                //登录请求
                .loginProcessingUrl("/login")
                //登录成功后转发
                .successForwardUrl("/loginSuccess")
                //登录页面
                .loginPage("/");

        //放行静态页面的操作
        http.authorizeRequests()
                // 千万不要忘记放行静态资源
                .antMatchers("/","/css/**","/js/**").permitAll()
                .anyRequest().authenticated();
        //禁用csrf
        http.csrf().disable();
    }
}
