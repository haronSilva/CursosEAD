package br.com.letscode.cursosead.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SegurancaConfig extends WebSecurityConfigurerAdapter {


    private UserDetailsService userDetailsServiceCustom() {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails admin = User.withUsername("haron")
                .password(passwordEncoder.encode("admin"))
                .roles("ADMIN")
                .build();
        UserDetails aluno = User.withUsername("aluno")
                .password(passwordEncoder.encode("aluno"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, aluno);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceCustom());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/alunos").hasAnyRole("ADMIN","USER")
                .antMatchers("/alunos/**").hasRole("ADMIN")
                .and()
                .formLogin().loginPage("/login").permitAll()
                .usernameParameter("usu").passwordParameter("psw").defaultSuccessUrl("/alunos")
                        .and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/403");

        http.csrf().disable();
    }
}
