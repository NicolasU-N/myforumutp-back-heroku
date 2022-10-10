package co.edu.utp.misiontic2022.myforumutp.config.security.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class JwtProvider {

    public String generateToken(Authentication authentication) {
        User userPrincipal = (User) authentication.getPrincipal();

        Claims claims = Jwts.claims().setSubject(userPrincipal.getUsername());
        //"authorities"
        claims.put("roles", userPrincipal.getAuthorities().stream().map(
                x -> x.getAuthority()).collect(Collectors.toList()));

        //return createToken(userDetails.getUsername(), claims);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JwtConstants.EXPIRATION))
                .setId(UUID.randomUUID().toString())
                .signWith(JwtConstants.SECRET_KEY).compact();
    }

    public String username(String token) {
        return claim(token, Claims::getSubject);
    }

    public Date expiration(String token) {
        return claim(token, Claims::getExpiration);
    }

    public <T> T claim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = allClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims allClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(JwtConstants.SECRET_KEY).build().parseClaimsJws(token).getBody();
    }


    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = username(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);

    }

    private Boolean isTokenExpired(String token) {
        return expiration(token).before(new Date());
    }
}
