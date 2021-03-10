package com.cg.lms.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.lms.exception.UserIdAlreadyExistException;
import com.cg.lms.exception.UserNotFoundException;
import com.cg.lms.model.UserDTO;
import com.cg.lms.entity.User;
import com.cg.lms.repository.AdminRepository;
import com.cg.lms.utils.AdminUtils;

import java.util.*;

@Service
public class AdminServiceImpl {
	
	@Autowired
	private AdminRepository repo;
		
    public List<UserDTO> getAllUsers() {
    	List<User> ulist=repo.findAll();
    	return AdminUtils.convertToUserDtoList(ulist);
    } 
    
     public List<UserDTO> getAllStudents(String student) {
    	List<User> ulist=repo.getAllStudents(student);
     	return AdminUtils.convertToUserDtoList(ulist);
     }
     
     public List<UserDTO> getAllInstructors(String instructor) {
      	List<User> ulist=repo.getAllInstructors(instructor);
     	return AdminUtils.convertToUserDtoList(ulist);
      }
     
     public List<UserDTO> getAllLibrarians(String librarian) {      	
      	List<User> ulist=repo.getAllLibrarians(librarian);
     	return AdminUtils.convertToUserDtoList(ulist);
      }
     
    public UserDTO getUserById(String userId) throws UserNotFoundException{
    	Optional<User> opt= repo.findById(userId);		
		if(opt.isPresent()) {
			User user= opt.get();
			return AdminUtils.convertToUserDto(user);
		}
		else {
			throw new UserNotFoundException("User not found for the given userId");			
		}
    }
    public UserDTO getUserByEmail(String email) throws UserNotFoundException {
    	Optional<User> opt= Optional.ofNullable(repo.findByEmail(email));		
		if(opt.isPresent()) {
			User user= opt.get();
			return AdminUtils.convertToUserDto(user);
		}
		else {
			throw new UserNotFoundException("User not found for the given Email");			
		}
    }
    
    public User createUser(UserDTO userdto) {
    	User user=AdminUtils.convertToUser(userdto);
    	boolean exist=repo.existsById(user.getUserId());
    	if(!exist)
    		return repo.save(user);
    	else {
    		throw new UserIdAlreadyExistException("UserId already exist");
    	}    		
    }
    
    public User updateUser(String userId, UserDTO userdto) throws UserNotFoundException {
        	Optional<User> opt= repo.findById(userId);
        	User user=new User();
        	if(opt.isPresent()) {        	
            user.setfName(userdto.getfName());
            user.setlName(userdto.getlName());
            user.setContactno(userdto.getContactno());
            user.setEmail(userdto.getEmail());
            user.setPassword(userdto.getPassword());  
            }          
        else{
        	throw new UserNotFoundException("UserId "+userId+" not found");
        }       
        repo.flush();
        return user;        
    }
    
    
    public ResponseEntity<Object> deleteUserById(String userId) {
    	return repo.findById(userId).map(user ->{
    		repo.delete(user);
    		return ResponseEntity.ok().build();
    	}).orElseThrow(()-> new UserNotFoundException("UserId "+userId+" not found"));
    }
}