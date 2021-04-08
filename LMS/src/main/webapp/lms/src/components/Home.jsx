import React,{useState} from 'react';
import {Link} from 'react-router-dom';
import {Card,Tab,Carousel, Container,Tabs, Row, Col} from 'react-bootstrap';
export default function Home(){
    const style={
        border:'4px',
        padding:'25px',
        boxShadow: '5px  5px 15px black'
      }
    const [key, setKey] = useState('admin');
        return(
           
            <Container>
            <Card className="text-center">
                <Card.Header style={{fontSize: "40px",fontWeight: "bold",backgroundColor:"#E4E3E3"}}>Library Management System</Card.Header>
            </Card>
            <Tabs style={{boxShadow:'5px 5px 15px black'}} variant="tabs" activeKey={key} onSelect={(k) => setKey(k)}>
                <Tab style={{boxShadow:'5px 5px 15px black'}} eventKey="admin" title="Admin">
                <Card style={style}>
                            <Card.Body>
                            <Card.Title>Admin</Card.Title>
                            <Card.Text>
                                Admin can access details of every user. Only he has the priviliges of adding and editing user details.
                            </Card.Text>
                            <Link to="/admin" className="btn btn-primary">Log in as Admin</Link>
                            </Card.Body>
                        </Card>
                </Tab>
                <Tab style={{boxShadow:'5px 5px 15px black'}} eventKey="librarian" title="Librarian">
                <Card style={style}>
                            <Card.Body>
                            <Card.Title>Librarian</Card.Title>
                            <Card.Text>
                                Librarian can add and update books in the library. Only he can asssign penalties for students.{' '}
                            </Card.Text>
                            <Link to="/librarian" className="btn btn-primary">Log in as Librarian</Link>
                            </Card.Body>
                        </Card>
                </Tab>
                <Tab style={{boxShadow:'5px 5px 15px black'}} eventKey="instructor" title="Instructor">
                <Card style={style}>
                            <Card.Body>
                            <Card.Title>Instructor</Card.Title>
                            <Card.Text>
                                Instructor can access library. An instructor can add courses and assign some books.
                            </Card.Text>
                            <Link to="/instructor" className="btn btn-primary">Log in as Instructor</Link>
                            </Card.Body>
                        </Card>
                </Tab>
                <Tab style={{boxShadow:'5px 5px 15px black'}} eventKey="student" title="Student">
                <Card style={style}>
                            <Card.Body>
                            <Card.Title>Student</Card.Title>
                            <Card.Text>
                                Student can access library and courses. A student can check if any penalties are assigned.{' '}
                            </Card.Text>
                            <Link to="/student" className="btn btn-primary">Log in as Student</Link>
                            </Card.Body>
                        </Card>
                </Tab>
                </Tabs>
                <Row><br/></Row>
                <Col>
                <Carousel>
                    <Carousel.Item interval={1500}>
                        <img className="" style={{height: "250px",backgroundColor:"black"}} 
                        src="https://www.thesaurus.com/e/wp-content/uploads/2016/12/1000x700-love-libraries-quotes-2-790x310.jpg" 
                        alt="first-slide"></img>
                    </Carousel.Item>
                    <Carousel.Item interval={1500}>
                        <img className="" style={{height: "250px",backgroundColor:"black"}} 
                        src="https://www.thesaurus.com/e/wp-content/uploads/2016/12/1000x700-love-libraries-quotes-1-790x310.jpg" 
                        alt="second-slide"></img>
                    </Carousel.Item>
                    <Carousel.Item interval={1500}>
                        <img className="" style={{height: "250px",backgroundColor:"black"}} 
                        src="https://www.thesaurus.com/e/wp-content/uploads/2016/12/1000x700-love-libraries-quotes-6-790x310.jpg" 
                        alt="third-slide"></img>
                    </Carousel.Item>
                    <Carousel.Item interval={1500}>
                        <img className="" style={{height: "250px",backgroundColor:"black"}} 
                        src="https://www.thesaurus.com/e/wp-content/uploads/2016/12/1000x700-love-libraries-quotes-9-790x310.jpg" 
                        alt="fourth-slide"></img>
                    </Carousel.Item>
                    <Carousel.Item interval={1500}>
                        <img style={{height: "250px",backgroundColor:"black"}} className="" 
                        src="https://www.thesaurus.com/e/wp-content/uploads/2016/12/1000x700-love-libraries-quotes-11-790x310.jpg" 
                        alt="five-slide"></img>
                    </Carousel.Item>
                    </Carousel>
                    </Col>
            </Container>
        );
}
