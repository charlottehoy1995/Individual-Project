package qa.baeuty.springboot.baeutyProject.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "address")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"creationDate","lastModified"},allowGetters = true)

public class AddressModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long LocationID;

	@NotBlank
	private String PostCode;
	
	@NotNull
	private int House_Number;
	
	@NotBlank
	private String Street;
	
	@NotBlank
	private String City;
	
	@NotBlank
	private String County;
	
	@NotBlank
	private String Country;
	
	///*****Collection of many courses (OneToMany) -- mapped by locationID
	

	public AddressModel(String PostCode, int House_Number, String Street, String City, String County, String Country) {
		this.PostCode = PostCode;
		this.House_Number = House_Number;
		this.Street = Street;
		this.City = City;
		this.County = County;
		this.Country = Country;
	}
 

	public AddressModel(){
	}

	public Long getLocationID() {
		return LocationID;
	}
	
	public void setLocationID(Long locationID) {
		LocationID = locationID;
	}

	public String getPostCode() {
		return PostCode;
	}

	public void setPostCode(String postCode) {
		PostCode = postCode;
	}

	public int getHouse_Number() {
		return House_Number;
	}

	public void setHouse_Number(int house_Number) {
		House_Number = house_Number;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getCounty() {
		return County;
	}

	public void setCounty(String county) {
		County = county;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}


}