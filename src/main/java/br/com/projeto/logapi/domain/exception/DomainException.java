package br.com.projeto.logapi.domain.exception;

public class DomainException extends RuntimeException{
    
    public DomainException(String mensagem) {
        super(mensagem);
    }
}
