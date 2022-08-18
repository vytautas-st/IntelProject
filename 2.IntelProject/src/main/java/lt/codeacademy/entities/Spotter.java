package lt.codeacademy.entities;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="spotters")
public class Spotter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	int rating;
	String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Report> reports = new ArrayList<Report>();
	
	int reportsCount = reports.size();

	public Spotter(int id, int rating, String name) {
		super();
		this.id = id;
		this.rating = rating;
		this.name = name;
		
	}

	public Spotter(int rating, String name) {
		super();
		this.rating = rating;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Spotter [id=" + id + ", rating=" + rating + ", name=" + name + "]";
	}
	
	public void addReport(Report report) {
		reports.add(report);
		
	}

}
