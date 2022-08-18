package lt.codeacademy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.entities.Spotter;
import lt.codeacademy.repositories.SpotterRepository;

@Service
public class SpotterService {
	@Autowired
	SpotterRepository spotterRepository;
	
	public Spotter save(Spotter spotter) {
		return spotterRepository.save(spotter);
	}
	
	public List<Spotter> getAll() {
		return spotterRepository.findAll();
	}
}
