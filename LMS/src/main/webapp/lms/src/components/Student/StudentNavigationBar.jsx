import React,{Component} from 'react';
import {Navbar,Nav} from 'react-bootstrap';
import {Link} from 'react-router-dom';
import {ImBooks} from "react-icons/im";
import {BiGitPullRequest} from "react-icons/bi";
export default class NavigationBar extends Component{
    style={
        boxShadow: '5px  5px 15px black'
      }
    render(){
        return(
            <div>
            <Navbar style={this.style} bg="light" variant="light">
            <Link to={"/student"} className="navbar-brand">
                <img src="https://png.pngitem.com/pimgs/s/7-77375_computer-icons-book-clip-art-stack-of-books.png" alt="img" width="30" height="30"/>Inventory
            </Link>
            <Nav className="mr-auto">
                <Link to="/student/viewbooks" className="nav-link"><ImBooks size="25px"/>View Books</Link>
                <Link to="/student/requestnewbook/_add" className="nav-link"><BiGitPullRequest size="25px"/>Request New Book</Link>
            </Nav>
        </Navbar>
        </div>
        );
    }
}