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
import qa.baeuty.springboot.baeutyProject.model.CourseModel;
import qa.baeuty.springboot.baeutyProject.repository.CourseRepo;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CourseController {

	@Autowired
	CourseRepo myRepository;

	// Method to get a course
	@GetMapping("/courses/{id}")
	public CourseModel getCourse(@PathVariable(value = "id") Long CourseID) {
		return myRepository.findById(CourseID)
				.orElseThrow(() -> new ResourceNotFoundException("Model", "id", CourseID));
	}
	
	
	// Method to get all courses
	@GetMapping("/courses")
	public List<CourseModel> getAllCourses() {
		return myRepository.findAll();
	}

	// Method to update courses
	@PutMapping("/courses/{id}")
	public CourseModel updateCourses(@PathVariable(value = "id") Long CourseID,
			@Valid @RequestBody CourseModel courseDetails) {

		CourseModel mSDM = myRepository.findById(CourseID)
				.orElseThrow(() -> new ResourceNotFoundException("People", "id", CourseID));
		
		mSDM.setName(courseDetails.getName());
		mSDM.setPrice(courseDetails.getPrice());
		mSDM.setDuration(courseDetails.getDuration());

		CourseModel updateData = myRepository.save(mSDM);
		return updateData;
	}

	// Method to remove a course
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<?> deleteCourses(@PathVariable(value = "id") Long CourseID) {
		CourseModel mSDM = myRepository.findById(CourseID)
				.orElseThrow(() -> new ResourceNotFoundException("People", "id", CourseID));
		myRepository.delete(mSDM);
		return ResponseEntity.ok().build();
	}

	// Method to delete all courses
	@DeleteMapping("/courses")
	public ResponseEntity<?> deleteAllCourses() {
		myRepository.deleteAll();
		return ResponseEntity.ok().build();
	}
}
