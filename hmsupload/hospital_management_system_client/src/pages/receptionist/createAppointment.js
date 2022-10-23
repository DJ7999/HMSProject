import { useState ,useEffect} from "react";
import { useLocation, useNavigate } from 'react-router-dom'
import {CDropdown,CDropdownToggle,CDropdownMenu,CDropdownItem} from '@coreui/react'
import { toast } from 'react-toastify'

import axios from "axios";

const CreateAppointment = () => {
  const navigate = useNavigate();
  const [doctor, setDoctor] = useState([]);
  const [selectedDr, setSelectedDr] = useState(); //empId
  const [dateTime ,setDateTime] = useState();   //dateTime
  const [selectedDrName, setSelectedDrName] = useState('Assign Doctor') //drName
  const [time,setTime] = useState() // time
  
  const location = useLocation();
  const patient=location.state.data;  //patient.patientId 
  

  useEffect(() => {   
    var config = {
      method:'get' ,     
      url: 'http://ec2-13-127-123-146.ap-south-1.compute.amazonaws.com:8082/hms/receptionist/getAllDoctorName',
      headers: { 
        'Authorization': 'Bearer '+sessionStorage.getItem('token')
      }
    };
  
    axios(config)
    .then(function (response) {   
      setDoctor(response.data)
    })
    .catch(function (error) {
      console.log(error);
    });
    
  }, [])

  const addNewAppointment=()=>{  
   
      var addAppointmentData = JSON.stringify({
        "dateTime":dateTime+'T'+time,
        "empId": selectedDr,
        "patientId": patient.patientId
      });
   
      
    var configAddAppointment= {
      method: 'post',
      url: 'http://ec2-13-127-123-146.ap-south-1.compute.amazonaws.com:8082/hms/receptionist/AddNewAppointment',
      headers: { 
          'Authorization': 'Bearer '+sessionStorage.getItem('token'),
          'Content-Type': 'application/json'
      },
      data : addAppointmentData
    };
    
    axios(configAddAppointment)
    .then(function (response) {
      if(response.status===201){                  
        toast.success('Appointment Booked')
      }
      navigate('/viewAllAppointment')
    })
    .catch(function (error) {
      console.log(error);
    }); 
  } 
  return (
    <div className="container div_style">

      <button className="btn_style"  style={{ marginLeft: 600,width:100 }} onClick={()=>{
                          navigate('/viewPatient')
                        }}>
        Back
      </button>
      <h3 style={styles.h3}>Book Appointment</h3>

      <div className="mb-3 ">
        
            <b><label>Patient Name</label></b>
            <input type="text" className="form-control" value ={patient.name} readonly></input>
          </div>
          <div className="col"> </div>
     

      <div className="mb-3 ">         
              <div>
                <b><label htmlFor="exampleFormControlInput1" className="form-label" >
                  Select Date
                </label></b>
              </div>
              <div>
                {" "}
                <input
                  type="date"
                  className="form-control"
                  id="exampleFormControlInput1 "
                  placeholder="date for appointment"
                  onChange={(e) => {
                  setDateTime(e.target.value)
                      }} />               
      </div>
        </div>
          <div className="col"> </div>
    
      <div className="mb-3 ">
        
            <b><label>select Time</label></b>
            <input type="time" className="form-control"  onChange={(e) => {
                    setTime(e.target.value)
                      }}></input>
          </div>
          <div className="col"> </div>
     
      <div className="mb-3 ">
        <div className="row">
          <div className="col-md-6">
          <CDropdown>
                <CDropdownToggle href="#" color="dark">
                {selectedDrName}
                </CDropdownToggle>
                <CDropdownMenu>
                {doctor.map((t) => {
                return (<CDropdownItem onClick={(event) => { setSelectedDr(t.empId);setSelectedDrName(t.empName)}}>Dr. { t.empName}</CDropdownItem>)})}
                </CDropdownMenu>
              </CDropdown>
               
          </div>
          <div>        
          </div>
        </div>
      </div>
      <div className="col-auto">
        <button
          type="submit"
          className="btn_style"
         onClick={addNewAppointment}>
          Book Appointment
        </button>
      </div>
    </div>
  );
};

const styles = {
  h3: {
   
    margin: 10,
    
    
  },
  button: {
    marginRight: 10,
  },
};
export default CreateAppointment;
