import './App.css';
import Register from './components/Register/register';
import {BrowserRouter,Routes,Route,Link} from "react-router-dom"
import Login from './components/Login/login';
import Home from './components/home';
import Forget from './components/Forget/forget';
import Reset from './components/Reset/reset';
import Registration from './components/Register/register1';

function App() {
  return (

    <>
    <BrowserRouter>
    {/* <Link to="register"><button type="button" class="btn btn-primary btn-lg">register</button></Link> */}

    <Routes>
    <Route path="/" element={<Login/>}/>    
    <Route path="/home" element={<Home/>}/>    
    <Route path="/register" element={<Registration/>}/>    
    <Route path="/forget" element={<Forget/>}/>    
    <Route path="/forget/reset" element={<Reset/>}/>    
    </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
