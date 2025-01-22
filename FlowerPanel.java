import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class FlowerPanel extends JPanel {
  private int numPetals = 5;
  private double innerRadius = 0.5;
  private double outerRadius = 1.5;

  public FlowerPanel() {
    setPreferredSize(new Dimension(400, 400));
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    int centerX = getWidth() / 2;
    int centerY = getHeight() / 2;

    for(int i = 0; i < numPetals; i++) {
      double angle = 2 * Math.PI * i / numPetals;
      Path2D.Double petal = new Path2D.Double();

      for(double t = 0; t <= 2 * Math.PI; t+= 0.01) {
        double r = outerRadius + innerRadius * Math.cos(5 * t);
        double x = centerX + r * Math.cos(t + angle);
        double y = centerY + r * Math.sin(t + angle);
        if(t == 0) {
          petal.moveTo(x, y);
        }
        else {
          petal.lineTo(x, y);
        }
      }
      petal.closePath();
      g2d.fill(petal);
    }
  }
  public static void main(String[] args) {
    JFrame frame = new JFrame("3D flower");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new FlowerPanel());
    frame.pack();
    frame.setVisible(true);
  }
}
