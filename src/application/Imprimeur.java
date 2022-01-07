package site;

/**
 * Classe Imprimeur qui contient la variable nom 
 */

public class Imprimeur {
	
	private String nom ;

	//Constructeur
	
	public Imprimeur(String nom) {
		super();
		this.nom = nom;
	}

	//Getters and Setters 
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	

}
