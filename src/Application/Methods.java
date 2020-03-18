package Application;

import Shapes.Point;
import Shapes.Shape;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Methods {

    public static void drawPoint(Panel panel, ArrayList<Point> currentPoints, MouseEvent mouseEvent) {
        panel.getGraphics().drawOval(mouseEvent.getX() -5 , mouseEvent.getY() - 5, 10,10);
        currentPoints.add(new Shapes.Point(mouseEvent.getX(), mouseEvent.getY()));
    }

    public static int setRequiredNumber() {
        JTextField textField = new JTextField();
        final JComponent[] inputs = new JComponent[] { new JLabel(""), textField };
        int result = JOptionPane.showConfirmDialog(null, inputs, "Enter please", JOptionPane.DEFAULT_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            return Integer.parseInt(textField.getText());
        } else {

        }
        return Integer.parseInt(textField.getText());
    }


    public static Point move() {
        JTextField textFieldX = new JTextField();
        JTextField textFieldY = new JTextField();
        final JComponent[] inputs = new JComponent[] { new JLabel("X"), textFieldX, new JLabel("Y"), textFieldY};
        int result = JOptionPane.showConfirmDialog(null, inputs, "Enter please", JOptionPane.DEFAULT_OPTION);
        return new Point(Integer.parseInt(textFieldX.getText()), Integer.parseInt(textFieldY.getText()));

    }

    public static void locateShape(Shape shape) {
        int result = JOptionPane.showConfirmDialog(null,
                new String[] {"Location of first point:",
                        "X = " + shape.locate().getX(),
                        "Y = " + shape.locate().getY()},
                "",
                JOptionPane.DEFAULT_OPTION);
    }
}
