package br.com.devrodrigues.userservice.input.api.mappers;

import br.com.devrodrigues.userservice.core.User;
import br.com.devrodrigues.userservice.openapi.model.CreateUser;
import br.com.devrodrigues.userservice.openapi.model.CreatedUser;
import com.google.common.hash.Hashing;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.nio.charset.StandardCharsets;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "password", target = "password", qualifiedByName = "hashPassword")
    User fromCreateUserToUser(CreateUser createUser);

    @Named("hashPassword")
    default String hashPassword(String password) {
        return Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
    }

    CreatedUser fromUserToCreatedUser(User user);
}
