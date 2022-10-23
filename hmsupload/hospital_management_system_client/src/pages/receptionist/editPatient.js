import { useState ,useEffect} from "react";
import axios from "axios";
import { toast } from 'react-toastify'
import { useLocation, useNavigate } from 'react-router-dom'

const EditPatient = () => {
    
  const navigate = useNavigate() ;

    const location = useLocation();
    const patientTemp=location.state.data;
    const [name, setName] = useState(patientTemp.name);
    const [birthDate, setBirthDate] = useState(patientTemp.birthDate);
    const [address, setAddress] = useState(patientTemp.address);
    const [mobileNo, setMobileNo] = useState(patientTemp.mobileNo);  


   const editPatientDetails = () => {
       
  
    if (name.length === 0) {
        toast.error('Enter name')
      } else if (mobileNo.length === 0) {
        toast.error('Enter mobileNo')
      } else if (address.length === 0) {
        toast.error('Enter address')
      }else if (birthDate.length === 0) {
        toast.error('Enter birthDate')
      } else {
        const body = {
            patientId:patientTemp.patientId,
            name,
            birthDate,
            address,
            mobileNo 
        }          

        var config = {
            method: 'put',
            url: 'http://ec2-13-127-123-146.ap-south-1.compute.amazonaws.com:8082/hms/receptionist/updatePatientDetails',
            headers: { 
                'Authorization': 'Bearer '+sessionStorage.getItem('token'),
                'Content-Type': 'application/json'
            },
            data : body
          };          
          axios(config)
            .then(function (response) {
              if(response.status===201){                  
                toast.success('Update successfully')
              }
            navigate('/viewPatient')        
           
            })
            .catch(function (error) {
             console.log(error);
            });   
    }
}


    return (          
            <div className="container div_style" >
              <button className="btn_style"  style={{ marginLeft: 600,width:100 }} onClick={()=>{
                          navigate('/viewPatient')
                        }}>
        Back
      </button>            
              <div >
                <div>
                <div className='mb-3'>
                        <label>Patient Id </label>
                        <input                    
                            type="number"
                            className='form-control' value={patientTemp.patientId}
                            >
                        </input>
                    </div>  
                   <div className='mb-3'>
                        <label>Name</label>
                        <input                    
                            type="text"
                            className='form-control' 
                            onChange={(e) => {
                              setName(e.target.value)
                            }} 
                            value={name}
                        >
                        </input>
                    </div>
                    <div className='mb-3'>
                        <label>Mobile no</label>
                        <input                    
                            type="number"
                            className='form-control'
                            onChange={(e) => {
                            setMobileNo(e.target.value)
                            }} 
                            value={mobileNo}>
                        </input>
                    </div> 
        
                    <div className='mb-3'>
                        <label>Address</label>
                        <input                    
                            type="text"
                            className='form-control'
                            onChange={(e) => {
                            setAddress(e.target.value)
                            }} 
                            value={address}>
                        </input>
                    </div>                      
        
                    <div className='mb-3'>
                        <label>Date Of Birth</label>
                        <input                    
                            type="date"
                            className='form-control'
                            onChange={(e) => {
                            setBirthDate(e.target.value)
                            }} value={patientTemp.birthDate}>
                        </input>
                    </div>        
                    <div class="text-center">
                         <button type="button"  className="btn_style" onClick={editPatientDetails}>Update Changes</button>
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
  
  export default EditPatient;
  