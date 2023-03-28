import Sidebar from '../Sidebar/sidebar';
import './dashboard.css';


function Dashboard(){
    return(

        <div className='dashboard_container'>
           
        <div className='mainpage'>
            
            <Sidebar/>
          
           <div >
           {/* <h2 className="status">Status</h2> */}
           <div className='dashboard_head'>
            <h3>your name</h3>
            <p>your seat for today is 1 at ground floor</p>

           </div>
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
            <div className='dashboard'>
                <a href='/bookseat'><button type="button" className="btn btn-primary seat">Book Seat</button></a>
                <a href='/viewpass'><button type="button" className="btn btn-success seat">View Booking</button></a>
           </div>
           
            </div>

        </div> 
        </div>
    )
}

export default Dashboard;