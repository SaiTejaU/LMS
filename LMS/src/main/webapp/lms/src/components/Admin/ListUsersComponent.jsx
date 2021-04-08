import React, {Component} from 'react'
import AdminService from './AdminService'
import {Card,Form,Button, Container,FormControl, Row, Col,Table} from 'react-bootstrap';
import NavigationBar from "./AdminNavigationBar";
import {FaEdit} from "react-icons/fa";
import {GrView} from "react-icons/gr";
import {MdDelete} from "react-icons/md"
import MenuBar from '../Menu';
class ListUsersComponent extends Component{
    constructor(props){
        super(props)
        this.state={           
            users:[],
            search:null,
            searchtype:'userId',
            usertype:'All'
        }
        this.addUser=this.addUser.bind(this);    
        this.updateUser=this.updateUser.bind(this);   
        this.deleteUser=this.deleteUser.bind(this);      
    }    
    componentDidMount(){
        AdminService.getAllUsers().then((res) => {
            this.setState({ users: res.data});
        });
    }
    deleteUser(userId){
        AdminService.deleteUser(userId).then(res => {
            this.setState({users: this.state.users.filter(user => user.userId !== userId)});
        });
    }
    viewUser(userId){
        this.props.history.push(`/admin/view-user/${userId}`)
    }
    updateUser(userId){
        this.props.history.push(`/admin/update-user/${userId}`)
    }
    addUser(){
        this.props.history.push(`/admin/add-user/_add`);
    }
    searchSpace=(event)=>{
        let keyword = event.target.value;
        this.setState({search:keyword})        
    }
    handleChange=(event)=>{
        let val=event.target.value;
        this.setState({searchtype:val})        
    }
    handleUserChange=(event)=>{
        let res=event.target.value;
        this.setState({usertype:res})
        if(res === "ST")
        {
            AdminService.getAllStudents(this.state.usertype).then((res) =>{
                this.setState({ users: res.data});
                            
            });
        }
        else if(res === "IS")
        {
            AdminService.getAllInstructors(this.state.usertype).then((res) =>{
                this.setState({ users: res.data});
                            
            });
        }
        else if(res === "LB")
        {
            AdminService.getAllLibrarians(this.state.usertype).then((res) =>{
                this.setState({ users: res.data});
                            
            });
        }
        else
        {
            AdminService.getAllUsers().then((res) => {
                this.setState({ users: res.data});
            });
        }
    }
    style={
        border:'4px',
        padding:'25px',
        boxShadow: '5px  5px 15px black'
      }
    render(){
        return(
            
            <Container>
                <MenuBar/>
                <NavigationBar />
            <Row className="jusstify-content-md-right" style={{padding:"5px"}}>
                <Col>
            <Form inline className="float-left">
               <select className="form-control" value={this.state.usertype} onChange={(e)=>this.handleUserChange(e)}>  
                        <option value="All">All</option>                                                                   
                        <option value="ST">Student</option>
                        <option value="IS">Instructor</option>
                        <option value="LB">Librarian</option>
                    </select> 
            </Form>
            <Form inline className="float-right">
                    <FormControl type="text" placeholder=" Search" className=" mr-sm-2" onChange={(e)=>this.searchSpace(e)}/>                    
                    
                    <select className="form-control" value={this.state.searchtype} onChange={(e)=>this.handleChange(e)}>                                                                     
                        <option value="userId">User Id</option>
                        <option value="fName">First Name</option>
                        <option value="email">Email</option>
                    </select>   
            </Form>
            </Col>
            </Row>
            <Row><br/></Row>
            <Row>
                <Col lg={12}>
            <Card style={this.style}>
                <Card.Header as="h6">Users List</Card.Header>
                <Card.Body>
                <Table striped bordered hover size="sm">
                    <thead>
                                <tr>
                                    <th> User Id</th>
                                    <th> First Name</th>
                                    <th> Email Id</th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                    <tbody>
                    {
                                    // eslint-disable-next-line
                                    this.state.users.filter((data)=>{                                        
                                        if(this.state.search == null)                    
                                        return data
                                        else if(this.state.searchtype === "userId" && data.userId.toLowerCase().includes(this.state.search.toLowerCase()))
                                        {                                    
                                            return data                            
                                        }
                                        else if(this.state.searchtype === "fName" && data.fName.toLowerCase().includes(this.state.search.toLowerCase()))
                                        {                                    
                                            return data                            
                                        }
                                        else if(this.state.searchtype === "email" && data.email.toLowerCase().includes(this.state.search.toLowerCase()))
                                        {                                    
                                            return data                            
                                        }
                                    }).map(
                                        user => 
                                        <tr key = {user.userId}>
                                             <td> {user.userId} </td> 
                                             <td> {user.fName} </td>   
                                             <td> {user.email}</td>
                                             <td>
                                                 <Button onClick={ () => this.updateUser(user.userId,user)} className="btn btn-info btn-sm"><FaEdit size="25px"/> </Button>
                                                 <Button style={{marginLeft: "10px"}} onClick={ () => this.deleteUser(user.userId)} className="btn btn-danger btn-sm"><MdDelete size="25px" /> </Button>
                                                 <Button style={{marginLeft: "10px"}} onClick={ () => this.viewUser(user.userId)} className="btn btn-success btn-sm"><GrView size="25"/> </Button>
                                             </td>
                                        </tr>
                                    )
                                }                    
                    </tbody>
                    </Table>
                </Card.Body>
            </Card>
            </Col>
            </Row>
            
            </Container>
        )
    }
}
export default ListUsersComponent