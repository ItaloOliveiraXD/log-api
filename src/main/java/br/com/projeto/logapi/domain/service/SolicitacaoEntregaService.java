package br.com.projeto.logapi.domain.service;

import br.com.projeto.logapi.domain.models.Cliente;
import br.com.projeto.logapi.domain.models.Entrega;
import br.com.projeto.logapi.domain.models.StatusEntrega;
import br.com.projeto.logapi.domain.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.LocalDateTime;

@Service
public class SolicitacaoEntregaService {

    @Autowired
    private EntregaRepository entregaRepository;
    @Autowired
    private CrudClienteService clienteService;

    @Transactional
    public Entrega solicicitar(Entrega entrega) {
        Cliente cliente = clienteService.pegaCliente(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENDTE);
        entrega.setDataPedido(LocalDateTime.now());
        return entregaRepository.save(entrega);
    }
}
