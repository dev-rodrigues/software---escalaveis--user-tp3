package br.com.devrodrigues.userservice.input.api.mappers;

import br.com.devrodrigues.userservice.core.User;
import br.com.devrodrigues.userservice.openapi.model.Authenticate;
import com.google.common.hash.Hashing;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.nio.charset.StandardCharsets;

@Mapper
public interface AuthUserMapper {

    AuthUserMapper INSTANCE = Mappers.getMapper(AuthUserMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(source = "password", target = "password", qualifiedByName = "hashPassword")
    User fromAuthenticateToUser(Authenticate authenticate);

    @Named("hashPassword")
    default String hashPassword(String password) {
        return Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
    }
}
