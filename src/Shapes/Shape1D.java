package Shapes;

import java.awt.*;

/**
 * @author Ivan
 * @version 1.0
 * @created 09-���-2020 21:25:00
 */
public abstract class Shape1D extends Shape {

	public Shape1D(){

	}

	public Shape1D(Point center, Color color) {
		this.center = center;
		this.borderColor = color;
	}

	public abstract void draw(Graphics2D g);

	public Point locate() {
		return this.center;
	}

	/**
	 * 
	 * @param point
	 */
	public abstract void move(Point point);

}