import { useNavigate } from 'react-router-dom'
import { useState ,useEffect} from "react";
import axios from "axios";
import { Modal, ModalBody, ModalHeader } from "reactstrap";

const InvoiceList = () => {


  const [modal, setModal] = useState(false);
  const [invoice, setInvoice] = useState([]);
  const [searchData, setSearchData] = useState("")

  // load the patients as soon as the component gets loaded successfully
  useEffect(() => {   
    var config = {
      method: 'get',
      url: 'http://ec2-3-110-160-156.ap-south-1.compute.amazonaws.com:8084/hms/accountant/bill',
      headers: { 
        'Authorization': 'Bearer '+sessionStorage.getItem('token')
      }
    };
    
    axios(config)
    .then(function (response) {
      console.log(response.data);
      setInvoice(response.data)
      
      
    })
    .catch(function (error) {
      console.log(error);
    });
    
  }, [])

  const navigate = useNavigate();
    
  const invoiceList = (inv) => {
      navigate('/invoice',{state:{data:inv}})
  }

    return (
        <div className="container">
       
  
        
        <button  className="btn_style" style={{ marginTop:30 ,marginLeft:900}}  onClick={()=>{
            navigate('/')
        }}>
          Logout
        </button>

        <h3 style={styles.h3}>Display patient invoice</h3>

        
  
        <table class="datatable table table-striped table-bordered">
          <thead>
            <tr>
              <th>Patient Id</th>
              <th>Name</th>
              <th>Payment Status</th>
              <th>Details</th>
            </tr>
          </thead>
          <tbody>

          {invoice.filter((inv) => {
            if (inv.payementStatus=="unpaid") {
              return inv
            } 
            



          }).map((invoice) => {
                  return ( 
            <tr>
               <td>{invoice.billId}</td> 
              <td>{invoice.appointmentId.patientId.name}</td>
              <td>{invoice.payementStatus}</td>
        
              <td>              
                <button onClick={() => invoiceList(invoice)} className="btn_style">
                 Invoice
                </button>
              </td>
            </tr>
             )
                })} 
          </tbody>
        </table>
      </div>
    );
  };
  
  const styles = {
    h3: {
      textAlign: "center",
      margin: 20,
    },
    button: {
      marginRight: 10,
    },
  };
    


export default InvoiceList