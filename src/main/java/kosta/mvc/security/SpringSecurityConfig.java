package kosta.mvc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MemberAuthenticationProvider authenticationProvider;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**/guest/**").permitAll()
        		.antMatchers("/**/member/**").hasRole("MEMBER")
        		.antMatchers("/**/company/**").hasRole("COMPANY")
        		.antMatchers("/**/admin/**").hasRole("ADMIN")
        		.anyRequest().permitAll();
		
		http.formLogin()
				.loginPage("/common/loginForm")
				.loginProcessingUrl("/login")
				.failureUrl("/common/loginForm") //실패하면 로그인으로
				.defaultSuccessUrl("/common/index")	//성공했을때 기본적으로 index로
				.usernameParameter("email")
				.passwordParameter("password")
				.permitAll();
		
		http.logout()
				.invalidateHttpSession(true)
				.logoutUrl("/logout")
				.logoutSuccessUrl("/common/loginForm")	//로그아웃 성공시 로그인 페이지로
				.permitAll();
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
