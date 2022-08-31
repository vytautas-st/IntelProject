package lt.codeacademy;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import lt.codeacademy.entities.CustomSpotterDetailsService;
import lt.codeacademy.services.SpotterDetailsService;
import lt.codeacademy.services.UserDetailsServiceImpl;





@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	 
	//@Autowired
   // private DataSource dataSource;
	 @Autowired
	   SpotterDetailsService userDetailsService;
     
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomSpotterDetailsService();
    }
     
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	//http.csrf().disable();
        http.authorizeRequests()
            .antMatchers("/spotters").authenticated()
            .antMatchers("/reports").authenticated()
            .anyRequest().permitAll()
            .and()
            .formLogin()
                .usernameParameter("name")
                .defaultSuccessUrl("/reports")
                .permitAll()
            .and()
            .logout().logoutSuccessUrl("/").permitAll();
    	/*http.authorizeHttpRequests().antMatchers("/reports")
        .hasAuthority("ROLE_ADMIN")
        .anyRequest()
        .authenticated()
        .and()
        .formLogin();*/
    	 /*http.authorizeRequests().antMatchers("/reports")
         .access("hasAnyRole('ROLE_SPOTTER', 'ROLE_ADMIN')");
    	 http.authorizeRequests().antMatchers("/spotters", "/reports").access("hasRole('ROLE_ADMIN')");
    	 http.authorizeRequests().and().formLogin()
    		.usernameParameter("name")
    	 	.passwordParameter("password")
    	 	.defaultSuccessUrl("/reports")
    	 	.and().logout().logoutSuccessUrl("/").permitAll();*/
    	 
    	
    }
	
}