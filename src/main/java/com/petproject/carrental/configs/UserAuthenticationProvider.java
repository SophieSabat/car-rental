package com.petproject.carrental.configs;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.petproject.carrental.dto.UserDTO;
import com.petproject.carrental.services.implementation.UserDetailsServiceImplementation;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class UserAuthenticationProvider {

    private final UserDetailsServiceImplementation userDetailsServiceImplementation;

    @Value("${security.jwt.token.secret-key: secret-value}")
    private String secretKey;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String email) {
        Date date = new Date();
        Date validity = new Date(date.getTime() + 3_600_000);

        return JWT.create()
                .withIssuer(email)
                .withIssuedAt(date)
                .withExpiresAt(validity)
                .sign(Algorithm.HMAC256(secretKey));
    }

    public Authentication validateToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        UserDTO user = userDetailsServiceImplementation.findByEmail(decodedJWT.getIssuer());

        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
    }
}
