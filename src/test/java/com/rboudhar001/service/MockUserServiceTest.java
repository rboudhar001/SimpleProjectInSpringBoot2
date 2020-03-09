package com.rboudhar001.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.rboudhar001.model.User;
import com.rboudhar001.repository.UserRepository;
import com.rboudhar001.service.impl.UserServiceImpl;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class MockUserServiceTest {

	@Mock
	private UserRepository mUserRepository;

	@InjectMocks
	private UserServiceImpl mUserServiceImpl;

	// User
	private User mUser;

	@BeforeAll
	public static void initAll() {
	}

	@BeforeEach
	public void init() {

		mUser = new User();
		mUser.setId(6L);
		mUser.setName("Tom");
		mUser.setCity("Cork");
	}

	@Test
	public void context() {
	}

	// CRUD

	@Test
	public void findAll() {

		// Mock
		List<User> users = new ArrayList<User>();
		when(mUserRepository.findAll()).thenReturn(users);

		// Test
		assertEquals(mUserServiceImpl.findAll(), users);
	}

	@Test
	public void findById() {

		// Mock
		when(mUserRepository.findById(mUser.getId())).thenReturn(Optional.of(mUser));

		// Test
		assertEquals(mUserServiceImpl.findById(mUser.getId()).get(), mUser);
	}

	@Test
	public void save() {

		// Mock
		when(mUserRepository.save(mUser)).thenReturn(mUser);

		// Test
		assertEquals(mUserServiceImpl.save(mUser), mUser);
	}

	@Test
	public void deleteById() {

		// Mock
		mUserRepository.deleteById(mUser.getId());

		// Test
		verify(mUserRepository, times(1)).deleteById(mUser.getId());
	}

	// Added

	@Test
	public void findFriends() {

		// Mock
		List<User> users = new ArrayList<User>();
		when(mUserRepository.findFriends(mUser.getId())).thenReturn(users);

		// Test
		assertEquals(mUserServiceImpl.findFriends(mUser.getId()), users);
	}

	@Test
	public void findSuggestedFriends() {

		// Mock
		List<User> users = new ArrayList<User>();
		when(mUserRepository.findSuggestedFriends(mUser.getId())).thenReturn(users);

		// Test
		assertEquals(mUserServiceImpl.findSuggestedFriends(mUser.getId()), users);
	}
}
