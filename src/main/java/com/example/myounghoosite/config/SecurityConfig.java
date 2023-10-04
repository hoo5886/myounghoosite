package com.example.myounghoosite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * WebSecurity는 Spring Security 필터 연결에 대한 보안 설정을 제공합니다.
     * 이를 통해 리소스를 완전히 보안에서 제외하거나 특정 패턴에 대한 제한을 완화할 수 있습니다.
     * 예를 들어, 정적 리소스에 대한 보안 요구를 제외하거나, 특정 URL 패턴을 무시하도록 설정할 수 있습니다.
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring().antMatchers( "/css/**", "/js/**", "/img/**");
    }

    /**
     * HttpSecurity는 HTTP 요청에 대한 보안을 구성합니다.
     * 이를 통해 특정 요청에 대한 인증 요구, 로그인 및 로그아웃 처리, 세션 관리 등을 정의할 수 있습니다.
     * 이 설정은 WebSecurity의 설정보다 더 세밀하게 HTTP 요청에 대한 보안을 구성할 수 있습니다.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable().cors() /* REST API 사용 예외처리 */
            .and()
            .authorizeRequests()
            .antMatchers("/**").permitAll();
    }
}
