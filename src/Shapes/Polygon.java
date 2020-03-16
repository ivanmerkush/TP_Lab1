package Shapes;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Ivan
 * @version 1.0
 * @created 09-���-2020 21:25:01
 */
public class Polygon extends Shape2D {

	protected ArrayList<Point> points;

	public Polygon(){

	}

	public Polygon(ArrayList<Point> points){
		this.points = new ArrayList<>(points);
	}

	public void draw(Graphics2D g){
		int [] xPoints = points.stream().mapToInt(p -> p.getX()).toArray();
		int [] yPoints = points.stream().mapToInt(p -> p.getY()).toArray();
		g.setColor(borderColor);
		g.drawPolygon(xPoints, yPoints, points.size());
		g.setColor(fillingColor);
		g.fillPolygon(xPoints, yPoints, points.size());

	}

	public ArrayList<Point> getPoints(){
		return points;
	}

	public Point locate(){
		return points.get(0);
	}

	/**
	 * 
	 * @param point
	 */
	public void move(Point point){
		int offsetX = point.getX() - points.get(0).getX();//points.get(0).getX() > point.getX() ? points.get(0).getX() - point.getX() : point.getX() - points.get(0).getX();
		int offsetY = point.getY() - points.get(0).getY();
		for(Point i: points) {
			i.setX(i.getX() + offsetX);
			i.setY(i.getY() + offsetY);
		}
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPoints(ArrayList<Point> newVal){
		points = newVal;
	}


}