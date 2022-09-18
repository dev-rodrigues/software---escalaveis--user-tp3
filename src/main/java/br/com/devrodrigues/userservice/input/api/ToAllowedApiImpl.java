package br.com.devrodrigues.userservice.input.api;

import br.com.devrodrigues.userservice.openapi.api.ToAllowedApi;
import br.com.devrodrigues.userservice.openapi.model.Permission;
import br.com.devrodrigues.userservice.usecase.ShouldHavePermissionUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToAllowedApiImpl implements ToAllowedApi {

    private final ShouldHavePermissionUseCase shouldHavePermissionUseCase;

    public ToAllowedApiImpl(ShouldHavePermissionUseCase shouldHavePermissionUseCase) {
        this.shouldHavePermissionUseCase = shouldHavePermissionUseCase;
    }

    @Override
    public ResponseEntity<Permission> toAllowed(String function, String token) {
        var result = shouldHavePermissionUseCase.execute(token, function);
        var response = new Permission();
        response.setMessage(result);
        return ResponseEntity.ok(response);
    }
}