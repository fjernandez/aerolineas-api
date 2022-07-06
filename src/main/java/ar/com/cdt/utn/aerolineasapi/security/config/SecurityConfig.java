package ar.com.cdt.utn.aerolineasapi.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ar.com.cdt.utn.aerolineasapi.security.AuthEntryPoint;
import ar.com.cdt.utn.aerolineasapi.security.TokenFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private AuthEntryPoint unauthorizedHandler;
	
	private static final String[] AUTH_WHITELIST = {

			// -- Swagger UI v2
			"/v2/api-docs", //
			"/swagger-resources", //
			"/swagger-resources/**", //
			"/configuration/ui", //
			"/configuration/security", //
			"/swagger-ui.html", //
			"/webjars/**", //

			// -- Swagger UI v3 (OpenAPI)
			"/v3/api-docs/**", //
			"/swagger-ui/**", //
			"/actuator/**",	
			// other public endpoints of your API may be appended to this array
			"/api/auth/**", //
			"/api/aerolineas/**"//
	};
	
	@Bean
	public TokenFilter authenticationJwtTokenFilter() {
		return new TokenFilter();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable() //
				.exceptionHandling()//
				.authenticationEntryPoint(unauthorizedHandler)//
				.and()//
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//
				.and()//
				.authorizeRequests()//
				.antMatchers(AUTH_WHITELIST).permitAll() // whitelist Swagger UI resources
				.anyRequest().authenticated();//
		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	
	
	

}
