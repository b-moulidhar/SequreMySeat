import Navbar from '../Navbar/navbar';
import Sidebar from '../Sidebar/sidebar';
import './dashboard.css';

function Dashboard(){
    return(

        <div>
            <Navbar/>
        <div className='mainpage'>
            
            <Sidebar/>
          
           <div className='dashboard_container'>
            <div className='dashboard'>
           <button type="button" className="btn btn-primary seat">Book Seat</button>
           <button type="button" className="btn btn-success seat">View Booking</button>
           </div>
           <h2 className="status">Status</h2>
           <div className='atten'>
                <div className='attenstatus'>
                    <button type="button" className="btn btn-success statusbtn">Approved</button>
                </div>
                <div className='attenstatus'>
                    <button type="button" className="btn btn-warning statusbtn" >Pending</button>
                </div>
                <div className='attenstatus'>
                    <button type="button" className="btn btn-danger statusbtn" >Rejected</button>
                </div>
                </div>  
            </div>

        </div> 
        </div>
    )
}

export default Dashboard;