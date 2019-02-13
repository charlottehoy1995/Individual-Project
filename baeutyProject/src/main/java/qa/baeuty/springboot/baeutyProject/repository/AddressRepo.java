package qa.baeuty.springboot.baeutyProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qa.baeuty.springboot.baeutyProject.model.AddressModel;


@Repository
public interface AddressRepo extends JpaRepository<AddressModel, Long> {

	/*List<Model> findByName(String Name);
	List<Model> findByStatus(String status);*/

}