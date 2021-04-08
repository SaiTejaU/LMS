import React, { Component } from 'react';
import {Carousel, Jumbotron} from 'react-bootstrap';
import MenuBar from '../Menu';
import NavigationBar from './LibrarianNavigationBar';

class Welcome extends Component{
  style={
    border:'4px solid',
    padding:'25px',
    boxShadow: '5px 5px 15px black'
  }
  render(){  
  return (
    <div>
      <MenuBar />
        <NavigationBar />
        <Jumbotron style={this.style}>
            <h1>Library Inventory Management</h1>
          <p>
            We are making your work easy.<br/>
            But, please be careful with your work, a small mistake can damage the sanity of the database!
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
    </div>
    );
  }
}
export default Welcome;

