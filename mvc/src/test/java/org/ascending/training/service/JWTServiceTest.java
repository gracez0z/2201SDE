package org.ascending.training.service;

import io.jsonwebtoken.Claims;
import org.ascending.training.ApplicationBootstrap;
import org.ascending.training.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootstrap.class)
public class JWTServiceTest {
    @Autowired
    private JWTService jwtService;

    @Test
    public void generateTokenTest() {
        User u = new User();
        u.setId(1);
        u.setName("Grace");

        String token = jwtService.generateToken(u);

        String[] array = token.split("\\.");
        boolean bool = array.length == 3 ? true: false;
        assertTrue(bool);
    }

    @Test
    public void decryptTokenTest() {
        User u = new User();
        u.setId(1);
        u.setName("Grace");
        String token = jwtService.generateToken(u);

        Claims c = jwtService.decryptToken(token);
        String userName = c.getSubject();

        assertEquals(u.getName(), userName);
    }
}
