package br.com.devrodrigues.userservice.input.api.exceptions;

import br.com.devrodrigues.userservice.core.exceptions.UserNotAllowedException;
import br.com.devrodrigues.userservice.openapi.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerImpl {

    @ResponseBody
    @ExceptionHandler(UserNotAllowedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Error userNotAllowedException(UserNotAllowedException e) {
        var response = new Error();
        response.setMessage(e.getMessage());
        return response;
    }
}
