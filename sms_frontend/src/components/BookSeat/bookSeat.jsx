import { useState } from "react"
import Sidebar from "../Sidebar/sidebar"
import "./bookSeat.css"

export default function BookSeat(){
    const [place,setPlace] = useState({
            request:'',
            fromdate:Date,
            todate:Date,
            shifttime: ""
    })

    const [optFood, setOptFood] = useState(false)

    function getRequest(event){
            setPlace({
                ...place,[event.target.name]:event.target.value,
            })
    }

    function foodOption(event){
        setOptFood({
            [event.target.name]:event.target.value
        })
    }

    function sendData(){
        console.log(optFood)
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
                   <select name="optfood" value={optFood} onInput={foodOption} required>
                   <option value="" disabled selected>Select Option</option>
                    <option value={true}>Yes</option>
                    <option value={false}>No</option>
                   </select>
                    <br/>
                    <br/>
                  <a href="/floorList" className="seatbook_next" onClick={sendData} type='submit' style={{backgroundColor:"crimson"}}>Next</a>
        </div>
        </div>
    )
}