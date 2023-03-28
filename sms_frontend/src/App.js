import './App.css';
import Register from './components/Register/register';
import {BrowserRouter,Routes,Route,Link} from "react-router-dom"
import Login from './components/Login/login';
import Forget from './components/Forget/forget';
import Reset from './components/Reset/reset';
import Dashboard from './components/Dashboard/dashboard';
import Navbar from './components/Navbar/navbar';
import Profile from './components/Profile/profile';
import Sidebar from './components/Sidebar/sidebar';
import Notify from './components/Notify/notify';
import FloorList from './components/FloorList/floorList';
import BookSeat from './components/BookSeat/bookSeat';
import Manager from './components/Manager/manager';
import QrCodeScan from './components/QR_Scanner/QrCodeScan';
import ViewPass from './components/ViewPass/viewPass';
import Regular from './components/Regularization/regular';


function App() {
  return (

    <>
    <BrowserRouter>
    {/* <Link to="register"><button type="button" class="btn btn-primary btn-lg">register</button></Link> */}
   
    <Routes>
    <Route path="/" element={<Login/>}/>      
    <Route path="/register" element={<Register/>}/>    
    <Route path="/forget" element={<Forget/>}/>    
    <Route path="/forget/reset" element={<Reset/>}/>    
    <Route path="/dashboard" element={<Dashboard/>}/>    
    <Route path="/navbar" element={<Navbar/>}/>    
    <Route path="/profile" element={<Profile/>}/>    
    <Route path="/sidebar" element={<Sidebar/>}/>    
    <Route path="/notify" element={<Notify/>}/>   
    <Route path="/regular" element={<Regular/>}/>   
    <Route path="/floorLIst" element={<FloorList/>}/>    
    <Route path="/bookseat" element={<BookSeat/>}/>    
    <Route path="/manager" element={<Manager/>}/>    
    <Route path="/qrscanner" element={<QrCodeScan/>}/> 
    <Route path="/viewpass" element={<ViewPass/>}/> 

    </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
