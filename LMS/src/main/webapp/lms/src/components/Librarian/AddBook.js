import { Component } from "react";
import React from 'react';
import { Card, Container,Form,Button,Row, Col} from "react-bootstrap";
import axios from 'axios';
import NavigationBar from "./LibrarianNavigationBar";
import {FiSave} from 'react-icons/fi';
import {FaUndoAlt} from 'react-icons/fa';
import {AiFillFileAdd} from 'react-icons/ai';
import MenuBar from "../Menu";
export default class AddBook extends Component
{

    constructor(props){
        super(props);
        this.state=this.initialState;
        this.addBook=this.addBook.bind(this);
        this.bookAdd=this.bookAdd.bind(this);
        this.listBooks=this.listBooks.bind(this);
    }

    initialState={bookId:'',bookName:'',authorName:'',bookDescription:'',bookCount:''}
    

    addBook(event)
    {
        event.preventDefault();
        const book={
            bookName:this.state.bookName,
            authorName:this.state.authorName,
            bookDescription:this.state.bookDescription,
            bookCount:this.state.bookCount
        };
        axios.post("http://localhost:8083/library/addnewbook",book)
            .then(response => {
                if(response.data!=null)
                {
                    this.setState(this.initialState);
                    alert("Book added!");
                }
        });
    };
    
    listBooks()
    {
        return this.props.history.push("/searchbook");
    }
    

    clearData = () => {
        this.setState(()=> this.initialState);
    }

    bookAdd(event)
    {
        this.setState({
            [event.target.name]:event.target.value
        });
    }
    style={
        border:'4px solid',
        padding:'25px',
        boxShadow: '5px 5px 15px black'
      }
    render()
    {
        return(
            <Container>
                <MenuBar/>
                <NavigationBar />
            <Card>
                <Form  style={this.style} onReset={this.clearData} onSubmit={this.state.id?this.updateBook:this.addBook} className="text-left float-left" if="newBook">
                    <Card.Header className="text-left" as="h6">Enter book details below:</Card.Header>
                    <Card.Body>
                        <Form.Row>
                        <Form.Group as={Col} controlId="formGridBookName">
                            <Form.Label>Book Title:</Form.Label>
                            <Form.Control required type="text" autoComplete="off" placeholder="Enter book name" name="bookName"
                            value={this.state.bookName} onChange={this.bookAdd}/>
                        </Form.Group>
                        <Form.Group as={Col} controlId="formGridAuthorName">
                            <Form.Label>Author Name:</Form.Label>
                            <Form.Control required type="text" autoComplete="off" placeholder="Enter author name" name="authorName" value={this.state.authorName} onChange={this.bookAdd}/>
                        </Form.Group>
                        </Form.Row>
                        <Form.Row>
                        <Form.Group as={Col} controlId="formGridDescription">
                            <Form.Label>Description:</Form.Label>
                            <Form.Control required as="textarea" autoComplete="off" rows={3} placeholder="Enter description of book" name="bookDescription" value={this.state.bookDescription} onChange={this.bookAdd}/>
                        </Form.Group>
                        </Form.Row>
                        <Form.Group as={Row} controlId="formGridBookCount">
                            <Form.Label column sm={1.5}>Available Number:</Form.Label>
                            <Col sm={3}>
                            <Form.Control required type="text" autoComplete="off" placeholder="Number of available books" name="bookCount" value={this.state.bookCount} onChange={this.bookAdd}/>
                            </Col>
                        </Form.Group>
                </Card.Body>
                <Card.Footer style={{"textAlign":"right"}}>
                    <Button size="sm" variant="success" type="submit">
                            {this.state.bookId?<AiFillFileAdd size="25px"/>:<FiSave size="25px"/>}
                        </Button>{' '}
                        <Button size="sm" variant="info" type="reset">
                            <FaUndoAlt size="25px"/>
                        </Button>{' '}
                </Card.Footer>
                </Form>
            </Card>
            </Container>
        );
    }
}