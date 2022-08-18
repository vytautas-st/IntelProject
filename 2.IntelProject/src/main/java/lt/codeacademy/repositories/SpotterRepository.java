package lt.codeacademy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.codeacademy.entities.Spotter;



public interface SpotterRepository extends JpaRepository<Spotter, Integer>{

}
