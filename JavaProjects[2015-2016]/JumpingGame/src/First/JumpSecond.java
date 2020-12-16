package First;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class JumpSecond implements ActionListener {
	private JFrame frame;
	public final int WIDTH = 800, HEIGHT = 800;
	public JumpThird third;
	public static JumpSecond second;
	public int ticks, yMotion;
	public Rectangle bird;
	public ArrayList <Rectangle> columns;
	public Random rand;
		public JumpSecond() {
			
			third = new JumpThird();
			frame = new JFrame();
			frame.setVisible(true);
			frame.setSize(WIDTH,HEIGHT);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setDefaultLookAndFeelDecorated(true);
			frame.add(third);
			
			bird = new Rectangle (WIDTH/2-10, HEIGHT/2-10, 20,20);
			columns = new ArrayList <Rectangle>();
			
			rand = new Random();
			
			Timer time = new Timer(20, this);
			
			
			addColumn(true);
			addColumn(true);
			addColumn(true);
			addColumn(true);
		
			time.start();
		}
		
		
		
	
		
	
	
	public void actionPerformed(ActionEvent e) {
		
		int speed = 10;
		ticks ++;
		if (ticks % 2 == 0 && yMotion < 15) {
		yMotion += 2;	
		}
		bird.y += yMotion;
		
		for (int i = 0; i < columns.size(); i++) {
			Rectangle column = columns.get(i);
			column.x -= speed;
		}
		
		for (int i = 0; i< columns.size(); i++) {
			Rectangle column = columns.get(i);
					if (column.x + column.width < 0 ) {
						columns.remove(column);
						if (column.y == 0) {
							addColumn(false);
						}
					}
		}
		third.repaint();
	}
	public void addColumn(boolean start) {
		int space = 300;
		int width = 100;
		int height= 50 + rand.nextInt(300);
		if (start == true) {
		columns.add(new Rectangle(WIDTH+width+columns.size()*300,HEIGHT-height-120,width,height));
		columns.add(new Rectangle(WIDTH+width+(columns.size()-1)*300,0,width,HEIGHT-height-space));
		}else {
		columns.add(new Rectangle(columns.get(columns.size()-1).x +600,HEIGHT-height-120,width,height));
		columns.add(new Rectangle(columns.get(columns.size()-1).x,0,width,HEIGHT-height-space));
		}
	}
	public void paintColumn(Graphics g, Rectangle column ) {
		g.setColor(Color.black.darker());
		g.fillRect(column.x, column.y, column.width, column.height);
	}
	public void repaint(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(0,0, HEIGHT, WIDTH);
		
		g.setColor(Color.orange);
		g.fillRect(0, HEIGHT-120, WIDTH, 120);
		
		g.setColor(Color.green);
		g.fillRect(0, HEIGHT-120, WIDTH, 20);
	
		g.setColor(Color.red);
		g.fillRect(bird.x, bird.y, bird.width, bird.height);
		
		for(Rectangle column:columns) {
			paintColumn(g,column);
		}
	}
	

	
	public static void main (String[]args) {
		second = new JumpSecond();
	}
}
