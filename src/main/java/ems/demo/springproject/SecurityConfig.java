package ems.demo.springproject;

import ems.demo.springproject.repository.Userrepository;
import ems.demo.springproject.service.Customuserdetailsservice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/", "/login","/register","/css/**")
                    .permitAll()
                    .anyRequest().authenticated()
                )
            .formLogin(form -> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/employees", true)
                    .permitAll()
                )
            .logout(logout -> logout
                    .logoutSuccessUrl("/login?logout")
                    .permitAll()
            );
        return http.build();

    }
    @Bean
    public UserDetailsService userDetailsService(Userrepository userrepository){
        return new Customuserdetailsservice(userrepository);
    }
}