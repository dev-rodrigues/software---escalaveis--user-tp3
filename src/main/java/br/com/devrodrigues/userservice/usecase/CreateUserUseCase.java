package br.com.devrodrigues.userservice.usecase;

import br.com.devrodrigues.userservice.core.User;
import br.com.devrodrigues.userservice.ports.UserPort;
import org.springframework.stereotype.Component;

@Component
public class CreateUserUseCase {

    private final UserPort port;

    public CreateUserUseCase(UserPort port) {
        this.port = port;
    }

    public User execute(User user) {
        return port.create(user);
    }
}
