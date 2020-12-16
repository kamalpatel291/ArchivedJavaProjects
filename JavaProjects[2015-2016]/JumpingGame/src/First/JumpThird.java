package First;

import java.awt.Graphics;

import javax.swing.JPanel;

public class JumpThird extends JPanel{
		
	
	protected void paintComponent(Graphics g) {
	//	super.paintComponent(g);	
			
		JumpFirst.jumpf.repaint(g);
		}
}
