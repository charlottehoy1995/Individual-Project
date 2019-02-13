package integrationTest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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

import qa.baeuty.springboot.baeutyProject.SpringbootBaeutyProject;
import qa.baeuty.springboot.baeutyProject.model.AddressModel;
import qa.baeuty.springboot.baeutyProject.repository.AddressRepo;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringbootBaeutyProject.class })
@AutoConfigureMockMvc

public class AddressTest {
	
	@Autowired
	private MockMvc mvc;

	@Autowired
	private AddressRepo repository;

	/*
	 * @Before public void clearDB() { repository.deleteAll(); //////Clears
	 * Repository, helps stop test interaction }
	 */

	@Test
	public void findingAndRetrivevingAddressFromDatabase() throws Exception {
		repository.save(new AddressModel("null", 123, "Fake Street", "Hoddesdon", "Hertfordshire", "UK"));  
		mvc.perform(get("/api/address").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].country", is("UK")));
	} 
  
}
  


 
 