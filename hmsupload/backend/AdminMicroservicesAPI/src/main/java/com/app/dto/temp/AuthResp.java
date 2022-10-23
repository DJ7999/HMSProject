package com.app.dto.temp;


	public class AuthResp {
		private String message;
		private String jwt;
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
		@Override
		public String toString() {
			return "AuthResp [message=" + message + ", jwt=" + jwt + "]";
		}
		public AuthResp() {
			super();
			// TODO Auto-generated constructor stub
		}
		public AuthResp(String message, String jwt) {
			super();
			this.message = message;
			this.jwt = jwt;
		}
	}

