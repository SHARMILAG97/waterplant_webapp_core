package com.revature.service;

import java.util.List;

import com.google.protobuf.ServiceException;
import com.revature.dao.ReserveDAO;
import com.revature.dao.ReserveInterface;
import com.revature.dao.StockDAO;
import com.revature.dao.StockInterface;
import com.revature.dao.UserDAO;
import com.revature.dao.UserInterface;
import com.revature.exception.DBException;
import com.revature.exception.ValidatorException;
import com.revature.model.Reserve;
import com.revature.model.User;
import com.revature.validator.RegisterValidation;

public class UserService {
	UserInterface Udao = new UserDAO();
	ReserveInterface Rdao= new ReserveDAO();
	StockInterface Sdao = new StockDAO();
	
public boolean loginUser(Long mobileno, String password) throws ServiceException {
		
		boolean isValid=true;
		try {
	
		     isValid=Udao.findByUNameAndPassword(mobileno, password);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to login");
			
		}
		return isValid;

	}


public List<User> viewUsers() throws ServiceException {

	List<User> list=null;
	try {
		
	   list = Udao.viewUser();
	} catch (DBException e) {
		e.printStackTrace();
		throw new ServiceException("Unable to register");
		
	}
	return list;
}



public User getUser(Long mobileno, String pwd) {
	
	
	User user = null;
	try {
		user=Udao.getUser(mobileno, pwd);
	} catch (DBException e) {
		e.printStackTrace();
	}
	return user;
}



public void registerUser(User u1) throws ValidatorException {

	RegisterValidation validate =new RegisterValidation();
	try {
         validate.validateBeforeRegister(u1);
	   Udao.AddUser(u1);
	}  catch (ValidatorException e) {
		throw new ValidatorException(e.getMessage());
	} catch (DBException e) {
		e.printStackTrace();
	}

	
	
}

public void reserve(Reserve rev, int rcans) throws DBException {
	
	try {
		
		int availcans =Sdao.findOne();
		
		availcans-=rcans;
		
		Rdao.addReserve(rev, rcans);
		Sdao.addStockReserve(rcans, availcans);
		
	} catch (DBException e) {

		throw new DBException(e.getMessage());
	}
	
}

}
