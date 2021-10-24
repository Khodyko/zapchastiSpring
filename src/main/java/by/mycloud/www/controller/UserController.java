package by.mycloud.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Controller;
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
			modelAndView.addObject("depo_db_list",depoList);
			
			System.out.println("modelAndView:"+ modelAndView);
			
			return modelAndView;
		}
		
		@RequestMapping("/goToRegistration2")
		public ModelAndView goToRegistration2(@RequestParam Integer depoIdUI,
				@RequestParam(defaultValue = "1") String nameUI, 
				@RequestParam(defaultValue = "1") String secondNameUI
				) {
			System.out.println("controller nameID: "+ nameUI);
			System.out.println("controller depiID: "+ depoIdUI);
			List<Sector> sectorList=itemService.getSectorList(depoIdUI);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("registration2");
			modelAndView.addObject("depoIdUI",depoIdUI);
			modelAndView.addObject("sectorUI",sectorList);
			modelAndView.addObject("nameUI",nameUI);
			modelAndView.addObject("secondNameUI",secondNameUI);
			
			System.out.println("modelAndView:"+ modelAndView);
			
			return modelAndView;
		}
		
		@RequestMapping("/register")
		public ModelAndView registerNewUser(@RequestParam(defaultValue = "") Integer depoIdUI,
				@RequestParam(defaultValue = "1") String nameUI, 
				@RequestParam(defaultValue = "1") String secondNameUI, 
				@RequestParam(defaultValue = "1") String emailUI, 
				@RequestParam(defaultValue = "0") Integer sectorIdUI,
				@RequestParam(defaultValue = "1") String passwordUI, 
				@RequestParam(defaultValue = "1") String password2UI) {

			User user;
			ModelAndView modelAndView = new ModelAndView();

//			if (theBindingResult.hasErrors()) {
//				modelAndView.setViewName("registration2");
//			} else {
				// make false when realised method
				user=new User(nameUI,secondNameUI, passwordUI, "user", emailUI, itemService.getSectorById(sectorIdUI), itemService.getDepoById(depoIdUI), true);
				try {
				userService.register(user, password2UI);
				}
				catch(AuthenticationServiceException e) {
					//msg!!!
					modelAndView.setViewName("registration2");
					return modelAndView;
				}
				modelAndView.setViewName("authorization");
//			}

			return modelAndView;
		}
}
