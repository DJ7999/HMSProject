import { useState ,useEffect} from "react";
import axios from "axios";
import { toast } from 'react-toastify'
import { useNavigate } from 'react-router-dom'

const AddNewPatient = () => {
    
    const [name, setName] = useState('');
    const [birthDate, setBirthDate] = useState('');
    const [address, setAddress] = useState('');
    const [mobileNo, setMobileNo] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
   
    const navigate = useNavigate()  

    const addNewPatient = () => {
     
        if (name.length === 0) {
            toast.error('Enter name')
          } else if (address.length === 0) {
            toast.error('Enter address')
          }else if (mobileNo.length === 0 || mobileNo.length !==10 ) {
            toast.error('Enter 10 digit mobileNo')
          } else if (password.length === 0) {
            toast.error('Enter password')
          }else if (confirmPassword.length === 0) {
            toast.error('Enter correct password')
          }else if (birthDate.length === 0) {
            toast.error('Enter birthDate')
          }else {
            const body = {
                name,
                birthDate,
                address,
                mobileNo,
                password,
                confirmPassword,              
            }       

            var config = {
                method: 'post',
                url: 'http://ec2-13-127-123-146.ap-south-1.compute.amazonaws.com:8082/hms/receptionist/addNewPatient',
                headers: { 
                    'Authorization': 'Bearer '+sessionStorage.getItem('token'),
                  'Content-Type': 'application/json'
                },
                data : body
              };

              axios(config)
                .then(function (response) {                
                
                if(response.status===201){                  
                  toast.success('Patient added successfully')
                }
                debugger
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
      <h3 style={styles.h3}>Add new patient</h3> 

        <div >
          <div>
             <div className='mb-3'>
                  <label>Name</label>
                  <input                    
                      type="text"
                      className='form-control' required  
                      onChange={(e) => {
                        setName(e.target.value)
                      }}>
                  </input>
              </div>  
               <div className='mb-3 '>
                  <label>Address</label>
                  <input                    
                      type="text"
                      className='form-control'
                      onChange={(e) => {
                      setAddress(e.target.value)
                      }}>                          
                  </input>
              </div> 
  
              <div className='mb-3'>
                  <label>Mobile no</label>
                  <input                    
                      type="number"
                      className='form-control'
                      onChange={(e) => {
                      setMobileNo(e.target.value)
                    }}>
                  </input>
              </div> 

              <div className='mb-3'>
                  <label>Password</label>
                  <input                    
                      type="Password"
                      className='form-control'
                      onChange={(e) => {
                      setPassword(e.target.value)
                    }}>
                  </input>
              </div> 

              <div className='mb-3'>
                  <label>Confirm Password </label>
                  <input                    
                      type="Password"
                      className='form-control'
                      onChange={(e) => {
                      setConfirmPassword(e.target.value)
                          }}>
                  </input>
              </div>                       
  
              <div className='mb-3'>
                  <label>Date Of Birth</label>
                  <input                    
                      type="date"
                      className='form-control'
                      onChange={(e) => {
                      setBirthDate(e.target.value)
                        }}>
                  </input>
              </div>  
              <div class="text-center">
                   <button type="button" className="btn_style" onClick={addNewPatient} >Add patient</button>
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

  export default AddNewPatient;
  