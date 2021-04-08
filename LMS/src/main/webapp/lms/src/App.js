import './App.css';
import {Provider} from 'react-redux';
import Store from './services/Store';
import { Container,Row,Col} from 'react-bootstrap';
import Home from './components/Home';
import StudentWelcome from './components/Student/StudentWelcome';
import LibrarianWelcome from './components/Librarian/LibrarianWelcome';
import CheckPenalties from './components/Librarian/CheckPenalties';
import AddBook from './components/Librarian/AddBook';
import SearchBook from './components/Librarian/SearchBook';
import ViewBooks from './components/Student/ViewBooks';
import Dummy from './components/Dummy';
import InstructorIssueBook from './components/Instructor/IssueBook';
import AdminWelcome from './components/Admin/AdminWelcome';
import IssueBook from './components/Student/IssueBook';
import UpdateBook from './components/Librarian/UpdateBook';
import InstructorWelcome from './components/Instructor/InstructorWelcome';
import {BrowserRouter as Router,Route,Switch} from 'react-router-dom';
import CheckRequests from './components/Librarian/CheckRequests';
import InstructoViewBooks from './components/Instructor/ViewBooks';
import ListCourseComponent from './components/Instructor/ListCourseComponent';
import CreateCourseComponent from './components/Instructor/createCourseComponent';
import CreateNewBookComponent from './components/Instructor/createNewBookComponent';
import CreateUser from './components/Admin/CreateUserComponent';
import ListUsers from './components/Admin/ListUsersComponent';
import UpdateUsers from './components/Admin/UpdateUserComponent';
import ViewUser from './components/Admin/ViewUserComponent';
import Contact from './components/Contact';
import RequestNewBookComponent from './components/Student/RequestNewBook';
function App() {
  const marginTop={marginTop:"20px"};
  return (
    <Router>
      <Container>
        <Row>
          <Col lg={12} style={marginTop} className="text-center">
            <Switch>
              <Route path="/" exact component={Home}/>
              <Route path="/admin" exact component={AdminWelcome}/>
              <Route path="/admin/add-user/:id" exact component={CreateUser}/>
              <Route path="/admin/getallusers" exact component={ListUsers}/>
              <Route path="/admin/view-user/:id" exact component={ViewUser}/>
              <Route path="/admin/update-user/:id" exact component={UpdateUsers}/>
              <Route path="/librarian" exact component={LibrarianWelcome}/>
              <Route path="/student" exact component={StudentWelcome}/>
              <Route path="/student/viewbooks" exact component={()=>
              <Provider store={Store}><ViewBooks/></Provider>}/>
              <Route path="/student/issuebook/:bookId" exact component={IssueBook}/>
              <Route path="/instructor/issuebook/:bookId" exact component={InstructorIssueBook}/>
              <Route path="/librarian/addbook" exact component={AddBook}/>
              <Route path="/librarian/checkrequests" exact component={CheckRequests}/>
              <Route path="/librarian/updatebook/:bookId" exact component={UpdateBook}/>
              <Route path="/librarian/searchbook" exact component={()=>
              <Provider store={Store}><SearchBook/></Provider>}/>
              <Route path="/librarian/checkpenalties" exact component={CheckPenalties}/>
              <Route path="/instructor" exact component={InstructorWelcome}/>
              <Route path="/instructor/viewbooks" exact component={InstructoViewBooks}/>
              <Route path="/instructor/courses/" exact component={ListCourseComponent}/>
              <Route path="/instructor/add-course/:id" exact component={CreateCourseComponent}/>
              <Route path="/student/requestnewbook/:id" exact component={RequestNewBookComponent}/>
              <Route path="/instructor/add-newbook/:id" exact component={CreateNewBookComponent}/>
              <Route path="/dummy" exact component={Dummy}/>
              <Route path="/contact" exact component={Contact}/>
            </Switch>
            </Col>
        </Row>
      </Container>
    </Router>  
  );
}

export default App;
