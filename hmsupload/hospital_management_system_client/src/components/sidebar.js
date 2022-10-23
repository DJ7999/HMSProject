import { useState } from "react";
import { ProSidebar, Menu, MenuItem, SubMenu } from "react-pro-sidebar";
import "react-pro-sidebar/dist/css/styles.css";
import { Link } from "react-router-dom";
const Sidebar = () => {
  var admin= false;
  var doctor= false;
  var receptionist= false;
  var accountant= false;
  

  
 
  if(sessionStorage.getItem('deptId')==1)
  {
    admin=true;
  }
  
  if(sessionStorage.getItem('deptId')==2)
  {
    doctor= true;
  }
  if(sessionStorage.getItem('deptId')==3)
  {
    receptionist=true
  }
  if(sessionStorage.getItem('deptId')==4)
  {
   accountant=true
  }

  return (
    <div Style="">
      <ProSidebar style={{width:0}} >
        <Menu
          iconShape="square"
          Style="background-color:rgba(5, 163, 144);height: 150vh; color:white"
        >
          <div style={{textAlign:"center"}}>
            {/* <h3></h3>           */}
            </div>
          <hr style={{marginTop:-10}}></hr>
        {admin?<><MenuItem Style=""><h5>Admin</h5></MenuItem>
        <MenuItem Style=""><h5>Dashboard <Link to="viewemp"/></h5></MenuItem></>:null}

        {doctor?<MenuItem Style=""><h5>Doctor</h5></MenuItem>:null}
        {receptionist?<MenuItem Style=""><h5>Receptionist</h5></MenuItem>:null}
        {accountant?<MenuItem Style=""><h5>Accountant</h5></MenuItem>:null}
       
        </Menu>
      </ProSidebar>
    </div>
  );
};
export default Sidebar;
