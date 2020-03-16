package Shapes;

import java.awt.*;

/**
 * @author Ivan
 * @version 1.0
 * @created 09-���-2020 21:25:01
 */
public class Polyline extends Shape1D {

	private Point[] points;

	public Polyline(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void draw(Graphics2D g){

	}

	public Point[] getpoints(){
		return points;
	}

	public Point locate(){
		return null;
	}

	/**
	 * 
	 * @param point
	 */
	public void move(Point point){

	}

	/**
	 * 
	 * @param newVal
	 */
	public void setpoints(Point[] newVal){
		points = newVal;
	}

}