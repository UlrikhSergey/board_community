package com.ulrikhsergey.board_info.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;


/**
 * Класс - настройка для Spring Security
 * Настройка логина + пароля
 * Настройка ролей и доступов
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("user").password("user").roles("USER"))
                .withUser(userBuilder.username("admin").password("admin").roles("ADMIN"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("ADMIN","USER")
                .antMatchers("/chat").hasAnyRole("ADMIN","USER")
                .antMatchers("/messages").hasAnyRole("ADMIN")
                .antMatchers("/messages/*").hasAnyRole("ADMIN")
                .antMatchers("/chatmessages").hasAnyRole("ADMIN")
                .antMatchers("/chatmessages/*").hasAnyRole("ADMIN")
                .and().formLogin().permitAll();

        http.csrf().disable();

    }
}

