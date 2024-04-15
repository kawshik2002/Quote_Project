package in.kawshik.controller;

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
import in.kawshik.service.IUserService;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	
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
		
		boolean registerUser = userService.registerUser(regDto);
		if(registerUser) {
			m.addAttribute("smsg", "Registration Succesfull");
			return "redirect:/";
		}else {
			m.addAttribute("emsg", "Something went wrong");
		}
		
//		m.addAttribute("userObj", new User());
		
		return "register";
	}
	
	@GetMapping("/")
	public String loginPage(Model model) {
		
		model.addAttribute("loginObj", new LoginDto());
		
		return "index";
	}

	@PostMapping("/login")
	public String login(LoginDto loginDto, Model model) {
		
		UserDto user = userService.getUser(loginDto);
		
		if(user==null) {
			model.addAttribute("emsg", "Something went wrong");
			return "index";
		}
		
			if(user.isPwdUpdated()) {
				return "redirect:dashboard";
			}else if(!user.isPwdUpdated()) {
				ResetPwdDto formObj = new ResetPwdDto();
				formObj.setEmail(user.getEmail());
				model.addAttribute("resetObj", formObj);
				return "resetPassword";
			
		}
		return "index";
	}

	@PostMapping("/resetPwd")
	public String resetPwd(@ModelAttribute("resetObj")ResetPwdDto pwdDto,Model m) {
		if(!(pwdDto.getConPwd().equals(pwdDto.getNewPwd()))){
			m.addAttribute("emsg", "confirm Password and new password  must be some ");
			return "resetPassword";
		}
		UserDto user = userService.getUser(pwdDto.getEmail());
		if(user!=null&& user.getPwd().equals(pwdDto.getOldPwd())) {
			boolean resetPwd = userService.resetPwd(pwdDto);
			if(resetPwd) {
				return "redirect:dashboard";
			}else {
			m.addAttribute("emsg", "Something went wrong");
			return "resetPassword";
		}
		}else {
			m.addAttribute("emsg", "Something went wrong");
			return "resetPassword";
		}
		
	}

	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		String quote=userService.getQuote();
		if(quote!=null && !quote.isEmpty()) {
			model.addAttribute("quote", quote);
		}else {
			model.addAttribute("emsg", "Failed to retirev a quote");
		}
		
		return "dashboard";
	}

	@GetMapping("/login")
	public String logout() {
		return "redirect:/";
	}

}
