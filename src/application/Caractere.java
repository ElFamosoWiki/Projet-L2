package site;

/**
 * Le type Caract�re d'une composante sous forme de classe, elle h�rite de la classe Composante
 *  @author Mouss
 */

public class Caractere extends Composante {

	// Constructeur de la classe Caract�re � l'aide de la classe Composante
	public Caractere(Point hautG, Point basD,String commentaire, String police) {
		super(hautG, basD, commentaire,police);
	}

}
