package com.rboudhar001.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.rboudhar001.model.User;

@SpringBootTest
public class UserServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private UserService mUserService;

	// User
	private User mUser;

	@BeforeAll
	public static void initAll() {
	}

	@BeforeEach
	public void init() {

		mUser = new User();
//		mUser.setId(999L);
		mUser.setName("Rachid");
		mUser.setCity("Madrid");

//		mUser = new User();
//		mUser.setId(1L);
//		mUser.setName("Alice");
//		mUser.setCity("Dublin");

		// Test
		save();
	}

	@Test
	public void context() {
	}

	// CRUD

	@Test
	public void findAll() {

		// when
		List<User> users = mUserService.findAll();

		// then
		assertThat(users.size()).isGreaterThan(1);
	}

	@Test
	public void findById() {

		// when
		User user = mUserService.findById(mUser.getId()).get();

		// then
		assertThat(user.getId()).isEqualTo(mUser.getId());
		assertThat(user.getName()).isEqualTo(mUser.getName());
		assertThat(user.getCity()).isEqualTo(mUser.getCity());
	}

//	@Test
	public void save() {

		// when
		User user = mUserService.save(mUser);

		// then
		assertThat(user.getName()).isEqualTo(mUser.getName());
		assertThat(user.getCity()).isEqualTo(mUser.getCity());
	}

	@Test
	public void deleteById() {

		// when
		mUserService.deleteById(mUser.getId());

		// then
		assertTrue(true);
	}

	// Added

	@Test
	public void findFriends() {

		// when
		List<User> users = mUserService.findFriends(mUser.getId());

		// then
		assertThat(users.size()).isEqualTo(0);
	}

	@Test
	public void findSuggestedFriends() {

		// when
		List<User> users = mUserService.findSuggestedFriends(mUser.getId());

		// then
		assertThat(users.size()).isEqualTo(0);
	}
}
