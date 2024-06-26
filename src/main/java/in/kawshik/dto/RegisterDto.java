package in.kawshik.dto;

import in.kawshik.entity.CityTable;
import in.kawshik.entity.CountryTable;
import in.kawshik.entity.StateTable;


public class RegisterDto {
	
	
   private String name;
	
	
	private String email;
	
	
	private String pwd;
	
	
	private Long phno;
	
    private Integer country;
    
    private Integer state;
    
 
    private Integer city;


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


	/**
	 * @return the country
	 */
	public Integer getCountry() {
		return country;
	}


	/**
	 * @param country the country to set
	 */
	public void setCountry(Integer country) {
		this.country = country;
	}


	/**
	 * @return the state
	 */
	public Integer getState() {
		return state;
	}


	/**
	 * @param state the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}


	/**
	 * @return the city
	 */
	public Integer getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(Integer city) {
		this.city = city;
	}


	

}
