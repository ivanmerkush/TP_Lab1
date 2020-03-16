package Shapes;

import java.awt.*;

/**
 * @author Ivan
 * @version 1.0
 * @created 09-���-2020 21:25:01
 */
public class Ray extends Segment {

	public Ray(){

	}

	public Ray(Point firstPoint, Point secondPoint, Color color) {
		super(firstPoint, secondPoint, color);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void draw(Graphics2D g){
		int offsetX = this.secondPoint.getX() - this.center.getX();
		int offsetY = this.secondPoint.getY() - this.center.getY();
		double k = (double) offsetY / (double) offsetX;
		double b = this.secondPoint.getY() - k * this.secondPoint.getX();
		g.setColor(this.borderColor);
		g.drawLine(this.center.getX(), this.center.getY(),
				offsetX > 0 ? 10000 : -10000,
				(int) (offsetX > 0 ? k * 10000 + b : k *(-10000) + b));
	}

}