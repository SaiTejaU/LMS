import React,{Component} from 'react';
import {Navbar,Nav} from 'react-bootstrap';
import {Link} from 'react-router-dom';
import {HiUserAdd} from "react-icons/hi";
import {MdFormatListBulleted} from "react-icons/md"
export default class NavigationBar extends Component{
    style={
        boxShadow: '5px  5px 15px black'
      }
    render(){
        return(
            <div>
            <Navbar style={this.style} bg="light" variant="light">
                <Link to={"/admin"} className="navbar-brand">
                    <img src="https://png.pngitem.com/pimgs/s/7-77375_computer-icons-book-clip-art-stack-of-books.png" alt="img" width="30" height="30"/>Inventory
                </Link>
                <Nav className="mr-auto">
                <Link to="/admin/getallusers" className="nav-link"><MdFormatListBulleted size="25px"/>List Users</Link>
                    <Link to="/admin/add-user/_add" className="nav-link"><HiUserAdd size="25px" /> Add user</Link>
                    </Nav>
            </Navbar>
            </div>
        );
    }
}