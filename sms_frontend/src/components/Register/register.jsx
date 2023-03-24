import { Component } from "react";
 
class App extends Component{
    state = {
        name : "",
        emp_id : Number,
        email : "",
        managers : "",
        role:"",
        password:"",
        confpassword:"",
        pass_error: "",
        confPass_error: "",
        email_error: "",
        man_error:"",
        role_error:"",
        email_error:"",
        empid_error:"",
        name_error:""
    }
    /* 
    titleChangeHandler = (evt)=>{
        this.setState({
            password : evt.target.value
        })
    }
    nameChangeHandler = (evt)=>{
        this.setState({
            confpassword : evt.target.value
        })
    }
    powerChangeHandler = (evt)=>{
        this.setState({
            email : evt.target.value
        })
    } 
    */
    changeHandler = (evt)=>{
        this.setState({
            [evt.target.name] : evt.target.value
        })
    }
    validateForm = ()=> {
        if( this.state.password === ""){
            this.setState({
                pass_error : "password is required"
            })
        }
        if(this.state.confpassword === ""){
            this.setState({
                confPass_error : "password is required"
            })
        }
        if(this.state.email === ""){
            this.setState({
                email_error: "email is required"
            })
        }
        if(this.state.name === ""){
            this.setState({
                email_error: "name is required"
            })
        }
        if(this.state.emp_id === ""){
            this.setState({
                email_error: "employee id is required"
            })
        }
        if(this.state.role === ""){
            this.setState({
                email_error: "role is required"
            })
        }
        if(this.state.managers === ""){
            this.setState({
                email_error: "manager is required"
            })
        }
        // else if(this.state.email <5 && this.state.email >0){
        //     this.setState({
        //         email_error: "Power is less"
        //     })
        // }
        // else{
        //     this.setState({
        //         email_error: "Power is more"
        //     })
        // }
    }
    render(){
        return <div className="container">
                <h1>{ this.state.apptitle }</h1>
                <div>
                <label htmlFor="name" className="form-label">Name</label>
                    <input type="text" placeholder="name" id="name" pattern="[A-Za-z]{5,10}" name="name" value={this.state.name} onChange={(evt) => this.changeHandler(evt)} required/>
                  </div>
                <div>
                <label htmlFor="emp_id" className="form-label">Employee Id</label>
                    <input type="number" placeholder="name" id="emp_id" pattern="[0-9]{4}" name="emp_id" value={this.state.emp_id} onChange={(evt) => this.changeHandler(evt)} required/>
                  </div>
                <div className="mb-3">
                        <label htmlFor="email" className="form-label">email</label>
                        <input onInput={ (evt) => this.changeHandler(evt) } value={this.state.email} id="email" name="email" type="email" className="form-control" pattern="^[a-zA-Z0-9+_.-]+@valtech.com" required/>
                        {/* { (this.state.email  < 5 || this.state.email === 0) && <div className="form-text text-danger">{ this.state.email_error}</div> }
                        { this.state.email > 10 && <div className="form-text text-danger">{ this.state.email_error}</div> }
                        { this.state.email == 0 && <div className="form-text text-danger">{ this.state.email_error}</div> } */}
                    </div>
                <select   name="role"  value={this.state.role} onChange={(evt) => this.changeHandler(evt)} required >
                <option value="" disabled selected>Select Your Role</option>
                    <option value="Role 1">Role 1</option>
                    <option value="Role 2">Role 2</option>
                    <option value="Role 3">Role 3</option>
                    <option value="Role 4">Role 4</option> 
                  </select>
		<br></br>
                 <select   name="managers"  value={this.state.managers} onChange={(evt) => this.changeHandler(evt)} required >
                <option value="" disabled selected>Select Your Manager</option>
                    <option value="Manager 1">Manager 1</option>
                    <option value="Manager 2">Manager 2</option>
                    <option value="Manager 3">Manager 3</option>
                    <option value="Manager 4">Manager 4</option> 
                  </select>
          
                    <br></br>
                    <div className="mb-3">
                        <label htmlFor="password" className="form-label">password</label>
                        <input onInput={ (evt) => this.changeHandler(evt) } value={this.state.password} id="password" type="text" className="form-control" required/>
                        { this.state.pass_error !== "" && <div className="form-text text-danger">{ this.state.pass_error }</div> }
                    </div>
                    <div className="mb-3">
                        <label htmlFor="confpassword" className="form-label">confirm password</label>
                        <input onChange={ (evt) => this.changeHandler(evt) } value={this.state.confpassword} id="confpassword" type="text" className="form-control" required/>
                        { this.state.confPass_error !== "" && <div className="form-text text-danger">{ this.state.confPass_error }</div> }
                    </div>
                    
                    <button type="submit" onClick={ this.validateForm } className="btn btn-primary">Submit</button>
                    <ul>
                        <li>Title : { this.state.name }</li>
                        <li>Name : { this.state.emp_id }</li>
                        <li>Power : { this.state.email }</li>
                    </ul>
               </div>
    }
}

export default App;
 
 
// http://p.ip.fi/XRt_
