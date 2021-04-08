import axios from 'axios';

const COURSE_API_BASE_URL = "http://localhost:8083/courses";

class CourseService {

   
  getNewBooks(){
      return axios.get(COURSE_API_BASE_URL + '/newbook');
  }

  createNewBook(newbook){
    return axios.post("http://localhost:8083/library/requestnewbook" , newbook);
}
 
  getCourses(){
      return axios.get(COURSE_API_BASE_URL + '/');
  }

  createCourse(course){
      return axios.post(COURSE_API_BASE_URL + '/createcourse' , course);
  }

  updateCourse(courseId, course){
      return axios.put(COURSE_API_BASE_URL + '/updatecourse/' + courseId, course);
  }
 
  getCourseById(courseId){
      return axios.get(COURSE_API_BASE_URL + '/getbyid/' + courseId);
  }

}
export default new CourseService()