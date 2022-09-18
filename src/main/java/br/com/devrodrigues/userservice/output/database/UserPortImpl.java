package br.com.devrodrigues.userservice.output.database;

import br.com.devrodrigues.userservice.core.User;
import br.com.devrodrigues.userservice.output.database.data.UserData;
import br.com.devrodrigues.userservice.ports.UserPort;
import org.springframework.stereotype.Component;

import static br.com.devrodrigues.userservice.output.database.mappers.UserEntityMappers.INSTANCE;

@Component
public class UserPortImpl implements UserPort {

    private final UserData data;

    public UserPortImpl(UserData data) {
        this.data = data;
    }

    @Override
    public User create(User user) {
        var userEntity = INSTANCE.fromUserToUserEntity(user);
        return INSTANCE.fromUserEntityToUser(data.save(userEntity));
    }
}
