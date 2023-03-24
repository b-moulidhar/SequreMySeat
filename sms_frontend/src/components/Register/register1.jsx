import React, { useReducer } from "react";
import "./register.css"
import {Link} from 'react-router-dom';
import { BrowserRouter as Router, Route,Routes } from "react-router-dom";
// import { Alert, Form } from "react-bootstrap";
import { useHistory } from "react-router-dom";
// import { Dropdown,DropdownButton } from "react-bootstrap";


// import axios from "axios";
class Registration extends React.Component{

    constructor(props){
        super(props);
        this.state= this.initiaLSTATE;
    }

    initiaLSTATE={
        emp_id:Number,
        name:"",
        email:"",
        username:"",
        password:"",
        confirmpassword:"",
        pnumber:"",
        role:"",
        managers:"",
        pswd_error:""
    };
      
    handlesubmit= (event) => {
      event.preventDefault()

        const user ={
            email:this.state.email,
            password:this.state.password,
            confirmpassword:this.state.confirmpassword,
    
        }
        const confirmpassword= this.state.confirmpassword;
        const password = this.state.password;
 
         if(confirmpassword===password) {
               alert("registered successfully") ;

         }
         else{
            this.initiaLSTATE.pswd_error = "Password and ConfirmPassword are not same"
            alert("Password and ConfirmPassword are not same");
           
         }

    }
    bookChange = (event) => {
        this.setState({
          [event.target.name]: event.target.value,
        });
      }; 
    render(){

        return(
  
<div>
    
        <form onSubmit={this.handlesubmit} >
            <div className="main">
            <div className="main1" >
              <div>
                <div>
                  <h1>Registration of Employee</h1>
                  <div>
                    
                    <input type="text" placeholder="name" className="name" pattern="[A-Za-z]{5,10}" name="name" value={this.state.name} onChange={this.bookChange} required/>
                  </div>
                  <div className="second-input">
                  
                    <input type="email" placeholder="Email" className="name" pattern="^[a-zA-Z0-9+_.-]+@valtech.com" value={this.state.email}  name="email" onChange={this.bookChange} required/>
                  </div>
                  
                  <div className="second-input">
                  
                    <input type="password" placeholder="Password" className="name" name="password" pattern="[A-Za-z0-9#@$&]{3,10}"  value={this.state.password} onChange={this.bookChange} required/>
                    <br /><span className="text text-danger">{this.initiaLSTATE.pswd_error}</span>
                  </div>
                  <div className="second-input">
                  
                    <input type="password" placeholder=" Confirm Password" className="name" name="confirmpassword" pattern="[A-Za-z0-9#@$&]{8,12}" value={this.state.confirmpassword} onChange={this.bookChange}  required/>
                    <br /><span>*password should be 8-12 characters</span>
                  </div>
                 
                  <div className="second-input">
                  
                    <input type="text" placeholder="Phone number" className="name"  name="pnumber" pattern="(0/91)?[6-9][0-9]{9}" value={this.state.pnumber}  onChange={this.bookChange} required/>
                  </div>
                  
                  <br></br>
                  <select   name="role"  value={this.state.role} onChange={this.bookChange} required >
                    <option value="">Select Your Role</option>
                    <option value="Role 1">Role 1</option>
                    <option value="Role 2">Role 2</option>
                    <option value="Role 3">Role 3</option>
                    <option value="Role 4">Role 4</option> 
                  </select>
		<br></br>
        <br />
                <select   name="managers"  value={this.state.managers} onChange={this.bookChange} required >
                    <option value="">Select Your Manager</option>
                    <option value="Manager 1">Manager 1</option>
                    <option value="Manager 2">Manager 2</option>
                    <option value="Manager 3">Manager 3</option>
                    <option value="Manager 4">Manager 4</option> 
                  </select>
                    <br></br>
                    <br></br>
                    
                     {/* {
                 this.state.hospitals.map((hospital) => (
                      
                     <option key={hospital.hospitalId}  value ={hospital.hospitalId}>{hospital.name}</option>
                    
                     ) )
                    }    */}    

                
                 
                 <div className="login-button">
                 <button>submit</button><br></br>
                 {/* <a className="btn btn-primary" href="/">submit</a><br></br> */}
                 <br></br>
                 {/* <button ><Link to={"/"}>Login Page</Link></button> */}
                 </div>
                </div>
              </div>
             
       
            </div>
           </div> 
           </form>

           </div>


           
        );
    }
}

export default Registration;