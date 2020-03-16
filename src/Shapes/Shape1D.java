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


	public abstract void draw(Graphics2D g);

	public abstract Point locate();

	/**
	 * 
	 * @param point
	 */
	public abstract void move(Point point);

}