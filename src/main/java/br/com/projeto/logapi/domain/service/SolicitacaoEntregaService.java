package br.com.projeto.logapi.domain.service;

import java.time.OffsetDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.logapi.domain.exception.DomainException;
import br.com.projeto.logapi.domain.models.Cliente;
import br.com.projeto.logapi.domain.models.Entrega;
import br.com.projeto.logapi.domain.models.StatusEntrega;
import br.com.projeto.logapi.domain.repository.EntregaRepository;

@Service
public class SolicitacaoEntregaService {

    @Autowired
    private EntregaRepository entregaRepository;
    @Autowired
    private CrudClienteService clienteService;

    @Transactional
    public Entrega solicicitar(Entrega entrega, Long id) {
        Cliente cliente = clienteService.pegaCliente(id);

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENDTE);
        entrega.setDataPedido(OffsetDateTime.now());
        return entregaRepository.save(entrega);
    }

    public List<Entrega> listaDeEntregas() {
        return entregaRepository.findAll();
    }

    public Entrega getEntrega(Long id) {
        return entregaRepository.findById(id)
                .orElseThrow(() -> new DomainException("Entrega não encontrada!"));
    }
}
