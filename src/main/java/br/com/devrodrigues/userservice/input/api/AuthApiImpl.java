package br.com.devrodrigues.userservice.input.api;

import br.com.devrodrigues.userservice.openapi.api.AuthApi;
import br.com.devrodrigues.userservice.openapi.model.Authenticate;
import br.com.devrodrigues.userservice.usecase.AuthenticateUserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static br.com.devrodrigues.userservice.input.api.mappers.AuthUserMapper.INSTANCE;

@RestController
public class AuthApiImpl implements AuthApi {

    private final AuthenticateUserUseCase authenticateUserUseCase;

    public AuthApiImpl(AuthenticateUserUseCase authenticateUserUseCase) {
        this.authenticateUserUseCase = authenticateUserUseCase;
    }

    @Override
    public ResponseEntity<Void> auth(Authenticate authenticate) {
        var user = INSTANCE.fromAuthenticateToUser(authenticate);
        var httpHeaders = authenticateUserUseCase.execute(user);
        return ResponseEntity.noContent().headers(httpHeaders).build();
    }
}
