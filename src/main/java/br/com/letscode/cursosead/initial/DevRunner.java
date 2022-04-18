package br.com.letscode.cursosead.initial;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile(value = "dev")
public class DevRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        args.getOptionNames().forEach(argName -> log.info("Argumento {} valor {}", argName, args.getOptionValues(argName)));
        log.info("RODANDO UM POSSÍVEL CÓDIGO EM AMBIENTE DEV");
    }
}
