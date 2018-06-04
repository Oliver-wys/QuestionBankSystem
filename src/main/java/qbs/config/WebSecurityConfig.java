package qbs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity //静态文件，json校验等支持
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true) //开启注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	/*
	 * 给用户、静态资源进行权限管理
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/assets/**").permitAll() //给静态文件的访问权
		.antMatchers("/login").permitAll() //给login的访问权
		.antMatchers("/main/manager/**").hasRole("manager") //设置manager路径下的文件只能manager访问
		.antMatchers("/main/user/**").hasAnyRole("user","manager")
//		.antMatchers("/main/**")
		.antMatchers("/**")
		.authenticated()
		.and() 
		.formLogin()
		.loginPage("/login")//自定义表单提交页面
		.defaultSuccessUrl("/main",true)
		
		.usernameParameter("username")
		.passwordParameter("password")
//		.successForwardUrl("/main")
		.and()
//		.rememberMe().rememberMeParameter("remember-me") //开启rememberMe支持
		.userDetailsService(userDetailsService)
//		.tokenValiditySeconds(8*3600)
		.csrf().disable();
	}
	
	/*
	 * 使用BCryptPasswordEncoder管理密码
	 */
	@Bean
	public PasswordEncoder passwordEncoder(){
		System.out.println("WebSecurityConfig.passwordEncoder()");
		return new BCryptPasswordEncoder();
	}
}
