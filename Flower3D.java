import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Flower3D extends JFrame implements MouseMotionListener {

  private int[] xPoints = {
    100, 150, 200, 150, 100,
    75, 125, 175, 125, 75,
    50, 100, 150, 100, 50
  };

  private int[] yPoints = {
    50, 25, 50, 75, 50,
    100, 75, 100, 125, 100, 
    150, 125, 150, 175, 150
  };

  private int[] zPoints = {
    0, 0, 0, 0, 0,
    25, 25, 25, 25, 25,
    0, 0, 0, 0, 0
  };

  private int xRot = 0; yRot = 0;

  public Flower3D() {
    addMouseMotionListener(this);
    setTitle("3D FLower");
    setSize(400, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIA_ON);

    // rotate points
    int[] rotatedX = new int[xPoints.length];
    int[] rotatedY = new int[yPoints.length];
    for(int i = 0; i < xPoints.length; i++) {
      double x = xPoints[i] * Math.cos(Math.toRadians(yRot)) - zPoints[i] * Math.sin(Math.toRadians(yRot));
      double z = xPoints[i] * Math.sin(Math.toRadians(yRot)) + zPoints[i] * Math.cos(Math.toRadians(yRot));
      double y = yPoints[i] * Math.cos(Math.toRadians(xRot)) - z * Math.sin(Math.toRadians(xRot));
      z = yPoints[i] * Math.sin(Math.toRadians(xRot)) + z * Math.cos(Math.toRadians(xRot));
      rotatedX[i] = (int) x + 200;
      rotatedY[i] = (int) y + 200;

    }
    // draw flower
    g2d.setColor(Color.RED);
    g2d.fillPolygon(rotatedX, rotatedY, xPoints.length);
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    xRot += e.getX() - e.getPreviousX();
    yRot += e.getY() - e.getPreviousY();
    repaint();
  }

  @Override
  public void mouseMoved(MouseEvent e) {
  }
  public static void main(String[] args) {
    new Flower3D();
  }

