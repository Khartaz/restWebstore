package com.crud.webstore.utils;

import com.crud.webstore.security.SecurityConstans;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

@Component
public class Utils {
    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private String generateRandomString(int length) {
        StringBuilder returnValue = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }

    public String generatePublicId(int length) {
        return generateRandomString(length);
    }

    public boolean hasTokenExpired(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstans.getTokenSecret())
                .parseClaimsJws(token).getBody();

        Date tokenExpirationDate = claims.getExpiration();
        Date todayDate = new Date();

        return tokenExpirationDate.before(todayDate);
    }

    public String generateEmailVerificationToken(String userId) {
        return Jwts.builder()
                .setSubject(userId)
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstans.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstans.getTokenSecret())
                .compact();
    }

    public String generatePasswordResetToken(String userId) {
        return Jwts.builder()
                .setSubject(userId)
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstans.PASSWORD_RESET_EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstans.getTokenSecret())
                .compact();
    }
}
