package br.com.devrodrigues.userservice.input.api;

import br.com.devrodrigues.userservice.openapi.api.AuthApi;
import br.com.devrodrigues.userservice.openapi.model.Authenticate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthApiImpl implements AuthApi {

    @Override
    public ResponseEntity<Void> auth(Authenticate authenticate) {
        return ResponseEntity.ok().build();
    }
}
