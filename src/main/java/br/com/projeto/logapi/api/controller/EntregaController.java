package br.com.projeto.logapi.api.controller;

import br.com.projeto.logapi.domain.models.Entrega;
import br.com.projeto.logapi.domain.service.SolicitacaoEntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entregas")
public class EntregaController {
    
    @Autowired
    private SolicitacaoEntregaService entregaService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Entrega solicitar(@RequestBody Entrega entrega) {
        
        return entregaService.solicicitar(entrega);
    }
}
