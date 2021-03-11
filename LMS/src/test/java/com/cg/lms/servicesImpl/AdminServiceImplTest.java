package com.cg.lms.servicesImpl;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.lms.entity.User;
import com.cg.lms.exception.UserNotFoundException;
import com.cg.lms.model.UserDTO;
import com.cg.lms.repository.AdminRepository;

class AdminServiceImplTest {
	@InjectMocks
	AdminServiceImpl service;
	@Mock
	AdminRepository repo;
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	void testGetUserByEmail() {
		User user= new User();
		user.setfName("Sai");
		user.setlName("Teja");
		user.setEmail("saiteja@gmail.com");
		user.setPassword("Sai@2799");
		when(repo.findByEmail( anyString())).thenReturn(user);
		UserDTO userdto=service.getUserByEmail("test@test.com");
		assertNotNull(userdto);
		assertEquals("Sai",userdto.getfName());
	}
	@Test
	void testGetUserByEmail_UserNotFoundException(){
		when(repo.findByEmail( anyString())).thenReturn(null);
		assertThrows(UserNotFoundException.class,
				()-> {
					service.getUserByEmail("test@test.com");
				}
				);
	}
}
