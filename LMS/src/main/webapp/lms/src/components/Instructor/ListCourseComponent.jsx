//import { render } from '@testing-library/react'
import React, { Component } from 'react';
import CourseService from '../Instructor/CourseService';
import {Card,Form,Button, Container,FormControl, Row, Col,Table} from 'react-bootstrap';
import NavigationBar from "./InstructorNavigationBar";
import MenuBar from '../Menu';

class ListCourseComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            courses: []
        }
       this.addCourse = this.addCourse.bind(this);
       this.editCourse = this.editCourse.bind(this);
     }

componentDidMount(){
    CourseService.getCourses().then((res) => {
        this.setState({ courses: res.data});
    });
}

addCourse(){
    this.props.history.push('/instructor/add-course/_add');
}

editCourse(id){
    this.props.history.push(`/instructor/add-course/${id}`);
}
searchSpace=(event)=>{
    let keyword = event.target.value;
    this.setState({search:keyword})
    console.log(keyword);
}
style={
    border:'4px',
    padding:'25px',
    boxShadow: '5px  5px 15px black'
  }
render(){
    return (
        <Container>
            <MenuBar/>
        <NavigationBar />
        <Row className="jusstify-content-md-right" style={{padding:"5px"}}>
        <Col>
        <Form inline className="float-right">
                    <FormControl type="text" placeholder=" Search" className=" mr-sm-2" onChange={(e)=>this.searchSpace(e)}/>                    
                </Form> 
                </Col>
                </Row> 
                <Row><br/></Row> 
                <Row>
            <Col lg={12}>
            <Card style={this.style}>
                <Card.Header as="h6">Search results</Card.Header>
                <Card.Body>
                <Table striped bordered hover size="sm">     
                <thead>
                <tr>
                    <th>Course Id</th>
                    <th>Course Name</th>
                     <th>Text Book</th>
                     <th>Reference Book</th>
                     <th>Actions</th>
                    
                </tr>
            </thead>
            <tbody>
                {this.state.courses.length===0 ?
                        <tr align="center">
                            <td colSpan="6">0 Courses available</td>
                        </tr> :
                        // eslint-disable-next-line
                    this.state.courses.filter((data)=>{
                        if(this.state.search==null)
                            {return data}
                        else if(data.name.toLowerCase().includes(this.state.search.toLowerCase())){
                            return data
                        }
                    }).map(
                        (course) => (
                        <tr key = {course.id}>
                            <td> {course.id} </td>
                             <td> {course.name} </td>   
                             <td> {course.textBook}</td>
                             <td> {course.refBook}</td>
                             <td>
                                 <Button onClick={ () => this.editCourse(course.id)} className="btn btn-info btn-sm">Update </Button>
                             </td>
                             
                        </tr>
                    ))
                }
            </tbody>
            </Table>
            </Card.Body>
            </Card>
            </Col>
            </Row>
            </Container>
        
    )
            
}
}

export default ListCourseComponent