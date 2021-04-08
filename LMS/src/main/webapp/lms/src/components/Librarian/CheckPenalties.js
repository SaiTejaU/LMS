import React, { Component } from 'react';
import {Card, Container, Row, Col,Table} from 'react-bootstrap';
import NavigationBar from './LibrarianNavigationBar';
import axios from 'axios';
import MenuBar from '../Menu';
class CheckPenalties extends Component{
    constructor(props)
    {
        super(props);
        this.state={
            defaulters:[]
        };
    }
    componentDidMount()
    {
        axios.get("http://localhost:8083/librarian/calculatepenalties")
        .then(response=>response.data)
        .then(
            (data)=>{this.setState({defaulters:data});}
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
            <Card.Header as="h6">Defaulters list</Card.Header>
            <Card.Body>
            <Table striped bordered hover size="sm">
                <thead>
                    <tr>
                    <th>BookId</th>
                    <th>UserId</th>
                    <th>Date Issued</th>
                    <th>Penalty</th>
                    </tr>
                </thead>
                <tbody>
                {this.state.defaulters.length===0 ?
                    <tr align="center">
                        <td colSpan="6">No defaulters</td>
                    </tr> :
                    this.state.defaulters.map((defaulters)=>(
                        <tr key={defaulters.bookId}>
                            <td>{defaulters.bookId}</td>
                            <td>{defaulters.userId}</td>
                            <td>{defaulters.dateIssued}</td>
                            <td>{defaulters.penalty}</td>
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
export default CheckPenalties;