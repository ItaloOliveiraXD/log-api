package br.com.projeto.logapi.controller;

import br.com.projeto.logapi.models.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @GetMapping
    public List<Cliente> listar() {

        Cliente c1 = new Cliente();
        c1.setId(1L);
        c1.setNome("italo");
        c1.setEmail("italo@email.com");
        c1.setTelefone("88779944");

        Cliente c2 = new Cliente();
        c2.setId(2L);
        c2.setNome("maria");
        c2.setEmail("maria@email.com");
        c2.setTelefone("88779944");
        return Arrays.asList(c1, c2);
    }
}
