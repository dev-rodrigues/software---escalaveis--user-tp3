package br.com.devrodrigues.userservice.output.database.mappers;

import br.com.devrodrigues.userservice.core.User;
import br.com.devrodrigues.userservice.output.database.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEntityMappers {

    UserEntityMappers INSTANCE = Mappers.getMapper(UserEntityMappers.class);

    UserEntity fromUserToUserEntity(User user);

    User fromUserEntityToUser(UserEntity userEntity);
}
