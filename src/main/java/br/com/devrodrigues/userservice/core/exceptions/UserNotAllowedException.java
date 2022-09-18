package br.com.devrodrigues.userservice.core.exceptions;

public class UserNotAllowedException extends RuntimeException {
    public UserNotAllowedException(String message) {
        super(message);
    }
}
