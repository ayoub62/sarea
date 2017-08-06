package app.entities;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Cours {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String matiere;
	private LocalDate date;
	@ManyToMany
	@JoinTable(name="cours_etudiants")
	private Collection<Etudiant> etudiants;
	@ManyToOne
	@JoinColumn(name="prof_id")
	private Professeur professeur;
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	public Professeur getProfesseur() {
		return professeur;
	}
	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cours(String matiere, LocalDate date) {
		this.matiere = matiere;
		this.date = date;
	}
	public Cours() {
	}
}
