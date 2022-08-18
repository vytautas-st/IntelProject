package lt.codeacademy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lt.codeacademy.entities.Report;
import lt.codeacademy.repositories.ReportRepository;

@Service
public class ReportService {
	@Autowired
	ReportRepository reportRepository;
	
	public Report save(Report report) {
		return reportRepository.save(report);
	}
	
	public List<Report> getAll() {
		return reportRepository.findAll();
	}
}
