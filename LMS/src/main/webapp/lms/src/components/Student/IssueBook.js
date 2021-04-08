import React, { Component } from 'react';
import {Card, Container, Row, Col,Table} from 'react-bootstrap';
import NavigationBar from './StudentNavigationBar';
import axios from 'axios';
import MenuBar from '../Menu';
class IssueBook extends Component{
    constructor(props){
        super(props);
        this.state={
            books:[]
        };
    };
    componentDidMount()
    {
        const id=+this.props.match.params.bookId;
        axios.get("http://localhost:8083/library/getbookissued/"+id)
        .then(response=>{
            if(response.data!=null){
                axios.get("http://localhost:8083/librarian/getissuedbooks")
                .then(response=>{
                    this.setState({books:response.data});
                });
            }
        });
    };
    style={
        border:'4px',
        padding:'25px',
        boxShadow: '5px  5px 15px black'
      }
    render(){
        return(<Container>
            <MenuBar/>
            <NavigationBar />
        <Row>
            <Col lg={12}>
        <Card style={this.style}>
            <Card.Header as="h6">Issued Books</Card.Header>
            <Card.Body>
            <Table striped bordered hover size="sm">
                <thead>
                    <tr>
                    <th>Date of Issue</th>
                    <th>Book Name</th>
                    <th>Penalty</th>
                    </tr>
                </thead>
                <tbody>
                {this.state.books.length===0 ?
                    <tr align="center">
                        <td colSpan="6">No issued books</td>
                    </tr> :
                    this.state.books.map((book)=>(
                        <tr key={book.bookId}>
                            <td>{book.dateIssued}</td>
                            <td>{book.bookName}</td>
                            <td>{book.penalty}</td>
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
export default IssueBook;