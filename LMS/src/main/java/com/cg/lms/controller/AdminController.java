package com.cg.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.lms.entity.User;
import com.cg.lms.exception.UserIdAlreadyExistException;
import com.cg.lms.exception.UserNotFoundException;
import com.cg.lms.model.UserDTO;
import com.cg.lms.servicesimpl.AdminServiceImpl;

@RestController
@RequestMapping("/user")
public class AdminController {
	
	@Autowired
	private AdminServiceImpl serv;
	
    @GetMapping("/getAllUsers")
    public List<UserDTO> getAllUsers(){
    	return serv.getAllUsers();
    }  
  
    @GetMapping("/getAllStudents")
    public List<UserDTO> getAllStudents(String s) {
    	String pattern="ST";
    	return  serv.getAllStudents(pattern);
    }
    
    @GetMapping("/getAllLibrarians")
    public List<UserDTO> getAllLibrarians(){
    	String pattern="LB";
        return  serv.getAllLibrarians(pattern);
    }
    
    @GetMapping("/getAllInstructors")
    public List<UserDTO> getAllInstructors(){
    	String pattern="IS";
        return  serv.getAllInstructors(pattern);
    }
  
  
    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<Object> getUserById(@PathVariable("userId") String userId) throws UserNotFoundException{
    	UserDTO u = serv.getUserById(userId);
    	return new ResponseEntity<>(u,HttpStatus.OK);
    }
    
    @GetMapping("/getUserByEmail/{email:.+}")
    public ResponseEntity<Object> getUserByEmail(@PathVariable("email") String email) throws UserNotFoundException{
    	UserDTO u = serv.getUserByEmail(email);
    	return new ResponseEntity<>(u,HttpStatus.OK);
    }   
       
    @PostMapping("/createUser")
    public User createUser(@RequestBody UserDTO userdto){
    	return serv.createUser(userdto);

    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<Object> updateUserById(@PathVariable("userId") String userId, @RequestBody UserDTO userdto) throws UserNotFoundException {
    	User user=serv.updateUser(userId, userdto);
    	return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
	@DeleteMapping("/deleteUserById/{userId}")
    public ResponseEntity<Object> deleteUserById(@PathVariable("userId") String userId) throws UserNotFoundException{
        return serv.deleteUserById(userId);
    }

	@ExceptionHandler(UserNotFoundException.class) 
	public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException e) {
		return new ResponseEntity<>("User Not Found Exception...",HttpStatus.OK);
	}
	@ExceptionHandler(UserIdAlreadyExistException.class) 
	public ResponseEntity<String> handleUserAlreadyExistException(UserIdAlreadyExistException e) {
		return new ResponseEntity<>("UserId already exists...",HttpStatus.OK);
	}
}