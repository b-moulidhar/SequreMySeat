import './App.css';
import Register from './components/Register/register';
import {BrowserRouter,Routes,Route,Link} from "react-router-dom"
import Login from './components/Login/login';
import Home from './components/Home/home';
import Forget from './components/Forget/forget';
import Reset from './components/Reset/reset';
import Dashboard from './components/Dashboard/dashboard';

import Navbar from './components/Navbar/navbar';

function App() {
  return (

    <>
    <BrowserRouter>
    {/* <Link to="register"><button type="button" class="btn btn-primary btn-lg">register</button></Link> */}

    <Routes>
    <Route path="/" element={<Login/>}/>    
    <Route path="/home" element={<Home/>}/>    
    <Route path="/register" element={<Register/>}/>    
    <Route path="/forget" element={<Forget/>}/>    
    <Route path="/forget/reset" element={<Reset/>}/>    
    <Route path="/dashboard" element={<Dashboard/>}/>    
    <Route path="/navbar" element={<Navbar/>}/>    
    </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
