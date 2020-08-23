package au.com.dev.sdm.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import au.com.dev.sdm.dto.Resource;

@Repository
@Transactional
public interface ResourceRepository extends JpaRepository<Resource, Long>{

}
