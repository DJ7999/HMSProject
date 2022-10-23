// import { useNavigate } from "react-router-dom";

// const DeleteEmployee = (prop) => {
//     const navigate= useNavigate();

//     return (          
    
//         <div>
//             <div className="container" Style=" margin-Top: 15vh ;padding:10px">            
//             <div style={{marginBottom:10}}><h2 style={{textAlign:"center"}}>Delete an employee</h2></div>
//               <div >
//                 <div>
//                    <div className='mb-3'>
//                         <label><b>Employee Id</b></label>
//                         <input                    
//                             type="number"
//                             className='form-control'>
//                                 </input>
//                     </div>

//                     <div className='mb-3' >
//                         <div>
//               <label Style="margin-right:30px"><b>Department</b></label>

//                         </div>
//               <div class="form-check form-check-inline">
//                   <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1"></input>
//                   <label class="form-check-label" for="inlineRadio1" >Doctor</label>
//               </div>
//               <div class="form-check form-check-inline">
//                   <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"></input>
//                   <label class="form-check-label" for="inlineRadio2">Admin</label>
//               </div>
//               <div class="form-check form-check-inline">
//                   <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"></input>
//                   <label class="form-check-label" for="inlineRadio2">Accountant</label>
//               </div>
//               <div class="form-check form-check-inline">
//                   <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"></input>
//                   <label class="form-check-label" for="inlineRadio2">Receptionist</label>
//               </div>
//           </div>
                    
                    
                
//                     <div class="text-center">
//                          <button type="button"  className="btn_style" onClick={()=>{
//                             window.alert("Employee deleted successfully");
//                             navigate('/viewemp')
//                          }}>Delete Employee</button>
//                     </div>
//                 </div> 
//               </div>
//             </div>
//   </div>
//           );
//   };
  
  
//   const styles = {
//       h3: {
//         textAlign: "center",
//         margin: 20,
//       },
//       button: {
//         marginRight: 10,        
//         textAlign:"center",
//         justifyContent:"center" ,      
//       },
  
//       container:{
//           left: "9px",
//           top: "5px",
//           width: "5px",
//           height: "10px",
//           border: "solid white",
//           borderWidth:" 0 3px 3px 0",
    
//         }
//     };
  
//   export default DeleteEmployee;
  