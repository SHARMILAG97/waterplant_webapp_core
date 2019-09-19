package waterplant_webapp_core.service;

import com.google.protobuf.ServiceException;

import waterplant_webapp_core.dao.UserDAO;
import waterplant_webapp_core.dao.UserInterface;
import waterplant_webapp_core.exception.DBException;
import waterplant_webapp_core.model.User;

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
