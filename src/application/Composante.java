package site;


/**
 * La classe Composante contient les diff�rentes informations sur les composantes que l'algorithme va d�tecter.
 * On y a introduit la m�thode du calcul du score de similarit� entre 2 composantes.
 * Le type de base d'une composante est "unknown" et les autres types sont faits sous forme de classe.
 * @author Mouss
 *
 */
public class Composante {
	
	 private double pourcentage;
	 private double x1, x2, y1, y2; 
	 private Point hautG = new Point(x1, y1);
	 private Point basD = new Point(x2, y2); 
	 private String commentaire;
	 private String police;

	/**
	 * Constructeur de la classe Composante qui initialise les points de rep�re d'une composante, ainsi que son �ventuel commentaire
	 * @param hautG : correspond au coin en haut � gauche du rectangle encadrant la composante
	 * @param basD : correspond au coin en bas � droite du rectangle encadrant la composante
	 * @param commentaire
	 * @param police : police de caract�re de la composante
	 */
	public Composante(Point hautG, Point basD, String commentaire,String police) {
		super();
		this.hautG = hautG;
		this.basD = basD;
		this.commentaire = commentaire;
		this.police = police;
	}
	
	/**
	 * Calcul du "score" d'une composante qui correspond � la longueur de la diagonale du rectangle qui l'entoure comme indiqu� dans le sujet.
	 * @param c1 : La composante dont laquelle on calcule le "score"
	 * @return : le score de la composante en nombre r�el
	 */
	public double score() {
		double score = Math.sqrt(Math.pow((this.basD.getX()-this.hautG.getX()),2) + (Math.pow((this.basD.getY()-this.hautG.getY()),2))) ;
		return score ;
	}
	
	/**
	 * Calcul du score de similarit� entre 2 composantes en %.
	 * @param c1 : La premi�re composante compar�e
	 * @param c2 : La deuxi�me composante compar�e
	 * @return Une chaine avec le pourcentage de similarit� entre les 2 composantes
	 */
	public double similarite(Composante c1,Composante c2) {
		if(c1.score() > c2.score()) {
		pourcentage = (c2.score()/c1.score())*100;
		return this.pourcentage;
		}
		pourcentage = (c1.score()/c2.score())*100;
		return this.pourcentage;
	}

	public Point getHautG() {
		return hautG;
	}

	public Point getBasD() {
		return basD;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public void getPolice(String police) {
		this.police = police;
	}

	public double getPourcentage() {
		return pourcentage;
	}

	public String getPolice() {
		return police;
	}

}
