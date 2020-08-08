package com.fbs.webapp.config;

import com.fbs.webapp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  public SecurityConfig() {

  }

  /* ===== Call User Service for D.A.P ===== */
  @Autowired
  private UsersService usersService;

  /* ===== BCrypt to Hash and Salt passwords ===== */
  @Bean
  public BCryptPasswordEncoder passwordHash() {
      return new BCryptPasswordEncoder();
  }

  /* ===== Inc. S.Data JPA/Hybernate into S.Security ===== Loads User Details and Password Hash methods to Bean. ===== */
  @Bean
  public DaoAuthenticationProvider authProv(){
    DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
    /* D.A.P Provides methods below */
    auth.setUserDetailsService(usersService);
    auth.setPasswordEncoder(passwordHash());
    return auth;
  }

  /* ===== (1) Create Admin and General User Profiles for Testing ===== */
  /* ===== (2) Pass Authentication Provider to A.P Method ====== */
  @Override
  protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
    auth
      .authenticationProvider(authProv())
      /* ===== Admin User ===== */
      .inMemoryAuthentication()
        .withUser("admin")
        /* ===== Password Hash ===== */
        .password(passwordHash().encode("admin123"))
        .roles("ADMIN")
      /* ===== General User ===== */
        .and()
        .withUser("user")
        .password(passwordHash().encode("user123"))
        .roles("USER");
  }

  /* ===== Configure Web App Access ===== */
  @Override 
  protected void configure(final HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
        /* ===== Only allow authenticated users access to content ===== */   
        .antMatchers("/", "/news", "/search", "/contact").hasAnyRole("USER", "ADMIN")
        /* ===== Only allow Admin user access to Admin Panel ===== */
        .antMatchers("/admin").hasRole("ADMIN")
        /* ===== Enable Spring Security Login to Custom Page ===== */
        .and()
          .formLogin()        
          .failureUrl("/login.html?error=true")
          .loginPage("/login")
          .permitAll()
        /* ===== Enable Spring Security Logout Function and Path ===== */
        .and()
          .logout()
          .invalidateHttpSession(true)
          .clearAuthentication(true)
          .deleteCookies("JSESSIONID")
          .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
          .logoutSuccessUrl("/login?logout")
        /* ===== Enable HTTP Basic Authentication ===== */
        .and()
          .httpBasic();
        /* ===== Security Headers: Cache Control, X-Conent Type Options, X-Frame Options, XSS Protection, HSTS, CSP ===== */
        /* ===== Below Headers Enabled by Default ===== */
        http.headers().cacheControl();
        http.headers().contentTypeOptions();
        http.headers().frameOptions();
        http.headers().xssProtection();
        /* ===== HSTS and CSP not enabled by Default, need to be configured ===== */
        http.headers().httpStrictTransportSecurity();
        http.headers().contentSecurityPolicy("list-style: none 'self' ");
        //### CSP Caused CSS File Loading Issues - Fix: "list-style: none" ###
        /* ===== Force HTTPS ===== */
        http.requiresChannel().anyRequest().requiresSecure();
        /* ===== Spring Security Inbuilt Session Management ===== */
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
  }
}