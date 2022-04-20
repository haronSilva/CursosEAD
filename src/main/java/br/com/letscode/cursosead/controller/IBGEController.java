package br.com.letscode.cursosead.controller;

import br.com.letscode.cursosead.service.IBGEService;
import br.com.letscode.cursosead.to.Municipio;
import br.com.letscode.cursosead.to.Uf;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("estados")
public class IBGEController {

    private final IBGEService ibgeService;

    public IBGEController(IBGEService ibgeService){
        this.ibgeService = ibgeService;
    }

    @GetMapping
    public List<Uf> listarEstados(){
        return this.ibgeService.listarEstados();
    }

    @GetMapping("{uf}/municipios")
    public List<Municipio> listarMunicipiosEstado(@PathVariable("uf") String uf){
        return this.ibgeService.listaMunicipiosPorUf(uf);
    }
}
