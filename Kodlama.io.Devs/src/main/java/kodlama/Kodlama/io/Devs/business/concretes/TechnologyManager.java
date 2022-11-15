package kodlama.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.Kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.Kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import kodlama.Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.Kodlama.io.Devs.business.responses.GetAllTechnologyResponse;
import kodlama.Kodlama.io.Devs.business.responses.GetByIdProgrammingLanguageResponse;
import kodlama.Kodlama.io.Devs.business.responses.GetByIdTechnologyResponse;
import kodlama.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.Kodlama.io.Devs.entities.concretes.ProgrammingLanguege;
import kodlama.Kodlama.io.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

	private TechnologyRepository technologyRepository;
	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository,
			ProgrammingLanguageService programmingLanguageService,
			ProgrammingLanguageRepository programmingLanguageRepository) {
		this.technologyRepository = technologyRepository;
		this.programmingLanguageService = programmingLanguageService;

	}

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologyResponse> getAllTechnologyResponses = new ArrayList<GetAllTechnologyResponse>();
		for (Technology technology : technologies) {
			GetAllTechnologyResponse getAllTechnologyResponse = new GetAllTechnologyResponse();
			getAllTechnologyResponse.setId(technology.getId());
			getAllTechnologyResponse.setProgrammingLanguageId(technology.getProgrammingLanguege().getId());
			getAllTechnologyResponse.setName(technology.getName());
			getAllTechnologyResponses.add(getAllTechnologyResponse);
		}
		return getAllTechnologyResponses;
	}

	@Override
	public GetByIdTechnologyResponse getById(int id) {
		Technology technology = technologyRepository.getReferenceById(id);
		GetByIdTechnologyResponse getByIdTechnologyResponse = new GetByIdTechnologyResponse();
		getByIdTechnologyResponse.setId(technology.getId());
		getByIdTechnologyResponse.setProgrammingLanguageId(technology.getProgrammingLanguege().getId());
		getByIdTechnologyResponse.setName(technology.getName());
		return getByIdTechnologyResponse;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = new Technology();
		ProgrammingLanguege programmingLanguege = new ProgrammingLanguege();
		GetByIdProgrammingLanguageResponse getByIdProgrammingLanguageResponse = programmingLanguageService
				.getById(createTechnologyRequest.getProgramminLanguageId());

		programmingLanguege.setId(getByIdProgrammingLanguageResponse.getId());
		technology.setProgrammingLanguege(programmingLanguege);
		technology.setName(createTechnologyRequest.getName());
		this.technologyRepository.save(technology);

	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		Technology technology = new Technology();
		ProgrammingLanguege programmingLanguege = new ProgrammingLanguege();
		GetByIdProgrammingLanguageResponse getByIdProgrammingLanguageResponse = programmingLanguageService
				.getById(updateTechnologyRequest.getProgrammingLanguageId());
		programmingLanguege.setId(getByIdProgrammingLanguageResponse.getId());
		programmingLanguege.setName(getByIdProgrammingLanguageResponse.getName());
		technology.setId(updateTechnologyRequest.getId());
		technology.setProgrammingLanguege(programmingLanguege);
		technology.setName(updateTechnologyRequest.getName());
		this.technologyRepository.save(technology);

	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		this.technologyRepository.deleteById(deleteTechnologyRequest.getId());

	}

	// Technology de bulunan Programların id sine göre listeleme
	// Bu işlem yapılmadan önce TechnologyRepository de Sorgu yazılmıştır.
	@Override
	public List<GetAllTechnologyResponse> findByProgrammingLanguege(int programmingLanguageId) {
	// findByProgrammingLanguage metodu TechnologyRepositoriy de Spring Data JPA nın @Query anotasyonu ile kullanılmıştır.
		List<Technology> technologies = technologyRepository.findByProgrammingLanguege(programmingLanguageId);
		List<GetAllTechnologyResponse> getAllTechnologyResponses = new ArrayList<GetAllTechnologyResponse>();

		for (Technology technology : technologies) {
			GetAllTechnologyResponse getAllTechnologyResponse = new GetAllTechnologyResponse();
			getAllTechnologyResponse.setId(technology.getId());
			getAllTechnologyResponse.setProgrammingLanguageId(technology.getProgrammingLanguege().getId());
			getAllTechnologyResponse.setName(technology.getName());
			getAllTechnologyResponses.add(getAllTechnologyResponse);
		}
		return getAllTechnologyResponses;
		
	}
	
	
	

}
