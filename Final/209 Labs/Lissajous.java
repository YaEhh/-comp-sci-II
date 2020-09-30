import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Lissajous extends JPanel {
	private JTextField textField_0;
	private JTextField textField_1;
	private JTextField textField_2;
	private boolean antiAlias;
	int size = 0;
	int a = 5;
	int b = 2;
	double delta = 0.7;

	/**
	 * Create the panel.
	 */
	public Lissajous(int size, boolean antiAlias) {
		this.size = size;
		this.setSize(size, size);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
		    	a = Integer.valueOf(textField_1.getText()).intValue();
		    	repaint();
	    }
	    });
		this.antiAlias = antiAlias;
		textField_1.setText(String.valueOf(a));
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField(); 
		textField_2.addActionListener(new
		ActionListener(){ public void actionPerformed(ActionEvent e){
			b = Integer.valueOf(textField_2.getText()).intValue();
			 repaint(); }
		});
		textField_2.setText(String.valueOf(b)); add(textField_2);
		textField_2.setColumns(10);
		  
		textField_0 = new JTextField(); textField_0.addActionListener(new
		ActionListener(){ public void actionPerformed(ActionEvent e){ 
			delta = Double.valueOf(textField_0.getText()).doubleValue();
			repaint(); }
		  }); 
		  textField_0.setText(String.valueOf(delta)); add(textField_0);
		  textField_0.setColumns(10);
	}
	
	public void paintComponent(Graphics graphics) {
        int x = (int) (size/2 + 2*size/5 * Math.sin(a * 0 + delta));
		int y = (int) (size/2 + 2*size/5 * Math.cos(b * 0));

        for (double t = 0; t <= (a + b) * Math.PI; t += 0.01) {
        	int x1 = (int) (size/2 + 2*size/5 * Math.sin(a * t + delta));
        	int y1 = (int) (size/2 + 2*size/5 * Math.cos(b * t));
            graphics.drawLine(x,y, (x1), (y1));
            x=x1;
            y=y1;         
        }
    } 
	
	public static void main(String[] args) {
        JFrame frame = new JFrame("Hello, Java!");
        frame.setSize(new Dimension(480, 480));
        Lissajous lissa = new Lissajous(300, true);
        frame.add(lissa);
        frame.setVisible(true);
    }

}
