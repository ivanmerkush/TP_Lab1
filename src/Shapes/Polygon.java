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

	public Polygon(ArrayList<Point> points, Color borderColor, Color fillingColor){
		this.points = new ArrayList<>(points);
		this.borderColor = borderColor;
		this.fillingColor = fillingColor;
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
		setOffset(point, points);
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPoints(ArrayList<Point> newVal){
		points = newVal;
	}


}