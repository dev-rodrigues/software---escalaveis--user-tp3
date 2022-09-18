package br.com.devrodrigues.userservice.usecase;

import br.com.devrodrigues.userservice.core.Permissions;
import br.com.devrodrigues.userservice.core.exceptions.InvalidTokenException;
import org.springframework.stereotype.Component;

@Component
public class ShouldHavePermissionUseCase {

    private final GetDataFromUserTokeUseCase getDataFromUserTokeUseCase;

    public ShouldHavePermissionUseCase(GetDataFromUserTokeUseCase getDataFromUserTokeUseCase) {
        this.getDataFromUserTokeUseCase = getDataFromUserTokeUseCase;
    }

    public String execute(String token, String function) {
        var userTokenized = getDataFromUserTokeUseCase.execute(token);
        var hasPermission = Permissions.hasPermission(userTokenized.getRole(), function);

        if (!hasPermission) {
            throw new InvalidTokenException("not allowed");
        }

        return "Allowed";
    }
}
