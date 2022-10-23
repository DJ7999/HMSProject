import { BrowserRouter, Routes, Route, useLocation } from "react-router-dom";
import "./App.css";
import AddNewPatient from "./pages/receptionist/addNewPatient";
import EditPatient from "./pages/receptionist/editPatient";
import Signin from "./pages/signin";
import ViewPatient from "./pages/receptionist/viewPatient";
import CreateAppointment from "./pages/receptionist/createAppointment";
import ViewAllAppointment from "./pages/receptionist/viewAllAppointment"
import Invoice from "./pages/accountant/invoice";
import InvoiceList from "./pages/accountant/invoiceList";
import AppointmentList from "./pages/doctor/appointmentList";
import Appointments from "./pages/doctor/appointments";
import ViewEmployee from "./pages/admin/viewemp";
import AddEmployee from "./pages/admin/addemp";
import AdmitForm from "./pages/doctor/admitform";
import Sidebar from "./components/sidebar";
import Navbar from "./components/navbar";
import DeleteEmployee from "./pages/admin/delemp";
import EditEmployee from "./pages/admin/editemp";

// this toastr container will be used to show the toast messages
import { ToastContainer } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'

function App() {
  const location = useLocation();
  return (
    <>
          <header><Navbar /></header>
        <div className="overflow-auto" Style=" flex: 120%; max-height:100vh ;">
          <div>         
      <div Style="display: flex;">
        {location.pathname !== "/" ? (
          
          <div Style=" flex">
            <header>
              <Sidebar />
            </header>
          </div>
        ) : null}

          <Routes>
            <Route path="/" element={<Signin />} />
            <Route path="/addNewPatient" element={<AddNewPatient />} />
            <Route path="/editPatient" element={<EditPatient />} />
            <Route path="/viewPatient" element={<ViewPatient />} />
            <Route path="/createAppointment" element={<CreateAppointment />} />
            <Route path="/viewAllAppointment" element={<ViewAllAppointment />}/>
            <Route path="/invoice" element={<Invoice />} />
            <Route path="/invoiceList" element={<InvoiceList />} />
            <Route path="/appointmentList" element={<AppointmentList />} />
            <Route path="/appointments" element={<Appointments />} />
            <Route path="/viewemp" element={<ViewEmployee />} />
            <Route path="/addemp" element={<AddEmployee />} />
            <Route path="/admitform" element={<AdmitForm />} />
            <Route path="/delemp" element={<DeleteEmployee/>} />
            <Route path="/editemp" element={<EditEmployee/>} />
          </Routes>
          <ToastContainer position='top-center' autoClose={1000} />
           </div>
        </div>
      </div>
    </>
  );
}

export default App;
