package com.example.simplecrudapp.security;

import com.example.simplecrudapp.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurity{

    private final UserService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurity(UserService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

        // late we'll need the authentication object:
        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();
        http.authenticationManager(authenticationManager);

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL)
                .permitAll().anyRequest().authenticated()
                .and().addFilter(new AuthenticationFilter(authenticationManager))
                .addFilter(new AuthorizationFilter(authenticationManager))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //doesn't work
        //.and().addFilter(getAuthenticationFilter(authenticationManager));

        return http.build();
    }

    // wasn't able to change url
//    public AuthenticationFilter getAuthenticationFilter() throws Exception {
//        final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
//        filter.setFilterProcessesUrl("users/login");
//        return filter;
//    }

}
