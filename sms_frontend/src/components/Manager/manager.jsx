import { useState, useEffect } from "react";
import Sidebar from "../Sidebar/sidebar";
import './manager.css';
import axios from 'axios';


function Manager(){
    const [managerEmp, setManagerEmp] = useState({
        empId:Number,
        empName:"",
        startdate:Date,
        endDate:Date,
        shiftStart:"",
        shiftEnd:""
    })

    useEffect(()=>{
        axios.get("http://10.191.80.104:7001/seats/total")
        .then((response) => {
            setManagerEmp({
                ...managerEmp, empId:response.data.empId,
                
            })
            console.log(response.data)
        })
        .catch(err => console.log("Error ", err))
    },[])


    return(
       
        
        <div className='manager'>
        <div>
        <Sidebar/>
        </div>
        <div>
        <h2>Manager Dashboard</h2>
        <table className="table1">
        <thead>
            <tr>
            <th scope="col">Employee ID</th>
            <th scope="col">Name</th>
            <th scope="col">Start Date</th>
            <th scope="col">End Date</th>
            <th scope="col">Shift Start</th>
            <th scope="col">Shift End</th>
            <th scope="col">Approve</th>
            <th scope="col">Decline</th>
            
            </tr>
        </thead>
        <tbody>
            <tr>
            <th scope="row">1</th>
            <td>Mark</td>
            <td>12</td>
            <td>22</td>
            <td>09:00am</td>
            <td>18:00pm</td>
            <td><button  type="button" className="btn btn-success manager_approve">Approve</button> </td>
            <td><button  type="button" className="btn btn-danger manager_approve">Decline</button> </td>
            </tr>   
        </tbody>
        </table>
        </div>
        <div>
            <a href="/bookseat"><button>Book Seat</button></a>
        </div>
    </div>
    
    )
}
export default Manager;