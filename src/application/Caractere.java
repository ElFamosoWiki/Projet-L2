package site;

/**
 * Le type Caractère d'une composante sous forme de classe, elle hérite de la classe Composante
 *  @author Mouss
 */

public class Caractere extends Composante {

	// Constructeur de la classe Caractère à l'aide de la classe Composante
	public Caractere(Point hautG, Point basD,String commentaire, String police) {
		super(hautG, basD, commentaire,police);
	}

}
