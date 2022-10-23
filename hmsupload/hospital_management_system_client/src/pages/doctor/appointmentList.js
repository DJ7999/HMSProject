import { useNavigate } from "react-router-dom";
import axios from "axios";
import { useState } from "react";
import React, { useEffect } from "react";
import { ToggleSlider }  from "react-toggle-slider";
const AppointmentList = () => {
  const [result, setresult] = useState([])
  const [admitresult, setadmitresult] = useState([])
  const [active, setActive] = useState(false);
  
  useEffect(() => {
    //window.scrollTo(0, 0);
    var configadmit = {
      method: 'get',
      url: 'http://ec2-3-110-170-135.ap-south-1.compute.amazonaws.com:8083/hms/doctor/getMyAdmit',
      headers: { 
        'id': sessionStorage.getItem("empId"), 
        'Authorization': 'Bearer '+sessionStorage.getItem('token')
      }
    };
    
    axios(configadmit)
    .then(function (response) {
      console.log(response.data);
      setadmitresult(response.data)
    })
    .catch(function (error) {
      console.log(error);
    });
    
    var config = {
      method: 'get',
      url: 'http://ec2-3-110-170-135.ap-south-1.compute.amazonaws.com:8083/hms/doctor/getMyAppointment',
      headers: { 
        'id': sessionStorage.getItem("empId"), 
        'Authorization': 'Bearer '+sessionStorage.getItem('token')
      }
    };
    
    axios(config)
    .then(function (response) {
     // console.log(JSON.stringify(response.data));
     
      
      setresult(response.data);
      console.log(response.data)
    })
    .catch(function (error) {
      console.log(error);
    });
  }, []);
  const navigate = useNavigate();

  

  return (
    <div className="container ">
      <ToggleSlider onToggle={state => setActive(!active)}/>
      {active?<><div>
        <h2 style={styles.h2}>Appointment List</h2>
      </div>
      <div>
        <table class="table" Style="text-align:center; ">
          <thead>
            <tr>
              <th scope="col">id</th>
              <th scope="col">Name</th>
              <th scope="col">date</th>
              <th scope="col">slot</th>
              <th scope="col">action</th>
            </tr>
          </thead>
          <tbody>
          {result.filter((res) => {
            if (res.status == "active") {
              return res
            }



          }).map((appointment) => {
            return (
              <tr>               
                <td>{appointment.appointmentId}</td>
                <td>{appointment.patientId.name}</td>
                <td>{appointment.dateTime.substring(0,10)}</td>
                <td>{appointment.dateTime.substring(11)}</td>
                
                <td>
                <button
                  onClick={() => {
                    navigate("/appointments",{state:{data:appointment}});
                  }}
                  type="submit"
                  className="btn_style"
                >
                  Attend
                </button>
                
              </td>
              </tr>
            );
          })}
        </tbody>
          </table>
      </div></>:
      <><div>
      <h2 style={styles.h2}>admit List</h2>
    </div>
    <div>
      <table class="table" Style="text-align:center; ">
        <thead>
          <tr>
            <th scope="col">id</th>
            <th scope="col">Name</th>
            <th scope="col">date</th>
            <th scope="col">slot</th>
            <th scope="col">action</th>
          </tr>
        </thead>
        <tbody>
        {admitresult.filter((res) => {
            if (res.status == "Active") {
              return res
            }



          }).map((appointment) => {
          return (
            <tr>               
              <td>{appointment.admitId}</td>
              <td>{appointment.appointmentId.patientId.name}</td>
              <td>{appointment.appointmentId.dateTime.substring(0,10)}</td>
              <td>{appointment.roomId.roomId}</td>
              
              <td>
              <button
                onClick={() => {
                  navigate("/admitform",{state:{data:appointment}});
                }}
                type="submit"
                className="btn_style"
              >
                Visit
              </button>
              
            </td>
            </tr>
          );
        })}
      </tbody>
        </table>
    </div>
      </>}
    </div>
  );
};

const styles = {
  h2: {
    textAlign: "center",
    margin: 20,
  }
};
export default AppointmentList;
