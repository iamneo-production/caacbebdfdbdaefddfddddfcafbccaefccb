/*package com.examly.springapp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes = SpringappApplication.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class SpringApplicationTests {

	@Autowired
    private MockMvc mockMvc;	

	//Add A New Task
	@Test
    public void test_case1() throws Exception {
		
		String dataOne = "{\"taskId\":\"12211\",\"taskHolderName\":\"Gowthaman M\",\"taskDate\":\"4/15/2021\",\"taskName\":\"Spring Projects\",\"taskStatus\":\"In Progress\"}";
	 	mockMvc.perform(MockMvcRequestBuilders.post("/saveTask")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.content(dataOne)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andReturn();
	 	
    }
	
	
	//Get All Task
	@Test
    public void test_case2() throws Exception {
		
	 	mockMvc.perform(MockMvcRequestBuilders.get("/alltasks")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
		        .andExpect(MockMvcResultMatchers.jsonPath("$[*].houseNo").exists())
		        .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
	        	.andReturn();
	 	
    }
	
	//Get A Task By ID
	@Test
	public void test_case3() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/getTask")
				.param("taskId","12211")
				.contentType(MediaType.APPLICATION_JSON)
		 		.accept(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$.taskHolderName").value("Gowthaman M"))
		        .andExpect(jsonPath("$.taskDate").value("4/15/2021"))
		        .andExpect(jsonPath("$.taskName").value("Spring Projects"))
				.andExpect(jsonPath("$.taskStatus").value("In Progress"))
		        .andReturn();
			
	}
	
	//Delete A Task
	@Test
	public void test_case4() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/deleteTask")
				.param("taskId","12211")
				.contentType(MediaType.APPLICATION_JSON)
		 		.accept(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk())
		        .andReturn();
			
	}


}
*/
package ai.iamneo.testing.Testing_Selenium_TestNg;

public class AppTest {
	ChromeDriver driver;
	String url = "http://www.flipkart.com";

	public void invokeBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Saurabh Dhingra\\workspace\\libs\\chromeDriver36\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

		driver.get(url);

	}

	public void loginToFlipkart() {
		driver.findElement(By.xpath("//div[@class='_1XBjg- row']//form//input[@type='text']")).sendKeys("testuser@abc.com");
		
		driver.findElement(By.xpath("//div[@class='_1XBjg- row']//form//input[@type='password']")).sendKeys("Test@1234");
		
		driver.findElement(By.xpath("//div[@class='_1XBjg- row']//form//button[@type='submit']")).click();
		
	}
	
	public void closeBrowser() {
		driver.quit();
	}

}