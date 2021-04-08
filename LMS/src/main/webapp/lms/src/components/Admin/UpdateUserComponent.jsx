import React, { Component } from "react";
import AdminService from './AdminService';
import { Card, Container,Form,Button, Col} from "react-bootstrap";
import NavigationBar from "./AdminNavigationBar";
import {ImCancelCircle} from "react-icons/im";
import {BiSave} from "react-icons/bi";
import MenuBar from "../Menu";
class UpdateUserComponent extends Component{
    constructor(props){
        super(props)
        this.state={
            userId:this.props.match.params.userId,
            fName:'',
            lName:'',
            email:'',
            password:'',
            contactno:''
        }
        this.changeUserIdHandler = this.changeUserIdHandler.bind(this);
        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);
        this.changeContactNumberHandler = this.changeContactNumberHandler.bind(this);        
        this.UpdateUser = this.UpdateUser.bind(this);
    }
    componentDidMount(){         
        if(this.state.userId !== '_add'){      
            AdminService.getUserById(this.state.userId).then( (res) =>{
                let user = res.data;
                this.setState({
                    userId: user.userId,
                    fName: user.fName,
                    lName: user.lName,
                    email: user.email,
                    password: user.password,
                    contactno: user.contactno
                });
            });
        }
    }
    UpdateUser = (u) => {
        u.preventDefault();
        let user = {
            userId: this.state.userId,
            fName: this.state.fName,
            lName: this.state.lName,
            email: this.state.email,
            password: this.state.password,
            contactno: this.state.contactno 
        };
        console.log('user => ' + JSON.stringify(user));
            AdminService.updateUser(user, this.state.userId).then( res => {
                this.props.history.push('/admin/getallusers');
            });
    }
    changeUserIdHandler= (event) => {
        this.setState({userId: event.target.value});
    }
    changeFirstNameHandler= (event) => {
        this.setState({fName: event.target.value});
    }

    changeLastNameHandler= (event) => {
        this.setState({lName: event.target.value});
    }

    changeEmailHandler= (event) => {
        this.setState({email: event.target.value});
    }    

    changePasswordHandler= (event) => {
        this.setState({password: event.target.value});
    }

    changeContactNumberHandler= (event) => {
        this.setState({contactno: event.target.value});
    }
    cancel(){
        this.props.history.push('/admin/getallusers');
    }
    style={
        border:'4px',
        padding:'25px',
        boxShadow: '5px  5px 15px black'
      }
    render() {
        return (
            <Container>
                <MenuBar/>
            <NavigationBar />
        <Card style={this.style}>
            
            <Form onReset={this.cancel.bind(this)} onSubmit={this.UpdateUser} className="text-left float-left">                   
                <Card.Header className="text-left" as="h6">Update user details below:</Card.Header>
                <Card.Body>
                    <Form.Row>
                    <Form.Group as={Col} controlId="formGridUserId">
                        <Form.Label>User Id:</Form.Label>
                        <Form.Control required type="text" autoComplete="off" placeholder="Enter user Id" name="userId"
                        value={this.state.userId} onChange={this.changeUserIdHandler}/>                            
                    </Form.Group>
                    <Form.Group as={Col} controlId="formGridFirstName">
                        <Form.Label>First Name:</Form.Label>
                        <Form.Control required type="text" autoComplete="off" placeholder="Enter first name" name="fName" 
                        value={this.state.fName} onChange={this.changeFirstNameHandler}/>
                    </Form.Group>                        
                    </Form.Row>

                    <Form.Row>
                    <Form.Group as={Col} controlId="formGridLastName">
                        <Form.Label>Last Name:</Form.Label>
                        <Form.Control required type="text" autoComplete="off" placeholder="Enter last name" name="lName"
                         value={this.state.lName} onChange={this.changeLastNameHandler}/>
                    </Form.Group>                        
                    <Form.Group as={Col} controlId="formGridEmail">
                        <Form.Label>Email:</Form.Label>                            
                        <Form.Control required type="text" autoComplete="off" placeholder="Enter email id" name="email"
                         value={this.state.email} onChange={this.changeEmailHandler}/>                                   
                    </Form.Group>
                    </Form.Row>

                    <Form.Row>
                    <Form.Group as={Col} controlId="formGridPassword">
                        <Form.Label>Password:</Form.Label>                            
                        <Form.Control required type="text" autoComplete="off" placeholder="Enter password" name="password"
                        value={this.state.password} onChange={this.changePasswordHandler}/>                                
                    </Form.Group>
                    <Form.Group as={Col} controlId="formGridContactNo">
                        <Form.Label>Contact Number:</Form.Label>                            
                        <Form.Control required type="text" autoComplete="off" placeholder="Enter contact number" name="contactno"
                         value={this.state.contactno} onChange={this.changeContactNumberHandler}/>                                  
                    </Form.Group>  
                    </Form.Row>
            </Card.Body>
            <Card.Footer style={{"textAlign":"right"}}>                
            <Button size="sm" variant="success" type="submit">
            <BiSave size="25px" />
                    </Button>{' '}
                    <Button size="sm" variant="danger" type="reset">
                    <ImCancelCircle size="25px" />
            </Button>
            </Card.Footer>
            </Form>
        </Card>
        </Container>
        )
    }
}
export default UpdateUserComponent