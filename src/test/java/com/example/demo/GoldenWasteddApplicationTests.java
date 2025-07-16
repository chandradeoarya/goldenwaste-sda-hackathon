package com.example.demo;

import com.example.demo.models.User;
import com.example.demo.models.LoginUser;
import com.example.demo.services.UserService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.BindingResult;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class GoldenWasteddApplicationTests {

    // Test cases for User.java

    @Test
    void testUserCreation() {
        User user = new User();
        user.setUserName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password123");

        assertNotNull(user);
    }

    @Test
    void testUserGettersAndSetters() {
        User user = new User();
        user.setUserName("John Doe");
        assertEquals("John Doe", user.getUserName());

        user.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", user.getEmail());

        user.setPassword("password123");
        assertEquals("password123", user.getPassword());
    }

@Test
void testUserEqualsAndHashCode() {
    User user1 = new User();
    user1.setUserName("John Doe");
    user1.setEmail("john.doe@example.com");
    user1.setPassword("password123");

    User user2 = new User();
    user2.setUserName("John Doe");
    user2.setEmail("john.doe@example.com");
    user2.setPassword("password123");

    assertEquals(user1, user2);
    assertEquals(user1.hashCode(), user2.hashCode());
}

    // Test cases for UserService.java

    @Test
    void testRegisterUser() {
        UserService userService = mock(UserService.class);
        User user = new User();

        BindingResult bindingResult = mock(BindingResult.class);

        when(userService.findUserById(anyLong())).thenReturn(user);

        userService.register(user, bindingResult);
        User found = userService.findUserById(user.getId());

        assertNotNull(found);
    }

@Test
void testLoginUser() {
    UserService userService = mock(UserService.class);
    LoginUser loginUser = new LoginUser();

    BindingResult bindingResult = mock(BindingResult.class);

    when(userService.findUserById(anyLong())).thenReturn(new User());

    userService.login(loginUser, bindingResult);
    User found = userService.findUserById(1L);

    assertNotNull(found);
}

    @Test
    void testFindUserById() {
        UserService userService = mock(UserService.class);
        User user = new User();

        when(userService.findUserById(anyLong())).thenReturn(user);

        User foundUser = userService.findUserById(1L);

        assertNotNull(foundUser);
        assertEquals(user, foundUser);
    }

    // Test cases for LoginUser.java

    @Test
    void testLoginUserCreation() {
        LoginUser loginUser = new LoginUser();
        loginUser.setEmail("john.doe@example.com");
        loginUser.setPassword("password123");

        assertNotNull(loginUser);
    }

    @Test
    void testLoginUserGettersAndSetters() {
        LoginUser loginUser = new LoginUser();
        loginUser.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", loginUser.getEmail());

        loginUser.setPassword("password123");
        assertEquals("password123", loginUser.getPassword());
    }
}