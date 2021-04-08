import React, { Component } from 'react';
import {Container,Carousel, Jumbotron} from 'react-bootstrap';
import MenuBar from '../Menu';
import Navigationbar from './InstructorNavigationBar';

class Welcome extends Component {
    style={
        border:'4px',
        padding:'25px',
        boxShadow: '5px  5px 15px black'
      }
    render(){
        return (
            <Container>
                <MenuBar/>
                <Navigationbar />
                <Jumbotron style={this.style}>
                    <h1>Library Course Management</h1>
                    <p>
                    In learning you will teach, and in teaching you will learn.
                    </p>
                </Jumbotron>
                <br/>
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
            </Container>
        );
    }
}
export default Welcome;