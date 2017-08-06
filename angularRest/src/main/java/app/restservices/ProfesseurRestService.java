package app.restservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dao.ProfesseurDaoInt;
import app.entities.Professeur;

@RestController
public class ProfesseurRestService {

	@Autowired
	private ProfesseurDaoInt professeurDaoInt;
	
	@RequestMapping("/findAllProfesseurs")
	public Page<Professeur> findAllProfesseurs(int page, int size){
		return professeurDaoInt.findAll(new PageRequest(page, size));
	}
	
	@RequestMapping("/addOrUpdateProfesseur")
	public Professeur addOrUpdateProfesseur(Professeur etd) {
		return professeurDaoInt.save(etd);
	}
	
	@RequestMapping("/deleteProfesseur")
	public void deleteProfesseur(Long id) {
		Professeur etd = professeurDaoInt.findOne(id);
		professeurDaoInt.delete(etd);
	}
}
