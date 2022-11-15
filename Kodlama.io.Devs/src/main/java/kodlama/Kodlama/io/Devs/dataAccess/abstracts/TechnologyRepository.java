package kodlama.Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.Kodlama.io.Devs.entities.concretes.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer>{

	@Query("From Technology where programmingLanguege.id=:programmingLanguageId")
	List<Technology> findByProgrammingLanguege(int programmingLanguageId);
}
