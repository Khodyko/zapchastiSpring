package by.mycloud.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import by.mycloud.www.entity.Depo;
import by.mycloud.www.service.ItemService;
import by.mycloud.www.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	
	@Autowired
	private ItemService itemService;
	
//	@Autowired
//	private UserService userService;
	
//	@Autowired
//	private PasswordEncoder bcryptBean;

	
	//authorization page
		@RequestMapping("loginPage")
		public String goToAuthorizationPage() {
			return "authorization";
		}
		
		
		@RequestMapping("/goToRegistration1")
		public ModelAndView goToStandartSearch() {
			
			List<Depo> depoList=itemService.getDepoList();
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("registration1");
			modelAndView.addObject("depo_bd_list",depoList);
			
			System.out.println("controller:"+ depoList);
			
			return modelAndView;
		}
}
