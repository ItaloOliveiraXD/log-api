package br.com.projeto.logapi.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Problema {
    
    private Integer status;
    private LocalDateTime dateTime;
    private String titulo;
    private List<Fields> fields;
}
