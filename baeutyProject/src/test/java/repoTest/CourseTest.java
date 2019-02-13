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
import qa.baeuty.springboot.baeutyProject.model.CourseModel;
import qa.baeuty.springboot.baeutyProject.repository.CourseRepo;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringbootBaeutyProject.class)
@DataJpaTest

public class CourseTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CourseRepo myRepo;

	@Test
	public void retrieveByIdTest() {
		CourseModel model1 = new CourseModel("Eyebrow and Lash", 85, "6-8hrs");
		entityManager.persist(model1);
		entityManager.flush();
		assertTrue(myRepo.findById(model1.getCourseID()).isPresent());

	}

}


