
import axios from 'axios';
import { useEffect, useState } from 'react';
import './admin_dashboard.css';

function AdminDashboard(){
    const [count,setCount] = useState({counts:0})
    useEffect(()=>{
        axios.get("https://reqres.in/api/users").then((res)=>{
                setCount({
                    ...count,counts:res.data.data.length
                }
                )
                console.log(res.data.data.length)
        })
    },[])
    return (
      <div className="dashboard_container">
      <div className="mainpage">
        <div>
        </div>
        <div>
          {/* <h2 className="status">Status</h2> */}
          {/* <div className="dashboard_head">
            <h3>your name</h3>
            <p>your seat for today is 1 at ground floor</p>
          </div> */}
          <div className=" atten">
            <div className="attenstatus">
              <button type="button" className="btn btn-success statusbtn">
                Approved
              </button>
            </div>
            <div className="attenstatus">
              <button type="button" className="btn btn-warning statusbtn">
                Pending
              </button>
            </div>
            <div className="attenstatus">
              <button type="button" className="btn btn-danger statusbtn">
                Rejected
              </button>
            </div>
          </div>
          <div className="dashboard">
            <a href="/bookseat">
              <button type="button" className="btn btn-primary seat">
                Book Seat
              </button>
            </a>
            <a href="/viewpass">
              <button type="button" className="btn btn-success seat">
                View Booking
              </button>
            </a>
          </div>

          {/* <div className="dashboard_bottom">
            <div>
              <img
                style={{ margin: "" }}
                src="https://png.pngtree.com/png-clipart/20210309/original/pngtree-3d-furniture-modern-office-chair-png-image_5892659.jpg"
                width="50"
                height="50"
                alt=""
              />
            </div>
            <div>
              <p>date:29-03-2022</p>
              <p>seat number:1005</p>
              <p>shift time:09:00-18:00</p>
            </div>
            <div>
              <a href="">
                <button className="btn btn-danger">Cancel</button>
              </a>
            </div>
          </div> */}
        </div>
      </div>
    </div>
      // <div classname="container admin_body">
      //   <div classname="mainpage">
      //     <div classname="admin_container">
      //       <nav className="navbar navbar-expand-lg bg-body-tertiary">
      //         <div className="container-fluid">
      //           <a className="navbar-brand" href="#">
      //             Navbar
      //           </a>
      //           <button
      //             className="navbar-toggler"
      //             type="button"
      //             data-bs-toggle="collapse"
      //             data-bs-target="#navbarSupportedContent"
      //             aria-controls="navbarSupportedContent"
      //             aria-expanded="false"
      //             aria-label="Toggle navigation"
      //           >
      //             <span className="navbar-toggler-icon" />
      //           </button>
      //           <div
      //             className="collapse navbar-collapse"
      //             id="navbarSupportedContent"
      //           >
      //             <ul className="navbar-nav me-auto mb-2 mb-lg-0">
      //               <li className="nav-item">ADMIN DASHBOARD</li>
      //             </ul>
      //           </div>
      //         </div>
      //       </nav>
      //       <div classname="admin">
      //         <div classname="total_count">
      //           <div className="card" style={{ width: "18rem" }}>
      //             <div className="card-body">
      //               <h5 className="card-title">Food count</h5>
      //               <h6 className="card-subtitle mb-2 text-body-secondary">
      //                 Food count
      //               </h6>
      //               <p className="card-text">
      //                 {count.counts}
      //               </p>
      //             </div>
      //           </div>

      //           <div className="card" style={{ width: "18rem" }}>
      //             <div className="card-body">
      //               <h5 className="card-title">Employee count</h5>
      //               <h6 className="card-subtitle mb-2 text-body-secondary">
      //                 Employee count
      //               </h6>
      //               <p className="card-text">
      //                 {count.counts}
      //               </p>
      //             </div>
      //           </div>
      //         </div>
      //         <select name id>
      //           <option value selected>
      //             generate report
      //           </option>
      //           <option value>weekly</option>
      //           <option value>monthly</option>
      //         </select>
      //         <div>registration approval</div>
      //         <div>scan QR</div>
      //       </div>
      //     </div>
      //   </div>
      // </div>
      
    );
}

export default AdminDashboard;