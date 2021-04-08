import React,{Component} from 'react';
import {Card} from 'react-bootstrap';
class Contact extends Component {
    render() { 
        return (  
            <Card style={{ width: '18rem' }}>
                <Card.Body>
                    <Card.Title>Contact</Card.Title>
                    <Card.Subtitle className="mb-2 text-muted">Infotech University</Card.Subtitle>
                    <Card.Text>
                    Email: info@tech.ac.in
                    Phone number: +422-2348-765
                    </Card.Text>
                    <Card.Link href="#">Website</Card.Link>
                    <Card.Link href="#">Social Media</Card.Link>
                </Card.Body>
            </Card>
        );
    }
}
 
export default Contact;