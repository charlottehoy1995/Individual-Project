package qa.baeuty.springboot.baeutyProject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qa.baeuty.springboot.baeutyProject.model.EquipmentModel;


@Repository
public interface EquipmentRepo extends JpaRepository<EquipmentModel, Long> {

	//List<EquipmentModel> findByName(String Name);
	//List<EquipmentModel> findByStatus(String status);

}