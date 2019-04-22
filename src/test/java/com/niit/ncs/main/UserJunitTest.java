package com.niit.ncs.main;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.ncs.dao.UserDAO;
import com.niit.ncs.model.User;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserJunitTest {


	@Autowired
	UserDAO userDAO;
	@BeforeClass
	public static void init()
	{
		System.out.println("This will Execute Before The class Execution");
	}
	
	@AfterClass
	public static void distroy()
	{
		System.out.println("This will Execute Only After the Class");	
	}
	@Test
	public void test_get_all_users_success() {
		
		List<User> users = userDAO.getAllUsers();
		assertEquals(5, users.size());
	}
	
	@Test(expected = AssertionError.class)
	public void test_get_all_users_fail() {
		
		List<User> users = userDAO.getAllUsers();
		assertEquals(4, users.size());
	}
	
	@Test
	public void test_add_user_success()
	{
		User user = new User(110, "Amit Kumar");
		assertEquals(true, userDAO.saveUser(user));
	}
	@Test
	public void test_get_user_by_id() {
		User user = userDAO.getUserById(103);
		assertEquals("Pankaj Saini", user.getName());
	}
	@Test
	public void test_update_user_details()
	{
		
		User user = userDAO.getUserById(103);
		user.setName("Pankaj Saini");
		
		assertEquals(true, userDAO.updateUser(user));
	}
	@Test
	public void test_delete_user_detail()
	{
		User user = userDAO.getUserById(103);
		assertEquals(true, userDAO.deleteUser(user));
	}
}
