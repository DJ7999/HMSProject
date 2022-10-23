import { useNavigate } from "react-router-dom";
import axios from "axios";
import { useState } from "react";
import React, { useEffect } from "react";
import { toast } from 'react-toastify'

const ViewAllAppointment = () => {
  const [result, setResult] = useState([]);
  const navigate = useNavigate(); 
  const [name, setName] = useState('');

  
  // load the patients as soon as the component gets loaded successfully
  useEffect(() => {   
    var config = {
      method:'get' ,     
      url: 'http://ec2-3-110-170-135.ap-south-1.compute.amazonaws.com:8083/hms/doctor/getAllAppointment',
      headers: { 
        'Authorization': 'Bearer '+sessionStorage.getItem('token')
      }
    };
    
    axios(config)
    .then(function (response) {    
      setResult(response.data)
    })
    .catch(function (error) {
      console.log(error);
    });
    
  }, [])  

  const cancelAppointment=(appointId)=>{    

    var appointCancel = {
      method: 'delete',
      url: 'http://ec2-13-127-123-146.ap-south-1.compute.amazonaws.com:8082/hms/receptionist/cancelAppointmnet?appointmentId='+appointId,
      headers: { 
        'Authorization': 'Bearer '+sessionStorage.getItem('token'),
      }
    };
    
    axios(appointCancel)
    .then(function (response) {
      if(response.status===201){                  
        toast.success('Appointment cancel')
      }
      window.location.reload(true) 
    })
    .catch(function (error) {
      toast.error('Can not cancel your appointment ')
      console.log(error);
    });    
   }  

  return (
    
    <div className="container ">
      <div>
        <h2 style={styles.h2}>All Appointment</h2>
      </div>     


      <form className="form-inline d-flex justify-content my-4">
        <input
          className="mr-md-2"
          style={{border:"solid", borderColor:" rgba(5, 163, 144)", backgroundColor:" rgba(5, 163, 144,0.3)",Color:"white"}}
          type="search"
          placeholder="Search Name"
          aria-label="Search"
          onChange={(e) => {
            setName(e.target.value)
          }}
        />
        <button className="btn_style"  style={{ marginLeft: 900,width:100 }} onClick={()=>{
                          navigate('/viewPatient')
                        }}>
        Back
      </button>

      </form>     

     
      <div>
        <table Style="text-align:center" class="datatable table table-striped table-bordered">
          <thead>
            <tr>
              <th scope="col">Appointment id</th>
              <th scope="col">Patient Name</th>
              <th scope="col">Assigned Dr.</th>
              <th scope="col">Date And Time</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
          {
          result.filter(p=>p.patientId.name.toLowerCase().includes(name.toLowerCase())) 
          .map((appointment) => {
            return (
              <tr>               
                <td>{appointment.appointmentId}</td>
                <td>{appointment.patientId.name}</td>
                <td>{appointment.empId.empName}</td>
                <td>{appointment.dateTime}</td>
                <td>
                <button onClick={() => cancelAppointment(appointment.appointmentId)}type="submit" className="btn_style" >               
                  Cancel Appointment
                </button>               
              </td>
              </tr>
            );
          })}
        </tbody>
          </table>
      </div>
    </div>
  );
};

const styles = {
  h2: {
    textAlign: "center",
    margin: 50,
  }
};
export default ViewAllAppointment;