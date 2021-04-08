import React,{Component} from 'react';
import {Navbar, Nav} from 'react-bootstrap';
import {Link} from 'react-router-dom';
import {MdFormatListBulleted} from "react-icons/md";
import {ImBooks} from "react-icons/im";
import {BiGitPullRequest} from "react-icons/bi";
import {IoMdAdd} from "react-icons/io";
export default class Navigationbar extends Component{
    style={
        boxShadow: '5px  5px 15px black'
      }
    render(){
        return(
            <div>
            <Navbar style={this.style} bg="light" variant="light">
                <Link to={"/instructor"} className="navbar-brand">
                    <img src="https://png.pngitem.com/pimgs/s/7-77375_computer-icons-book-clip-art-stack-of-books.png" alt="img" width="30" height="30"/>Inventory
                </Link>
                <Nav className="mr-auto">
                    <Link to="/instructor/viewbooks" className="nav-link"><ImBooks size="25px"/>View Books</Link>
                    <Link to="/instructor/courses/" className="nav-link"><MdFormatListBulleted size="25px"/>List Courses</Link>
                    <Link to="/instructor/add-course/_add" className="nav-link"><IoMdAdd size="25px"/>Add Course</Link>
                    <Link to="/instructor/add-newbook/_add" className="nav-link"><BiGitPullRequest size="25px"/>Request Book</Link>
                </Nav>
            </Navbar>
            </div>
        );
    }
}
