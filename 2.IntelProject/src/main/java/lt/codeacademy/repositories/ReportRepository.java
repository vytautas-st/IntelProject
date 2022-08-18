package lt.codeacademy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import lt.codeacademy.entities.Report;

public interface ReportRepository extends JpaRepository<Report, Integer>{

}
