package by.mycloud.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.mycloud.www.entity.Item;
import by.mycloud.www.service.ItemService;
import by.mycloud.www.entity.StandartSearchItem;
/**
 * 
 * 
 * @author Vitamin_XO
 *
 */

@Controller
@RequestMapping("/item")
public class ItemController {

	
	@Autowired
	private ItemService itemService;

	//authorization page
	@RequestMapping("/main")
	public String goToAuthorizationPage() {
		return "authorization";
	}

	@GetMapping("/goToDocumentationPage")
	public String goToDocumentationPage() {

		return "documentation";

	}
	
	
	@GetMapping("/goToStandartPreSearch")
	public String goToStandartPreSearch() {

		return "standart_pre_search";

	}
	
	@GetMapping("/goToStandartSearch")
	public ModelAndView goToStandartSearch(@RequestParam(defaultValue = "") String nnSap,  @RequestParam(defaultValue = "") String nn, @RequestParam(defaultValue = "") String name) {
		StandartSearchItem standartSearchItemFromUI=new StandartSearchItem(null, nnSap, nn, name);
		List<StandartSearchItem> items= itemService.listStandartSearchItem(standartSearchItemFromUI);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("standart_pre_search");
		modelAndView.addObject("item_bd_list",items);
		System.out.println("controller "+items);
		System.out.println(items.get(0).getName());
		
		return modelAndView;

	}
}