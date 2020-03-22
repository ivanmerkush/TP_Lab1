package Shapes;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author ����������
 * @version 1.0
 * @created 09-���-2020 21:25:01
 */
public class RegularPolygon extends Polygon {

	public RegularPolygon(Point center, Point borderPoint, int numberOfSides, Color borderColor, Color fillingColor){
		points = new ArrayList<>();
		double horizontal = center.getX() > borderPoint.getX() ? center.getX() - borderPoint.getX() : borderPoint.getX() - center.getX();
		double vertical = center.getY() > borderPoint.getY() ? center.getY() - borderPoint.getY() : borderPoint.getY() - center.getY();
		double radius = Math.sqrt(Math.pow(horizontal,2) + Math.pow(vertical,2));
		double angle = 360.0 / numberOfSides;
		double z = Math.toDegrees(Math.asin(vertical / radius));
		for (int i = 0; i < numberOfSides; i++) { //цикл для создания списка точек
			double a = Math.cos( z/180*Math.PI);
			double b = Math.sin( z/180*Math.PI);
			points.add(new Point(center.getX() < borderPoint.getX() ? center.getX() + (int) (a * radius) : center.getX() - (int) (a * radius),
					center.getY() < borderPoint.getY() ? center.getY() + (int) (b * radius) : center.getY() - (int) (b * radius)));
			z += angle;
		}
        this.borderColor = borderColor;
		this.fillingColor = fillingColor;
	}


}