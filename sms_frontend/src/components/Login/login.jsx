import { useState } from "react";
import Navbar from "../Navbar/navbar";
import { Link } from "react-router-dom";

import "./login.css";

export default function Login(){

   const [state,setState] = useState({uid:'',password:''});
   const[dig,setDig] = useState({dig:Number})

   function loginFunc(event){
    setState({
      [event.target.name]: event.target.value,
    });
    
   }

   function checkVal(event){
    setDig({
      ...dig,dig: event.target.value
    });
    console.log(dig.length)
    if(dig.length<5){
      alert("do not exceed more than 4 characters")
    }

   }
    return (
      <div>
      <Navbar/>
        <form>
        <div className="main">
     <div className="sub-main">
       <div>
         <div className="imgs">
           <div className="container-image">
            
           </div>


         </div>
         <div>
           <h1>Login Page</h1>
           <div>
            
             <input type="number" placeholder="Employee Id" className="name" name="empid" minlength="4" maxLength="4" required value={state.uid} onChange={loginFunc} onInput={checkVal}/>
           </div>
           <div className="second-input">
             
             <input type="password" placeholder="Password" className="name" name="password" pattern="[A-Za-z0-9#@$&]{3,10}" required  value={state.password} onChange={loginFunc}/>
           </div>
          <div className="login-button">
          <Link to="/dashboard"><button>Login</button></Link>
          </div>
           
            <p className="link1">
            <a href="/forget" className="a1">Forgot password ?</a> <br></br>
            <a href="/register" className="a2">Register</a>             
            </p>
            
           
 
         </div>
       </div>
       

     </div>
    </div>
</form>

      </div>
    );
}