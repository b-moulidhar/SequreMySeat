import './App.css';
import Register from './components/Register/register';
import {BrowserRouter,Routes,Route,Link} from "react-router-dom"
import Login from './components/Login/login';
import Home from './components/Home/home';
import Forget from './components/Forget/forget';
import Reset from './components/Reset/reset';
import Dashboard from './components/Dashboard/dashboard';
import Navbar from './components/Navbar/navbar';
import Profile from './components/Profile/profile';
import Sidebar from './components/Sidebar/sidebar';
import Notify from './components/Notify/notify';
import FloorList from './components/FloorList/floorList';
import Floor from './components/Floor/floor';
import BookSeat from './components/BookSeat/bookSeat';


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
    <Route path="/profile" element={<Profile/>}/>    
    <Route path="/sidebar" element={<Sidebar/>}/>    
    <Route path="/notify" element={<Notify/>}/>    
    {/* <Route path="/floor" element={<Floor/>}/>     */}
    <Route path="/floorLIst" element={<FloorList/>}/>    
    <Route path="/bookseat" element={<BookSeat/>}/>    
    </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
