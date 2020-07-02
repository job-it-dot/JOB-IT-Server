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
                .antMatchers("/*").permitAll()
        		.antMatchers("/**/user/**").hasRole("USER")
        		.antMatchers("/**/company/**").hasRole("COMPANY")
        		.antMatchers("/**/admin/**").hasRole("ADMIN")
        		.anyRequest().permitAll();
        
        		
		
		http.formLogin()
				.loginPage("/common/loginForm")
				.loginProcessingUrl("/login")
				.failureUrl("/common/loginForm") 
				.defaultSuccessUrl("/common/index")	
				.usernameParameter("email")
				.passwordParameter("password")
				.permitAll();
		
		http.logout()
				.invalidateHttpSession(true)
				.logoutUrl("/logout")
				.logoutSuccessUrl("/common/loginForm")	
				.permitAll();
		
		http.csrf()
				.ignoringAntMatchers("/**");
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
