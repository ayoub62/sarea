package app.restservices;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dao.AdminDaoInt;
import app.entities.Admin;

@RestController
public class AdminRestService {

	@Autowired
	private AdminDaoInt adminDaoInt;
	
	@RequestMapping("/findAllAdmins")
	public Page<Admin> findAllAdmins(int page, int size){
		return adminDaoInt.findAll(new PageRequest(page, size));
	}
	
	@RequestMapping("/addOrUpdateAdmin")
	public Admin addOrUpdateAdmin(Admin etd) {
		return adminDaoInt.save(etd);
	}
	
	@RequestMapping("/deleteAdmin")
	public void deleteAdmin(String id) {
		Admin etd = adminDaoInt.findOne(id);
		adminDaoInt.delete(etd);
	}
	
	@RequestMapping("/getAuthAdmin")
	public Map<String, String> getAuthAdmin(HttpSession httpSession) {
		SecurityContext securityContext = (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
		Admin authAdmin = (Admin) securityContext.getAuthentication().getPrincipal();
		Map<String, String> map = new HashMap<>();
		map.put("username", authAdmin.getUsername());
		map.put("role", authAdmin.getRole());
		map.put("password", authAdmin.getPassword());
		return map;
	}
}
