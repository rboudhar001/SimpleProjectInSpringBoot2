package com.rboudhar001.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rboudhar001.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	// Added

	@Query(value = "SELECT * FROM users WHERE user_id IN (SELECT frie_friend_id FROM friends WHERE frie_user_id = ?1)", nativeQuery = true)
	List<User> findFriends(Long id);

	@Query(value = "SELECT * FROM users WHERE user_id IN ("
			+ "SELECT frie_friend_id FROM friends WHERE frie_user_id IN ("
			+ "SELECT frie_friend_id FROM friends WHERE frie_user_id = ?1" + ")" + "AND frie_friend_id NOT IN ("
			+ "SELECT frie_friend_id FROM friends WHERE frie_user_id = ?1" + ")"
			+ "AND frie_friend_id != ?1);", nativeQuery = true)
	List<User> findSuggestedFriends(Long id);
}
