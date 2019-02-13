package repoTest;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import qa.baeuty.springboot.baeutyProject.SpringbootBaeutyProject;
import qa.baeuty.springboot.baeutyProject.model.CustomerModel;
import qa.baeuty.springboot.baeutyProject.repository.CustomerRepo;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringbootBaeutyProject.class)
@DataJpaTest
public class CustomerTest {

	@Autowired 
	private TestEntityManager entityManager;

	@Autowired
	private CustomerRepo myRepo;

	@Test
	public void retrieveByIdTest() {
		CustomerModel model1 = new CustomerModel("Mia", LocalDate.parse("1990-03-23"));
		entityManager.persist(model1);
		entityManager.flush();
		assertTrue(myRepo.findById(model1.getCustomerID()).isPresent());

	} 

}
 
