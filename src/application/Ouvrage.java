package site;


/**
 * La classe Ouvrage contient les informations relatives à l'ouvrage
 * @author Mouss
 *
 */
public class Ouvrage {

	private String Titre;
	private int nb_page;
	private String Lieux_associes;
	private int Annee_edit;
	private String Commentaires;
	

	/**
	 * Le constructeur de la classe qu initiliase les informations de l'ouvrage
	 * @param titre : Titre de l'ouvrage
	 * @param nb_page : nombre de pages de l'ouvrage
	 * @param lieux_associes : Les lieux associés à l'ouvrage
	 * @param annee_edit : L'année d'édition de l'ouvrage
	 * @param commentaires
	 */
	public Ouvrage(String titre, int nb_page, String lieux_associes, int annee_edit, String commentaires) {
		super();
		Titre = titre;
		this.nb_page = nb_page;
		Lieux_associes = lieux_associes;
		Annee_edit = annee_edit;
		Commentaires = commentaires;
	}

	// Getters

	public String getTitre() {
		return Titre;
	}

	public int getNb_page() {
		return nb_page;
	}

	public String getLieux_associes() {
		return Lieux_associes;
	}

	public int getAnnee_edit() {
		return Annee_edit;
	}

	public String getCommentaires() {
		return Commentaires;
	}

}
