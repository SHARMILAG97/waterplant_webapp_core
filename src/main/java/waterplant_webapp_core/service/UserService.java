package waterplant_webapp_core.service;

import java.util.List;


import com.google.protobuf.ServiceException;

import waterplant_webapp_core.dao.ReserveDAO;
import waterplant_webapp_core.dao.ReserveInterface;
import waterplant_webapp_core.dao.StockDAO;
import waterplant_webapp_core.dao.StockInterface;
import waterplant_webapp_core.dao.UserDAO;
import waterplant_webapp_core.dao.UserInterface;
import waterplant_webapp_core.exception.DBException;
import waterplant_webapp_core.exception.ValidatorException;
import waterplant_webapp_core.model.Reserve;
import waterplant_webapp_core.model.User;
import waterplant_webapp_core.validator.RegisterValidation;

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
