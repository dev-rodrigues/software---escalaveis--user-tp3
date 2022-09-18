package br.com.devrodrigues.userservice.core;

import java.util.List;
import java.util.Map;

public class Permissions {

    private Permissions() {
        //no-sonar
    }
    private static final Map<String, List<String>> permissions = Map.of(
            "TEACHER", List.of("rolls", "reasons", "reports"),
            "FATHER", List.of("reports")
    );

    public static boolean hasPermission(String role, String function) {
        return permissions.get(role).contains(function);
    }
}
