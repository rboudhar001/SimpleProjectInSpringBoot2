package com.rboudhar001.service;

import java.util.List;
import java.util.Optional;

import com.rboudhar001.model.User;

public interface UserService {

	// CRUD

	List<User> findAll();

	Optional<User> findById(Long id);

	User save(User user);

	void deleteById(Long id);

	// Added

	List<User> findFriends(Long id);

	List<User> findSuggestedFriends(Long id);
}
