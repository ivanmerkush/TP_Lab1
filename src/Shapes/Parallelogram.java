package Shapes;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author ����������
 * @version 1.0
 * @created 09-���-2020 21:25:01
 */
public class Parallelogram extends Polygon {

	public Parallelogram(){

	}
	public Parallelogram(Point base1, Point base2, Point side, Color borderColor, Color fillingColor){
		points = new ArrayList<>(4);
		int offsetX = side.getX() - base2.getX();
		int offsetY = side.getY() - base2.getY();

		points.add(base1);
		points.add(base2);
		points.add(side);
		points.add(new Point(base1.getX() + offsetX, base1.getY() + offsetY));
		this.borderColor = borderColor;
		this.fillingColor = fillingColor;
	}



}