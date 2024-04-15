package in.kawshik.entity;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "stateTable")
public class StateTable {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stateId;
	
	
	
	private String stateName;
	
	
	@ManyToOne
	@JoinColumn(name = "country_id")
	private CountryTable countryId;
	



	public Integer getStateId() {
		return stateId;
	}


	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}


	public String getStateName() {
		return stateName;
	}


	public void setStateName(String stateName) {
		this.stateName = stateName;
	}



	public CountryTable getCountryId() {
		return countryId;
	}


	public void setCountryId(CountryTable countryId) {
		this.countryId = countryId;
	}



	
	
	
}
