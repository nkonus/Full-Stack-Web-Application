package jbr.springmvc.dao;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public interface UserDao {
	
 String register(User user);
 	User validateUser(Login login);
 	
}