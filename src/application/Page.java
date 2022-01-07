package site;

/**
 * Classe Page qui herite de la classe ouvrage et qui contient la variable
 * numero de page
 */

public class Page extends Ouvrage {

	private int num_page;

	// Constructeur

	public Page(String titre, int nb_page, String lieux_associes, int annee_edit, String commentaires, int num_page) {
		super(titre, nb_page, lieux_associes, annee_edit, commentaires);
		this.num_page = num_page;
	}

	// Getters

	public int getNum_page() {
		return num_page;
	}

}
