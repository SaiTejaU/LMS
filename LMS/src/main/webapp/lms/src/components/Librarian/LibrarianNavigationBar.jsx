import React,{Component} from 'react';
import {Navbar,Nav} from 'react-bootstrap';
import {Link} from 'react-router-dom';
import {GiBookshelf} from 'react-icons/gi';
import {VscDiffAdded} from 'react-icons/vsc';
import {IoGitPullRequestOutline} from 'react-icons/io5';
import {AiFillClockCircle} from 'react-icons/ai';
export default class NavigationBar extends Component{
    style={
        boxShadow: '5px 5px 15px black'
      }
    render(){
        return(
            <div>
            <Navbar style={this.style} bg="light" variant="light">
                <Link to={"/librarian"} className="navbar-brand">
                    <img src="https://png.pngitem.com/pimgs/s/7-77375_computer-icons-book-clip-art-stack-of-books.png" alt="img" width="30" height="30"/>Inventory
                </Link>
                <Nav className="mr-auto">
                <Link to="/librarian/searchbook" className="nav-link"><GiBookshelf size="25px"/> List Books</Link>
                    <Link to="/librarian/addbook" className="nav-link"><VscDiffAdded size="25px"/>Add Book</Link>
                    <Link to="/librarian/checkrequests" className="nav-link"><IoGitPullRequestOutline size="25px"/>Requests</Link>
                    <Link to="/librarian/checkpenalties" className="nav-link"><AiFillClockCircle size="25px"/>Defaulters</Link>
                    </Nav>
            </Navbar>
            </div>
        );
    }
}