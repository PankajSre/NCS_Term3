package com.niit.ncs.main;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.niit.ncs.dao.UserDAO;
import com.niit.ncs.model.User;

import ch.qos.logback.core.status.Status;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMockMVCkControllerTesting {

	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMVC;
	
	@Mock
	UserDAO userDAO;
	
	
	@Before
	public void init()
	{
		this.mockMVC = MockMvcBuilders.webAppContextSetup(this.ctx).build();
	}
	
	@Test
	public void test_default_url() throws Exception
	{
		MvcResult result = mockMVC
				.perform(MockMvcRequestBuilders.get("/"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("message",is("Hello World")))
				.andReturn();
			String content = result.getResponse().getContentAsString();		
			System.out.println("Response : "+content);
	}
	
	@Test
	public void tes_user_by_id() throws Exception {
		MvcResult result = mockMVC
				.perform(MockMvcRequestBuilders.get("http://localhost:7070/api/user/105"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("id", is(105)))
				.andExpect(jsonPath("name", is("Sujala")))
				.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println("The response is : "+content);
	}
	
	public void test_get_all_users() throws Exception
	{
//		when(userDAO.getAllUsers()).thenReturn(users);
		mockMVC.perform(MockMvcRequestBuilders.get("http://localhost:7070/api/user"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(5)))
		.andExpect(jsonPath("$[0].id", is(101)))
		.andExpect(jsonPath("$[0].name", is("Sandeepan")));
	
		
	}

}
