package com.niit.ncs.dao;

import java.util.List;

import com.niit.ncs.model.User;

public interface UserDAO {

	public boolean saveUser(User user);

	public boolean updateUser(User user);

	public boolean deleteUser(User user);

	public User getUserById(int id);

	public List<User> getAllUsers();
}
