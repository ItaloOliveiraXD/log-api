package br.com.projeto.logapi.domain.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Embeddable
public class Destinatario {

    @Column(name = "destinatario_nome")
    @NotBlank
    private String nome;
    @Column(name = "destinatario_logradouro")
    @NotBlank
    private String logradouro;
    @Column(name = "destinatario_numero")
    @NotBlank
    private String numero;
    @Column(name = "destinatario_complemento")
    @NotBlank
    private String complemento;
    @Column(name = "destinatario_bairro")
    @NotBlank
    private String bairro;
}
