package br.com.letscode.cursosead.initial;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile(value = "local")
public class LocalRunner implements ApplicationRunner {


    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("RODANDO UM POSSÍVEL CÓDIGO EM AMBIENTE LOCAL");
    }
}
