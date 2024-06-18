package com.mohanadhilles.demotest.Util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class Token {

    private final String CLAIMS_SUBJECT = "sub";
    private final String CLAIIMS_CREATRED = "created";

    @Value("${auth.expiration}")
    private final Long TOKEN_VALIDATE = 604800L;

    @Value("${auth.secret}")
    private String TOKEN_SECRET;


    public String generateToken(UserDetails userDetails) {

        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIMS_SUBJECT, userDetails.getUsername());
        claims.put(CLAIIMS_CREATRED, new Date());

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, TOKEN_SECRET)
                .compact();
    }


    /**
     * @param token
     * @return
     */
    public String getUserNameFromToken(String token)
    {
        try {
           Claims  claims = getClaims(token);
            return claims.getSubject();
        } catch (Exception e) {
            return null;
        }
    }
    

    private Date generateExpirationDate() {

        return new Date(System.currentTimeMillis() + TOKEN_VALIDATE * 1000);
    }


    public boolean isTokenValid(String token, UserDetails userDetails) {
       
        String username = getUserNameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }


    private boolean isTokenExpired(String token) {

        Date expiration = getClaims(token).getExpiration();
        return expiration.before(new Date());
    }
    

    
    /**
     * @param token
     * @return
     */
    private Claims getClaims(String token)
    {
        Claims claims;
        try {
             claims = Jwts.parser()
                    .setSigningKey(TOKEN_SECRET)
                    .parseClaimsJws(token)
                    .getBody();
    
        } catch (ExpiredJwtException | MalformedJwtException | SignatureException | UnsupportedJwtException | IllegalArgumentException e) {
           claims = null;
        }
        return claims;
    }
}
