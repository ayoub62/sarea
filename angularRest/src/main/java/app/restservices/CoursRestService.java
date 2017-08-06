package app.restservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dao.CoursDaoInt;
import app.entities.Cours;

@RestController
public class CoursRestService {

	@Autowired
	private CoursDaoInt coursDaoInt;
	
	@RequestMapping("/findAllCourss")
	public Page<Cours> findAllCourss(int page, int size){
		return coursDaoInt.findAll(new PageRequest(page, size));
	}
	
	@RequestMapping("/addOrUpdateCours")
	public Cours addOrUpdateCours(Cours etd) {
		return coursDaoInt.save(etd);
	}
	
	@RequestMapping("/deleteCours")
	public void deleteCours(Long id) {
		Cours etd = coursDaoInt.findOne(id);
		coursDaoInt.delete(etd);
	}
}
