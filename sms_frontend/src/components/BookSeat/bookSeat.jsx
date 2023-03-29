import { useState } from "react"
import Sidebar from "../Sidebar/sidebar"
import "./bookSeat.css";
import axios from 'axios';

export default function BookSeat(){

    axios.post('/', {
        fields:"abc"
    })
    .then(function(response){
        console.log(response);
    })    
    .catch(function(error){
        console.log(error);
    })    
    
    const [place,setPlace] = useState({
            request:'',
            fromdate:Date,
            todate:Date,
            shifttime: "",
            optFood:false
    })



    function getRequest(event){
            setPlace({
                ...place,[event.target.name]:event.target.value,
            })
            console.log(place.optFood)
    }

    // function foodOption(event){
    //     setOptFood({
    //         [event.target.name]:event.target.value
    //     })
    // }

    function sendData(){
        console.log(place.optFood)
    }
    return(
        <div className="bookseat_head">
            <div>
                <Sidebar/>
            </div>
        <div className="bookseat_container">
        <select   name="request"  value={place.request} onInput={getRequest} required>
                    <option value="">Select type of requests</option>
                    <option value="weekly">weekly</option>
                    <option value="daily">daily</option>
                  </select>
                  <br />
		<br/>
        <label htmlFor="" ></label>
        <input type="date" name="fromdate" id="fromdate" placeholder="From Date"  required/> &nbsp;&nbsp;<br /><br /><input type="date" name="todate" id="todate" required/>
        <br />
        <br />
                <select name="shifttime"  value={place.shifttime} onInput={getRequest} required>
                    <option value="">shift time</option>
                    <option value="time1">9:00am to 6:00pm</option> 
                    <option value="time2">10:00am to 6:00pm</option> 
                    <option value="time3">2:00pm to 10:00pm</option> 
                    <option value="time4">2:00am to 6:00</option>  
                  </select>
                  <br />
                  <br />
                  <p>Would you like to opt for lunch at Office? (It would help us arrange the lunch for you)</p>
                   <select name="optFood" value={place.optFood} onInput={getRequest} required>
                   <option value="" disabled selected>Select Option</option>
                    <option value={true}>Yes</option>
                    <option value={false}>No</option>
                   </select>
                    <br/>
                    <br/>
                  <a href="/floorList" className="seatbook_next" onClick={sendData} type='submit'>Next</a>
        </div>
        </div>
    )
}