package br.com.letscode.cursosead.service;

import br.com.letscode.cursosead.to.Municipio;
import br.com.letscode.cursosead.to.Uf;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class IBGEService {

    private final WebClient.Builder webClientBuilder;

    @Value("${ibge.webservice.estados.endpoint}")
    private String ibgeEstadosEndpoint;

    public IBGEService(WebClient.Builder webClientBuilder){
        this.webClientBuilder = webClientBuilder;
    }

    @Cacheable("ufs")
    public List<Uf> listarEstados(){
        Mono<List<Uf>> monoListaUF = this.webClientBuilder.build()
                .get().uri(ibgeEstadosEndpoint)
                .retrieve().bodyToMono(new ParameterizedTypeReference<List<Uf>>(){});
        return monoListaUF.block();
    }

    @Cacheable(value="municipios-sp", unless = "#uf.equals(\"SP\")")
    public List<Municipio> listaMunicipiosPorUf(String uf){
        String uriMunicipios = String.format("%s/%s/municipios",ibgeEstadosEndpoint,uf);
        Mono<List<Municipio>> monoListaMunicipios= this.webClientBuilder.build()
                .get().uri(uriMunicipios)
                .retrieve().bodyToMono(new ParameterizedTypeReference<List<Municipio>>(){});
        return monoListaMunicipios.block();
    }
}
