package kodlama.Kodlama.io.Devs.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.Kodlama.io.Devs.entities.concretes.ProgrammingLanguege;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguege, Integer>{
	
	

}
