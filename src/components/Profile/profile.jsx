import React, {useState, useEffect } from 'react';
import Sidebar from '../Sidebar/sidebar';
import "./profile.css";

function Profile(){
    const data1 = [
        {
            email: "abc@valtech.com",
            phone: 1234567890,
            emp_id: 1,
            role:"employee"
        },
        {
            email: "pqr@valtech.com",
            phone: 1234567890,
            emp_id: 2,
            role:"manager"
        },
        {
            email: "wer@valtech.com",
            phone: 1234567890,
            emp_id: 3,
            role:"admin"
        },
        {
            email: "asd@valtech.com",
            phone: 1234567890,
            emp_id: 4,
            role:"employee"
        }

    ]
    //const[data, setData] = useState("");
    // useEffect(()=>{
    //     fetch("").then((result)=>{
    //         result.json().then((res)=>{
    //             console.log(res)
    //             setData(res)
    //         })
    //     })
    // },[])
    // console.log(data);
    return(
        <div className='profile'>
        <Sidebar/>
        <div>
            <div className="imgs">
           <div className="container-image">
            
           </div>
           </div>
           <h2>User Info</h2>
            <h3>Name</h3>
            <table className="table">
            <thead>
                <tr>
                <th scope="col">Email ID</th>
                <th scope="col">Phone Number</th>
                <th scope="col">Employee ID</th>
                <th scope="col">Role</th>
                </tr>
            </thead>
            <tbody>
                {
                    data1.map((items)=>
                
                <tr>
                <th scope="row">{items.email}</th>
                <td>{items.phone}</td>
                <td>{items.emp_id}</td>
                <td>{items.role}</td>
                </tr>
                    )
}
                
               
            </tbody>
            </table>

            </div>
        </div>
    )
}
export default Profile;