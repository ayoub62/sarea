package app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.Professeur;

public interface ProfesseurDaoInt extends JpaRepository<Professeur, Long> {

}
