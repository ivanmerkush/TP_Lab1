package Application;
import Shapes.*;
import Shapes.Point;
import Shapes.Polygon;
import Shapes.Rectangle;
import Shapes.Shape;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class App {

    private TypeOfShape currentType = null;
    private Panel panel;
    private JFrame frame;
    private JMenuItem btnFinishBuilding;
    private JButton btnLocate;
    private JButton btnMove;
    private ArrayList<Shapes.Point> currentPoints;
    private int requiredValue;
    static ArrayList<Shape> listOfShape;
    private JColorChooser chooser;
    private Color borderColor = Color.black;
    private Color fillingColor = Color.black;
    private int selected;
    private DefaultListModel<String> info = new DefaultListModel<String>();
    private JList<String> list   = new JList<String>(info);
    private Shape currentShape;
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

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu mnShapes = new JMenu("Shapes");
        menuBar.add(mnShapes);

        ArrayList<JMenuItem> buttonShapes = new ArrayList<>();

        for(TypeOfShape i : TypeOfShape.values()) {
            buttonShapes.add(new JMenuItem(i.getName()));
            buttonShapes.get(buttonShapes.size() -1).addActionListener(actionEvent -> {
                currentType = i;

            });
            switch(i) {
                case REGULARPOLYGON:
                case ISOSCELESTRIANGLE:
                    buttonShapes.get(buttonShapes.size() - 1).addActionListener(actionEvent -> {
                        requiredValue = Methods.setRequiredNumber();
                    });
                    break;
                case POLYGON:
                case POLYLINE:
                    buttonShapes.get(buttonShapes.size() - 1).addActionListener(actionEvent -> {
                        btnFinishBuilding.setEnabled(true);
                    });
                    break;
                default:
                    break;
            }
        }
        for(JMenuItem i : buttonShapes) {
            mnShapes.add(i);
        }
        JSeparator separator = new JSeparator();
        mnShapes.add(separator);

        btnFinishBuilding = new JMenuItem("Finish building");
        btnFinishBuilding.setEnabled(false);
        btnFinishBuilding.addActionListener(actionEvent -> {
            switch(currentType) {
                case POLYGON:
                    currentShape = new Polygon(currentPoints, borderColor, fillingColor);
                    break;
                case POLYLINE:
                    currentShape = new Polyline(currentPoints, borderColor);
                    break;
            }
            btnFinishBuilding.setEnabled(false);
            addShape();
        });
        mnShapes.add(btnFinishBuilding);

        JMenu mnColor = new JMenu("Color");
        menuBar.add(mnColor);

        JMenuItem border = new JMenuItem("Border");
        mnColor.add(border);

        JMenuItem filling = new JMenuItem("Filling");
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
        btnLocate.addActionListener(actionEvent -> Methods.locateShape(listOfShape.get(selected)));
        menuBar.add(btnLocate);


        btnMove = new JButton("Move");
        btnMove.setEnabled(false);
        btnMove.addActionListener(actionEvent -> {
            Point newLocation = Methods.move();
            listOfShape.get(selected).move(newLocation);
            panel.repaint();
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
                Methods.drawPoint(panel, currentPoints, mouseEvent);
                if(currentType != TypeOfShape.POLYLINE && currentType != TypeOfShape.POLYGON) {

                    if (currentPoints.size() == 2 && currentType != TypeOfShape.ELLIPSE && currentType != TypeOfShape.TRIANGLE && currentType != TypeOfShape.PARALLELOGRAM) {
                        switch (currentType) {
                            case SEGMENT:
                                currentShape = new Segment(currentPoints.get(0), currentPoints.get(1), borderColor);
                                break;
                            case RAY:
                                currentShape = new Ray(currentPoints.get(0), currentPoints.get(1), borderColor);
                                break;
                            case LINE:
                                currentShape = new Line(currentPoints.get(0), currentPoints.get(1), borderColor);
                                break;
                            case CIRCLE:
                                currentShape = new Circle(currentPoints.get(0), currentPoints.get(1), borderColor, fillingColor);
                                break;
                            case RECTANGLE:
                                currentShape = new Rectangle(currentPoints.get(0), currentPoints.get(1), borderColor, fillingColor);
                                break;
                            case ISOSCELESTRIANGLE:
                                currentShape = new IsoscelesTriangle(currentPoints.get(0), currentPoints.get(1), requiredValue, borderColor, fillingColor);
                                break;
                            case REGULARPOLYGON:
                                currentShape = new RegularPolygon(currentPoints.get(0), currentPoints.get(1), requiredValue, borderColor, fillingColor);
                                break;
                            default:
                                break;
                        }
                        addShape();
                    }
                    if(currentPoints.size() == 3) {
                        switch (currentType) {
                            case ELLIPSE:
                                currentShape = new Ellipse(currentPoints.get(0), currentPoints.get(1), currentPoints.get(2), borderColor, fillingColor);
                                break;
                            case TRIANGLE:
                                currentShape = new Triangle(currentPoints.get(0), currentPoints.get(1), currentPoints.get(2), borderColor, fillingColor);
                                break;
                            case PARALLELOGRAM:
                                currentShape = new Parallelogram(currentPoints.get(0), currentPoints.get(1), currentPoints.get(2), borderColor, fillingColor);
                                break;
                            default:
                                break;
                        }
                        addShape();
                    }
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
    void addShape() {
        info.addElement(currentShape.getClass().getSimpleName());
        listOfShape.add(currentShape);
        panel.repaint();
        currentType = null;
        currentPoints.clear();
    }

}


