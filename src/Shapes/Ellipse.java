package Shapes;

import Application.App;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @author Ivan
 * @version 1.0
 * @created 09-���-2020 21:25:00
 */
public class Ellipse extends Shape2D {

	protected Point majorPoint;
	protected Point minorPoint;

	Ellipse(){

	}

	public Ellipse(Point center, Point majorPoint, Point minorPoint, Color borderColor, Color fillingColor) {
		this.center = center;
		this.majorPoint = majorPoint;
		this.minorPoint = minorPoint;
		this.borderColor = borderColor;
		this.fillingColor = fillingColor;
	}

	public void draw(Graphics2D g){
		g.setColor(borderColor);
		g.drawOval(this.center.getX() > this.majorPoint.getX() ? this.majorPoint.getX() : 2 * this.center.getX() - this.majorPoint.getX() ,
				this.center.getY() > this.minorPoint.getY() ? this.minorPoint.getY() : 2 * this.center.getY() - this.minorPoint.getY() ,
				this.center.getX() > this.majorPoint.getX()? 2 * (this.center.getX() - this.majorPoint.getX()): 2 * (this.majorPoint.getX() - this.center.getX()),
				this.center.getY() > this.minorPoint.getY()? 2 * (this.center.getY() - this.minorPoint.getY()): 2 * (this.minorPoint.getY() - this.center.getY()));
		g.setColor(fillingColor);
		g.fillOval(this.center.getX() > this.majorPoint.getX() ? this.majorPoint.getX() : 2 * this.center.getX() - this.majorPoint.getX() ,
				this.center.getY() > this.minorPoint.getY() ? this.minorPoint.getY() : 2 * this.center.getY() - this.minorPoint.getY() ,
				this.center.getX() > this.majorPoint.getX()? 2 * (this.center.getX() - this.majorPoint.getX()): 2 * (this.majorPoint.getX() - this.center.getX()),
				this.center.getY() > this.minorPoint.getY()? 2 * (this.center.getY() - this.minorPoint.getY()): 2 * (this.minorPoint.getY() - this.center.getY()));
	}

	public Point getMajorPoint(){
		return majorPoint;
	}

	public Point getMinorPoint(){
		return minorPoint;
	}

	public Point locate(){
		return this.center;
	}

	/**
	 * 
	 * @param point
	 */
	public void move(Point point) {
		int offsetX = point.getX() - this.center.getX();
		int offsetY = point.getY() - this.center.getY();
		this.center = point;
		this.majorPoint.setX(this.majorPoint.getX() + offsetX);
		this.majorPoint.setY(this.majorPoint.getY() + offsetY);
		this.minorPoint.setX(this.minorPoint.getX() + offsetX);
		this.minorPoint.setY(this.minorPoint.getY() + offsetY);
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMajorPoint(Point newVal){
		majorPoint = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinorPoint(Point newVal){
		minorPoint = newVal;
	}

}