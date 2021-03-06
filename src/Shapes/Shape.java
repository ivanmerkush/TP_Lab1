package Shapes;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Ivan
 * @version 1.0
 * @created 09-���-2020 21:25:01
 */
public abstract class Shape {

	protected Color borderColor;
	protected Point center;

	public Shape(){

	}


	public abstract void draw(Graphics2D g);

	public Color getBorderColor(){
		return borderColor;
	}

	public Point getCenter(){
		return center;
	}


	public abstract Point locate();

	void setOffset(Point point, ArrayList<Point> points) {
		int offsetX = point.getX() - points.get(0).getX();
		int offsetY = point.getY() - points.get(0).getY();
		for(Point i: points) {
			i.setX(i.getX() + offsetX);
			i.setY(i.getY() + offsetY);
		}
	}
	/**
	 * 
	 * @param newPoint
	 */
	public abstract void move(Point newPoint);

	/**
	 * 
	 * @param newVal
	 */
	public void setBorderColor(Color newVal){
		borderColor = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCenter(Point newVal){
		center = newVal;
	}

	@Override
	public String toString() {
		return "Shape{" + center +
				'}';
	}
}