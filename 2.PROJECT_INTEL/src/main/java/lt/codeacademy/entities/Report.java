package lt.codeacademy.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="reports")
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	int level;
	String description;
	//Spotter spotter;
	double  lat;
	double  lng;
	

	public Report(int id, int level, String description, double lat, double lng) {
		super();
		this.id = id;
		this.level = level;
		this.description = description;
		//this.spotter = spotter;
		this.lat = lat;
		this.lng = lng;
	}

	public Report(int level, String description,  double lat, double lng) {
		super();
		this.level = level;
		this.description = description;
		this.lat = lat;
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "Report [id=" + id + ", level=" + level + ", description=" + description + ", spotter=" + spotter.id
				+ ", lat=" + lat + ", lng=" + lng + "]";
	}
	
	

	
	
	
	
}
