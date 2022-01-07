package site;



/**
 * Classe qui contient les informations de l'utilisateur.
 * @author Mouss
 *
 */
public class Utilisateur {
	
	private String Adresse_mail;
	private String Mot_de_passe;
	private String nom;
	private String prenom;


	public Utilisateur(String adresse_mail, String mot_de_passe, String nom, String prenom) {
		super();
		Adresse_mail = adresse_mail;
		Mot_de_passe = mot_de_passe;
		this.nom = nom;
		this.prenom = prenom;
	}

	//Getters et Setters
	
	public String getAdresse_mail() {
		return Adresse_mail;
	}

	public void setAdresse_mail(String adresse_mail) {
		Adresse_mail = adresse_mail;
	}

	public String getMot_de_passe() {
		return Mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		Mot_de_passe = mot_de_passe;
	}

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
