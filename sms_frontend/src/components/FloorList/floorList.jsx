import React from 'react';
import Sidebar from '../Sidebar/sidebar';
import './floorList.css';

function FloorList(){
    return(
       
        <div className='FloorList_container'> 
            <div>
                <Sidebar/>
            </div>   
        <div className='fList'>
            <h3>Select Floor</h3>
            <div className="floor0">
                
                <button className='floorbtn'>Ground Floor</button>
            </div>
            <div className="floor0">
                
                <button className='floorbtn'>First Floor</button>
            </div>
            <div className="floor0">
                
                <button className='floorbtn'>Second Floor</button>
            </div>
            <div className="floor0">
                
                <button className='floorbtn'>Third Floor</button>
            </div>
        </div>
        </div>
        
    )
}
export default FloorList;