package taco;

import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@SpringBootTest(classes=TacosCloudApplication.class)
@AutoConfigureMockMvc
public class HomeControllerTests
{
	// Inject MockMvc
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testHomePage() throws Exception
	{
		/*
		 * Performs a HTTP GET request for / (the root path) setting the following 
		 *	expectations:
		 *	- The response should have an HTTP 200 (OK) status.
		 *	- The view should have a logical name of home.
		 *	- The rendered view should contain the text "Welcome to ..."
		 */
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("home"))
			.andExpect(content().string(
						containsString("Welcome to ...")
						));
	}
}
