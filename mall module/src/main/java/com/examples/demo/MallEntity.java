package com.example.demo;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class MallEntity {  
	 private Integer Id;
	 private String mallname;
	 private String locations;
	 private String categories;
	 
	 
	 public MallEntity() {
	 }
	 
	 public MallEntity(String mallname, String locations, String categories, Integer Id)
	 {
		 this.Id = Id;
		 this.mallname = mallname;
		 this.locations = locations;
		 this.categories = categories;
	 }
	 @Id    
     @GeneratedValue(strategy = GenerationType.AUTO)
	
	 
    public Integer getId() {
			return Id;
		}
	public void setId(Integer Id) {
			this.Id = Id;
		} 
	public String getMallname() {
		return mallname;
	    }
	public void setMallname(String mallname) {
		this.mallname = mallname;
	    }
	public String getLocations() {
		return locations;
	    }
	public void setLocations(String locations) {
		this.locations = locations;
	    }
	public String getCategories() {
		return categories;
	    }
	public void setCategories(String categories) {
		this.categories = categories;
	    }

	@Override
	public String toString() {
		return "MallEntity [id=" + Id + ", mallname=" + mallname + ", locations=" + locations + ", categories="
				+ categories + "]";
	}
}
