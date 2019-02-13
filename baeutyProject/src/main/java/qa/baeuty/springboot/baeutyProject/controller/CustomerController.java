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
import qa.baeuty.springboot.baeutyProject.model.CustomerModel;
import qa.baeuty.springboot.baeutyProject.repository.CustomerRepo;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerRepo myRepository;

	// Method to create a customer
	@PostMapping("/customers")
	public CustomerModel createCustomer(@Valid @RequestBody CustomerModel mSDM) {
		return myRepository.save(mSDM);
	}

	// Method to get a customer
	@GetMapping("/customers/{id}")
	public CustomerModel getCustomers(@PathVariable(value = "id") Long CustomerID) {
		return myRepository.findById(CustomerID)
				.orElseThrow(() -> new ResourceNotFoundException("Model", "id", CustomerID));
	}
	
	
	// Method to get all customers
	@GetMapping("/customers")
	public List<CustomerModel> getAllCustomer() {
		return myRepository.findAll();
	}

	// Method to update customers
	@PutMapping("/customers/{id}")
	public CustomerModel updateCustomers(@PathVariable(value = "id") Long CustomerID,
			@Valid @RequestBody CustomerModel customerDetails) {

		CustomerModel mSDM = myRepository.findById(CustomerID)
				.orElseThrow(() -> new ResourceNotFoundException("People", "id", CustomerID));

		mSDM.setName(customerDetails.getName());
		mSDM.setDOB(customerDetails.getDOB());

		CustomerModel updateData = myRepository.save(mSDM);
		return updateData;
	}

	// Method to remove a customer
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<?> deleteCustomers(@PathVariable(value = "id") Long CustomerID) {
		CustomerModel mSDM = myRepository.findById(CustomerID)
				.orElseThrow(() -> new ResourceNotFoundException("People", "id", CustomerID));
		myRepository.delete(mSDM);
		return ResponseEntity.ok().build();
	}

	// Method to delete all customers
	@DeleteMapping("/customers")
	public ResponseEntity<?> deleteAllCustomers() {
		myRepository.deleteAll();
		return ResponseEntity.ok().build();
	}
}
