package jbr.springmvc.service;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public interface UserService {

 String register(User user);

 User validateUser(Login login);
}
