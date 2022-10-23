import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { toast } from 'react-toastify'
import {CDropdown,CDropdownToggle,CDropdownMenu,CDropdownItem} from '@coreui/react'


const AddEmployee=()=>{

    
  
const navigate= useNavigate();


const [empName, setEmpName]= useState("");
const [address, setEmpAddress]= useState("");
const [birthDate, setEmpBirthDate]= useState( );
const [mobileNo, setEmpMobile]= useState("");
const [password, setEmpPassword]= useState("");

const [deptId, setEmpDeptId]= useState(1);
const [empStatus,setEmpStatus]=useState("Active");
let dept= 0;

const addNewEmployee=()=>{

    console.log("hii")

    if (empName.length === 0) {
        toast.error('Enter name')
      } else if (address.length === 0) {
        toast.error('Enter address')
      }else if (mobileNo.length === 0 || mobileNo.length !==10 ) {
        toast.error('Enter 10 digit mobileNo')
      } else if (password.length === 0) {
        toast.error('Enter password')
      }else if (empStatus.length === 0) {
        toast.error('Enter status')
      }else if (birthDate.length === 0) {
        toast.error('Enter birthDate')
      }else {

    const body={

        empName,
        address,
        birthDate: birthDate+"T00:00:00.000",
        mobileNo,
        password,
        deptId,
        empStatus
}

console.log(body);
 
   
        var config = {
            method: 'post',
            url: 'http://ec2-13-234-32-167.ap-south-1.compute.amazonaws.com:8081/hms/admin/addNewEmployee',
            headers: { 
                'Authorization': 'Bearer '+sessionStorage.getItem('token')
            },
            data : body
        };
        
        axios(config)
        .then(function (response) {
            console.log(JSON.stringify(response.data));
            navigate('/viewemp')
            if(response.status===201){                  
                toast.success('Employee added successfully')
              }
            //   setEmployee(response.data)
        })
        .catch(function (error) {
            console.log(error);
        });
    
        
    
}}
return ( 
    
      
  <div className="container div_style" >


    <h3 style={styles.h3}>Add new employee</h3>

    <div >
      <div >
         <div className='mb-3'>
              <label><b>Name:</b></label>
              <input                    
                  type="text"
                  className='form-control'
                  onChange={(event) => { setEmpName(event.target.value)}}>

              </input>
          </div>  
         
          <div className='mb-3'>
          <label><b>Date of birth:</b></label>
              <input                    
                  type="date"
                  className='form-control'  onChange={(event) => { setEmpBirthDate(event.target.value)}}>
              </input>
          </div>                    
          <div className='mb-3'>
          <label><b>Address:</b></label>
              <input                    
                  type="text"
                  className='form-control'  onChange={(event) => { setEmpAddress(event.target.value)}}>
              </input>
          </div>                    
          <div className='mb-3'>
          <label><b>Mobile number:</b></label>
              <input                    
                  type="number"
                  className='form-control'  onChange={(event) => { setEmpMobile(event.target.value)}}>
              </input>
          </div>                    

          <div className='mb-3'>
          <label><b>Password:</b></label>
              <input                    
                  type="password"
                  className='form-control'  onChange={(event) => { setEmpPassword(event.target.value)}}>
              </input>
          </div>  




 <div className='mb-3' style={{marginTop:30}}>

            <div>
                
                <CDropdown>
  <CDropdownToggle href="#" color="success">
    Department
  </CDropdownToggle>
  <CDropdownMenu>
  <CDropdownItem onClick={(event) => { {setEmpDeptId(1)};console.log(deptId);}}>Admin</CDropdownItem>
    <CDropdownItem onClick={(event) => { {setEmpDeptId(2);};console.log(deptId);}}>Doctor</CDropdownItem>
    <CDropdownItem onClick={(event) => { {setEmpDeptId(3);};console.log(deptId);}}>Receptionist</CDropdownItem>
    <CDropdownItem onClick={(event) => { {setEmpDeptId(4);};console.log(deptId);}}>Accountant</CDropdownItem>
  </CDropdownMenu>
</CDropdown>
</div>




 </div>
          <div class="text-center">
               <button type="button" className="btn_style" onClick={addNewEmployee} >Add Employee</button>
          </div>
      </div> 
    </div>
  </div>
);
};


const styles = {
  h3: {
    textAlign: "center",
    margin: 20,
  }
};

export default AddEmployee;