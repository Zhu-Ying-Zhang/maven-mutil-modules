package org.example.openapi.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityCofig extends WebSecurityConfigurerAdapter {

    /**
     * https://chikuwa-tech-study.blogspot.com/2021/06/spring-boot-security-authentication-and-authorization.html
     *
     * https://blog.csdn.net/qq_42962779/article/details/104400620?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-104400620-blog-104830066.pc_relevant_3mothn_strategy_recovery&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-104400620-blog-104830066.pc_relevant_3mothn_strategy_recovery&utm_relevant_index=1
     *
     * https://blog.csdn.net/chihaihai/article/details/104830066?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-104830066-blog-81559975.pc_relevant_default&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-104830066-blog-81559975.pc_relevant_default&utm_relevant_index=1
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

    }
}
