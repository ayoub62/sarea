package app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.Cours;

public interface CoursDaoInt extends JpaRepository<Cours, Long> {

}
