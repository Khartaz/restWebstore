package com.crud.webstore.security;

import com.crud.webstore.service.ProductService;
import com.crud.webstore.service.UserService;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserService userService;
    private final ProductService productService;


    public WebSecurity(UserService userService, ProductService productService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.productService = productService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST)
                .permitAll()
                .antMatchers(HttpMethod.GET)
                .permitAll()
                .antMatchers(HttpMethod.DELETE)
                .permitAll()
                .antMatchers(HttpMethod.PUT)
                .permitAll()
                .anyRequest().authenticated().and().addFilter(new AuthenticationFilter(authenticationManager()));
    }

    @Override
    public void configure(AuthenticationManagerBuilder authentication) throws Exception {
        authentication.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }
}
