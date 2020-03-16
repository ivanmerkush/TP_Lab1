package Application;
import Shapes.*;
import Shapes.Point;
import Shapes.Polygon;
import Shapes.Rectangle;
import Shapes.Shape;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Vector;

import javax.swing.*;

public class App {

    private TypeOfShape currentType = TypeOfShape.NONE;
    private Panel panel;
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu mnShapes;
    private JMenuItem btnSegment;
    private JMenuItem btnRay;
    private JMenuItem btnLine;
    private JMenuItem btnPolyline;
    private JMenuItem btnTriangle;
    private JMenuItem btnRectangle;
    private JMenuItem btnParallelogram;
    private JMenuItem btnRegularPolygon;
    private JMenuItem btnIsoscelesTriangle;
    private JMenuItem btnEllipse;
    private JMenuItem btnCircle;
    private JMenuItem btnPolygon;
    private JMenuItem btnFinishBuilding;
    private JMenu mnColor;
    private JMenuItem border;
    private JMenuItem filling;
    private JButton btnLocate;
    private JButton btnMove;
    private ArrayList<Shapes.Point> currentPoints;
    private int numberOfSides;
    static ArrayList<Shape> listOfShape;
    private JColorChooser chooser;
    private Color borderColor = Color.black;
    private Color fillingColor = Color.black;
    private int selected;
    private DefaultListModel<String> info = new DefaultListModel<String>();
    private JList<String> list   = new JList<String>(info);
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    App window = new App();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public App() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1196, 787);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new Panel(new BorderLayout());

        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        mnShapes = new JMenu("Shapes");
        menuBar.add(mnShapes);

        btnSegment = new JMenuItem("Segment");
        btnSegment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                currentType = TypeOfShape.SEGMENT;
                currentPoints.clear();
            }
        });
        mnShapes.add(btnSegment);

        btnRay = new JMenuItem("Ray");
        btnRay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                currentType = TypeOfShape.RAY;
                currentPoints.clear();
            }
        });
        mnShapes.add(btnRay);

        btnLine = new JMenuItem("Line");
        btnLine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                currentType = TypeOfShape.LINE;
                currentPoints.clear();
            }
        });
        mnShapes.add(btnLine);

        btnPolyline = new JMenuItem("Polyline");
        btnPolyline.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                btnFinishBuilding.setEnabled(true);
                currentType = TypeOfShape.POLYLINE;
                currentPoints.clear();
            }
        });
        mnShapes.add(btnPolyline);

        btnTriangle = new JMenuItem("Triangle");
        btnTriangle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                currentType = TypeOfShape.TRIANGLE;
                currentPoints.clear();
            }
        });
        mnShapes.add(btnTriangle);

        btnRectangle = new JMenuItem("Rectangle");
        btnRectangle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                currentType = TypeOfShape.RECTANGLE;
                currentPoints.clear();
            }
        });
        mnShapes.add(btnRectangle);

        btnParallelogram = new JMenuItem("Parallelogram");
        btnParallelogram.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                currentType = TypeOfShape.PARALLELOGRAM;
                currentPoints.clear();
            }
        });
        mnShapes.add(btnParallelogram);

        btnRegularPolygon = new JMenuItem("Regular Polygon");
        btnRegularPolygon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                numberOfSides = Methods.enterNumberOfSides();
                currentType = TypeOfShape.REGULARPOLYGON;
                currentPoints.clear();
            }
        });
        mnShapes.add(btnRegularPolygon);

        btnIsoscelesTriangle = new JMenuItem("Isosceles Triangle");
        mnShapes.add(btnIsoscelesTriangle);

        btnEllipse = new JMenuItem("Ellipse");
        btnEllipse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                currentType = TypeOfShape.ELLIPSE;
                currentPoints.clear();
            }
        });
        mnShapes.add(btnEllipse);

        btnCircle = new JMenuItem("Circle");
        btnCircle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                currentType = TypeOfShape.CIRCLE;
                currentPoints.clear();
            }
        });
        mnShapes.add(btnCircle);

        btnPolygon = new JMenuItem("Polygon");
        btnPolygon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                btnFinishBuilding.setEnabled(true);
                currentType = TypeOfShape.POLYGON;
                currentPoints.clear();
            }
        });
        mnShapes.add(btnPolygon);

        JSeparator separator = new JSeparator();
        mnShapes.add(separator);

        btnFinishBuilding = new JMenuItem("Finish building");
        btnFinishBuilding.setEnabled(false);
        btnFinishBuilding.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                switch(currentType) {
                    case POLYGON:
                        Polygon polygon = new Polygon(currentPoints);
                        polygon.setBorderColor(borderColor);
                        polygon.setfillingColor(fillingColor);
                        listOfShape.add(polygon);
                        info.addElement("Polygon");
                        panel.repaint();
                        currentType = TypeOfShape.NONE;
                        btnFinishBuilding.setEnabled(false);
                        break;
                    case POLYLINE:
                        Polyline polyline = new Polyline(currentPoints, borderColor);
                        listOfShape.add(polyline);
                        info.addElement("Polyline");
                        panel.repaint();
                        currentType = TypeOfShape.NONE;
                        btnFinishBuilding.setEnabled(false);
                        break;
                    default:
                        break;
                }
            }
        });
        mnShapes.add(btnFinishBuilding);

        mnColor = new JMenu("Color");
        menuBar.add(mnColor);

        border = new JMenuItem("Border");
        mnColor.add(border);

        filling = new JMenuItem("Filling");
        mnColor.add(filling);

        chooser = new JColorChooser();

        border.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                borderColor = JColorChooser.showDialog(chooser, "SHOW THE COLOR",
                        chooser.getColor());
            }
        });

        filling.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fillingColor = JColorChooser.showDialog(chooser, "SHOW THE COLOR",
                        chooser.getColor());
            }
        });

        btnLocate = new JButton("Locate");
        btnLocate.setEnabled(false);
        btnLocate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Methods.locateShape(listOfShape.get(selected));
            }
        });
        menuBar.add(btnLocate);


        btnMove = new JButton("Move");
        btnMove.setEnabled(false);
        btnMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Point newLocation = Methods.move();
                listOfShape.get(selected).move(newLocation);
                panel.repaint();
            }
        });
        menuBar.add(btnMove);

        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.WEST);
        frame.getContentPane().add(panel,BorderLayout.CENTER);

        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                switch(currentType) {
                    case SEGMENT:
                        Methods.drawPoint(panel, currentPoints, mouseEvent);
                        if (currentPoints.size() == 2) {
                            Segment segment = new Segment(currentPoints.get(0), currentPoints.get(1), borderColor);
                            listOfShape.add(segment);
                            info.addElement("Segment");
                            panel.repaint();
                            currentType = TypeOfShape.NONE;
                        }
                        break;
                    case RAY:
                        Methods.drawPoint(panel, currentPoints, mouseEvent);
                        if (currentPoints.size() == 2) {
                           Ray ray = new Ray(currentPoints.get(0), currentPoints.get(1), borderColor);
                            listOfShape.add(ray);
                            info.addElement("Ray");
                            panel.repaint();
                            currentType = TypeOfShape.NONE;
                        }
                        break;
                    case LINE:
                        Methods.drawPoint(panel, currentPoints, mouseEvent);
                        if (currentPoints.size() == 2) {
                            Line line = new Line(currentPoints.get(0), currentPoints.get(1), borderColor);
                            listOfShape.add(line);
                            info.addElement("Line");
                            panel.repaint();
                            currentType = TypeOfShape.NONE;
                        }
                        break;
                    case ELLIPSE:
                        Methods.drawPoint(panel, currentPoints, mouseEvent);
                        if (currentPoints.size() == 3) {
                            Ellipse ellipse = new Ellipse(currentPoints.get(0), currentPoints.get(1), currentPoints.get(2));
                            ellipse.setBorderColor(borderColor);
                            ellipse.setfillingColor(fillingColor);
                            listOfShape.add(ellipse);
                            info.addElement("Ellipse");
                            panel.repaint();
                            currentType = TypeOfShape.NONE;
                        }
                        break;
                    case CIRCLE:
                        Methods.drawPoint(panel, currentPoints, mouseEvent);
                        if (currentPoints.size() == 2) {
                            Circle circle = new Circle(currentPoints.get(0), currentPoints.get(1));
                            circle.setBorderColor(borderColor);
                            circle.setfillingColor(fillingColor);
                            listOfShape.add(circle);
                            info.addElement("Circle");
                            panel.repaint();
                            currentType = TypeOfShape.NONE;
                        }
                        break;
                    case POLYGON:
                    case POLYLINE:
                        Methods.drawPoint(panel, currentPoints, mouseEvent);
                        break;
                    case REGULARPOLYGON:
                        Methods.drawPoint(panel, currentPoints, mouseEvent);
                        if(currentPoints.size() == 2) {
                            RegularPolygon regularPolygon = new RegularPolygon(currentPoints.get(0), currentPoints.get(1), numberOfSides);
                            regularPolygon.setBorderColor(borderColor);
                            regularPolygon.setfillingColor(fillingColor);
                            listOfShape.add(regularPolygon);
                            info.addElement("Regular Polygon");
                            panel.repaint();
                            currentType = TypeOfShape.NONE;
                            numberOfSides = 0;
                        }
                        break;
                    case TRIANGLE:
                        Methods.drawPoint(panel, currentPoints, mouseEvent);
                        if(currentPoints.size() == 3) {
                            Triangle triangle = new Triangle(currentPoints.get(0), currentPoints.get(1), currentPoints.get(2));
                            triangle.setBorderColor(borderColor);
                            triangle.setfillingColor(fillingColor);
                            listOfShape.add(triangle);
                            info.addElement("Triangle");
                            panel.repaint();
                            currentType = TypeOfShape.NONE;
                        }
                        break;
                    case PARALLELOGRAM:
                        Methods.drawPoint(panel, currentPoints, mouseEvent);
                        if(currentPoints.size() == 3) {
                            Parallelogram parallelogram = new Parallelogram(currentPoints.get(0), currentPoints.get(1), currentPoints.get(2));
                            parallelogram.setBorderColor(borderColor);
                            parallelogram.setfillingColor(fillingColor);
                            listOfShape.add(parallelogram);
                            info.addElement("Parallelogram");
                            panel.repaint();
                            currentType = TypeOfShape.NONE;
                        }
                        break;
                    case RECTANGLE:
                        Methods.drawPoint(panel, currentPoints, mouseEvent);
                        if(currentPoints.size() == 2) {
                            Rectangle rectangle = new Rectangle(currentPoints.get(0), currentPoints.get(1));
                            rectangle.setBorderColor(borderColor);
                            rectangle.setfillingColor(fillingColor);
                            listOfShape.add(rectangle);
                            info.addElement("Rectangle");
                            panel.repaint();
                            currentType = TypeOfShape.NONE;
                        }
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        currentPoints = new ArrayList<>();
        listOfShape = new ArrayList<>();
        scrollPane.setViewportView(list);
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                selected = list.getSelectedIndex();
                if(selected == -1) {
                    btnLocate.setEnabled(false);
                    btnMove.setEnabled(false);
                }
                else {
                    btnLocate.setEnabled(true);
                    btnMove.setEnabled(true);
                }
            }
        });

    }

}


