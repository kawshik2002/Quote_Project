package in.kawshik.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import in.kawshik.entity.User;

public interface UserDtlsRepo extends JpaRepository<User, Integer> {
	
	public User findByEmail(String email);

	
	
	public User findByEmailAndPwd(String email,String pwd);
}
