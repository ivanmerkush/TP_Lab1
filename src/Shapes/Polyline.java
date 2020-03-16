package Shapes;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Ivan
 * @version 1.0
 * @created 09-���-2020 21:25:01
 */
public class Polyline extends Shape1D {

	private ArrayList<Point> points;

	public Polyline(){

	}

	public Polyline(ArrayList<Point> points, Color color) {
		this.points = new ArrayList<>(points);
		this.borderColor = color;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void draw(Graphics2D g){
		int [] xPoints = points.stream().mapToInt(p -> p.getX()).toArray();
		int [] yPoints = points.stream().mapToInt(p -> p.getY()).toArray();
		g.setColor(borderColor);
		g.drawPolyline(xPoints, yPoints, points.size());
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