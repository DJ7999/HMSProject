import { useNavigate } from "react-router-dom";
import { useState } from "react";
import { Modal, ModalBody, ModalHeader, Placeholder } from "reactstrap";
import EditEmployee from "./editemp";
import axios from "axios";
import { useEffect } from "react";


const ViewEmployee = () => {
  const navigate = useNavigate();
  const [modal, setModal] = useState(false);
  const [employee, setEmployee] = useState([]);
  const [searchData, setSearchData] = useState("")
  useEffect(() => {
    var config = {
      method: 'get',
      url: 'http://ec2-13-234-32-167.ap-south-1.compute.amazonaws.com:8081/hms/admin/getAllEmployees',
      headers: {
        'Authorization': 'Bearer ' + sessionStorage.getItem('token')
      }
    };

    axios(config)
      .then(function (response) {
        console.log(JSON.stringify(response.data));
        setEmployee(response.data)
      })
      .catch(function (error) {
        console.log(error);
      });

  }, [])

  //edit emp

  const editEmp = (id) => {
    navigate('/editemp', { state: { empId: id } })
  }
  return (
    <div className="container">
      <h3 style={styles.h3}>All Employees</h3>


      <button onClick={() => {
        navigate('/addemp')
      }} className="btn_style" >
        Add new employee
      </button>

      <button onClick={() => {
        navigate('/')

      }} className="btn_style" style={{ marginLeft: 800 }} >
        Logout
      </button>


      <form className="form-inline d-flex justify-content-end my-4">
        <input
          className="mr-md-2"
          style={{border:"solid", borderColor:" rgba(5, 163, 144)", backgroundColor:" rgba(5, 163, 144,0.3)",Color:"white"}}
          type="search"
          placeholder="Search employee"
          aria-label="Search"
          onChange={(e) => {
            setSearchData(e.target.value)
          }}
        />

      </form>
      {/* <button className="btn_style" type="submit">
          Search
        </button> */}


      <table className="table table-striped ">
        <thead>
          <tr>
            <th>Employee Id</th>
            <th>Name</th>
            <th>Birth Date</th>
            <th>Address</th>
            <th>Mobile No.</th>
            <th>Dept Name</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {employee.filter((employee) => {
            if (searchData == "") {
              return employee
            } else if (employee.empName.toLowerCase().includes(searchData.toLowerCase())) {
              return employee
            }



          }).map((employee) => {


            return (
              <tr>

                <td>{employee.empId}</td>
                <td>{employee.empName}</td>
                <td>{employee.birthDate}</td>
                <td>{employee.address}</td>
                <td>{employee.mobileNo}</td>
                <td>{employee.deptId.deptName}</td>
                <td>{employee.empStatus}</td>


                <td>
                  <button
                    id="edit"
                    className="btn_style"
                    onClick={() => editEmp(employee.empId)}
                    data-toggle="modal"
                    data-target="#exampleModal"
                  >
                    Edit
                  </button>
                  {/* <button  className="btn_style"
                  onClick={()=>{
                    navigate('/delemp')
                  }}
                  
                  >
                  Delete
                </button> */}
                </td>
              </tr>


            );
          })}

        </tbody>
      </table>



      {/* <Modal
          size="md"
        isOpen={modal}
        toggle={() => {
          setModal(!modal);
        }}
      >
        <ModalHeader
          toggle={() => {
            setModal(!modal);
          }}
        ></ModalHeader>
        <ModalBody>         
          <EditEmployee/>
          
        </ModalBody>

      </Modal> */}


    </div>
  );
};

const styles = {
  h3: {
    textAlign: "center",
    margin: 40,
  },

};

export default ViewEmployee;