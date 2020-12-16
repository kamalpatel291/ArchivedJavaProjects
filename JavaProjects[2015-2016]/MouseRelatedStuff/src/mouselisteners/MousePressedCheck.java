package mouselisteners;

import java.awt.event.*;

import javax.swing.JFrame;

public class MousePressedCheck extends JFrame implements MouseListener {

	public MousePressedCheck() {
		super("Mouse Checking");
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		setVisible(true);
		this.addMouseListener(this);
	}

	public static void main(String[] args) {
		MousePressedCheck ch = new MousePressedCheck();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.print("Hello World");
		System.out.print(arg0.getButton());
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
