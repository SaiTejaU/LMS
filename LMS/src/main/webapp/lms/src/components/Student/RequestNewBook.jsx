import React, { Component } from 'react'
import { Card, Container,Form,Button, Col} from "react-bootstrap";
import NavigationBar from "./StudentNavigationBar";
import {AiFillFileAdd} from 'react-icons/ai';
import axios from 'axios';
import {ImCancelCircle} from "react-icons/im";
import MenuBar from '../Menu';
class RequestNewBook extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.id,
            name: '',
            authorName: ''
        }
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeAuthorNameHandler = this.changeAuthorNameHandler.bind(this);
        this.saveorUpdateNewBook = this.saveorUpdateNewBook.bind(this);
    }
    componentDidMount(){

        if(this.state.id === '_add'){
            return 
        }
    }
    saveorUpdateNewBook = (e) => {
        e.preventDefault();
        let newbook = {name: this.state.name, authorName: this.state.authorName};
        console.log('newbook => ' + JSON.stringify(newbook));

        if(this.state.id === '_add'){
            axios.post("http://localhost:8083/library/requestnewbook" , newbook).then(res =>{
                this.props.history.push('/student/viewbooks');
            });
        }
    }
    changeNameHandler=(event) => {
        this.setState({name: event.target.value});
    }

    changeAuthorNameHandler= (event) => {
        this.setState({authorName: event.target.value});
    }

    cancel(){
        this.props.history.push('/student/viewbooks');
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
                <Form className="text-left float-left">                
                    <Card.Header className="text-left" as="h6">Enter new book details below:</Card.Header>
                    <Card.Body>
                        <Form.Row>
                        <Form.Group as={Col} controlId="formGridBookName">
                            <Form.Label>Book Name:</Form.Label>
                            <Form.Control required type="text" autoComplete="off" placeholder="Enter book name" name="name"
                             value={this.state.name} onChange={this.changeNameHandler}/>                           
                        </Form.Group>
                        <Form.Group as={Col} controlId="formGridAuthorName">
                            <Form.Label>Author Name:</Form.Label>
                            <Form.Control required type="text" autoComplete="off" placeholder="Enter author name" name="" 
                            value={this.state.authorName} onChange={this.changeAuthorNameHandler}/>
                        </Form.Group>                        
                        </Form.Row>                        
                </Card.Body>
                <Card.Footer style={{"textAlign":"right"}}>
                <Button className="btn btn-success btn-sm" onClick={this.saveorUpdateNewBook}><AiFillFileAdd size="25px" /></Button>
                <Button className="btn btn-danger btn-sm" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}><ImCancelCircle size="25px" /></Button>                
                </Card.Footer>
                </Form>
            </Card>
            </Container>
         );
    }
}
 
export default RequestNewBook;