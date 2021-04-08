import React, { Component } from 'react';
import {Card, Container, Row, Col,Table} from 'react-bootstrap';
import NavigationBar from './LibrarianNavigationBar';
import axios from 'axios';
import MenuBar from '../Menu';
class CheckRequests extends Component{
    constructor(props)
    {
        super(props);
        this.state={
            books:[]
        };
    }
    componentDidMount()
    {
        axios.get("http://localhost:8083/library/checkrequests")
        .then(response=>response.data)
        .then(
            (data)=>{this.setState({books:data});}
        );
    }
    
    style={
        border:'4px solid',
        padding:'25px',
        boxShadow: '5px 5px 15px black'
      }
    render(){
        return(
            <Container>
                <MenuBar/>
            <NavigationBar />
        <Row>
            <Col lg={12}>
        <Card style={this.style}>
            <Card.Header as="h6">New Requests</Card.Header>
            <Card.Body>
            <Table striped bordered hover size="sm">
                <thead>
                    <tr>
                    <th>Id</th>
                    <th>Book Name</th>
                    <th>Author Name</th>
                    </tr>
                </thead>
                <tbody>
                {this.state.books.length===0 ?
                    <tr align="center">
                        <td colSpan="6">No new requests</td>
                    </tr> :
                    this.state.books.map((book)=>(
                        <tr key={book.id}>
                            <td>{book.id}</td>
                            <td>{book.name}</td>
                            <td>{book.authorName}</td>
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
        );
    }
}
export default CheckRequests;