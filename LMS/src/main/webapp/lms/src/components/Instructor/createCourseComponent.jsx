import React, { Component } from 'react'
import CourseService from './CourseService';
import { Card, Container,Form,Button, Col} from "react-bootstrap";
import NavigationBar from "./InstructorNavigationBar";
import {AiFillFileAdd} from 'react-icons/ai';
import {ImCancelCircle} from "react-icons/im";
import MenuBar from '../Menu';
class CreateCourseComponent extends Component {
       
    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.id,
            courseid:'',
            name: '',
            textBook: '',
            refBook: ''
        }
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeTextBookHandler = this.changeTextBookHandler.bind(this);
        this.changeRefBookhandler = this.changeRefBookhandler.bind(this);
        this.saveOrUpdateCourse = this.saveOrUpdateCourse.bind(this);
        this.changeCourseIdHandler = this.changeCourseIdHandler.bind(this);
    }

    componentDidMount(){

        if(this.state.id === '_add'){
            return
        }else{
            CourseService.getCourseById(this.state.id).then( (res) =>{
                let course = res.data;
                this.setState({ courseid: course.id,
                    name: course.name,
                    textBook: course.textBook,
                    refBook: course.refBook
                });
            });
        }
    }
    
    saveOrUpdateCourse = (e) => {
        e.preventDefault();
        let course = {id: this.state.courseid, name: this.state.name, textBook: this.state.textBook, refBook: this.state.refBook};
        console.log('course => ' + JSON.stringify(course));

        if(this.state.id === '_add'){
            CourseService.createCourse(course).then(res =>{
                this.props.history.push('/instructor/courses');
            });
        }else{
            CourseService.updateCourse(this.state.courseid, course).then( res => {
                this.props.history.push('/instructor/courses');
            })
        }
    }

    changeNameHandler= (event) => {
        this.setState({name: event.target.value});
    }

    changeCourseIdHandler= (event) => {
        this.setState({courseid: event.target.value});
    }

    changeTextBookHandler= (event) => {
        this.setState({textBook: event.target.value});
    }

    changeRefBookhandler= (event) => {
        this.setState({refBook: event.target.value});
    }

    cancel(){
        this.props.history.push('/instructor/courses');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return "Enter course details below:"
        }else{
            return "Update course details below:"
        }
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
            <Card style={this.style}>                
                <Form className="text-left float-left">                
                    <Card.Header className="text-left" as="h6">
                    {
                        this.getTitle()
                    }
                    </Card.Header>
                    <Card.Body>
                        <Form.Row>
                        <Form.Group as={Col} controlId="formGridCourseId">
                            <Form.Label>Course Id:</Form.Label>
                            <Form.Control required type="text" autoComplete="off" placeholder="Enter course Id" name="courseid"
                            value={this.state.courseid} onChange={this.changeCourseIdHandler}/>                            
                        </Form.Group>                        
                        <Form.Group as={Col} controlId="formGridCourseName">
                            <Form.Label>Course Name:</Form.Label>
                            <Form.Control required type="text" autoComplete="off" placeholder="Enter course name" name="name" 
                             value={this.state.name} onChange={this.changeNameHandler}/>
                        </Form.Group>                        
                        </Form.Row>

                        <Form.Row>
                        <Form.Group as={Col} controlId="formGridTextBook">
                            <Form.Label>Text Book Name:</Form.Label>
                            <Form.Control required type="text" autoComplete="off" placeholder="Enter text book name" name="textbook"
                             value={this.state.textBook} onChange={this.changeTextBookHandler}/>
                        </Form.Group>                        
                        <Form.Group as={Col} controlId="formGridRefBook">
                            <Form.Label>Reference Book Name:</Form.Label>                            
                            <Form.Control required type="text" autoComplete="off" placeholder="Enter reference book name" name="refBook"
                             value={this.state.refBook} onChange={this.changeRefBookhandler}/>                                   
                        </Form.Group>
                        </Form.Row>
                </Card.Body>
                <Card.Footer style={{"textAlign":"right"}}>
                <Button className="btn btn-success btn-sm" onClick={this.saveOrUpdateCourse}><AiFillFileAdd size="25px" /></Button>
                <Button className="btn btn-danger btn-sm" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}><ImCancelCircle size="25px" /></Button>                
                </Card.Footer>
                </Form>
            </Card>
            </Container>
            
        )
    }

}

export default CreateCourseComponent