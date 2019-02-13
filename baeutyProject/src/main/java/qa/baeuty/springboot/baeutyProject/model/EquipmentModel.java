package qa.baeuty.springboot.baeutyProject.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "equipment")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"creationDate","lastModified"},allowGetters = true)

public class EquipmentModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long EquipmentID;

	@NotNull
	private double Price;
	
	@NotBlank
	private String Name;
	
	@NotNull
	private int Stock_Level; 

//	ON TO MANY CUSTOMERID ***********************************
//  ******************************************************
	 

//	ON TO MANY COURSEID ***********************************
//  *******************************************************

	public EquipmentModel(double Price, String Name, int Stock_Level) {
		this.Price = Price;
		this.Name = Name;
		this.Stock_Level = Stock_Level;
	} 
	
	public EquipmentModel(){
	}

	public Long getEquipmentID() {
		return EquipmentID;
	}

	public void setEquipmentID(Long equipmentID) {
		EquipmentID = equipmentID;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getStock_Level() {
		return Stock_Level;
	}

	public void setStock_Level(int stock_Level) {
		Stock_Level = stock_Level;
	}

	
}


	
	