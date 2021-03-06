package com.crud.webstore.security;

import com.crud.webstore.service.UserService;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserService userService;


    public WebSecurity(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public AuthenticationFilter getAuthenticationFilter() throws Exception {
        final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
        filter.setFilterProcessesUrl(SecurityConstans.LOGIN_URL);
        return filter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST,
                        SecurityConstans.SIGN_UP_URL,
                        SecurityConstans.PASSWORD_RESET_REQUEST_URL,
                        SecurityConstans.PASSWORD_RESET_URL)
                .permitAll()
                .antMatchers(HttpMethod.GET,
                       // SecurityConstans.PRODUCT_BY_ID,
                       // SecurityConstans.PRODUCTS_ALL,
                        SecurityConstans.VERIFICATION_EMAIL_URL,
                        SecurityConstans.EMAIL_VERIFICATION_STATUS_URL)
                .permitAll()
                .antMatchers(SecurityConstans.SWAGGER)
                .permitAll()
                .antMatchers(HttpMethod.DELETE)
                .permitAll()
                .antMatchers(HttpMethod.PUT)
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(getAuthenticationFilter())
                .addFilter(new AuthorizationFilter(authenticationManager()))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder authentication) throws Exception {
        authentication.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }
}
