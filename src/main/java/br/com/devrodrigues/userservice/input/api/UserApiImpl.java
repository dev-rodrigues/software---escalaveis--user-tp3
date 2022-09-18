package br.com.devrodrigues.userservice.input.api;

import br.com.devrodrigues.userservice.openapi.api.UserApi;
import br.com.devrodrigues.userservice.openapi.model.CreateUser;
import br.com.devrodrigues.userservice.openapi.model.CreatedUser;
import br.com.devrodrigues.userservice.usecase.CreateUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static br.com.devrodrigues.userservice.input.api.mappers.UserMapper.INSTANCE;

@RestController
public class UserApiImpl implements UserApi {

    private final CreateUserUseCase createUserUseCase;

    public UserApiImpl(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @Override
    public ResponseEntity<CreatedUser> store(CreateUser createUser) {
        var user = INSTANCE.fromCreateUserToUser(createUser);
        var createdUser = createUserUseCase.execute(user);
        var response = INSTANCE.fromUserToCreatedUser(createdUser);
        return ResponseEntity.ok(response);
    }
}
