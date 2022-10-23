import TagsInput from '../../components/tagsinput'
import { useNavigate } from 'react-router-dom';
import {useLocation} from "react-router-dom";
import {CDropdown,CDropdownToggle,CDropdownMenu,CDropdownItem} from '@coreui/react'
import axios from "axios";
import React,{useEffect} from 'react'
import { useState } from "react";
const AdmitForm = () => {
  const location = useLocation();
  const [AllMeds, setAllMeds] = useState([])
  const [alltests, setalltests] = useState([])
  const [meds, setmeds] = useState([])
  const [tests, settests] = useState([])
  const [prescription, setprescription] = useState("")
  const medsId=[]
  const testsId=[]
  const admitDetails=location.state.data
  const setIds=()=>{
    meds.map((t)=>{medsId.push(t.medicineId);console.log(medsId);})
    tests.map((t)=>{testsId.push(t.testId);console.log(testsId);})
    //tests.map((t)=>{settestsId(...testsId, t.testId );console.log(t.testId)})
    // console.log("meds"+JSON.stringify(meds))
    // console.log("medsif"+medsId)
    // console.log("test"+JSON.stringify(tests))
    // console.log("testid"+testsId)


   }
   const update=()=>{
    var data = JSON.stringify({
      "prescription": prescription,
      "admitId": admitDetails.admitId,
      "tests": testsId,
      "medicines": medsId
    });
    
    var config = {
      method: 'put',
      url: 'http://ec2-3-110-170-135.ap-south-1.compute.amazonaws.com:8083/hms/doctor/getMyAppointment/admit/update',
      headers: { 
        'Authorization': 'Bearer '+sessionStorage.getItem('token'), 
        'Content-Type': 'application/json', 
        },
      data : data
    };
    
    axios(config)
    .then(function (response) {
      console.log(JSON.stringify(response.data));
      navigate("/appointmentList");
    })
    .catch(function (error) {
      console.log(error);
    });
    
   }
   const discharge=()=>{
    var data = JSON.stringify({
      "appointId": admitDetails.appointmentId.appointmentId,
      "admitId": admitDetails.admitId
    });
    
    var config = {
      method: 'post',
      url: 'http://ec2-3-110-170-135.ap-south-1.compute.amazonaws.com:8083/hms/doctor/getMyAppointment/admit/discharge',
      headers: { 
        'Authorization': 'Bearer '+sessionStorage.getItem('token'), 
        'Content-Type': 'application/json',
        },
      data : data
    };
    
    axios(config)
    .then(function (response) {
      console.log(JSON.stringify(response.data));
      navigate("/appointmentList");
    })
    .catch(function (error) {
      console.log(error);
    });
    
   }
  //console.log(location.state.data)
    React.useEffect(() => {
        window.scrollTo(0, 0);
        var configmeds = {
          method: 'get',
          url: 'http://ec2-3-110-170-135.ap-south-1.compute.amazonaws.com:8083/hms/doctor/getAllMeds',
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
          url: 'http://ec2-3-110-170-135.ap-south-1.compute.amazonaws.com:8083/hms/doctor/getAllTests',
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
      }, []);
    const navigate= useNavigate();
    const selectedTags = tags => console.log(tags);
          return (
              
              <div className="container" >
                   <div Style=" w-100 
                margin-top: 10px;
                margin-bottom: 10px;
                padding:10px;
                box-shadow: 0px 0px 4px #093329;background:#004763 ;
                ">
                    <h1 Style="margin:10px;color:white;">Admit form</h1>
                </div>
                <div Style=" padding:20px;box-shadow: 0px 0px 4px #093329;margin-top:20px;margin-bottom:20px">
                  <table className="table table-bordered ">
                    <tr><td Style="width:30%; text-align:left"><label>Name</label></td>
                    <td Style="width:10%; ">:</td>
                    <td>{admitDetails.admitId}</td></tr>
                    <tr><td Style="width:30%; text-align:left"><label>birthdate </label></td><td Style="width:10%;">:</td><td>{admitDetails.appointmentId.patientId.name}
</td></tr>
                    <tr><td Style="width:30%; text-align:left"><label>Mobile</label></td><td Style="width:10%;">:</td><td>{admitDetails.appointmentId.patientId.mobileNo}</td></tr>
                    <tr><td Style="width:30%; text-align:left"><label>Address</label></td><td Style="width:10%;">:</td><td>{admitDetails.appointmentId.patientId.address}</td></tr>
                    <tr><td Style="width:30%; text-align:left"><label>Admit date</label></td><td Style="width:10%;">:</td><td>{admitDetails.appointmentId.dateTime.substring(0,10)}</td></tr>
                    <tr><td Style="width:30%; text-align:left"><label>room</label></td><td Style="width:10%;">:</td><td>{admitDetails.roomId.roomId}</td></tr>
                  
                  </table>
                </div>
                
                <div className='mb-3' Style=" text-align:left ; padding:20px;box-shadow: 0px 0px 4px #093329;;margin-top:20px;margin-bottom:20px">
                <label Style="margin:10px">medicines</label>
                
            <div><ul>{meds.map((t) =>{return(<li onClick={(event) => {setmeds(prev => prev.filter(tes => tes !== t ))}}>{t.medicineName}</li>)})}</ul></div>
            
            
            
            
              <div><CDropdown>
  <CDropdownToggle href="#" color="secondary">
    Dropdown button
  </CDropdownToggle>
  <CDropdownMenu>
  {AllMeds.map((t) => {
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
                <div className='mb-3' Style=" text-align:left ; padding:20px;box-shadow: 0px 0px 4px #093329;;margin-top:20px;margin-bottom:20px">
                <label Style="margin:10px">tests :</label>
              
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
               
                <div className='mb-3' Style=" text-align:left ; padding:20px;box-shadow: 0px 0px 4px #093329;;margin-top:20px;margin-bottom:20px">
                  <label Style="margin:10px">Remarks</label>
                  <textarea
                class="form-control"
                id="exampleFormControlTextarea1"
                rows="3"
                onChange={(event) => {
                  setprescription(event.target.value)
                }}
              ></textarea>

</div>
<div className='mb-3' style={{ marginTop: 40 }} >
                  <button Style="box-shadow: 0px 0px 4px #093329;"  className="btn_style" onClick={() => {update()}}>update</button>
                  <button Style="box-shadow: 0px 0px 4px #093329;"  className="btn_style"onClick={() => {discharge()}}>Discharge</button>
                </div>


              </div>
              
          )}
export default AdmitForm;