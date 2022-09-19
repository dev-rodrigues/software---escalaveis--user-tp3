package br.com.devrodrigues.userservice.core;

import java.util.List;
import java.util.Map;

import static java.util.List.of;

public class Permissions {

    private Permissions() {
        //no-sonar
    }
    private static final Map<String, List<String>> permissions = Map.of(
            "TEACHER", of("rolls", "reasons", "reports, justify"),
            "FATHER", of("reports, justify")
    );

    public static boolean hasPermission(String role, String function) {
        return permissions.get(role).contains(function);
    }
}
