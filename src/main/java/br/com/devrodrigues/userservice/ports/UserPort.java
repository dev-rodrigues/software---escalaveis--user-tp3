package br.com.devrodrigues.userservice.ports;

import br.com.devrodrigues.userservice.core.User;

public interface UserPort {
    User create(User user);
}
