package in.kawshik.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.kawshik.entity.CityTable;


public interface CityRepo extends JpaRepository<CityTable, Integer> {
	
	
	@Query(value="select * from city_table where state_id=:sid",nativeQuery = true)
	public List<CityTable> getCities(Integer sid);

}
