package in.kawshik.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import in.kawshik.entity.StateTable;

public interface StateRepo extends JpaRepository<StateTable, Integer> {

//	SELECT * FROM StatTable WHERE countryId=1;
	
	@Query(value="select * from state_table where country_id=:cid",nativeQuery = true)
	public List<StateTable> getStates(Integer cid);
}
