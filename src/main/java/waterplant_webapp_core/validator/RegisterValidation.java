package waterplant_webapp_core.validator;

import waterplant_webapp_core.exception.ValidatorException;
import waterplant_webapp_core.model.User;

public class RegisterValidation {
	
	public  void validateBeforeRegister(User user) throws ValidatorException {
		
		//Name Validation
		String name = user.getName();
        String numbers = "(.*[0-9].*)";
		if(name.matches(numbers)) 
			throw new ValidatorException("Name should not contain numbers!!!"); 
		
		
		//Mobile Number Validation
		Long mobile = user.getMobileno();
		String num = String.valueOf(mobile);
		if (num.length() != 10)
			throw new ValidatorException("Invalid Mobile Number!!!");
		
       String number = "(.*[A-Z].*[a-z].*)";
		if(num.matches(number)) 
			throw new ValidatorException("Mobile Number should not contain Alphabets!!!");
		
	
}}
