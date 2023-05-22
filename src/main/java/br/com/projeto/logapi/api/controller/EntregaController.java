package br.com.projeto.logapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.logapi.domain.models.Entrega;
import br.com.projeto.logapi.domain.service.SolicitacaoEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {
    
    @Autowired
    private SolicitacaoEntregaService entregaService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Entrega solicitar(@Valid @RequestBody Entrega entrega,@RequestParam  Long id) {

        return entregaService.solicicitar(entrega, id);
    }

    @GetMapping 
    public List<Entrega> listar() {
        return entregaService.listaDeEntregas();
    }

    @GetMapping("/{id}") 
    public Entrega obterEntrega(@PathVariable("id") Long id) {
        return entregaService.getEntrega(id);

    }
}
