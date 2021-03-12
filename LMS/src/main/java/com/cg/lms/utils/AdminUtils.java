package com.cg.lms.utils;

import com.cg.lms.entity.User;
import com.cg.lms.model.UserDTO;
import java.util.*;

public class AdminUtils {
		
		private AdminUtils() {}	
	
		public static List<UserDTO> convertToUserDtoList(List<User> list){
			List<UserDTO> dtolist = new ArrayList<>();
			for(User user : list) 
				dtolist.add(convertToUserDto(user));
			return dtolist;
		}
		public static List<User> convertToUserList(List<UserDTO> dtolist){
			List<User> list = new ArrayList<>();
			for(UserDTO user : dtolist) 
				list.add(convertToUser(user));
			return list;
		}
		public static User convertToUser(UserDTO userdto) {
			User u=new User();
			u.setUserId(userdto.getUserId());
			u.setfName(userdto.getfName());
            u.setlName(userdto.getlName());
            u.setContactno(userdto.getContactno());
            u.setEmail(userdto.getEmail());
            u.setPassword(userdto.getPassword());
			return u;
		}		
			
		public static UserDTO convertToUserDto(User u) {
			UserDTO userdto=new UserDTO();
			userdto.setUserId(u.getUserId());
			userdto.setfName(u.getfName());
           	userdto.setlName(u.getlName());
           	userdto.setContactno(u.getContactno());
           	userdto.setEmail(u.getEmail());
           	userdto.setPassword(u.getPassword());
			return userdto;
		}
			

}