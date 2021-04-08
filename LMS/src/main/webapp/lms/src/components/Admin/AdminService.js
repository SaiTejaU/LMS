import axios from 'axios';
const USER_API_BASE_URL = "http://localhost:8083/user";
class AdminService{
    getAllUsers(){
        return axios.get(USER_API_BASE_URL+"/getAllUsers");
    }

    getAllStudents(){
        return axios.get(USER_API_BASE_URL+"/getAllStudents");
    }
    getAllInstructors(){
        return axios.get(USER_API_BASE_URL+"/getAllInstructors");
    }
    getAllLibrarians(){
        return axios.get(USER_API_BASE_URL+"/getAllLibrarians");
    }

    getUserById(userId){
        return axios.get(USER_API_BASE_URL + "/getUserById/" + userId);
    }
    createUser(user){
        return axios.post(USER_API_BASE_URL+"/createUser/", user);
    }
    updateUser(user, userId){
        return axios.put(USER_API_BASE_URL + "/updateUser/" + userId, user);
    }

    deleteUser(userId){
        return axios.delete(USER_API_BASE_URL + "/deleteUserById/" + userId);
    }
}

export default new AdminService()