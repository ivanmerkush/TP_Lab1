package Shapes;

import java.util.ArrayList;

/**
 * @author ����������
 * @version 1.0
 * @created 09-���-2020 21:25:01
 */
public class Rectangle extends Polygon {

	public Rectangle(){

	}
	public Rectangle(Point leftTop, Point rightBottom){
		points = new ArrayList<>();

		points.add(leftTop);
		points.add(new Point(leftTop.getX(), rightBottom.getY()));
		points.add(rightBottom);
		points.add(new Point(rightBottom.getX(), leftTop.getY()));
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}