package in.kawshik.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.kawshik.entity.CountryTable;

public interface CountryRepo extends JpaRepository<CountryTable,Integer> {

}
