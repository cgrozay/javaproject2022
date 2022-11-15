package kodlama.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.Kodlama.io.Devs.business.requests.CreateProgramminLanguageRequest;
import kodlama.Kodlama.io.Devs.business.requests.DeleteProgrammingLanguage;
import kodlama.Kodlama.io.Devs.business.requests.UpdateProgrammingLanguagaRequest;
import kodlama.Kodlama.io.Devs.business.responses.GetAllProgramminLanguageResponse;
import kodlama.Kodlama.io.Devs.business.responses.GetByIdProgrammingLanguageResponse;


public interface ProgrammingLanguageService {

	List<GetAllProgramminLanguageResponse> getAll();
	GetByIdProgrammingLanguageResponse getById(int id);
	public void add(CreateProgramminLanguageRequest createProgramminLanguageRequest) throws Exception ;
	public void update(UpdateProgrammingLanguagaRequest updateProgrammingLanguagaRequest);
	public void delete(DeleteProgrammingLanguage deleteProgrammingLanguage);
	
	
	
}
