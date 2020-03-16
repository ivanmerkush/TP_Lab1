package Shapes;

/**
 * @author ����������
 * @version 1.0
 * @created 09-���-2020 21:25:00
 */
public class Circle extends Ellipse {


	public Circle(Point center, Point majorPoint) {
		this.center = center;
		this.majorPoint = majorPoint;
		double horizontal = center.getX() > majorPoint.getX() ? Math.pow(center.getX() - majorPoint.getX(), 2) : Math.pow(majorPoint.getX() - center.getX(), 2);
		double vertical = center.getY() > majorPoint.getY() ? Math.pow(center.getY() - majorPoint.getY(), 2) : Math.pow(majorPoint.getY() - center.getY(), 2);
		double length = Math.sqrt(horizontal + vertical);
		this.minorPoint = new Point(center.getX(), center.getY() - (int) length);
		this.majorPoint = new Point(center.getX() - (int)length, center.getY());
	}


}