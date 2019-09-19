package com.revature.service;

import com.google.protobuf.ServiceException;
import com.revature.dao.UserDAO;
import com.revature.dao.UserInterface;
import com.revature.exception.DBException;
import com.revature.model.User;

public class AdminService {
public User adminLogin(String name, String password) throws ServiceException {
		
		User admin =null;
		try {
			UserInterface Udao = new UserDAO();
		     admin=Udao.findByNameAndPassword(name, password);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to login");
			
		}
		return admin;

	}

}
