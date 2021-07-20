/**
 * 
 */
package com.shailesh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shailesh.exception.ResourceNotFoundException;
import com.shailesh.model.User;
import com.shailesh.model.UserRequest;
import com.shailesh.repository.UserRepository;

/**
 * @author Shailesh
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Override
	public Optional<List<User>> getAllUsers() {
		return Optional.ofNullable(userRepository.findAll());
	}

	@Override
	public Optional<User> getUser(Long id) throws ResourceNotFoundException {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
		return Optional.ofNullable(user);
	}

	@Override
	public Optional<User> createUser(UserRequest request) {
		User user = new User();
		BeanUtils.copyProperties(user, request);
		user.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
		return Optional.ofNullable(userRepository.save(user));
	}

	@Override
	public Optional<User> updateUser(Long id, UserRequest userDetails) throws ResourceNotFoundException {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

		user.setSurName(userDetails.getSurName());
		user.setTitle(userDetails.getTitle());
		user.setDob(userDetails.getDob());
		user.setFirstName(userDetails.getFirstName());
		User updatedUser = userRepository.save(user);
		return Optional.ofNullable(updatedUser);
	}

	@Override
	public Optional<Boolean> deleteUser(Long id) throws ResourceNotFoundException {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
		try {			
			userRepository.delete(user);
			return Optional.of(true);
		} catch (Exception e) {
			return Optional.of(false);
		}
	}

}
