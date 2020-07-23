package au.com.dev.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import au.com.dev.dto.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{

}
