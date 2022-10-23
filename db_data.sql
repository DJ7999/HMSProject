use hospital_management;
insert into room (room_type,cost_per_day) values("ordinary",1000);
insert into room (room_type,cost_per_day) values("AC",3000);
insert into room (room_type,cost_per_day) values("ICU",10000);
insert into room (room_type,cost_per_day) values("ordinary",1000);
insert into room (room_type,cost_per_day) values("AC",3000);
insert into room (room_type,cost_per_day) values("ICU",10000);
insert into room (room_type,cost_per_day) values("ordinary",1000);
insert into room (room_type,cost_per_day) values("AC",3000);
insert into room (room_type,cost_per_day) values("ICU",10000);

insert into patient(p_name,birth_date,address,mobile_no,password) values('nikhil','1999-11-18','pune','9378526598','nikhil123');
insert into patient(p_name,birth_date,address,mobile_no,password) values('Rohit','1999-9-7','jalgaon','9834490567','ROhit123');
insert into patient(p_name,birth_date,address,mobile_no,password) values('samay','1979-5-18','kashmira','7896541278','samay123');
insert into patient(p_name,birth_date,address,mobile_no,password) values('samiksha','1989-9-12','kolhaapur','7412589630','samiksha123');
insert into patient(p_name,birth_date,address,mobile_no,password) values('pratik','1993-12-1','pune','9810505221','pratik123');
insert into patient(p_name,birth_date,address,mobile_no,password) values('swati','1995-4-01','pimpri','9810505226','swati123');
insert into patient(p_name,birth_date,address,mobile_no,password) values('soham','1995-4-01','pimpri','9819505226','soham123');
insert into patient(p_name,birth_date,address,mobile_no,password) values('manoj','1991-1-15','kate puram pune','9075436010','manoj123');
insert into patient(p_name,birth_date,address,mobile_no,password) values('sagar','1993-12-21','sangvi pune','9475436018','sagar123');
insert into patient(p_name,birth_date,address,mobile_no,password) values('sonal','1988-07-21','sangvi pune','9075436018','sagar123');

insert into department(dept_name) values ('Doctor');
insert into department(dept_name) values ('Admin');
insert into department(dept_name) values ('Accountant');
insert into department(dept_name) values ('Receptionist');

Insert into test(test_name,price) values('X-Ray',500);
Insert into test(test_name,price) values('Blood',200);
Insert into test(test_name,price) values('CT-Scan',2500);
Insert into test(test_name,price) values('MRI',9000);
Insert into test(test_name,price) values('URINE',400);
Insert into test(test_name,price) values('Dengue IgG',1800);
Insert into test(test_name,price) values('Liver',600);
Insert into test(test_name,price) values('Lipid',500);
Insert into test(test_name,price) values('Thyroid',800);
Insert into test(test_name,price) values('Diabetes',150); 
Insert into test(test_name,price) values('RT-PCR',900); 


Insert into medicine(medicine_name,price) values('Paracetamol',50); 
Insert into medicine(medicine_name,price) values('Testerone',649); 
Insert into medicine(medicine_name,price) values('Go365',818); 
Insert into medicine(medicine_name,price) values('Methycobal',91); 
Insert into medicine(medicine_name,price) values('Bestozyme',48); 
Insert into medicine(medicine_name,price) values('DailyCal-HD',56); 
Insert into medicine(medicine_name,price) values('One-Up Gold',55); 
Insert into medicine(medicine_name,price) values('Himalaya',72); 
Insert into medicine(medicine_name,price) values('Vitamin E Softgel',100); 
Insert into medicine(medicine_name,price) values('Tramadol 50 mg',500); 
Insert into medicine(medicine_name,price) values('Paclitaxel 100mg ',1250);
Insert into medicine(medicine_name,price) values('Amoxycillin 250mg',550); 
Insert into medicine(medicine_name,price) values('Ceftriaxone 1000mg',750); 
Insert into medicine(medicine_name,price) values('Doxycycline',200);
Insert into medicine(medicine_name,price) values('Ofloxacin 400 mg',700);

insert into employee (emp_name,birth_date,address,mobile_no,password,dept_id) values("Reshma","1993-12-21","pune","9075436018","Reshma123",1);
insert into employee (emp_name,birth_date,address,mobile_no,password,dept_id) values("vaibhav","1990-7-12","jalgaon","9425636018","vaibhav123",1);
insert into employee (emp_name,birth_date,address,mobile_no,password,dept_id) values("suyash","1998-4-30","kolhapur","8421962601","suyash123",3);
insert into employee (emp_name,birth_date,address,mobile_no,password,dept_id) values("Rohit","1999-9-7","jalgaon","9834490567","ROhit123",4);
insert into employee (emp_name,birth_date,address,mobile_no,password,dept_id) values("sachin","1996-4-23","Uk","8859550031","sachin123",2);