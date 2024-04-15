package in.kawshik.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

//import org.hibernate.mapping.Map;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.kawshik.dto.LoginDto;
import in.kawshik.dto.QuotesDto;
import in.kawshik.dto.RegisterDto;
import in.kawshik.dto.ResetPwdDto;
import in.kawshik.dto.UserDto;
import in.kawshik.entity.CityTable;
import in.kawshik.entity.CountryTable;
import in.kawshik.entity.StateTable;
import in.kawshik.entity.User;
import in.kawshik.repo.CityRepo;
import in.kawshik.repo.CountryRepo;
import in.kawshik.repo.StateRepo;
import in.kawshik.repo.UserDtlsRepo;
import in.kawshik.utils.EmailSender;
import in.kawshik.utils.PasswordGen;
import jakarta.mail.MessagingException;

@Service
public class UserServiceImpl implements IUserService {
	
	
	@Autowired
	private CityRepo cityRepo;
	
	@Autowired
	private CountryRepo countryRepo;
	
	@Autowired
	private UserDtlsRepo userRepo;
	
	@Autowired
	private StateRepo stateRepo;
	
	@Autowired
	private EmailSender emailUtils;

	@Override
	public Map<Integer, String> getCountries() {
		
		Map<Integer, String> cHashMap = new HashMap();
		
		countryRepo.findAll().forEach(c->{
			cHashMap.put(c.getCountryId(),c.getCountryName());
		});
		
		
		return cHashMap;
	}

	@Override
	public Map<Integer, String> getStates(Integer cid) {
	
		Map<Integer, String> sHashMap = new HashMap();
		List<StateTable> states = stateRepo.getStates(cid);
		states.forEach(s->{
			sHashMap.put(s.getStateId(), s.getStateName());
		});
		
		
		return sHashMap;
	}

	@Override
	public Map<Integer, String> getCities(Integer sid) {
		Map<Integer, String> cHashMap = new HashMap();
		List<CityTable> cities = cityRepo.getCities(sid);
		cities.forEach(c->{
			cHashMap.put(c.getCityId(),c.getCityName());
		});
		
		
		return cHashMap;
	}
	
	
	
	@Override
	public UserDto getUser(String email) {
		User user = userRepo.findByEmail(email);	
		ModelMapper map = new ModelMapper();
		UserDto userDto = map.map(user,UserDto.class);
		
		return userDto;
		
	}
	
	


//	
	

	@Override
	public boolean registerUser(RegisterDto regDto){
		
		
		
		
		ModelMapper model = new ModelMapper();
		User user = model.map(regDto, User.class);
		CountryTable country = countryRepo.findById(regDto.getCountry()).orElseThrow();
		StateTable state = stateRepo.findById(regDto.getState()).orElseThrow();
		CityTable city = cityRepo.findById(regDto.getCity()).orElseThrow();
		
		
		user.setCountry(country);
		user.setState(state);
		user.setCity(city);
		
		user.setPwd(PasswordGen.getRandomString());
		user.setPwdUpdate(false);
		
		User save = userRepo.save(user);
		
		String subject ="User Registration";
		String body ="Your Temperary Pwd is "+user.getPwd();
		
//			EmailSender emailSender = new EmailSender();
			try {
				emailUtils.sendSimpleMessage(user.getEmail(), body, subject);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		return user.getUserId()!=null;
		
	}

	@Override
	public UserDto getUser(LoginDto loginDto) {
		User user = userRepo.findByEmailAndPwd(loginDto.getEmail(),loginDto.getPwd());
		
		if(user==null) {
			return null;
		}
		
//		ModelMapper model = new ModelMapper();
		 ModelMapper modelMapper = new ModelMapper();
		 
		UserDto map = modelMapper.map(user, UserDto.class);
		
		return map;
		
	}

	@Override
	public boolean resetPwd(ResetPwdDto pwdDto) {
		
		 

	        // Fetch user from database
	        User user = userRepo.findByEmailAndPwd(pwdDto.getEmail(),pwdDto.getOldPwd());
	       
	        if (user!=null) {
	        	user.setPwdUpdate(true);
	        	user.setPwd(pwdDto.getNewPwd());
	        	userRepo.save(user);
	            return true; // User not found
	        }

	    

	        return false;
	    }
//	
	


	@Override
	public String getQuote() {
		
	
		QuotesDto[] quotes=null;
		
		String url="https://type.fit/api/quotes";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> forEntity = restTemplate.getForEntity(url,String.class);
		
		String body = forEntity.getBody();
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			quotes = objectMapper.readValue(body, QuotesDto[].class);
			
		
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed to retrive quote";
		}
		
		Random r = new Random();
		int nextInt = r.nextInt(quotes.length - 1);
		return quotes[nextInt].getText();

	}

	





	

}
