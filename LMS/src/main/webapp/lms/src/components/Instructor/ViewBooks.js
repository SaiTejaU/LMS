import { Component } from "react";
import React from 'react';
import {Card,Form,FormControl, Container, Row, Col,Table} from 'react-bootstrap';
import {Link} from 'react-router-dom';
import axios from 'axios';
import NavigationBar from "./InstructorNavigationBar";
import MenuBar from "../Menu";
class ViewBooks extends Component
{
    constructor(props)
    {
        super(props);
        this.state={
            books:[]
        };
    }
    componentDidMount()
    {
        axios.get("http://localhost:8083/library/getallbooks")
        .then(response=>response.data)
        .then(
            (data)=>{this.setState({books:data});}
        );
    }
    searchSpace=(event)=>{
        let keyword = event.target.value;
        this.setState({search:keyword})        
    }
    style={
        border:'4px',
        padding:'25px',
        boxShadow: '5px  5px 15px black'
      }
    render()
    {
        return(
            <Container>
                <MenuBar/>
                <NavigationBar />
            <Row className="jusstify-content-md-right" style={{padding:"5px"}}>
                <Col>
            <Form inline className="float-right">
                <FormControl type="text" placeholder="Search" className=" mr-sm-2" onChange={(e)=>this.searchSpace(e)}/>
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
                        <th>Book Name</th>
                        <th>Author Name</th>
                        <th>Description</th>
                        <th>Available Number</th>
                        <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    {this.state.books.length===0 ?
                        <tr align="center">
                            <td colSpan="6">0 Books available</td>
                        </tr> :
                        // eslint-disable-next-line
                        this.state.books.filter((book)=>{                                        
                            if(this.state.search == null)                    
                                {return book}
                            else if(book.bookName.toLowerCase().includes(this.state.search.toLowerCase()))
                            {                                    
                                return book   
                            }                        
                            }).map((book)=>(
                            <tr key={book.bookId}>
                                <td>{book.bookName}</td>
                                <td>{book.authorName}</td>
                                <td>{book.bookDescription}</td>
                                <td>{book.bookCount}</td>
                                <td><Link to={"/student/issuebook/"+book.bookId}>Get issued</Link></td>
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
export default ViewBooks;