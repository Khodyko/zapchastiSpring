package by.mycloud.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import by.mycloud.www.entity.StandartSearchItem;
import by.mycloud.www.service.ItemService;
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

	@GetMapping("/goToDocumentationPage")
	public String goToDocumentationPage() {
		return "documentation";
	}
	
	
	@GetMapping("/goToStandartPreSearch")
	public String goToStandartPreSearch() {
		return "standart_pre_search";
	}
	
	@PostMapping("/goToStandartSearch")
	public ModelAndView goToStandartSearch(@RequestParam(defaultValue = "") String nnSapUI, @RequestParam(defaultValue = "") String nnUI, 
			@RequestParam(defaultValue = "") String nameUI) {
		StandartSearchItem standartSearchItemFromUI=new StandartSearchItem(null, nnSapUI, nnUI, nameUI);
		System.out.println(standartSearchItemFromUI);
		List<StandartSearchItem> items= itemService.listStandartSearchItem(standartSearchItemFromUI);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("standart_search");
		modelAndView.addObject("item_bd_list",items);
		return modelAndView;
	}
}