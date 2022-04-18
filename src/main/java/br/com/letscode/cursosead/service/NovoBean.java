package br.com.letscode.cursosead.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@Slf4j
public class NovoBean implements BeanNameAware, ApplicationContextAware, DisposableBean, BeanFactoryAware, InitializingBean {

    @Value("${ambiente.mensagem}")
    private String ambienteMensagem;

    @Override
    public void setBeanName(String nome) {
      log.info("Nome BEAN {}",nome);
    }

    private void customInit() {
        log.info("Executou Custom INIT");
        log.info("Qual ambiente estou rodando? {} ",ambienteMensagem);
    }

    private void customDestroy() {
        log.info("Executou Custom Destroy");
    }

    @Override
    public void destroy() throws Exception {
        log.info("Executou destroy");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("Executou ApplicationContext");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("Executou BeanFactory");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("Executou AfterPrepertiesSet");
    }
}
