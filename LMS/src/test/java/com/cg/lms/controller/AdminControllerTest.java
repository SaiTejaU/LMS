package com.cg.lms.controller;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.ArgumentMatchers.anyString;

import com.cg.lms.entity.User;
import com.cg.lms.model.UserDTO;
import com.cg.lms.servicesimpl.AdminServiceImpl;
import com.cg.lms.utils.AdminUtils;

class AdminControllerTest {

	@InjectMocks
	AdminController controller;

	@Mock
	AdminServiceImpl service;

	UserDTO userdto;
	final String USER_ID="AD0001";
	final String USER_Email="Shan@gmail.com";
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		userdto=new UserDTO();
		userdto.setfName("Sai");
		userdto.setlName("Teja");
		userdto.setEmail(USER_Email);
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
	@Test
	void testGetUserByEmail() {
		when(service.getUserByEmail(anyString())).thenReturn(userdto);
		UserDTO outuser=service.getUserByEmail(USER_Email);
		assertNotNull(USER_Email,outuser.getEmail());
		assertEquals(userdto.getUserId(),outuser.getUserId());
		assertEquals(userdto.getfName(),outuser.getfName());
		assertEquals(userdto.getlName(),outuser.getlName());
		assertEquals(userdto.getPassword(),outuser.getPassword());		
		assertEquals(userdto.getContactno(),outuser.getContactno());
	}
	@Test
	void testGetAllUsers() {

		User user1=new User();
		user1.setUserId("AD0003");
		user1.setfName("Niha");
		user1.setlName("Tomas");
		user1.setEmail("tomas@gail.com");
		user1.setPassword("niha@2799");
		user1.setContactno("8639345871");			

		User user2=new User();
		user2.setUserId("ST0006");
		user2.setfName("Nick");
		user2.setlName("Jonas");
		user2.setEmail("nick@gmail.com");
		user2.setPassword("jonas123");
		user2.setContactno("9754236012");  
		List<UserDTO> List = new ArrayList<>();
		List.add(AdminUtils.convertToUserDto(user1));
		List.add(AdminUtils.convertToUserDto(user2));

		when(service.getAllUsers()).thenReturn(List);	       
		assertThat(service.getAllUsers()).isEqualTo(List);
	}	
	@Test
	void testGetAllStudents() {
		User user1=new User();
		user1.setUserId("AD0003");
		user1.setfName("Niha");
		user1.setlName("Tomas");
		user1.setEmail("tomas@gail.com");
		user1.setPassword("niha@2799");
		user1.setContactno("8639345871");			

		User user2=new User();
		user2.setUserId("ST0006");
		user2.setfName("Nick");
		user2.setlName("Jonas");
		user2.setEmail("nick@gmail.com");
		user2.setPassword("jonas123");
		user2.setContactno("9754236012");  
		List<UserDTO> List = new ArrayList<>();
		List.add(AdminUtils.convertToUserDto(user1));
		List.add(AdminUtils.convertToUserDto(user2));

		String pattern="ST";
		when(service.getAllStudents(pattern)).thenReturn(List);	       
		assertThat(service.getAllStudents(pattern)).isEqualTo(List);		 
	}
	@Test
	void testGetAllLibrarians() {
		User user1=new User();
		user1.setUserId("LB0003");
		user1.setfName("Niha");
		user1.setlName("Tomas");
		user1.setEmail("tomas@gail.com");
		user1.setPassword("niha@2799");
		user1.setContactno("8639345871");			

		User user2=new User();
		user2.setUserId("ST0006");
		user2.setfName("Nick");
		user2.setlName("Jonas");
		user2.setEmail("nick@gmail.com");
		user2.setPassword("jonas123");
		user2.setContactno("9754236012");  
		List<UserDTO> List = new ArrayList<>();
		List.add(AdminUtils.convertToUserDto(user1));
		List.add(AdminUtils.convertToUserDto(user2));

		String pattern="LB";
		when(service.getAllLibrarians(pattern)).thenReturn(List);	       
		assertThat(service.getAllLibrarians(pattern)).isEqualTo(List);		 
	}
	@Test
	void testGetAllInstructors() {
		User user1=new User();
		user1.setUserId("IS0008");
		user1.setfName("Niha");
		user1.setlName("Tomas");
		user1.setEmail("tomas@gail.com");
		user1.setPassword("niha@2799");
		user1.setContactno("8639345871");			

		User user2=new User();
		user2.setUserId("ST0006");
		user2.setfName("Nick");
		user2.setlName("Jonas");
		user2.setEmail("nick@gmail.com");
		user2.setPassword("jonas123");
		user2.setContactno("9754236012");  
		List<UserDTO> List = new ArrayList<>();
		List.add(AdminUtils.convertToUserDto(user1));
		List.add(AdminUtils.convertToUserDto(user2));

		String pattern="IS";
		when(service.getAllInstructors(pattern)).thenReturn(List);	       
		assertThat(service.getAllInstructors(pattern)).isEqualTo(List);		 
	}
	 @Test
 void testCreateUser() {
 	User user1=new User();
   	user1.setUserId("IS0008");
user1.setfName("Niha");
user1.setlName("Tomas");
user1.setEmail("tomas@gail.com");
user1.setPassword("niha@2799");
user1.setContactno("8639345871");
 when(service.createUser(AdminUtils.convertToUserDto(user1))).thenReturn(AdminUtils.convertToUser(userdto));
 assertThat(service.createUser(AdminUtils.convertToUserDto(user1))).isEqualTo(userdto);		
 }

}