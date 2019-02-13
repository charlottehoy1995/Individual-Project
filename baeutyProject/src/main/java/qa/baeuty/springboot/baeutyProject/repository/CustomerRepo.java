package qa.baeuty.springboot.baeutyProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qa.baeuty.springboot.baeutyProject.model.CustomerModel;


@Repository
public interface CustomerRepo extends JpaRepository<CustomerModel, Long> {

	/*List<Model> findByName(String Name);
	List<Model> findByStatus(String status);*/

}