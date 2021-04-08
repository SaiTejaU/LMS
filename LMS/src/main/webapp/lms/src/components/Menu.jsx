import React,{Component} from 'react';
import { slide as Menu } from 'react-burger-menu';
import './MenuStyle.css';
import { Link } from 'react-router-dom';
import {RiLogoutCircleLine} from 'react-icons/ri';
import {CgProfile} from 'react-icons/cg';
import {GrContactInfo} from 'react-icons/gr';
class MenuBar extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }
    render() { 
        return ( 
            <Menu className="bm-menu">
                <Link to="/dummy" className="btn btn-light"><CgProfile/>Profile</Link><br/>
                <Link to="/contact" className="btn btn-light"><GrContactInfo/>Contact</Link><br/>
                <Link to="/" className="btn btn-light"><RiLogoutCircleLine/>Logout</Link>
            </Menu>
         );
    }
}
 
export default MenuBar;