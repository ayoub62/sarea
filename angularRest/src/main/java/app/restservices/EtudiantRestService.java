package app.restservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dao.EtudiantDaoInt;
import app.entities.Etudiant;

@RestController
public class EtudiantRestService {

	@Autowired
	private EtudiantDaoInt etudiantDaoInt;
	
	@RequestMapping("/findAllEtudiants")
	public Page<Etudiant> findAllEtudiants(int page, int size){
		return etudiantDaoInt.findAll(new PageRequest(page, size));
	}
	
	@RequestMapping("/addOrUpdateEtudiant")
	public Etudiant addOrUpdateEtudiant(Etudiant etd) {
		return etudiantDaoInt.save(etd);
	}
	
	@RequestMapping("/deleteEtudiant")
	public void deleteEtudiant(Long id) {
		Etudiant etd = etudiantDaoInt.findOne(id);
		etudiantDaoInt.delete(etd);
	}
}
