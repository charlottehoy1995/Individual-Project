package repoTest;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import qa.baeuty.springboot.baeutyProject.SpringbootBaeutyProject;
import qa.baeuty.springboot.baeutyProject.model.AddressModel;
import qa.baeuty.springboot.baeutyProject.repository.AddressRepo;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringbootBaeutyProject.class)
@DataJpaTest

public class AddressTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private AddressRepo myRepo;

	@Test
	public void retrieveByIdTest() {
		AddressModel model1 = new AddressModel("null", 124, "Fake Street", "Hoddesdon", "Hertfordshire", "UK");
		entityManager.persist(model1);
		entityManager.flush();
		assertTrue(myRepo.findById(model1.getLocationID()).isPresent());

	}

	
	/*@Test
	public void retrieveByCountyTest() {
		AddressModel model1 = new AddressModel("null", 124, "Fake Street", "Hoddesdon", "Hertfordshire", "UK");
		entityManager.persist(model1);
		entityManager.flush();
		assertTrue(myRepo.findById(model1.getCounty()).isPresent());

	}*/

}

