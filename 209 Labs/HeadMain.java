import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class HeadMain {
	public static void main(String[] args) {
		JFrame f = new JFrame("Head Drawing");
		 f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	     f.setLayout(new GridLayout(2,2));
	     f.add(new Head());
	     f.add(new Head());
	     f.add(new Head());
	     f.add(new Head());
	     f.pack();
	     f.setVisible(true);
	}

}
