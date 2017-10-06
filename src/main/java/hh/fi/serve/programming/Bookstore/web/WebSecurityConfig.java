package hh.fi.serve.programming.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	

		 @Override
		 protected void configure(HttpSecurity  http) throws Exception {
			 http
			 	//CSS enabled when without login
			 	.authorizeRequests().antMatchers("/css/**").permitAll()
			 	.and()
			 	.authorizeRequests()
			 		//paths who don't need authentication
			 		.antMatchers("/","/booklist","/api**","/books").permitAll()
			 		.antMatchers("/admin**").hasRole("ADMIN")
				 		.anyRequest().authenticated()
				 		.and()
			 	.formLogin()
			 	//successfully logs in,redirected to the previously requested page
			 	//that required authentication
			 		.loginPage("/login")
			 		.defaultSuccessUrl("/booklist")
			 		//everyone can see it 
			 		.permitAll()
			 		.and()
			 	.logout()
			 		.permitAll();
		 }
		 
	//sets up an in-memory user store with a single user & role of USER
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				//default users & passwords
				.withUser("user").password("password").roles("USER").and()
				.withUser("admin").password("MyBooks!").roles("ADMIN");
				
	}
}


