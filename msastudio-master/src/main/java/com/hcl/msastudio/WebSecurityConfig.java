package com.hcl.msastudio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
                .authorizeRequests()
                    .antMatchers("/resources/**", "/registration").permitAll()
                    .anyRequest().authenticated()
                .anyRequest()
        		.permitAll()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll().
                    defaultSuccessUrl("/analyseMicroService", true)
                    .and()
                .logout()
                .permitAll();
      http.csrf().disable();
    /*  and()
      .formLogin()
  .and()
      .logout()
      .logoutSuccessUrl("/");
    	http.csrf().disable();*/
        
    	/*http
		.authorizeRequests()
		// .antMatchers("/resources/**", "/registration").permitAll()
		// .antMatchers("/**")
		.anyRequest()
		.permitAll()
		.and().httpBasic().and()
		.logout()
		.permitAll();
		http.csrf().disable();*/
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}