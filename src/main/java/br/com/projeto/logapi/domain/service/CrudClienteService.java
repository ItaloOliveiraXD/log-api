package br.com.projeto.logapi.domain.service;

import br.com.projeto.logapi.domain.exception.DomainException;
import br.com.projeto.logapi.domain.models.Cliente;
import br.com.projeto.logapi.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CrudClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listaDeClientes() {
        return clienteRepository.findAll();
    }

    public Cliente pegaCliente(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new DomainException("Cliente não encontrado!"));
    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

        if (emailEmUso) {
            throw new DomainException("Email já existente!");
        }

        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }
}
