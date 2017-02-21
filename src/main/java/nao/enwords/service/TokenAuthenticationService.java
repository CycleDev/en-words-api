package nao.enwords.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import nao.enwords.security.AuthenticatedUser;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class TokenAuthenticationService {

    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24; // 1 day
    private String secret = "ThisIsASecret";
    private String tokenPrefix = "Bearer";
    private String headerString = "Authorization";

    public void addAuthentication(HttpServletResponse response, String username) {
        // We generate a token now.
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        response.addHeader(headerString, tokenPrefix + " " + JWT);
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(headerString);

        if (token != null) {
            // parse the token.
            String username = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            if (username != null) { // we managed to retrieve a user
               return new AuthenticatedUser(username);
            }
        }
        return null;
    }
}