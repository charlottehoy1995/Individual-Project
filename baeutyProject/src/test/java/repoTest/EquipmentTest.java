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
import qa.baeuty.springboot.baeutyProject.model.EquipmentModel;
import qa.baeuty.springboot.baeutyProject.repository.EquipmentRepo;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringbootBaeutyProject.class)
@DataJpaTest

public class EquipmentTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private EquipmentRepo myRepo;

	@Test
	public void retrieveByIdTest() {
		EquipmentModel model1 = new EquipmentModel(34.00, "Brow Expert Set", 10);
		entityManager.persist(model1);
		entityManager.flush();
		assertTrue(myRepo.findById(model1.getEquipmentID()).isPresent());

	} 
	

}
  
 
