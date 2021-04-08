import React,{Component} from 'react';
import {Card,Container,ListGroup,ListGroupItem} from 'react-bootstrap';
import NavigationBar from './Librarian/LibrarianNavigationBar';
class Dummy extends Component {
    render() { 
        return (
            <Container>
            <NavigationBar/>
            <Card className="align-center" style={{ width: '18rem' }}>
            <Card.Header as="h6">Details:</Card.Header>
                <Card.Img variant="right" src="https://upload.wikimedia.org/wikipedia/commons/7/7e/Circle-icons-profile.svg" />
                <Card.Body>
                <ListGroup className="list-group-flush">
                    <ListGroupItem>UserID:ST1001</ListGroupItem>
                    <ListGroupItem>First Name:Ram</ListGroupItem>
                    <ListGroupItem>Last Name:Kumar</ListGroupItem>
                    <ListGroupItem>Email Id:ramkumar@gmail.com</ListGroupItem>
                    <ListGroupItem>Contact Number: 9894662565</ListGroupItem>
                </ListGroup>
                </Card.Body>
            </Card>
            </Container>
         );
    }
}
 
export default Dummy;