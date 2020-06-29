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
				.failureUrl("/common/loginForm") //�떎�뙣�븯硫� 濡쒓렇�씤�쑝濡�
				.defaultSuccessUrl("/common/index")	//�꽦怨듯뻽�쓣�븣 湲곕낯�쟻�쑝濡� index濡�
				.usernameParameter("email")
				.passwordParameter("password")
				.permitAll();
		
		http.logout()
				.invalidateHttpSession(true)
				.logoutUrl("/logout")
				.logoutSuccessUrl("/common/loginForm")	//濡쒓렇�븘�썐 �꽦怨듭떆 濡쒓렇�씤 �럹�씠吏�濡�
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
