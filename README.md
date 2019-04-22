
REST

Spring?

Spring Boot?

1. It is an Open Source java based framework 
2. With the Help of this We can create microservices

3. It is used to create Stand alone Applications
4. It has minimum Configuration



Advantages of Spring Boot:

1. It is easy to understand and develop spring like application
2. It increases the production
3. It reduces development Time.

Goals to  Move for Spring Boot:
1. It avoids the xml configuration
2. To Develop production-ready stand alone applications
3. to reduce development time

Features:
1. It provides flexible way to configure java Beans
2. It is very efficient for consuming the REST API
3. Everything is auto-configured
4. It offers annotation based Spring application
5. It has easy management of Dependencies
6. It has its own web server(Apache Tomcat)

Micro Service?

A micro service is an archecture that allows the developers to develop and deploy services independently

Every service has its own process and are mode to achieve a specific task.

Monolithic Application

Advantages of using microservices:

1. Easy development
2. Simple and Scalable
3. It is compatible with containers
4. It need minimum configuration
5. Lesser time for production


REST API
Communication b/w a client and a Server

REST --> Representational State Transfer

Architectural style for  networked hypermedia applications


It is primarily used for building Web services

Web services are light Weight, maintainable, scalable


A service based on REST is called Restful Web service

REST is not dependent on any protocol, but all the webservices are using HTTP protocol

It is introduced in 2000 by Roy Fielding

JSON

{
   "Name": "Raman"
}

POSTMAN/

Stream API



Testing:
JUNIT Testing
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMockMVCTests {  
  @Autowired
  private WebApplicationContext ctx;  
  private MockMvc mockMvc;  
  @Before
  public void setUp() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.ctx).build();
  }  
  @Test
  public void testBasicMVC() throws Exception {
    MvcResult result = mockMvc
        .perform(MockMvcRequestBuilders.get("/"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("result", is("Hello World")))         
        .andReturn();    
    String content = result.getResponse().getContentAsString();
     System.out.println("{testBasicMVC} response : " + content);
  }
}


Annotations:

@Before: -->That method will execute after every test case

@After : --> That method will execute after the execution of Every test case

@BeforeClass: This will execute Before Executing the class

@Test
@Ignore


WebApplicationContext: it provides the web application configuration.It loads all the application beans and controllers into the context

MockMvc: it provides support for Spring MVC Testing. It encapsulates all web application beans and make them available for the Testing

we do not need to initialize the bean everytime.

Node.js
=================


