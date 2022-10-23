import { useState } from 'react'
import { Link } from 'react-router-dom'
import axios from 'axios'


import { useNavigate } from 'react-router-dom'

const Signin = () => {
  // get user inputs
  const [name, setname] = useState('')
  const [password, setPassword] = useState('')

  // get the navigate function reference
  const navigate = useNavigate()

  const signin = () => {
    // check if user has really entered any value
    
      // make the API call to check if user exists
      var data = JSON.stringify({
        "name": name,
        "password": password
      });
      
      var config = {
        method: 'post',
        url: 'http://localhost:8080/hms/login/signin',
        headers: { 
          'Content-Type': 'application/json', 
          },
        data : data
      };
      
      axios(config)
      .then(function (response) {
        console.log(JSON.stringify(response.data));
        sessionStorage.setItem('token',response.data.jwt);
      sessionStorage.setItem('empId',response.data.empId);
      sessionStorage.setItem('deptId',response.data.deptId);
      if(response.data.deptId==1)
        navigate("/viewemp")
        if(response.data.deptId==2)
        navigate("/appointmentList")
        if(response.data.deptId==3)
        navigate("/viewPatient")
        if(response.data.deptId==4)
        navigate("/invoiceList")
      })
      .catch(function (error) {
        console.log(error);
      });
      
    }       
  return (
   
    <div style={{ marginTop: 100 }}>
      <div style={styles.container}>
        <div className='mb-3'>
          <label>Name</label>
          <input
            onChange={(event) => {
              setname(event.target.value)
            }}
            className='form-control'
            type='text'
          />
        </div>
        <div className='mb-3'>
          <label>Password</label>
          <input
            onChange={(event) => {
              setPassword(event.target.value)
            }}
            className='form-control'
            type='password'
          />
        </div>
        <div className='mb-3' style={{ marginTop: 40 }}>
          
          <button onClick={signin} style={styles.signinButton}>
            Signin
          </button>
        </div>
      </div>
    </div>
 
  )
}

const styles = {
  container: {
    
    width: 400,
    height: 300,
    padding: 20,
    position: 'relative',
    top: 0,
    left: 500,
    right: 0,
    bottom: 0,
    margin: 'auto',
    borderColor: 'rgba(5, 163, 144)',
    borderRadius: 10,
    broderWidth: 1,
    borderStyle: 'solid',
    boxShadow: '1px 1px 20px 5px #C9C9C9',
  },
  signinButton: {
    position: 'relative',
    width: '100%',
    height: 40,
    backgroundColor: 'rgba(5, 163, 144)',
    color: 'white',
    borderRadius: 5,
    border: 'none',
    marginTop: 10,
  },
}

export default Signin
