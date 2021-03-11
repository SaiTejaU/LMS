package com.cg.lms.controller;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.ArgumentMatchers.anyString;

import com.cg.lms.model.UserDTO;
import com.cg.lms.servicesImpl.AdminServiceImpl;

class AdminControllerTest {
	
	@InjectMocks
	AdminController controller;
	
	@Mock
	AdminServiceImpl service;
	
	UserDTO userdto;
	final String USER_ID="Ad1001";
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		userdto=new UserDTO();
		userdto.setfName("Sai");
		userdto.setlName("Teja");
		userdto.setEmail("saiteja@gmai.com");
		userdto.setPassword("Sai@2799");
		userdto.setContactno("8639334693");
		userdto.setUserId(USER_ID);
	}

	@Test
	void testGetUserById() {
		when(service.getUserById(anyString())).thenReturn(userdto);
		UserDTO outuser=service.getUserById(USER_ID);
		assertNotNull(USER_ID,outuser.getUserId());
		assertEquals(userdto.getfName(),outuser.getfName());
		assertEquals(userdto.getlName(),outuser.getlName());
		assertEquals(userdto.getPassword(),outuser.getPassword());
		assertEquals(userdto.getEmail(),outuser.getEmail());
		assertEquals(userdto.getContactno(),outuser.getContactno());
	}

}





