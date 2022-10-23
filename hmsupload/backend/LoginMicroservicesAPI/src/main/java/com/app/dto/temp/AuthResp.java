package com.app.dto.temp;


	public class AuthResp {
		private String message;
		private String jwt;
		private Long deptId;
		private Long empId;
		@Override
		public String toString() {
			return "AuthResp [message=" + message + ", jwt=" + jwt + ", deptId=" + deptId + ", empId=" + empId + "]";
		}
		public AuthResp() {
			super();
			// TODO Auto-generated constructor stub
		}
		public AuthResp(String message, String jwt, Long deptId, Long empId) {
			super();
			this.message = message;
			this.jwt = jwt;
			this.deptId = deptId;
			this.empId = empId;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getJwt() {
			return jwt;
		}
		public void setJwt(String jwt) {
			this.jwt = jwt;
		}
		public Long getDeptId() {
			return deptId;
		}
		public void setDeptId(Long deptId) {
			this.deptId = deptId;
		}
		public Long getEmpId() {
			return empId;
		}
		public void setEmpId(Long empId) {
			this.empId = empId;
		}
		
		
	}

