package br.com.letscode.cursosead;

import br.com.letscode.cursosead.service.NovoBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class })
@Configuration
@Slf4j
@EnableCaching
public class CursosEadApplication {

    public static void main(String[] args) {
        SpringApplication.run(CursosEadApplication.class, args);
    }

    @Bean(initMethod = "customInit", destroyMethod = "customDestroy",name = "NovoBean")
    public NovoBean novoBean(){
        return new NovoBean();
    }

    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("mensagens");
        return messageSource;
    }

}
