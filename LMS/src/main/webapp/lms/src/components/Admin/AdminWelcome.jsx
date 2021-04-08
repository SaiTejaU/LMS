import React, { Component } from 'react';
import {Container,Carousel, Jumbotron} from 'react-bootstrap';
import NavigationBar from './AdminNavigationBar';
import MenuBar from '../Menu';
class Welcome extends Component{
  style={
    boxShadow: '5px  5px 15px black'
  }
  render(){  
  return (
    <Container >
      <MenuBar />
        <NavigationBar />
        <Jumbotron style={this.style}>
            <h1>User Profile Management</h1>
          <p>
          It is no use saying “we are doing our best.” 
          You have to succeed in doing what is necessary.”
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

