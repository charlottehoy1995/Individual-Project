package qa.baeuty.springboot.baeutyProject.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "courses")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"creationDate","lastModified"},allowGetters = true)

public class CourseModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CourseID;

	@NotBlank
	private String Name;
	
	private double Price;
	
	@NotBlank
	private String Duration;
	
	
//	ON TO MANY ADDRESS ***********************************
//  ******************************************************

	
	public CourseModel(String Name, double Price, String Duration) {
		this.Name = Name;
		this.Price = Price;
		this.Duration = Duration;
	}
	
	public CourseModel(){
	} 

	public Long getCourseID() {
		return CourseID;
	}

	public void setCourseID(Long courseID) {
		CourseID = courseID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public String getDuration() {
		return Duration;
	}

	public void setDuration(String duration) {
		Duration = duration;
	}

}
	