package br.com.devrodrigues.userservice.core;

import br.com.devrodrigues.userservice.core.exceptions.GenerateTokenException;
import com.google.gson.Gson;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.ECDSASigner;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.gen.ECKeyGenerator;
import org.apache.logging.log4j.util.Strings;

import static org.apache.logging.log4j.util.Strings.concat;

public class User {

    private final Integer id;
    private final String name;
    private final String role;
    private final String password;

    public User(Integer id, String name, String role, String password) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        try {
            var ecJWK = new ECKeyGenerator(Curve.P_256)
                    .keyID("123")
                    .generate();

            var signer = new ECDSASigner(ecJWK);

            var jwsObject = new JWSObject(
                    new JWSHeader
                            .Builder(JWSAlgorithm.ES256)
                            .keyID(ecJWK.getKeyID())
                            .build(),
                    new Payload(new Gson().toJson(new UserTokenized(getName(), getRole())))
            );

            jwsObject.sign(signer);

            return concat("Bearer ", jwsObject.serialize());

        } catch (JOSEException e) {
            throw new GenerateTokenException("Failed to generate token");
        }
    }
}