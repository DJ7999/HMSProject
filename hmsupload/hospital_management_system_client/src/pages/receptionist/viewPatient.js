import { useNavigate} from "react-router-dom";
import { useState ,useEffect} from "react";
import axios from "axios";


const ViewPatient = () => {
  const [name, setName] = useState('');
  const [patient, setPatient] = useState([]);
  
  const navigate = useNavigate();

  
  // load the patients as soon as the component gets loaded successfully
  useEffect(() => {   
    var config = {
      method:'get' ,     
      url: 'http://ec2-13-127-123-146.ap-south-1.compute.amazonaws.com:8082/hms/receptionist/getAllPatients',
      headers: { 
        'Authorization': 'Bearer '+sessionStorage.getItem('token')
      }
    };
    
    axios(config)
    .then(function (response) {     
      setPatient(response.data)      
    })
    .catch(function (error) {
      console.log(error);
    });
    
  }, [])  

  return (
    <div className="container" >
      <div>
        <h1 style={styles.h3}>All patient</h1>
      </div>
      
      <div >
    <div>
      <button className="btn_style"  onClick={()=>{
                          navigate('/addNewPatient')
                        }}>
        Add new patient
      </button>

      <button className="btn_style"  style={{ marginLeft: 50 }}   onClick={()=>{
                          navigate('/viewAllAppointment')
                        }}>
        View Appointments
      </button>

      <button className="btn_style" style={{ marginLeft: 600 }}  onClick={() => {
                 navigate('/')
               }}>
        Logout
      </button>

      <div style={{ marginTop: 30,marginBottom:40}}>
        <div className="col-sm-3">                  
          <input type="text" className="form-control"  placeholder="search name" style={{border:"solid", borderColor:" rgba(5, 163, 144)", backgroundColor:" rgba(5, 163, 144,0.3)",Color:"white"}}
                        onChange={(e) => {
                        setName(e.target.value)
                      }}>                      
          </input>
        </div>
      </div>
      </div>
      </div>      

      <table
        cellpadding="0"
        cellspacing="0"
        border="0"
        class="datatable table table-striped table-bordered"
      >
        <thead>
          <tr>
            <th>Patient Id</th>
            <th>Name</th>
            <th>Birthdate</th>
            <th>Address</th>
            <th>Mobile No</th>
            <th>Details</th>
          </tr>
        </thead>
        <tbody>
          {
          patient.filter(p=>p.name.toLowerCase().includes(name.toLowerCase()))        
          .map((patient) => {
            return (
              <tr>               
                <td>{patient.patientId}</td>
                <td key={patient.patientId}>{patient.name}</td>
                <td>{patient.birthDate}</td>
                <td>{patient.address}</td>
                <td>{patient.mobileNo}</td>
                <td>                  
                  <button className="btn_style"
                   onClick={()=>{
                    navigate('/editPatient',{state:{data:patient}})
                  }}>
                     edit 
                  </button>

                  <button className="btn_style"
                        onClick={()=>{
                          navigate('/createAppointment',{state:{data:patient}})
                        }}>                 
                    Appointement
                  </button>
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

const styles = {
  h3: {
    textAlign: "center",
    margin: 30,
  },
  
};

export default ViewPatient;