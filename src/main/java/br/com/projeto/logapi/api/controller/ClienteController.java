package br.com.projeto.logapi.api.controller;

import br.com.projeto.logapi.domain.models.Cliente;
import br.com.projeto.logapi.domain.service.CrudClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private CrudClienteService clienteService;

    @GetMapping
    public List<Cliente> listar() {

        return clienteService.listaDeClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable("id") Long id) {

        return clienteService.pegaCliente(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

        // Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        // if (!clienteOptional.isPresent()) {
        // return ResponseEntity.notFound().build();
        // }

        // return ResponseEntity.ok(clienteOptional.get());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Transactional
    public Cliente novoCliente(@Valid @RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atulalizaCliente(@PathVariable("id") Long id, @Valid @RequestBody Cliente cliente) {

        Optional<Cliente> pegaCliente = clienteService.pegaCliente(id);

        if (!pegaCliente.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        cliente.setId(id);
        cliente = clienteService.salvar(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletaCliente(@PathVariable("id") Long id) {
        Optional<Cliente> pegaCliente = clienteService.pegaCliente(id);
        if (!pegaCliente.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        clienteService.excluir(id);

        return ResponseEntity.noContent().build();
    }
}
