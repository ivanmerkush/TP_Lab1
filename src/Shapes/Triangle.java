package Shapes;


import java.awt.*;
import java.util.ArrayList;

/**
 * @author ����������
 * @version 1.0
 * @created 09-���-2020 21:25:01
 */
public class Triangle extends Polygon {


	public Triangle(){

	}
	public Triangle(Point vertex1, Point vertex2, Point vertex3, Color borderColor, Color fillingColor) {
		points = new ArrayList<>(3);

		points.add(vertex1);
		points.add(vertex2);
		points.add(vertex3);
		this.borderColor = borderColor;
		this.fillingColor = fillingColor;
	}
	public void finalize() throws Throwable {
		super.finalize();
	}

}