package site;

/**
 * Classe Auteur qui contient les variables nom et prenom
 */

public class Auteur {
	private String nom;
	private String prenom;

	// Constructeur

	public Auteur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	// Getters and Setters

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
