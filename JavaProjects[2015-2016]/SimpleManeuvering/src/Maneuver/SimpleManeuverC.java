package Maneuver;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.DoubleBuffer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SimpleManeuverC extends JFrame {
	public static SimpleManeuverC simple;
	public JFrame frame;
	public SimpleTwo two;
	public int WIDTH = 400, HEIGHT = 400, x = 200 ,y = 200, y1,x1;
	public Rectangle rect,rect2;
	public Image image;
	public Graphics GUI;
	
	public class key extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			int k = arg0.getKeyCode();
			
			if (k == arg0.VK_W) {
				y -= 5;
				System.out.println("W");
			}
			else if (k == arg0.VK_S) {
				
				System.out.println("S");
				y += 5;
			}
			else if (k == arg0.VK_A) {
				System.out.println("A");
				x -= 5;
			}
			else if (k == arg0.VK_D) {
				System.out.println("D");
				x += 5;
			}
		}
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	public SimpleManeuverC() {
		frame = new JFrame();
	//	two = new SimpleTwo();
		setVisible(true);
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
	//	frame.add(two);
		//rect = new Rectangle(200, 200, WIDTH/100 + 16, HEIGHT/100 + 16);
		//rect2 = new Rectangle(0,0,WIDTH,HEIGHT);
		addKeyListener(new key());
//		time.start();
	}
	
	public void paint(Graphics g) {
		image = createImage(getHeight(),getWidth());
		GUI = image.getGraphics();
		paintComponent(GUI);
		g.drawImage(image, 0, 0, this);
	}
	public void paintComponent(Graphics g){
		Graphics2D g2 =(Graphics2D)g;
	/*	setSize(400,400);
		g2.setColor(Color.black);
		g2.fill(rect2);
		
		g2.setColor(Color.white.brighter());
		g2.fill(rect);*/
		rect = new Rectangle(100,100,50,20);
		rect2 = new Rectangle(x,y,20,20);
		g2.fill(rect);
		
		g2.setColor(Color.WHITE);
		g2.fillRect(x, y, 20, 20);
		repaint();
	}

	public static void main(String[] args) {

		simple = new SimpleManeuverC();
		
		
	}
	
	

}
