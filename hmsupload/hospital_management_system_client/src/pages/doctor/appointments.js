import TagsInput from "../../components/tagsinput";

import { useNavigate } from "react-router-dom";
import React, { useEffect } from "react";
import {useLocation} from "react-router-dom";
import axios from "axios";
//import Dropdown from 'react-dropdown'
import {CDropdown,CDropdownToggle,CDropdownMenu,CDropdownItem} from '@coreui/react'

import { useState } from "react";
import { render } from "react-dom";

const Appointment = () => {
  const [result, setresult] = useState([])
  const [AllRoom, setAllRoom] = useState([])
  const [Room,setRoom]=useState(0)
  const [tests, settests] = useState([])
  const testsId=[]
  const [alltests, setalltests] = useState([])
  const [allmeds, setAllMeds] = useState([])
  const [meds, setmeds] = useState([])
  const medsId=[]
  const [admit, setadmit] = useState(false)
  const [prescription,setprescription]=useState('')
  const location = useLocation();
  const appointment=location.state.data
  const options=[]
  
  React.useEffect(() => {
    window.scrollTo(0, 0);
    var configRoom = {
      method: 'get',
      url: 'http://localhost:8083/hms/doctor/getAllRoom',
      headers: { 
        'Authorization': 'Bearer '+sessionStorage.getItem('token'), 
        }
    };
    
    axios(configRoom)
    .then(function (response) {
      console.log(JSON.stringify(response.data));
      setAllRoom(response.data)
    })
    .catch(function (error) {
      console.log(error);
    });
    
    var configmeds = {
      method: 'get',
      url: 'http://localhost:8083/hms/doctor/getAllMeds',
      headers: { 
        'Authorization': 'Bearer '+sessionStorage.getItem('token'), 
        }
    };
    
    axios(configmeds)
    .then(function (response) {
      console.log(JSON.stringify(response.data));
      setAllMeds(response.data)
    })
    .catch(function (error) {
      console.log(error);
    });
    
    var configtest = {
      method: 'get',
      url: 'http://localhost:8083/hms/doctor/getAllTests',
      headers: { 
        'Authorization': 'Bearer '+sessionStorage.getItem('token')
         }
    };
    
    axios(configtest)
    .then(function (response) {
      console.log(JSON.stringify(response.data));
      setalltests(response.data)
    })
    .catch(function (error) {
      console.log(error);
    });
    
    
    var data = '';

    
var config = {
  method: 'get',
  url: 'http://localhost:8083/hms/doctor/getMyAppointment/history',
  headers: { 
    'id': appointment.patientId.patientId, 
    'Authorization': 'Bearer '+sessionStorage.getItem('token'), 
    
  },
  data : data
};

axios(config)
.then(function (response) {
  setresult(response.data);
      console.log(response.data)
})
.catch(function (error) {
  console.log(error);
});

  }, []);
  const updatdeadmit=()=>{
    const addmedicine=[]
     medicines[medicines.length-1].map((m)=>addmedicine.push(m.slice(-1)))
    const addtest=[]
    // selectedtests[selectedtests.length-1].map((m)=>addtest.push(m.slice(-1)))
    // var data2 = JSON.stringify({
    //   "prescription": prescription,
    //   "id": appointment.appointId,
    //   "testIds":addtest,
    //   "medicineIds": addmedicine,
    // });
    
    // var config2 = {
    //   method: 'put',
    //   url: 'http://localhost:8083/hms/doctor/getMyAppointment/update',
    //   headers: { 
    //     'Authorization': 'Bearer '+sessionStorage.getItem("token"), 
    //     'Content-Type': 'application/json', 
    //       },
    //   data : data2
    // };
    
    // axios(config2)
    // .then(function (response) {
    //   console.log(JSON.stringify(response.data));
    // })
    // .catch(function (error) {
    //   console.log(error);
  //   });
    
   }
   const setIds=()=>{
    meds.map((t)=>{medsId.push(t.medicineId);console.log(medsId);})
    tests.map((t)=>{testsId.push(t.testId);console.log(testsId);})
    //tests.map((t)=>{settestsId(...testsId, t.testId );console.log(t.testId)})
    // console.log("meds"+JSON.stringify(meds))
    // console.log("medsif"+medsId)
    // console.log("test"+JSON.stringify(tests))
    // console.log("testid"+testsId)


   }
   const admitpatient=()=>{
     console.log("admit patient")
     var dataadmit = JSON.stringify({
      "roomId": Room,
      "empId": sessionStorage.getItem('empId'),
      "appointmentId":appointment.appointmentId 
    });
    
    var configadmit = {
      method: 'post',
      url: 'http://localhost:8083/hms/doctor/getMyAppointment/admit',
      headers: { 
        'Authorization': 'Bearer '+sessionStorage.getItem('token'), 
        'Content-Type': 'application/json', 
        },
      data : dataadmit
    };
    
    axios(configadmit)
    .then(function (response) {
      console.log(JSON.stringify(response.data));
      navigate("/admitform",{state:{data:response.data}});
    })
    .catch(function (error) {
      console.log(error);
    });
    
   }
   const updatdeappointment=()=>{
    
    var dataupdateappointment = {
      "prescription": prescription,
      "id": appointment.appointmentId,
      "testIds":testsId,
      "medicineIds": medsId
    };
    
    var configupdateappointment = {
      method: 'put',
      url: 'http://localhost:8083/hms/doctor/getMyAppointment/update',
      headers: { 
        'Authorization': 'Bearer '+sessionStorage.getItem('token'), 
        'Content-Type': 'application/json'
        
      },
      data : dataupdateappointment
    };
    console.log(dataupdateappointment);
    axios(configupdateappointment)
    .then(function (response) {
      console.log(JSON.stringify(response.data));
    })
    .catch(function (error) {
      console.log(error);
    });
    
    
   }
  const discharge=()=>{
    var data1 = JSON.stringify({
      "appointId": appointment.appointmentId
    });
    
    var config1 = {
      method: 'post',
      url: 'http://localhost:8083/hms/doctor/getMyAppointment/discharge',
      headers: { 
        'Authorization': 'Bearer '+sessionStorage.getItem("token"), 
        'Content-Type': 'application/json', 
        
      },
      data : data1
    };
    
    axios(config1)
    .then(function (response) {
      console.log(JSON.stringify(response.data));
      navigate("/appointmentList");
    })
    .catch(function (error) {
      console.log(error);
    });
    
  }
  const selectedtests=[];
  const navigate = useNavigate();
  const selectedTags = (tags) => selectedtests.push(tags);
  const medicines=[];
  const medsTags = (tags) => {medicines.push(tags)};
  



  let birthDate=appointment.patientId.birthDate.substring(0,10).replace("-","/").replace("-","/");
  let ageInMilliseconds = new Date() - new Date(birthDate);
  const age=Math.floor(ageInMilliseconds/1000/60/60/24/365);
  //console.log(age);


  return (
    

    <div className="container">
      <div>
  <h2 style={styles.h2}>Appointment {appointment.appointmentId}</h2>
      </div>
      
      <div className="row">
        <div className="col">
          <div Style=" padding:20px;margin-top:20px;margin-bottom:20px">
            <table className="table table-bordered ">
              <tr>
                <td Style="width:30%; text-align:left">
                  <label>Name</label>
                </td>
                <td Style="width:10%; ">:</td>
                <td>{appointment.patientId.name}</td>
              </tr>
              <tr>
                <td Style="width:30%; text-align:left">
                  <label>Age</label>
                </td>
                <td Style="width:10%;">:</td>
                <td>{age}</td>
              </tr>
              <tr>
                <td Style="width:30%; text-align:left">
                  <label>Mobile</label>
                </td>
                <td Style="width:10%;">:</td>
                <td>{appointment.patientId.mobileNo}</td>
              </tr>
              <tr>
                <td Style="width:30%; text-align:left">
                  <label>Address</label>
                </td>
                <td Style="width:10%;">:</td>
                <td>{appointment.patientId.address}</td>
              </tr>
            </table>
          </div>
          <div>
            <div>
              <label Style="padding:20px;">History</label>
              <div className="overflow-auto" Style="max-height:250px;">
                <table class="table">
                  <thead
                    class="thead-dark"
                    Style="position: sticky;inset-block-start: 0; Background-color:rgba(6, 99, 88);color:white"
                  >
                    <tr>
                      <th scope="col">appointment id</th>
                      <th scope="col">doctor name</th>
                      <th scope="col">problem</th>
                      <th scope="col">date and time</th>
                    </tr>
                  </thead>
                  <tbody>
                  {result.map((app) => {
            return (
              <tr>               
                <td>{app.appointmentId}</td>
                <td>{app.empId.empName}</td>
                <td>{app.prescription}</td>
                <td>{app.dateTime}</td>
                </tr>)})}
                  </tbody>
                    </table>
              </div>
            </div>
          </div>
        </div>
        <div className="col">
          <div>
            <div
              className="mb-3"
              Style=" text-align:left ; padding:20px;box-shadow: 0px 0px 4px #093329;;margin-top:20px;margin-bottom:20px"
            >
              <label Style="margin:10px">medicines</label>
            <div>{medsId}<ul>{meds.map((t) =>{return(<li onClick={(event) => {setmeds(prev => prev.filter(tes => tes !== t ))}}>{t.medicineName}</li>)})}</ul></div>
              
              <div><CDropdown>
  <CDropdownToggle href="#" color="secondary">
    Dropdown button
  </CDropdownToggle>
  <CDropdownMenu>
  {allmeds.map((t) => {
  return (<CDropdownItem onClick={(event) => { if (meds.indexOf(t) === -1) {setmeds([...meds, t]);}console.log(meds)}}>{t.medicineName}</CDropdownItem>)})}
  </CDropdownMenu>
</CDropdown></div>
<div className="mb-3" style={{ marginTop: 40 }}>
          <button
            Style="box-shadow: 0px 0px 4px #093329;"
            onClick={() => {
              
              setIds();
              
            }}
            className="btn_style"
          >
            save
          </button>
        </div>
            </div>
            <div
              className="mb-3"
              Style=" text-align:left ; padding:20px;box-shadow: 0px 0px 4px #093329;;margin-top:20px;margin-bottom:20px"
            >
              <label Style="margin:10px">tests :</label>
              <div class="mb-3">
              <div><ul >{tests.map((t) =>{return(<li onClick={(event) => {settests(prev => prev.filter(tes => tes !== t ))}}>{t.testName}</li>)})}</ul></div>
              
            <div><CDropdown>
  <CDropdownToggle href="#" color="secondary">
    select test
  </CDropdownToggle>
  <CDropdownMenu>
  {alltests.map((t) => {
  return (<CDropdownItem onClick={(event) => { if (tests.indexOf(t) === -1) {settests([...tests, t]);}console.log(tests);}}>{t.testName}</CDropdownItem>)})}
  </CDropdownMenu>
</CDropdown></div>
              </div>
            </div>
            <div
              className="mb-3"
              Style=" text-align:left ; padding:20px;box-shadow: 0px 0px 4px #093329;;margin-top:20px;margin-bottom:20px">
              <label Style="margin:10px">prescription</label>
              <textarea
                class="form-control"
                id="exampleFormControlTextarea1"
                rows="3"
                onChange={(event) => {
                  setprescription(event.target.value)
                }}
              ></textarea>
            </div>
          </div>
        </div>
        <div className="form-check" Style="text-align:left ">
          <input
            className="form-check-input"
            type="checkbox"
            value=""
            id="flexCheckDefault"
            Style="margin-left:30px; margin-right:10px"
            onChange={
              (event) => {
                setadmit(!admit)
               
            }}
          />
          
          <label className="form-check-label" htmlFor="flexCheckDefault">
            admit
          </label>
          { admit ? <div><CDropdown>
                <CDropdownToggle href="#" color="secondary">
                  Dropdown button
                </CDropdownToggle>
                <CDropdownMenu>
                {AllRoom.map((t) => {
                return (<CDropdownItem onClick={(event) => { setRoom(t.roomId)}}>{ t.roomType}</CDropdownItem>)})}
                </CDropdownMenu>
              </CDropdown></div>: null }

          
          <div id="rooms"></div>
          
        </div>
        <div className="mb-3" style={{ marginTop: 40 }}>
          <button
            Style="box-shadow: 0px 0px 4px #093329;"
            onClick={() => {
              updatdeappointment()
                
            }}
            className="btn_style"
          >
            update
          </button>
        </div>
        <div className="mb-3" style={{ marginTop: 40 }}>
          <button
            Style="box-shadow: 0px 0px 4px #093329;"
            onClick={() => {
              if(admit){
                if(Room===0){
                  window.alert("select Room")
                }
                else{admitpatient();
                  }
                  
              }
              
              else{
                discharge();
                // navigate("/appointmentList");
              }
              
            }}
            className="btn_style"
          >
            Complete
          </button>
        </div>
      </div>
    </div>
  );
};

const styles = {
  h2: {
    textAlign: "center",
    margin: 20,
  },
};

export default Appointment;
