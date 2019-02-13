package qa.baeuty.springboot.baeutyProject.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "customers")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"creationDate","lastModified"},allowGetters = true)

public class CustomerModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CustomerID;

	@NotBlank
	private String Name;
	
	@Column
	private LocalDate DOB;

//	ON TO MANY ADDRESS ***********************************
//  ******************************************************

	public CustomerModel(String Name, LocalDate DOB) {
		this.Name = Name;
		this.DOB = DOB;
	}
	
	public CustomerModel(){
	}

	public Long getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(Long customerID) {
		CustomerID = customerID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}
}

 
	
	