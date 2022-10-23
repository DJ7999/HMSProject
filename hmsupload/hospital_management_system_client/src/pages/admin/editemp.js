import { useEffect } from "react";
import { useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import axios from "axios";
import {CDropdown,CDropdownToggle,CDropdownMenu,CDropdownItem} from '@coreui/react'
const EditEmployee = (props) => {
    const location = useLocation();
    
const [details, setDetails]=useState({})
// const empTemp=location.state.data;
console.log("hi")
console.log(details);
const [empName, setEmpName]= useState(details.empName);
const [address, setAddress]= useState(details.address);
const [birthDate, setBirthDate]= useState( details.birthDate);
const [mobileNo, setMobile]= useState(details.mobileNo);
const [password, setPassword]= useState(details.password);

const [deptId, setDeptId]= useState(details.deptId);
const [empStatus,setStatus]=useState(details.empStatus);


    const navigate= useNavigate();

    useEffect(()=>{
        const {empId}= location.state;
        getDetails(empId)
    },[])

    const getDetails=(id)=>{
        var config = {
            method: 'get',
            url: 'http://ec2-13-234-32-167.ap-south-1.compute.amazonaws.com:8081/hms/admin/findEmpById?id='+id,
            headers: { 
                'Authorization': 'Bearer '+sessionStorage.getItem('token')
            }
           
        };
        
        axios(config)
        .then(function (response) {
            console.log(JSON.stringify(response.data));
            // navigate('/viewemp')
            //   setEmployee(response.data)
            setDetails(response.data)
        })
        .catch(function (error) {
            console.log(error);
        });



    }

    const updateEmployee=()=>{
        console.log("hii")

        const body={
            empId:details.empId,
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
        method: 'put',
        url: 'http://ec2-13-234-32-167.ap-south-1.compute.amazonaws.com:8081/hms/admin/updateEmployee',
        headers: { 
            'Authorization': 'Bearer '+sessionStorage.getItem('token')
        },
        data : body
    };
    
    axios(config)
    .then(function (response) {
        console.log(JSON.stringify(response.data));
       
        navigate('/viewemp')
        //   setEmployee(response.data)
    })
    .catch(function (error) {
        console.log(error);
    });


    }

    return (          
            <div className="container" Style="box-shadow: 0px 0px 4px gray; margin-Top: 20px ;padding:10px">            
              <div >
              <h3 style={styles.h3}>Edit Employee</h3>
                
                <div>
                   <div className='mb-3'>
                        <label><b>Name</b></label>
                        <input                    
                            type="text"
                            className='form-control'
                              onChange={(e) => {
                                setEmpName(e.target.value)
              }}            
                           placeholder ={details.empName}  >
                          
                        </input>
                    </div>

                    <div className='mb-3'>
                        <label><b>Birth Date</b></label>
                        <input                    
                            type="date"
                            className='form-control'
                            onChange={(e) => {
                                setBirthDate(e.target.value)}}
                                placeholder={details.birthDate} >
                        </input>
                    </div>
                    
        
                    <div className='mb-3'>
                        <label><b>Address</b></label>
                        <input                    
                            type="text"
                            className='form-control'
                            onChange={(e) => {
                                setAddress(e.target.value)}}
                                placeholder={details.address}>
                        </input>
                    </div>                            
                    <div className='mb-3'>
                        <label><b>Mobile</b></label>
                        <input                    
                            type="number"
                            className='form-control'
                            onChange={(e) => {
                                setMobile(e.target.value)}}
                                placeholder={details.mobileNo}  >
                        </input>
                    </div>                            
                                            
        
                 
        
                    <div className='mb-3'>
                        <label><b>Password</b></label>
                        <input                    
                            type="Password"
                            className='form-control'
                            onChange={(e) => {
                                setPassword(e.target.value)}}
                                placeholder={details.password}>
                        </input>
                    </div> 

                     <div className='mb-3'>
                        <label><b>Status :</b></label>
                        <input                    
                            type="text"
                            onChange={(e) => {
                                setStatus(e.target.value)}}
                                placeholder={details.empStatus}
                           
                    >
                        </input>
                    </div>                      
        
                   
        
                    <div className='mb-3' style={{marginTop:30}}>

<div>
    
    <CDropdown>
<CDropdownToggle href="#" color="success">
Department
</CDropdownToggle>
<CDropdownMenu>
<CDropdownItem onClick={(event) => { {setDeptId(1)};console.log(deptId);}}>Admin</CDropdownItem>
<CDropdownItem onClick={(event) => { {setDeptId(2);};console.log(deptId);}}>Doctor</CDropdownItem>
<CDropdownItem onClick={(event) => { {setDeptId(3);};console.log(deptId);}}>Receptionist</CDropdownItem>
<CDropdownItem onClick={(event) => { {setDeptId(4);};console.log(deptId);}}>Accountant</CDropdownItem>
</CDropdownMenu>
</CDropdown>
</div>




</div>
                    <div class="text-center">
                         <button type="button"  className="btn_style" onClick={updateEmployee}>Save Changes</button>
                    </div>
                </div> 
              </div>
            </div>
          );
  };
  
//   ()=>{
//     navigate('/viewemp')
//  }
  const styles = {
      h3: {
        textAlign: "center",
        margin: 40,
      },
      button: {
        marginRight: 10,        
        textAlign:"center",
        justifyContent:"center" ,      
      },
  
      container:{
          left: "9px",
          top: "5px",
          width: "5px",
          height: "10px",
          border: "solid white",
          borderWidth:" 0 3px 3px 0",
    
        }
    };
  
  export default EditEmployee;
  