package kodlama.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.Kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import kodlama.Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.Kodlama.io.Devs.business.responses.GetAllTechnologyResponse;
import kodlama.Kodlama.io.Devs.business.responses.GetByIdTechnologyResponse;


public interface TechnologyService {

	List<GetAllTechnologyResponse> getAll();
	List<GetAllTechnologyResponse> findByProgrammingLanguege(int programmingLanguageId);

	GetByIdTechnologyResponse getById(int id);

	void add(CreateTechnologyRequest createTechnologyRequest);

	void update(UpdateTechnologyRequest updateTechnologyRequest);

	void delete(DeleteTechnologyRequest deleteTechnologyRequest);
}
