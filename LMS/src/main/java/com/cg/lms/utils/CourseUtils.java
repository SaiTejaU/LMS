package com.cg.lms.utils;

import java.util.ArrayList;
import java.util.List;

import com.cg.lms.entity.Courses;
import com.cg.lms.model.CoursesDTO;

public class CourseUtils {

	private CourseUtils()
	{	
	}

	public static List<CoursesDTO> convertToCoursesDtoList(List<Courses> list){
		List<CoursesDTO> coursesdtolist = new ArrayList<>();
		for(Courses course : list) 
			coursesdtolist.add(convertToCoursesDto(course));
		return coursesdtolist;
	}
	
	public static Courses convertToCourses(CoursesDTO coursesdto) {
		Courses course = new Courses();
		course.setId(coursesdto.getId());
		course.setName(coursesdto.getName());
		course.setTextBook(coursesdto.getTextBook());
		course.setRefBook(coursesdto.getRefBook());
		return course;
	}
	public static CoursesDTO convertToCoursesDto(Courses course) {
		CoursesDTO coursesdto = new CoursesDTO();
		coursesdto.setName(course.getName());
		coursesdto.setId(course.getId());
		coursesdto.setTextBook(course.getTextBook());
		coursesdto.setRefBook(course.getRefBook());
		return coursesdto;
	}
		
}
