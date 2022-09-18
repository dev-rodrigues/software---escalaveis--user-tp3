package br.com.devrodrigues.userservice.usecase;

import br.com.devrodrigues.userservice.core.User;
import br.com.devrodrigues.userservice.core.exceptions.UserNotAllowedException;
import br.com.devrodrigues.userservice.ports.UserPort;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static java.util.Objects.nonNull;

@Component
public class AuthenticateUserUseCase {

    private final UserPort userPort;

    public AuthenticateUserUseCase(UserPort userPort) {
        this.userPort = userPort;
    }

    public HttpHeaders execute(User user) {
        HttpHeaders responseHeaders = new HttpHeaders();
        var localizedUser = userPort.getByName(user.getName());

        if (nonNull(localizedUser) && Objects.equals(localizedUser.getPassword(), user.getPassword())) {
                responseHeaders.add("token", localizedUser.getToken());
                return responseHeaders;
        }

        throw new UserNotAllowedException("User not found");
    }
}
