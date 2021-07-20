package com.shailesh.service;

import java.util.List;
import java.util.Optional;

import com.shailesh.exception.ResourceNotFoundException;
import com.shailesh.model.User;
import com.shailesh.model.UserRequest;

/**
 * 
 * @author Shailesh
 *
 */
public interface UserService {

	/**
	 * 
	 * @return all available users
	 */
	Optional<List<User>> getAllUsers();

	/**
	 * 
	 * @param id
	 * @throws ResourceNotFoundException
	 * @return user
	 */
	Optional<User> getUser(Long id) throws ResourceNotFoundException;

	/**
	 * 
	 * @param user
	 * @return newly created user
	 */
	Optional<User> createUser(UserRequest user);

	/**
	 * 
	 * @param user
	 * @throws ResourceNotFoundException
	 * @return updated user
	 */
	Optional<User> updateUser(Long id, UserRequest user) throws ResourceNotFoundException;

	/**
	 * @apiNote deletes user
	 * @throws ResourceNotFoundException
	 * @param id
	 * @return true/false
	 */
	Optional<Boolean> deleteUser(Long id) throws ResourceNotFoundException;

}
