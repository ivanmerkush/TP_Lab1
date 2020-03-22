package Shapes;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Ivan
 * @version 1.0
 * @created 09-���-2020 21:25:00
 */
public class IsoscelesTriangle extends Polygon {

	public IsoscelesTriangle(){

	}

	public IsoscelesTriangle(Point firstPoint, Point secondPoint, int height, Color borderColor, Color fillingColor) {
	    int bigX, smallX, bigY, smallY;
	    if(firstPoint.getX() > secondPoint.getX()) {
	        bigX = firstPoint.getX();
	        smallX = secondPoint.getX();
        }
	    else {
	        bigX = secondPoint.getX();
	        smallX = firstPoint.getX();
        }
        if(firstPoint.getY() > secondPoint.getY()) {
            bigY = firstPoint.getY();
            smallY = secondPoint.getY();
        }
        else {
            bigY = secondPoint.getY();
            smallY = firstPoint.getY();
        }
		Point midPoint = new Point((bigX - smallX) / 2 + smallX, (bigY - smallY) / 2  + smallY);
		double z = Math.atan((double)(bigY - smallY) / (double)(bigX - smallX));
		int vertexX;
		int vertexY;
        vertexX = firstPoint.getY() > secondPoint.getY() ? (int)(midPoint.getX() - height * Math.sin(z)) : (int)(midPoint.getX() + height * Math.sin(z));
        vertexY = firstPoint.getX() > secondPoint.getX() ? (int) (midPoint.getY() + height * Math.cos(z)) : (int) (midPoint.getY() - height * Math.cos(z));
		Point vertex = new Point(vertexX, vertexY);
		this.points = new ArrayList<>();
        points.add(firstPoint);
        points.add(secondPoint);
        points.add(vertex);
        this.borderColor = borderColor;
        this.fillingColor = fillingColor;
	}
	public void finalize() throws Throwable {
		super.finalize();
	}

}