package Shapes;

import java.awt.*;

/**
 * @author ����������
 * @version 1.0
 * @created 09-���-2020 21:25:01
 */
public class Segment extends Shape1D {

	private Point secondPoint;

	public Segment(){

	}

	public void draw(Graphics2D g){

	}

	public Point getsecondPoint(){
		return secondPoint;
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
	public void setsecondPoint(Point newVal){
		secondPoint = newVal;
	}

}