package app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import app.dao.AdminDaoInt;
import app.entities.Admin;

@Component
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private AdminDaoInt adminDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminDao.findByUsername(username);
		if(admin != null)
			return adminDao.findByUsername(username);
		else
			throw new UsernameNotFoundException("cet admin n'existe pas");
	}

}