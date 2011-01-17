package com.gisce;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CV implements Validator{

	
	@Override
	public boolean supports(Class arg0) {
		// TODO Auto-generated method stub
//		if(VO.class.isAssignableFrom(arg0)){
//			return false;
//		}
//		return false;
		return arg0.equals(VO.class);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		// TODO Auto-generated method stub
		
		VO cc = (VO)arg0;
		if(isEmpty(cc.getName())){
			errors.rejectValue("name", "required","필수");
		}
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","required");
		
	}
	
	private boolean isEmpty(String value){
		if(value == null || value.length()==0){
			return true;
		}
		return false;
	}

}
