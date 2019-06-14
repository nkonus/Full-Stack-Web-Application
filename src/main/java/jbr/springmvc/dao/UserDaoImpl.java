package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import AES.src.main.java.AES.AES;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

public class UserDaoImpl implements UserDao {
	@Autowired
	DataSource datasource;
 
	@Autowired
	JdbcTemplate jdbcTemplate;
 
	public String register(User user) {
		final String secretKey = "cst341!";
		String encryptedString = AES.encrypt(user.getPassword(), secretKey) ;
		
		String sql = "insert into users values(?,?,?,?,?,?,?)";
		
		try {
		jdbcTemplate.update(sql, new Object[] { user.getUsername(), encryptedString, user.getFirstname(),
				user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone() });
		}catch (Exception e) {
			return "Error on user registration, try again";
		}
		
			return null;
		
   }
	
   public User validateUser(Login login) {
	    final String secretKey = "cst341!";
	     
	    String encryptedString = AES.encrypt(login.getPassword(), secretKey) ;
	    
   String sql = "select * from users where username='" + login.getUsername() + "' and password='" + encryptedString
   + "'";
   List<User> users = jdbcTemplate.query(sql, new UserMapper());
   return users.size() > 0 ? users.get(0) : null;
   }
 }
 
	class UserMapper implements RowMapper<User> {
		
		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			User user = new User();
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			user.setEmail(rs.getString("email"));
			user.setAddress(rs.getString("address"));
			user.setPhone(rs.getInt("phone"));
			return user;
		}
	}