package qa.baeuty.springboot.baeutyProject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qa.baeuty.springboot.baeutyProject.exception.ResourceNotFoundException;
import qa.baeuty.springboot.baeutyProject.model.AddressModel;
import qa.baeuty.springboot.baeutyProject.repository.AddressRepo;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AddressController {

	@Autowired
	AddressRepo myRepository;

	// Method to create address
	@PostMapping("/address")
	public AddressModel createAddress(@Valid @RequestBody AddressModel mSDM) {
		return myRepository.save(mSDM);
	}

	// Method to get a address
	@GetMapping("/address/{id}")
	public AddressModel getAddress(@PathVariable(value = "id") Long LocationID) {
		return myRepository.findById(LocationID)
				.orElseThrow(() -> new ResourceNotFoundException("Model", "id", LocationID));
	}
	
	
	// Method to get all address'
	@GetMapping("/address")
	public List<AddressModel> getAllAddress() {
		return myRepository.findAll();
	}

	// Method to update address
	@PutMapping("/address/{id}")
	public AddressModel updateAddress(@PathVariable(value = "id") Long LocationID,
			@Valid @RequestBody AddressModel addressDetails) {

		AddressModel mSDM = myRepository.findById(LocationID)
				.orElseThrow(() -> new ResourceNotFoundException("People", "id", LocationID));

		mSDM.setPostCode(addressDetails.getPostCode());
		mSDM.setHouse_Number(addressDetails.getHouse_Number());
		mSDM.setStreet(addressDetails.getStreet());
		mSDM.setCity(addressDetails.getCity());
		mSDM.setCounty(addressDetails.getCounty());
		mSDM.setCountry(addressDetails.getCountry());

		AddressModel updateData = myRepository.save(mSDM);
		return updateData;
	}

	// Method to remove an address
	@DeleteMapping("/address/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long LocationID) {
		AddressModel mSDM = myRepository.findById(LocationID)
				.orElseThrow(() -> new ResourceNotFoundException("People", "id", LocationID));
		myRepository.delete(mSDM);
		return ResponseEntity.ok().build();
	}

	// Method to delete all address'
	@DeleteMapping("/address")
	public ResponseEntity<?> deleteAllAddress() {
		myRepository.deleteAll();
		return ResponseEntity.ok().build();
	}
}
