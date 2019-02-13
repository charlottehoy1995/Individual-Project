package qa.baeuty.springboot.baeutyProject.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qa.baeuty.springboot.baeutyProject.exception.ResourceNotFoundException;
import qa.baeuty.springboot.baeutyProject.model.EquipmentModel;
import qa.baeuty.springboot.baeutyProject.repository.EquipmentRepo;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EquipmentController {

	@Autowired
	EquipmentRepo myRepository;


	// Method to get equipment
	@GetMapping("/equipment/{id}")
	public EquipmentModel getEquipment(@PathVariable(value = "id") Long EquipmentID) {
		return myRepository.findById(EquipmentID)
				.orElseThrow(() -> new ResourceNotFoundException("Model", "id", EquipmentID));
	}
	
	
	// Method to get all equipment
	@GetMapping("/equipment")
	public List<EquipmentModel> getAllEquipment() {
		return myRepository.findAll();
	}

	// Method to update equipment
	@PutMapping("/equipment/{id}")
	public EquipmentModel updateEquipment(@PathVariable(value = "id") Long EquipmentID,
			@Valid @RequestBody EquipmentModel equipmentDetails) {

		EquipmentModel mSDM = myRepository.findById(EquipmentID)
				.orElseThrow(() -> new ResourceNotFoundException("People", "id", EquipmentID));

		mSDM.setPrice(equipmentDetails.getPrice());
		mSDM.setName(equipmentDetails.getName());
		mSDM.setStock_Level(equipmentDetails.getStock_Level());

		EquipmentModel updateData = myRepository.save(mSDM);
		return updateData;
	}

	// Method to remove equipment
	@DeleteMapping("/equipment/{id}")
	public ResponseEntity<?> deleteEquipment(@PathVariable(value = "id") Long EquipmentID) {
		EquipmentModel mSDM = myRepository.findById(EquipmentID)
				.orElseThrow(() -> new ResourceNotFoundException("People", "id", EquipmentID));
		myRepository.delete(mSDM);
		return ResponseEntity.ok().build();
	}

	// Method to delete all equipment
	@DeleteMapping("/equipment")
	public ResponseEntity<?> deleteAllEquipment() {
		myRepository.deleteAll();
		return ResponseEntity.ok().build();
	}
}
