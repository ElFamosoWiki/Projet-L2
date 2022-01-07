package site;

/**
 * Classe Point du plan avec ses cordonnées x et y
 */

public class Point {
	private double x, y;

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	//Getters et Setters
	public void setX(double p) {
		this.x = p;
	}

	public void setY(double p) {
		this.y = p;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}
};