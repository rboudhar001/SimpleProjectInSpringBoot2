package com.rboudhar001.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rboudhar001.model.User;
import com.rboudhar001.repository.UserRepository;
import com.rboudhar001.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository mUserRepository;

	// CRUD

	@Override
	public List<User> findAll() {

		List<User> result = (List<User>) mUserRepository.findAll();

		if (result.size() > 0) {
			return result;
		} else {
			return new ArrayList<User>();
		}
	}

	@Override
	public Optional<User> findById(Long id) {

		return mUserRepository.findById(id);
	}
	
	@Override
	public User save(User user) {
		
		return mUserRepository.save(user);
	}

	@Override
	public void deleteById(Long id) {

		mUserRepository.deleteById(id);
	}

	// Added

	@Override
	public List<User> findFriends(Long id) {

		return mUserRepository.findFriends(id);
	}

	@Override
	public List<User> findSuggestedFriends(Long id) {

		return mUserRepository.findSuggestedFriends(id);
	}
}
