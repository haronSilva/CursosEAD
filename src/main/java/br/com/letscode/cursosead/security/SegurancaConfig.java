package br.com.letscode.cursosead.security;


import br.com.letscode.cursosead.filters.CustomFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SegurancaConfig extends WebSecurityConfigurerAdapter {
    private DataSource dataSource;
   /* private UserDetailsService userDetailsServiceCustom() {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //$2a$10$vcoEdK1t1XAaVd3Wt3L3ZuqhYprThyaRwX2WkjfC9sfLERqC/.t.e
        UserDetails admin = User.withUsername("haron")
                .password("{bcrypt}$2a$10$vcoEdK1t1XAaVd3Wt3L3ZuqhYprThyaRwX2WkjfC9sfLERqC/.t.e")
                .roles("ADMIN")
                .build();
        //$2a$10$3l2o9kTB2SzAHTLLrkpFkOurLSIYZ2X/837jSCqyY/Ce190Jo2fOi
        UserDetails aluno = User.withUsername("aluno")
                .password("{bcrypt}$2a$10$3l2o9kTB2SzAHTLLrkpFkOurLSIYZ2X/837jSCqyY/Ce190Jo2fOi")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, aluno);
    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       //auth.userDetailsService(userDetailsServiceCustom());
        auth.jdbcAuthentication().dataSource(dataSource);
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
        http.addFilterBefore(new CustomFilter(), BasicAuthenticationFilter.class);
    }


}
