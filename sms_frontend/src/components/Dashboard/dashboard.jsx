import './dashboard.css';

function Dashboard(){
    return(
        <div className='mainpage'>
          
           <div className='container'>
           <button type="button" className="btn btn-primary seat">Book Seat</button>
           <button type="button" className="btn btn-success seat">View Booking</button>
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
    )
}

export default Dashboard;