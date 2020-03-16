package Shapes;

import java.awt.*;

/**
 * @author Ivan
 * @version 1.0
 * @created 09-���-2020 21:25:00
 */
public abstract class Shape2D extends Shape {

	protected Color fillingColor;

	public Shape2D(){

	}

	public void draw(Graphics2D g){

	}

	public Color getfillingColor(){
		return fillingColor;
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
	public void setfillingColor(Color newVal){
		fillingColor = newVal;
	}

}