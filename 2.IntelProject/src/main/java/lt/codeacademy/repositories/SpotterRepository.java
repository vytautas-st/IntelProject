package lt.codeacademy.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lt.codeacademy.entities.Spotter;




public interface SpotterRepository extends JpaRepository<Spotter, Integer>{
	 @Query("SELECT u FROM Spotter u WHERE u.name = ?1")
	 Optional< Spotter> findByName(String name);
	    

}
