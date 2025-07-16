package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
	void testGettersAndSetters() {
			User user = new User();
			user.setUserName("John Doe");
			assertEquals("John Doe", user.getUserName());
			user.setEmail("john.doe@example.com");
			assertEquals("john.doe@example.com", user.getEmail());
			user.setPassword("password123");
			assertEquals("password123", user.getPassword());
	}

	@Test
	void testEqualsAndHashCode() {
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
			UserService userService = new UserService();
			User user = new User();
			user.setUserName("John Doe");
			user.setEmail("john.doe@example.com");
			user.setPassword("password123");
			userService.register(user, new BindingResult());
			assertNotNull(userService.findUserById(user.getId()));
	}

	@Test
	void testLoginUser() {
			UserService userService = new UserService();
			LoginUser loginUser = new LoginUser();
			loginUser.setEmail("john.doe@example.com");
			loginUser.setPassword("password123");
			userService.login(loginUser, new BindingResult());
			assertNotNull(userService.findUserById(loginUser.getId()));
	}

	@Test
	void testFindUserById() {
			UserService userService = new UserService();
			User user = new User();
			user.setUserName("John Doe");
			user.setEmail("john.doe@example.com");
			user.setPassword("password123");
			userService.register(user, new BindingResult());
			User foundUser = userService.findUserById(user.getId());
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
	void testGettersAndSetters() {
			LoginUser loginUser = new LoginUser();
			loginUser.setEmail("john.doe@example.com");
			assertEquals("john.doe@example.com", loginUser.getEmail());
			loginUser.setPassword("password123");
			assertEquals("password123", loginUser.getPassword());
	}
}
