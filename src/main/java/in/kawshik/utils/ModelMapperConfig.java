package in.kawshik.utils;

//package in.kawshik.config;

	import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.kawshik.dto.UserDto;
import in.kawshik.entity.User;

	@Configuration
	public class ModelMapperConfig {

//	    @Bean
//	    public ModelMapper modelMapper() {
//	    	 ModelMapper modelMapper = new ModelMapper();
//
//	         // Specify mappings for ambiguous properties
//	         modelMapper.typeMap(User.class, UserDto.class)
//	         .addMapping(user -> user.getState().getStateName(), UserDto::setState)
//             .addMapping(user -> user.getCity().getCityName(), UserDto::setCity)
//             .addMapping(user -> user.getCountry().getCountryName(), UserDto::setCountry);
//	         
///
//	         return modelMapper;
//	    }
	}

