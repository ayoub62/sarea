package app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.Admin;

public interface AdminDaoInt extends JpaRepository<Admin, String> {

	public Admin findByUsername(String username);
}
