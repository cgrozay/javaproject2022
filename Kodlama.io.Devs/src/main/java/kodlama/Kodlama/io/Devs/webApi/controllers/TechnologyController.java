package kodlama.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.Kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.Kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import kodlama.Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.Kodlama.io.Devs.business.responses.GetAllTechnologyResponse;
import kodlama.Kodlama.io.Devs.business.responses.GetByIdTechnologyResponse;
import kodlama.Kodlama.io.Devs.entities.concretes.Technology;

@RequestMapping("/api/technology")
@RestController
public class TechnologyController {

	private TechnologyService technologyService;
	@Autowired
	public TechnologyController(TechnologyService technologyService) {
		this.technologyService=technologyService;
	}
	
	@GetMapping("/getall")
	public List<GetAllTechnologyResponse> getAll() {
		return this.technologyService.getAll();
	}
	@PostMapping("/add")
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		this.technologyService.add(createTechnologyRequest);
	}
	@PutMapping("/update")
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		this.technologyService.update(updateTechnologyRequest);
	}
	@GetMapping("/id")
	public GetByIdTechnologyResponse getById(int id) {
		return this.technologyService.getById(id);
	}
	@DeleteMapping("/delete")
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		this.technologyService.delete(deleteTechnologyRequest);
	}
	@GetMapping("/programminglanguageid")
	public List<GetAllTechnologyResponse> findByProgrammingLanguege(int languageId){
		return this.technologyService.findByProgrammingLanguege(languageId);
	}
	
}
