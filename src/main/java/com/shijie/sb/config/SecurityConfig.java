package com.shijie.sb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置类
 * Created by ShiJie on 2018-11-21 01:32
 */
@EnableWebSecurity  // 1.安全配置类注解
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 2.重载configure方法自定义拦截策略
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll()  // 都可以访问
                .antMatchers("/users/**").hasRole("ADMIN")  // 需要相应的角色才能访问
                .and()
                .formLogin()  // 基于 Form 表单登录验证
                .loginPage("/login").failureUrl("/login-error"); // 自定义登录界面
    }

    /**
     * 3.认证信息管理
     * @param authenticationManagerBuilder
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication()  // 认证信息存储在内存中
                .withUser("admin").password("123456").roles("ADMIN");
    }
}
