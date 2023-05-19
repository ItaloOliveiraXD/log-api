package br.com.projeto.logapi.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class Problema {
    
    private Integer status;
    private LocalDateTime dateTime;
    private String titulo;
    private List<Fields> fields;
}
