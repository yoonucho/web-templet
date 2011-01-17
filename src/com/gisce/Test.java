package com.gisce;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test/*")
public class Test {

	private CV cv;

	@RequestMapping
	public ModelAndView form(Map vo) {

		ModelAndView mav = new ModelAndView();
		

		
		return mav;
	}
	
	@RequestMapping
	public ModelAndView list( @ModelAttribute("data")VO vo) {

		ModelAndView mav = new ModelAndView();
				
		return mav;
	}
	

	
	@RequestMapping
	public ModelAndView insert(@ModelAttribute("data")VO vo,BindingResult result) {
		
		cv = new CV();
		cv.validate(vo,result);
		
		if(result.hasErrors()){
			System.out.println("error");
			
			
			return new ModelAndView("test/list",result.getModel());
		}
		System.out.println("run");
//
//		if(errors.hasErrors()){
//			return new ModelAndView("", errors.getModel());
//		}

		ModelAndView mav = new ModelAndView();
				
		return mav;
	}
//	@RequestMapping
//	public ModelAndView insert(@ModelAttribute("data")VO vo,BindingResult result) {
//		
//		cv = new CV();
//		cv.validate(vo,result);
//		
//		if(result.hasErrors()){
//			System.out.println("error");
//			
//			
//			return new ModelAndView("test/list",result.getModel());
//		}
//		System.out.println("run");
////
////		if(errors.hasErrors()){
////			return new ModelAndView("", errors.getModel());
////		}
//
//		ModelAndView mav = new ModelAndView();
//				
//		return mav;
//	}
	
}
