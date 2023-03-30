import { useState } from "react";
import Navbar from "../Navbar/navbar";
import { useNavigate } from "react-router-dom";

import "./login.css";

export default function Login(){

   const [state,setState] = useState({uid:'',password:''});
  //  const[dig,setDig] = useState({dig:Number});
   const navigate = useNavigate();

   function loginFunc(event){
    const name = event.target.name;
    const value = event.target.value;

    setState((prevState) => ({
      ...prevState,
      [name]: value
    }));  
   }

  //  function checkVal(event){
  //   setDig({
  //     ...dig,dig: event.target.value
  //   });
  //   console.log(dig.length)
  //   if(dig.length<5){
  //     alert("do not exceed more than 4 characters")
  //   }

  //  }

   function handleSubmit(event){
      event.preventDefault();
      if (state.uid.trim() === "" || state.password.trim() === "") {
        alert("Please fill in both fields.");
        return;
      }
      else{
        navigate("/dashboard");
      }
      console.log("Logged in with id: " + state.uid + " and password: " + state.password);
      
   }

    return (
      <div className="login_back">    

      <Navbar/>
        <form onSubmit={handleSubmit}>
        <div className="main">
     <div className="sub-main">
       <div>
        
         <div>
           <h1>Login Page</h1>
           <div>
            
             <input type="number" placeholder="Employee Id" className="name" name="uid" min="1000" max="9999" required value={state.uid} onChange={loginFunc}/>
           </div>
           <div className="second-input">
             
             <input type="password" placeholder="Password" className="name" name="password" pattern="[A-Za-z0-9#@$&]{3,10}" required  value={state.password} onChange={loginFunc}/>
           </div>
          <div className="login-button">
          <button  type="submit" className="login">Login</button>
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
