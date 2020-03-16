package Shapes;

import java.awt.*;

/**
 * @author ����������
 * @version 1.0
 * @created 09-���-2020 21:25:01
 */
public class Segment extends Shape1D {

	protected Point secondPoint;

	public Segment(){

	}

	public Segment(Point firstPoint, Point secondPoint, Color color) {
		super(firstPoint,color);
		this.secondPoint = secondPoint;
	}

	public void draw(Graphics2D g){
		g.setColor(this.borderColor);
		g.drawLine(center.getX(), center.getY(), secondPoint.getX(), secondPoint.getY());
	}

	public Point getSecondPoint(){
		return secondPoint;
	}

	/**
	 * 
	 * @param point
	 */
	public void move(Point point){
		int offsetX = point.getX() - this.center.getX();
		int offsetY = point.getY() - this.center.getY();
		this.center = point;
		this.secondPoint.setX(this.secondPoint.getX() + offsetX);
		this.secondPoint.setY(this.secondPoint.getY() + offsetY);
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setsecondPoint(Point newVal){
		secondPoint = newVal;
	}

}