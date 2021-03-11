package com.cg.lms.servicesImpl;
import static org.mockito.Mockito.when;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
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
import com.cg.lms.servicesimpl.AdminServiceImpl;

@SuppressWarnings("unused")
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
	void testGetUserByEmail() throws UserNotFoundException {
		User user= new User();
		user.setUserId("AD0002");
		user.setfName("Sai");
		user.setlName("Teja");
		user.setEmail("saiteja@gmail.com");
		user.setPassword("Sai@2799");
		user.setContactno("9745631120");
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
	@Test
	void testGetUserById() throws UserNotFoundException {
		User user= new User();
		user.setUserId("AD0002");
		user.setfName("Sai");
		user.setlName("Teja");
		user.setEmail("saiteja@gmail.com");
		user.setPassword("Sai@2799");
		user.setContactno("9745631120");

		when(repo.findById( anyString())).thenReturn(Optional.of(user));
		UserDTO userdto=service.getUserById("AD0002");
		assertNotNull(userdto);
		assertEquals("Sai",userdto.getfName());
	}
	/*@Test
void testGetUserById_UserNotFoundException(){
when(repo.findById( anyString())).thenReturn(null);
assertThrows(UserNotFoundException.class,
()-> {
service.getUserById("AD0002");
}
);
}*/
	/* @Test
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
    List<User> list = new ArrayList<>();
        list.add(user1);//(AdminUtils.convertToUserDto(user1));
        list.add(user2);//(AdminUtils.convertToUserDto(user2));

        when( repo.findAll()).thenReturn(list);	       
        assertThat(service.getAllUsers()).isEqualTo(list);
 }*/
}