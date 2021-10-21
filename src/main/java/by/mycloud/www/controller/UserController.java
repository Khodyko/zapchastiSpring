package by.mycloud.www.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.mycloud.www.entity.Depo;
import by.mycloud.www.entity.Sector;
import by.mycloud.www.entity.User;
import by.mycloud.www.service.ItemService;
import by.mycloud.www.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private UserService userService;
	
	

	
	//authorization page
		@RequestMapping("loginPage")
		public String goToAuthorizationPage() {
			return "authorization";
		}
		
		
		@RequestMapping("/goToRegistration1")
		public ModelAndView goToRegistration1() {
			
			List<Depo> depoList=itemService.getDepoList();
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("registration1");
			modelAndView.addObject("depo_bd_list",depoList);
			
			System.out.println("controller:"+ depoList);
			
			return modelAndView;
		}
		
		@RequestMapping("/goToRegistration2")
		public ModelAndView goToRegistration2(@RequestParam(defaultValue = "") Depo depoUI,
				@RequestParam(defaultValue = "1") String nameUI
				) {
			System.out.println("controller nameID: "+ nameUI);
			System.out.println("controller depiID: "+ depoUI);
			List<Sector> sectorList=itemService.getSectorList(depoUI);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("registration2");
			modelAndView.addObject("sector_bd_list",sectorList);
			
			System.out.println("controllerSector:"+ sectorList);
			
			return modelAndView;
		}
		
		@RequestMapping("/register")
		public ModelAndView registerNewUser(@Valid @ModelAttribute("user") User user, BindingResult theBindingResult) {

			ModelAndView modelAndView = new ModelAndView();

			if (theBindingResult.hasErrors()) {
				modelAndView.setViewName("registration2");
			} else {
				
				userService.register(user);
				modelAndView.setViewName("loginPage");
			}

			return modelAndView;
		}
}
