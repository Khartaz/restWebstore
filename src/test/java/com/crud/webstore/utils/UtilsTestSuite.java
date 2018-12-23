package com.crud.webstore.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.security.SecureRandom;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UtilsTestSuite {
    @Autowired
    private Utils utils;

    @Test
    public void testGenerateRandomString() {
        //Given
        final Random RANDOM = new SecureRandom();
        final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder stringBuilder = new StringBuilder(20);
        //When
        stringBuilder.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        //Then
        assertNotNull(stringBuilder);
    }

    @Test
    public void testGenerateUserId() {
        //Given
        String userId1 = utils.generatePublicId(30);
        String userId2 = utils.generatePublicId(30);

        //When & Then
        assertNotNull(userId2);
        assertNotNull(userId1);
        assertEquals(30, userId1.length());
        assertTrue( !userId1.equalsIgnoreCase(userId2));
    }

}
