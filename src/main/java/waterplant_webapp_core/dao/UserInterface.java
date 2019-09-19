package waterplant_webapp_core.dao;

import java.util.List;

import waterplant_webapp_core.exception.DBException;
import waterplant_webapp_core.model.User;

public interface UserInterface {

	void AddUser(User user) throws DBException;
	User findByNameAndPassword(String Uname,String Pwd) throws DBException;
	boolean findByUNameAndPassword(long mobileno,String Pwd) throws DBException;
	 User getUser(long mobileno, String Pwd) throws DBException;
	 public  List<User> viewUser() throws DBException;
	 

}
