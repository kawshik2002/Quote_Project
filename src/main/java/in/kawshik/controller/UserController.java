package in.kawshik.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import in.kawshik.dto.LoginDto;
import in.kawshik.dto.RegisterDto;
import in.kawshik.dto.ResetPwdDto;
import in.kawshik.dto.UserDto;
import in.kawshik.entity.User;
import in.kawshik.repo.CountryRepo;
import in.kawshik.service.IUserService;
import in.kawshik.utils.AppConstants;
import in.kawshik.utils.AppProperties;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private AppProperties props;
	
	
	@GetMapping("/register")
	public String registerPage(Model model) {
		
		model.addAttribute("regObj", new User());
//		model.addAttribute("countries", userService.getCountries());
		model.addAttribute("country", userService.getCountries());
		
		return "register";
	}

	@GetMapping("/states/{cid}")
	@ResponseBody
	public Map<Integer, String> getStates(@PathVariable("cid") Integer cid){
		
		return userService.getStates(cid);
	}

	@GetMapping("/cities/{sid}")
	@ResponseBody
	public Map<Integer, String> getCities(@PathVariable("sid") Integer sid){
		return userService.getCities(sid);
	}

	@PostMapping("/register")
	public String register(User u,RegisterDto regDto,Model m) {
		
//		m.addAttribute("countries", userService.getCountries());
		
		Map<String,String> messages=props.getMessages();
		
		boolean registerUser = userService.registerUser(regDto);
		if(registerUser) {
			m.addAttribute(AppConstants.SUCC_MSG, messages.get("succMsg"));
			return "redirect:/";
		}else {
			m.addAttribute(AppConstants.ERROR_MSG, messages.get("eMsg"));
		}
		
//		m.addAttribute("userObj", new User());
		
		return AppConstants.REGISTER_VIEW;
	}
	
	@GetMapping("/")
	public String loginPage(Model model) {
		
		model.addAttribute(AppConstants.LOGIN_OBJ, new LoginDto());
		
		return AppConstants.LOGIN_VIEW;
	}

	@PostMapping("/login")
	public String login(LoginDto loginDto, Model model) {
		Map<String,String> messages=props.getMessages();
		
		UserDto user = userService.getUser(loginDto);
		
		if(user==null) {
			model.addAttribute(AppConstants.ERROR_MSG,messages.get("eMsg"));
			return AppConstants.LOGIN_VIEW;
		}
		
			if(user.isPwdUpdated()==false) {
				return AppConstants.DASHBOARD_VIEW;
			}else if(!user.isPwdUpdated()) {
				ResetPwdDto formObj = new ResetPwdDto();
				formObj.setEmail(user.getEmail());
				model.addAttribute(AppConstants.RESET_OBJ, formObj);
				return AppConstants.RESETPASSWORD_VIEW;
			
		}
		return AppConstants.LOGIN_VIEW;
	}

	@PostMapping("/resetPwd")
	public String resetPwd(@ModelAttribute(AppConstants.RESET_OBJ)ResetPwdDto pwdDto,Model m) {
		Map<String,String> messages=props.getMessages();
		
		if(!(pwdDto.getConPwd().equals(pwdDto.getNewPwd()))){
			m.addAttribute(AppConstants.ERROR_MSG, messages.get("passMissMatch"));
			return AppConstants.RESETPASSWORD_VIEW;
		}
		UserDto user = userService.getUser(pwdDto.getEmail());
		if(user!=null&& user.getPwd().equals(pwdDto.getOldPwd())) {
			boolean resetPwd = userService.resetPwd(pwdDto);
			if(resetPwd) {
				return "redirect:dashboard";
			}else {
			m.addAttribute(AppConstants.ERROR_MSG, messages.get("eMsg"));
			return AppConstants.RESETPASSWORD_VIEW;
		}
		}else {
			m.addAttribute(AppConstants.ERROR_MSG, messages.get("eMsg"));
			return AppConstants.RESETPASSWORD_VIEW;
		}
		
	}

	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		Map<String,String> messages=props.getMessages();
		String quote=userService.getQuote();
		if(quote!=null && !quote.isEmpty()) {
			model.addAttribute("quote", quote);
		}else {
			model.addAttribute(AppConstants.ERROR_MSG, messages.get("quoteError"));
		}
		
		return AppConstants.DASHBOARD_VIEW;
	}

	@GetMapping("/login")
	public String logout() {
		return "redirect:/";
	}

}
