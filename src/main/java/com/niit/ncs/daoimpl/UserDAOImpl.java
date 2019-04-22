package com.niit.ncs.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.ncs.dao.UserDAO;
import com.niit.ncs.model.User;

@Repository(value  = "userDAO")
public class UserDAOImpl implements UserDAO{

	public static List<User> users = new ArrayList<User>();
	
	public UserDAOImpl()
	{
		users.add(new User(101, "Sandeepan"));
		users.add(new User(102, "Jyoti Mittal"));
		users.add(new User(103, "Anuradha"));
		users.add(new User(104, "Amitabha"));
		users.add(new User(105, "Sujala"));
	}
	
	public boolean saveUser(User user) {
		try {
			users.add(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateUser(User user) {
	
		 try {
			users.stream()
					.filter(u -> u.getId() == user.getId())
					.findAny()
					.orElseThrow(() -> new RuntimeException("User Not Available"))
					.setName(user.getName());
			 return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUser(User user) {
		try {
			users.removeIf((User u) -> u.getId() == user.getId());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public User getUserById(int id) {
		
		return users.stream()
				.filter(user -> user.getId() == id)
				.findAny()
				.orElse(new User(0, "User Not Available"));
	}

	public List<User> getAllUsers() {
		
		return users;
	}

}
