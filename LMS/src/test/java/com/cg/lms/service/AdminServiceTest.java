package com.cg.lms.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.lms.entity.User;
import com.cg.lms.model.UserDTO;
import com.cg.lms.repository.AdminRepository;
import com.cg.lms.utils.AdminUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {
	@MockBean
	private AdminRepository repo;
	
	@Autowired
	private AdminService serv;
	
    @SuppressWarnings("unchecked")
	@Test
    public void testCreateUser(){
        UserDTO user=new UserDTO();
        user.setUserId("ST0001");
        user.setfName("Tom");
        user.setlName("Hackson");
        user.setEmail("thackson@university.edu");
        user.setPassword("Htom123");
        user.setContactno("9486751202");  
        User u1=(AdminUtils.convertToUser(user));
        User u2=(AdminUtils.convertToUser(user));
        Mockito.when(((OngoingStubbing<User>) repo.save(u1)).thenReturn(u2));
        assertThat(serv.createUser(user)).isEqualTo(user);
    }
}
