package co.grandcircus.movies.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.grandcircus.movies.rest.SunService;



@Controller
public class SunController {
	
	private static final Logger logger = LoggerFactory.getLogger(SunController.class);
	
	@Autowired
	private SunService sunService;
	
	
	@RequestMapping("/sun")
	public String home(Locale locale, Model model) {
		
		model.addAttribute("sun", sunService.getCurrentTimeAtGrandCircus());
		
		logger.info("/sun -> sun.jsp");
		
		return "sun";
	}
	
}