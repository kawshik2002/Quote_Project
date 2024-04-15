package in.kawshik.utils;

//package in.kawshik.config;

	import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.kawshik.dto.UserDto;
import in.kawshik.entity.User;

	@Configuration
	public class ModelMapperConfig {

	    @Bean
	    public ModelMapper modelMapper() {
	    	 ModelMapper modelMapper = new ModelMapper();
//	    	 
	    	 modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//	    	 
//	    	
	    	 
//	    	 
//	    	 modelMapper.typeMap(User.class, UserDto.class)
//	    	    .addMapping(User::getState, (userDto, value) -> userDto.setState((Integer) value))
//	    	    .addMapping(User::getCountry, (userDto, value) -> userDto.setCountry((Integer) value))
//	    	    .addMapping(User::getCity, (userDto, value) -> userDto.setCity((Integer) value));

	    	 
	    	 
//	    	 modelMapper.typeMap(User.class, UserDto.class)
//	         .addMapping(User::getState, UserDto::setState, context -> {
//	           // Check if StateName exists, otherwise use StateId (assuming fallback logic)
//	           if (context.getSource() != null && context.getSource().getState() != null) {
//	             return context.getSource().getState().getStateName();
//	           } else {
//	             return null; // Or provide a default value if applicable
//	           }
//	         })
//	         .addMapping(User::getCountry, UserDto::setCountry, context -> {
//	           // Similar logic for CountryName fallback to CountryId
//	           if (context.getSource() != null && context.getSource().getCountry() != null) {
//	             return context.getSource().getCountry().getCountryName();
//	           } else {
//	             return null;
//	           }
//	         })
//	         .addMapping(User::getCity, UserDto::setCity, context -> {
//	           // Similar logic for CityName fallback to CityId
//	           if (context.getSource() != null && context.getSource().getCity() != null) {
//	             return context.getSource().getCity().getCityName();
//	           } else {
//	             return null;
//	           }
//	         });
//
//	         // Specify mappings for ambiguous properties
//	         modelMapper.typeMap(User.class, UserDto.class)
//	         .addMapping(User -> User.getState().getStateName(), UserDto::setState)
//             .addMapping(User -> User.getCity().getCityName(), UserDto::setCity)
//             .addMapping(User -> User.getCountry().getCountryName(), UserDto::setCountry);
	         
//	    	 	modelMapper.typeMap(User.class, UserDto.class)
//	            .addMapping(User::getState, UserDto::setState)
//	            .addMapping(User::getCity, UserDto::setCity)
//	            .addMapping(User::getCountry, UserDto::setCountry);

	    	 
	         return modelMapper;
	    }
	}
	

