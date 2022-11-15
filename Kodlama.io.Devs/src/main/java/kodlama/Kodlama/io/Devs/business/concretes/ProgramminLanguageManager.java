package kodlama.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.Kodlama.io.Devs.business.requests.CreateProgramminLanguageRequest;
import kodlama.Kodlama.io.Devs.business.requests.DeleteProgrammingLanguage;
import kodlama.Kodlama.io.Devs.business.requests.UpdateProgrammingLanguagaRequest;
import kodlama.Kodlama.io.Devs.business.responses.GetAllProgramminLanguageResponse;
import kodlama.Kodlama.io.Devs.business.responses.GetByIdProgrammingLanguageResponse;
import kodlama.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.Kodlama.io.Devs.entities.concretes.ProgrammingLanguege;

@Service
public class ProgramminLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProgramminLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;

	}

	@Override
	public List<GetAllProgramminLanguageResponse> getAll() {
		List<ProgrammingLanguege> programmingLangueges = programmingLanguageRepository.findAll();
		List<GetAllProgramminLanguageResponse> getAllProgramminLanguageResponses = new ArrayList<GetAllProgramminLanguageResponse>();
		for (ProgrammingLanguege languege : programmingLangueges) {
			GetAllProgramminLanguageResponse getAllProgramminLanguageResponse = new GetAllProgramminLanguageResponse();
			getAllProgramminLanguageResponse.setId(languege.getId());
			getAllProgramminLanguageResponse.setName(languege.getName());
			getAllProgramminLanguageResponses.add(getAllProgramminLanguageResponse);

		}
		return getAllProgramminLanguageResponses;
	}

	@Override
	public void add(CreateProgramminLanguageRequest createProgramminLanguageRequest) throws Exception {

		List<ProgrammingLanguege> programmingLangueges=programmingLanguageRepository.findAll();
		if (createProgramminLanguageRequest.getName().isEmpty()&&createProgramminLanguageRequest.getName().isBlank()) {
			throw new Exception("Program adı boş geçilemez");
		}
		
		for (ProgrammingLanguege programmingLanguege : programmingLangueges) {
			if (programmingLanguege.getName().equals(createProgramminLanguageRequest.getName())) {
				throw new Exception("Aynı isimde program mevcut");
			}
		}
		ProgrammingLanguege programmingLanguege = new ProgrammingLanguege();
		
		programmingLanguege.setName(createProgramminLanguageRequest.getName());
		this.programmingLanguageRepository.save(programmingLanguege);

	}

	@Override
	public GetByIdProgrammingLanguageResponse getById(int id) {
		ProgrammingLanguege programmingLanguege = programmingLanguageRepository.getReferenceById(id);
		GetByIdProgrammingLanguageResponse getByIdProgrammingLanguageResponse = new GetByIdProgrammingLanguageResponse();
		getByIdProgrammingLanguageResponse.setId(programmingLanguege.getId());
		getByIdProgrammingLanguageResponse.setName(programmingLanguege.getName());

		return getByIdProgrammingLanguageResponse;
	}

	@Override
	public void update(UpdateProgrammingLanguagaRequest updateProgrammingLanguagaRequest) {

		ProgrammingLanguege programmingLanguege = new ProgrammingLanguege();
		programmingLanguege.setId(updateProgrammingLanguagaRequest.getId());
		programmingLanguege.setName(updateProgrammingLanguagaRequest.getName());
		this.programmingLanguageRepository.save(programmingLanguege);
	}

	@Override
	public void delete(DeleteProgrammingLanguage deleteProgrammingLanguage) {
		this.programmingLanguageRepository.deleteById(deleteProgrammingLanguage.getId());

	}

	public boolean isNameCheck(String name) throws Exception {
		List<ProgrammingLanguege> programmingLangueges = programmingLanguageRepository.findAll();
		for (ProgrammingLanguege programmingLanguege : programmingLangueges) {
			if (programmingLanguege.getName().equals(name)) {
				throw new Exception("Aynı İsimde Program mevcut");
			}
		}
		return false;
	}

}
