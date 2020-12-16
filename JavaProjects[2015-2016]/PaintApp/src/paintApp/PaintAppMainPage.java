package paintApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintAppMainPage extends JFrame implements MouseMotionListener, MouseListener, ActionListener{
	private String color,shapeName = "Rectangle";
	private JButton propertiesSelection,colorSelection;
	
	private double cx,cy, cxprev,cyprev;
	private int Red,Green,Blue,size=5;
	
	
	//getters and setters
	public int getRed() {
		return Red;
	}

	public void setRed(int red) {
		Red = red;
	}

	public int getGreen() {
		return Green;
	}

	public void setGreen(int green) {
		Green = green;
	}

	public int getBlue() {
		return Blue;
	}

	public void setBlue(int blue) {
		Blue = blue;
	}
	
	public String getName(){
		return shapeName;
	}
	
	public void setName(String shapeName){
		this.shapeName = shapeName;
	}
	
	public int getPSize(){
		return size;
	}
	
	public void setPSize(int size){
		this.size = size;
	}
	public void propertiesManager(String r, String g, String b,int value,String name){
		//sets the size and shape
				setPSize(value);
				setName(name);
		//sets the red green blue ratio for coloring
				setRed(Integer.valueOf(r));
				setGreen(Integer.valueOf(g));
				setBlue(Integer.valueOf(b));
				
	}
	
	public PaintAppMainPage() {
		super("Paint App v1.0.0");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		getContentPane().setLayout(null);
		
		/*colorSelection = new JButton("Color Selection");
		colorSelection.setFont(new Font("Constantia", Font.BOLD,16));
		colorSelection.setBounds(25, 510, 350, 40);
		colorSelection.setActionCommand("color");
		colorSelection.addActionListener(this);
		*/
		
		propertiesSelection = new JButton("Properties Selection");
		propertiesSelection.setFont(new Font("Constantia", Font.BOLD,16));
		propertiesSelection.setBounds(25,510, 750, 40);
		propertiesSelection.setActionCommand("properties");
		propertiesSelection.addActionListener(this);
		
		
		add(propertiesSelection);
	//	add(colorSelection);
	//	addMouseListener(this);
		addMouseMotionListener(this);
		setVisible(true);
	
	}
	
	public void paint(Graphics g){
		Color rgb = new Color(getRed(),getGreen(),getBlue());
		Graphics2D g2d = (Graphics2D)g;
		

		
		g.setColor(rgb);
		
		if(getName().equals("Rectangle")){
			g.fillRect((int)cx, (int)cy, getPSize(), getPSize());	
			g2d.drawLine((int)cyprev, (int)cx,(int)cxprev,(int)cy);
		}else{
			g.fillOval((int)cx, (int)cy,getPSize(),getPSize());
		}
		
	
	}
	

	public static void main(String[] args) {
		PaintAppMainPage pamp = new PaintAppMainPage();

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		cx = MouseInfo.getPointerInfo().getLocation().getX();
		cy = MouseInfo.getPointerInfo().getLocation().getY();
	
		repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		/*if(e.getActionCommand().equals("color")){
			PaintAppPaintSelector paps = new PaintAppPaintSelector();
			dispose();
		}*/
		if(e.getActionCommand().equals("properties")){
			PaintAppPaintSelector paps1 = new PaintAppPaintSelector();
			setVisible(false);
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		cxprev = MouseInfo.getPointerInfo().getLocation().getX();
		cyprev = MouseInfo.getPointerInfo().getLocation().getY();
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
