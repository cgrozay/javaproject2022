package kodlama.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.Kodlama.io.Devs.business.requests.CreateProgramminLanguageRequest;
import kodlama.Kodlama.io.Devs.business.requests.DeleteProgrammingLanguage;
import kodlama.Kodlama.io.Devs.business.requests.UpdateProgrammingLanguagaRequest;
import kodlama.Kodlama.io.Devs.business.responses.GetAllProgramminLanguageResponse;
import kodlama.Kodlama.io.Devs.business.responses.GetByIdProgrammingLanguageResponse;

@RestController
@RequestMapping("/api/programminglanguage")
public class ProgramminLanguageController {

	private ProgrammingLanguageService programmingLanguageService;

	public ProgramminLanguageController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}

	@GetMapping("/getall")
	public List<GetAllProgramminLanguageResponse> getAll() {
		return programmingLanguageService.getAll();
	}
	@PostMapping("/add")
	public void add(CreateProgramminLanguageRequest createProgramminLanguageRequest) throws Exception {
		this.programmingLanguageService.add(createProgramminLanguageRequest);
	}
	
	@GetMapping("/id")
	public GetByIdProgrammingLanguageResponse getById(int id) {
		return this.programmingLanguageService.getById(id);
	}
	@PutMapping("/update")
	public void update(UpdateProgrammingLanguagaRequest updateProgrammingLanguagaRequest) {
		this.programmingLanguageService.update(updateProgrammingLanguagaRequest);
	}
	@DeleteMapping("/delete")
	public void delete(DeleteProgrammingLanguage deleteProgrammingLanguage) {
		this.programmingLanguageService.delete(deleteProgrammingLanguage);
	}
}
