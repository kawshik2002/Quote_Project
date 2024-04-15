package in.kawshik.dto;

import in.kawshik.entity.CityTable;
import in.kawshik.entity.CountryTable;
import in.kawshik.entity.StateTable;

public class UserDto {


	
	 private String name;
		
		
		private String email;
		
		
		private String pwd;
		
		
		private Long phno;
		
	    private Integer country_id;
	    
	    private Integer state_id;
	    
	 
	    private Integer city_id;
	
	private boolean pwdUpdated;

		private String oldPwd;
		
		private String newPwd;
		
		
		private String conPwd;


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPwd() {
			return pwd;
		}


		public void setPwd(String pwd) {
			this.pwd = pwd;
		}


		public Long getPhno() {
			return phno;
		}


		public void setPhno(Long phno) {
			this.phno = phno;
		}


	


		public boolean isPwdUpdated() {
			return pwdUpdated;
		}


		public void setPwdUpdated(boolean pwdUpdated) {
			this.pwdUpdated = pwdUpdated;
		}


		public String getOldPwd() {
			return oldPwd;
		}


		public void setOldPwd(String oldPwd) {
			this.oldPwd = oldPwd;
		}


		public String getNewPwd() {
			return newPwd;
		}


		public void setNewPwd(String newPwd) {
			this.newPwd = newPwd;
		}


		public String getConPwd() {
			return conPwd;
		}


		public void setConPwd(String conPwd) {
			this.conPwd = conPwd;
		}


		/**
		 * @return the country_id
		 */
		public Integer getCountry_id() {
			return country_id;
		}


		/**
		 * @param country_id the country_id to set
		 */
		public void setCountry_id(Integer country_id) {
			this.country_id = country_id;
		}


		/**
		 * @return the state_id
		 */
		public Integer getState_id() {
			return state_id;
		}


		/**
		 * @param state_id the state_id to set
		 */
		public void setState_id(Integer state_id) {
			this.state_id = state_id;
		}


		/**
		 * @return the city_id
		 */
		public Integer getCity_id() {
			return city_id;
		}


		/**
		 * @param city_id the city_id to set
		 */
		public void setCity_id(Integer city_id) {
			this.city_id = city_id;
		}


				
		
	
		
}
