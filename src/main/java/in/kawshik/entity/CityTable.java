package in.kawshik.entity;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="cityTable")
public class CityTable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cityId;
	
	
	
	private String cityName;
	
	@ManyToOne
	@JoinColumn(name="state_id")
	private StateTable stateId;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public StateTable getStateId() {
		return stateId;
	}

	public void setStateId(StateTable stateId) {
		this.stateId = stateId;
	}

	

	
	

	
	
}
