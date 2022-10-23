import { useNavigate } from 'react-router-dom'
import {useLocation} from "react-router-dom";
import axios from "axios";
const Invoice = () => {
    const navigate = useNavigate();
    const location = useLocation();
    
    const invoicedetails=location.state.data
    const appointment=invoicedetails.appointmentId
    const admit=invoicedetails.admintId
    var toshow=true
    if(invoicedetails.admintId==null){
      toshow=false
    }
    console.log("i am in ")
    console.log(location.state.data);
    
    const invoice = () => {
        
    
        var config = {
          method: 'get',
          url: 'http://ec2-3-110-160-156.ap-south-1.compute.amazonaws.com:8084/hms/accountant/update?billId='+invoicedetails.billId,
          headers: { 
            'Authorization': 'Bearer '+sessionStorage.getItem('token'), 
            }
        };
        
        axios(config)
        .then(function (response) {
          console.log(JSON.stringify(response.data));
          navigate('/invoiceList')
        })
        .catch(function (error) {
          console.log(error);
        });
        
    }
    return ( 
       
        <div  Style="box-shadow: 0px 0px 10px gray;margin-Top: 50px; margin-left:100px; padding: 10px; margin-right:100px; justifyContent:center">
            <h3 style={styles.h3}>Invoice</h3>
            <div style={{}} >
            <table className="table table-bordered ">
                    <tr><td Style="width:30%; text-align:left"><label>Name</label></td>
                    <td Style="width:10%; ">:</td>
                    <td>{invoicedetails.appointmentId.patientId.name}
.</td>
</tr>
                    
                    <tr><td Style="width:30%; text-align:left"><label>Mobile</label></td><td Style="width:10%;">:</td><td>{invoicedetails.appointmentId.patientId.mobileNo
}</td></tr>
                    <tr><td Style="width:30%; text-align:left"><label>Address</label></td><td Style="width:10%;">:</td><td>{invoicedetails.appointmentId.patientId.address}</td></tr>
                  </table>
                  <div className='mb-3'>
                <label>Payment Status</label>
                <div class="input-group">
                    {invoicedetails.payementStatus}                
                </div>
            </div>
            <div>
            <table className="table">
      <thead className="table table-striped">
      <tr>
      
      <th scope="col">Charges Type</th>
      <th scope="col">Charges(Rs.)</th>
    </tr>
  </thead>
  <tbody>
    <label>appointment details</label>
    
    <tr>
      
      <td>Doctor Charges</td>
      <td>{invoicedetails.appointmentId.cost}</td>
    </tr>
    {toshow?<><label>Room charges per day</label>
    <h6>Room cost : </h6>{admit.roomId.costPerday}</>
    :null}
    {/* {invoicedetails.appointmentId.medicines.map((med)=>{<tr>
      
      <td></td>
      <td>{meds
}</td></tr>})} */}
    
    
    
    <tr>
      <th scope="row"></th>
      <td>Total</td>
            <td>{invoicedetails.cost}</td>
            </tr>
        </tbody>
        </table>
            </div>
            <button onClick={() => {invoice();console.log("clicked here")}} className="btn_style" >
          Update
        </button>
            </div>
      
        </div>
    )
}

const styles = {
    Button: {
      position: 'relative',
      width: '30%',
      height: 40,
      backgroundColor: '#db0f62',
      color: 'white',
      borderRadius: 5,
      border: 'none',
      marginTop: 10,
    },
    h3: {
        textAlign: "center",
        margin: 20,
      },
  }
  
export default Invoice