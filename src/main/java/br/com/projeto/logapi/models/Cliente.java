package br.com.projeto.logapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cliente {
    
    private Long id;
    private String nome;
    private String email;
    private String telefone;
}
