package Application;

import Shapes.Shape;


import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    Panel(BorderLayout borderLayout)
    {
        super(borderLayout);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Shape i : App.listOfShape) {
            i.draw(g2d);
        }
    }
}
