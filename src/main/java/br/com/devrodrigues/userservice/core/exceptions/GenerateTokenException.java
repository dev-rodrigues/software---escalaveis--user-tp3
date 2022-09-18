package br.com.devrodrigues.userservice.core.exceptions;

public class GenerateTokenException extends RuntimeException {
    public GenerateTokenException(String message) {
        super(message);
    }
}
