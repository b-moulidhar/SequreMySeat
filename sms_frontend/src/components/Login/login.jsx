import { useState } from "react";
import Header from "../header";
import "./login.css"

export default function Login(){

   const [state,setState] = useState({uid:'',password:''});

   function loginFunc(event){
    setState({
      [event.target.name]: event.target.value,
    });
   }
    return (
      <>
        <form>
        <div className="main">
     <div className="sub-main">
       <div>
         <div className="imgs">
           <div className="container-image">
             {/* <img src={profile} alt="profile" className="profile"/> */}

           </div>


         </div>
         <div>
           <h1>Login Page</h1>
           <div>
             {/* <img src={state.uid} alt="email" className="email"/> */}
             <input type="text" placeholder="Email" className="name" name="email" pattern="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$" required value={state.uid} onChange={loginFunc}/>
           </div>
           <div className="second-input">
             {/* <img src={pass} alt="pass" className="email"/> */}
             <input type="password" placeholder="Password" className="name" name="password" pattern="[A-Za-z0-9#@$&]{3,10}" required  value={state.password} onChange={loginFunc}/>
           </div>
          <div className="login-button">
          <button>Login</button>
          </div>
           
            <p className="link1">
            <a href="/forget">Forgot password ?</a> <br></br>
            <a href="/register">Register</a>             
            </p>
            
           
 
         </div>
       </div>
       

     </div>
    </div>
</form>

      </>
    );
}