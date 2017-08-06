package app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.Etudiant;

public interface EtudiantDaoInt extends JpaRepository<Etudiant, Long>{

}
