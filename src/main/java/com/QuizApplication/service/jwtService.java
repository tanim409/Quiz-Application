package com.QuizApplication.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Service
public class jwtService {

    String security = "";

    public jwtService() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
        SecretKey secretKey = keyGenerator.generateKey();
        security = Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    public String generateJwtToken(String username) throws NoSuchAlgorithmException, InvalidKeySpecException {

        HashMap<String, Object> claims = new HashMap<String, Object>();
        return Jwts
                .builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 3000))
                .and()
                .signWith(getKey())
                .compact();

    }

    public SecretKey getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(security);
        return Keys.hmacShaKeyFor(keyBytes);

    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> function) {
        Claims claim = extractAllClaim(token);
        return function.apply(claim);
    }

    private Claims extractAllClaim(String token) {
        return Jwts
                .parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private Boolean isTokenExpired(String token) {
        Claims claims = extractAllClaim(token);
        return claims.getExpiration().before(new Date());
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {

        Claims claims = extractAllClaim(token);
        return claims.getSubject().equals(userDetails.getUsername()) && !isTokenExpired(token);

    }

}
