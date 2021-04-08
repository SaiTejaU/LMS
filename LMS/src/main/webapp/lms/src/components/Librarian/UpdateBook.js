import { Card, Container,Form,Button,Row, Col} from "react-bootstrap";
import axios from 'axios';
import NavigationBar from "./LibrarianNavigationBar";
import React,{Component} from 'react';

import {FiSave} from 'react-icons/fi';
import {AiFillFileAdd} from 'react-icons/ai';
import {ImCancelCircle} from 'react-icons/im';
import MenuBar from "../Menu";
class UpdateBook extends Component {
    constructor(props) {
        super(props);
        this.state = {bookId:this.props.match.params.bookId,bookName:'',authorName:'',bookDescription:'',bookCount:''}
        this.valueChange=this.valueChange.bind(this);
    }
    componentDidMount()
    {
        const id=+this.props.match.params.bookId;
        if(id)
        {
            axios.get("http://localhost:8083/library/getbyid/"+id)
            .then(response=>{
                if(response.data!=null)
                {
                    this.setState(
                        {
                            bookId:response.data.bookId,
                            bookName:response.data.bookName,
                            authorName:response.data.authorName,
                            bookDescription:response.data.bookDescription,
                            bookCount:response.data.bookCount
                        });
                }
            });
        }
    };
    updateBook=event=>{
        event.preventDefault();
        const book={
            bookId:this.state.bookId,
            bookName:this.state.bookName,
            authorName:this.state.authorName,
            bookDescription:this.state.bookDescription,
            bookCount:this.state.bookCount
        };
        console.log("updating");
        axios.put("http://localhost:8083/library/updatebook/",book)
            .then(response => {
                if(response.data!=null)
                {
                    this.props.history.push('/librarian/searchbook');
                    console.log("updated");
                }
        });
    };
    valueChange(event)
    {
        this.setState({
            [event.target.name]:event.target.value
        });
    };
    cancel(){
        this.props.history.push('/librarian/searchbook');
    }
    style={
        border:'4px solid',
        padding:'25px',
        boxShadow: '5px 5px 15px black'
      }
    render() { 
        return ( 
            <Container style={this.style}>
                <MenuBar/>
                <NavigationBar />
            <Card>
                <Form onReset={this.cancel.bind(this)} onSubmit={this.updateBook} className="text-left float-left" if="newBook">
                    <Card.Header className="text-left" as="h6">Enter book details below:</Card.Header>
                    <Card.Body>
                        <Form.Row>
                        <Form.Group as={Col} controlId="formGridBookName">
                            <Form.Label>Book Title:</Form.Label>
                            <Form.Control required type="text" autoComplete="off" placeholder="Enter book name" name="bookName"
                            value={this.state.bookName} onChange={this.valueChange}/>
                        </Form.Group>
                        <Form.Group as={Col} controlId="formGridAuthorName">
                            <Form.Label>Author Name:</Form.Label>
                            <Form.Control required type="text" autoComplete="off" placeholder="Enter author name" name="authorName" value={this.state.authorName} onChange={this.valueChange}/>
                        </Form.Group>
                        </Form.Row>
                        <Form.Row>
                        <Form.Group as={Col} controlId="formGridDescription">
                            <Form.Label>Description:</Form.Label>
                            <Form.Control required as="textarea" autoComplete="off" rows={3} placeholder="Enter description of book" name="bookDescription" value={this.state.bookDescription} onChange={this.valueChange}/>
                        </Form.Group>
                        </Form.Row>
                        <Form.Group as={Row} controlId="formGridBookCount">
                            <Form.Label column sm={1.5}>Available Number:</Form.Label>
                            <Col sm={3}>
                            <Form.Control required type="text" autoComplete="off" placeholder="Number of available books" name="bookCount" value={this.state.bookCount} onChange={this.valueChange}/>
                            </Col>
                        </Form.Group>
                </Card.Body>
                <Card.Footer style={{"textAlign":"right"}}>
                <Button size="sm" variant="success" type="submit">
                            {this.state.bookId?<AiFillFileAdd size="25px"/>:<FiSave size="25px"/>}
                        </Button>{' '}
                        <Button size="sm" variant="danger" type="reset">
                        <ImCancelCircle size="25px"/>
                        </Button>
                </Card.Footer>
                </Form>
            </Card>
            </Container>
         );
    }
}
 
export default UpdateBook;