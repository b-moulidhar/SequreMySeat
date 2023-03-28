
import './admin_dashboard.css';

function AdminDashboard(){
    return(

        <div className='container admin_body'>
        <div className='mainpage'>

           <div className='admin_container'>
            <div className='admin'>
           <button type="button" className="btn btn-primary danger">Book Seat</button>
                <div>total seat count</div>
                <div>total food count</div>
                <select name="" id="">
                    <option value="" selected>generate report</option>
                    <option value="">weekly</option>
                    <option value="">monthly</option>
                </select>
                <div>registration approval</div>
                <div>scan QR</div>
           </div>
            </div>

        </div> 
        </div>
    )
}

export default AdminDashboard;