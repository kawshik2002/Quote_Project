package in.kawshik.service;

import java.util.Map;

import in.kawshik.dto.LoginDto;
import in.kawshik.dto.RegisterDto;
import in.kawshik.dto.ResetPwdDto;
import in.kawshik.dto.UserDto;
import in.kawshik.entity.User;

public interface IUserService {
	
	public Map<Integer,String> getCountries();

	public Map<Integer,String> getStates(Integer cid);

	public Map<Integer,String> getCities(Integer sid);

	public UserDto getUser(String email);

	public boolean registerUser(RegisterDto regDto);

	public UserDto getUser(LoginDto loginDto);

	public boolean resetPwd(ResetPwdDto pwdDto);

	public String getQuote(); // api-call

}
