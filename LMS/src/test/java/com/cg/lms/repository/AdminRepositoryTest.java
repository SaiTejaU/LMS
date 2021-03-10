package com.cg.lms.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.lms.entity.User;

@RunWith(SpringRunner.class)
@DataJpaTest
 class AdminRepositoryTest {
	
	@Autowired
    private AdminRepository adminrepo;

    @Autowired
    private TestEntityManager testem;
    
    @Test
     void testCreateUser() throws Exception{
    	User user=getUser();
        User saveInDb = testem.persist(user);
        User getFromDb = adminrepo.findById(saveInDb.getUserId()).get();
        assertThat(getFromDb).isEqualTo(saveInDb);
    }
    private User getUser() {
        User user=new User();
        user.setfName("Shanthiya");
        user.setlName("Loganathan");
        user.setContactno("9876543210");
        user.setEmail("shan@gmail.com");
        user.setPassword("Shant123"); 
        return user;
    }
}
