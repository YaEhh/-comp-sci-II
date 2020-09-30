import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class Head extends JPanel {
	private boolean mouseInside;
	
	public Head() {
		this.setPreferredSize(new Dimension(500, 500));
        // Many other settings and options can also be given.
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.mouseInside = false;
        
        class MyMouseListener extends MouseAdapter {
        	 @Override public void mouseEntered(MouseEvent e) {
        		 mouseInside = true;
        		 repaint();
        	 }
        	 
        	 @Override public void mouseExited(MouseEvent e) {
        		 mouseInside = false; 
        		 repaint();
        	 }      
        }
        this.addMouseListener(new MyMouseListener());
	}
	
	@Override public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		//Draw Head	
		g2.setPaint(Color.BLACK);
		g2.draw(new Ellipse2D.Double(200,55,70,70));
		g2.setPaint(Color.WHITE);
		g2.fill(new Ellipse2D.Double(200,55,70,70));
		
		g2.setPaint(Color.BLACK);
		g2.drawLine(220,110,250, 110);
		
		if (mouseInside) {
			g2.draw(new Ellipse2D.Double(220,80,10,10));
			g2.draw(new Ellipse2D.Double(240,80,10,10));
		} else {
			g2.drawLine(220, 80, 228, 80);
			g2.drawLine(240, 80, 248, 80);			
		}
	}
}
