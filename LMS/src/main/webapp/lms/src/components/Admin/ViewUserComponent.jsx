import React, {Component} from 'react'
import AdminService from './AdminService'
import { Card, Container} from "react-bootstrap";
import NavigationBar from "./AdminNavigationBar";
import MenuBar from '../Menu';
class ViewUserComponent extends Component{
    constructor(props){
        super(props)
        this.state={
            userId: this.props.match.params.userId,
            user: {}
        }
    }
    componentDidMount(){
        AdminService.getUserById(this.state.userId).then( res => {
            this.setState({user: res.data});
        })
    }style={
        border:'4px',
        padding:'25px',
        boxShadow: '5px  5px 15px black'
      }
    render() {
        return (
            
            <Container>
                <MenuBar/>
            <NavigationBar />
            <Card style={this.style}>
                <Card.Header as="h6">View user details</Card.Header>
                <Card.Body className="text-left">
                <Card.Text>
                 User Id: { this.state.user.userId }
                 </Card.Text>
                 <Card.Text>
                 First Name:  { this.state.user.fName }
                 </Card.Text>
                 <Card.Text>
                 Last Name:  { this.state.user.lName }
                 </Card.Text>
                 <Card.Text>
                 Email Id:   { this.state.user.email }
                 </Card.Text>
                 <Card.Text>
                 Password:   { this.state.user.password }
                 </Card.Text>
                 <Card.Text>
                 Contact Number:   { this.state.user.contactno }
                </Card.Text>
                </Card.Body>
            </Card>            
            </Container>
            
                
            /*    
            <div>                
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View User Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> User Id: </label>
                            <div> { this.state.user.userId }</div>
                        </div>
                        <div className = "row">
                            <label> First Name: </label>
                            <div> { this.state.user.fName }</div>
                        </div>
                        <div className = "row">
                            <label> Last Name: </label>
                            <div> { this.state.user.lName }</div>
                        </div>
                        <div className = "row">
                            <label> Email: </label>
                            <div> { this.state.user.email }</div>
                        </div>
                        <div className = "row">
                            <label> Password: </label>
                            <div> { this.state.user.password }</div>
                        </div>
                        <div className = "row">
                            <label> Contact No: </label>
                            <div> { this.state.user.contactno }</div>
                        </div>
                    </div>

                </div>
            </div>*/
        );
    }
}
export default ViewUserComponent