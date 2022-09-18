package br.com.devrodrigues.userservice.usecase;

import br.com.devrodrigues.userservice.core.UserTokenized;
import br.com.devrodrigues.userservice.core.exceptions.InvalidTokenException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class GetDataFromUserTokeUseCase {

    public UserTokenized execute(String token) {
        try {
            return getDecodedToken(token);
        } catch (Throwable e) {
            throw new InvalidTokenException(e.getMessage());
        }
    }

    public UserTokenized getDecodedToken(String token) throws Throwable {
        var payloadData = partsOfToken(token)[1];
        var payloadDataJson = new String(Base64.getUrlDecoder().decode(payloadData), StandardCharsets.UTF_8);
        return new ObjectMapper().readValue(payloadDataJson, UserTokenized.class);
    }

    private String[] partsOfToken(String token)  {
        String[] parts = token.split("\\.");
        if (parts.length == 2 && token.endsWith(".")) {
            parts = new String[]{parts[0], parts[1], ""};
        }
        if (parts.length != 3) {
            throw new RuntimeException();
        }
        return parts;
    }
}
