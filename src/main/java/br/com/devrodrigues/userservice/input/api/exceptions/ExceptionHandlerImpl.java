package br.com.devrodrigues.userservice.input.api.exceptions;

import br.com.devrodrigues.userservice.core.exceptions.GenerateTokenException;
import br.com.devrodrigues.userservice.core.exceptions.UserNotAllowedException;
import br.com.devrodrigues.userservice.openapi.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.METHOD_NOT_ALLOWED;

@ControllerAdvice
public class ExceptionHandlerImpl {

    @ResponseBody
    @ExceptionHandler(UserNotAllowedException.class)
    @ResponseStatus(METHOD_NOT_ALLOWED)
    public Error userNotAllowedException(UserNotAllowedException e) {
        var response = new Error();
        response.setMessage(e.getMessage());
        return response;
    }

    @ResponseBody
    @ExceptionHandler(GenerateTokenException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public Error generateTokenException(GenerateTokenException e) {
        var response = new Error();
        response.setMessage(e.getMessage());
        return response;
    }

}
