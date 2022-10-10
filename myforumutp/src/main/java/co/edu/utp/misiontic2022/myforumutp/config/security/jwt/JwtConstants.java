package co.edu.utp.misiontic2022.myforumutp.config.security.jwt;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.HttpHeaders;

import java.security.Key;

public class JwtConstants {

    public static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    public static final long EXPIRATION = 7200000;
    public static final String HEADER = HttpHeaders.AUTHORIZATION;
    public static final String TOKEN_HEADER = "Bearer";

}