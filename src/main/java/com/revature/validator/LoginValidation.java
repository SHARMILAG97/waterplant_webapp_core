package com.revature.validator;

import com.revature.exception.ValidatorException;

public class LoginValidation {

	public  void validateMobileNo(Long mno) throws ValidatorException {

		String num = String.valueOf(mno);

		if (num.length() != 10)

			throw new ValidatorException("Invalid Mobile Number!!!");

	}
	
}
