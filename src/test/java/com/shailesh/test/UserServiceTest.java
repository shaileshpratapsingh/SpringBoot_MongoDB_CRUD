package com.shailesh.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.shailesh.exception.ResourceNotFoundException;
import com.shailesh.model.User;
import com.shailesh.model.UserRequest;
import com.shailesh.repository.UserRepository;
import com.shailesh.service.SequenceGeneratorService;
import com.shailesh.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Mock
	private UserRepository repository;
	
	@Mock
	private SequenceGeneratorService sequence;
	
	@InjectMocks
	private UserServiceImpl service;
	
	@Test
	public void testGetAllUsers() {
		List<User> list = new ArrayList<>();
		User user = new User();
		user.setFirstName("shailesh");
		user.setSurName("singh");
		user.setTitle("Mr.");
		user.setDob(new Date());
		list.add(user);
		when(repository.findAll()).thenReturn(list);
		Optional<List<User>> userList = service.getAllUsers();
		assertEquals(list, userList.get());
	}
	
	@Test
	public void testGetUserById() throws ResourceNotFoundException {
		User user = new User();
		user.setId(1L);
		user.setFirstName("shailesh");
		user.setSurName("singh");
		user.setTitle("Mr.");
		user.setDob(new Date());
		when(repository.findById(1L)).thenReturn(Optional.of(user));
		Optional<User> userDetails = service.getUser(1L);
		assertEquals("shailesh", userDetails.get().getFirstName());
	}
	
	@Test(expected = ResourceNotFoundException.class)
	public void testGetUserByIdThrowException() throws ResourceNotFoundException {
		User user = mock(User.class);
		when(repository.findById(1L)).thenReturn(Optional.of(user));
		service.getUser(2L);
	}

}
