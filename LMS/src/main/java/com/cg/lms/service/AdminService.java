package com.cg.lms.service;

import java.util.List;


import org.springframework.http.ResponseEntity;

import com.cg.lms.entity.User;
import com.cg.lms.model.UserDTO;
public interface AdminService {
	
	public List<UserDTO> getAllUsers(); 
	public List<UserDTO> getAllStudents(String student);
	public List<UserDTO> getAllInstructors(String instructor);
	public List<UserDTO> getAllLibrarians(String librarian);
    public UserDTO getUserById(String userId);   
    public UserDTO getUserByEmail(String email);
    public User createUser(UserDTO userdto);
    public List<User> createMultipleUsers(List<UserDTO> userdto);
    public User updateUserById(String userId, UserDTO userdto);
    public ResponseEntity<String> deleteUserById(String userId);   	   
}