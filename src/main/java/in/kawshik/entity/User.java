package in.kawshik.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	
	private String pwd;
	
	
	private Long phno;
	
	private Boolean pwdUpdate;
	
	
	@ManyToOne
    @JoinColumn(name = "country_id")
    private CountryTable country;
    
    @ManyToOne
    @JoinColumn(name = "state_id")
    private StateTable state;
    
    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityTable city;
	
	
	
	@CreationTimestamp
	private LocalDate createdDate;
	
	@UpdateTimestamp
	private LocalDate updatedDate;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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

	public boolean getPwdUpdate() {
		return pwdUpdate;
	}

	public void setPwdUpdate(Boolean pwdUpdate) {
		this.pwdUpdate = pwdUpdate;
	}

	public CountryTable getCountry() {
		return country;
	}

	public void setCountry(CountryTable country) {
		this.country = country;
	}

	public StateTable getState() {
		return state;
	}

	public void setState(StateTable state) {
		this.state = state;
	}

	public CityTable getCity() {
		return city;
	}

	public void setCity(CityTable city) {
		this.city = city;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	
	
	
	
	
}
