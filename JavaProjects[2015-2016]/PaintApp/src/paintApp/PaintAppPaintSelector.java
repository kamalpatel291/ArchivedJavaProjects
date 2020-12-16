package paintApp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.io.*;
import java.util.Scanner;

public class PaintAppPaintSelector extends JFrame implements MouseListener, ActionListener{
	private String color;
	private int value;
	private String r,g,b,GetRedHex,GetGreenHex,GetBlueHex,GetSize,GetShape,shapeName,storesShape;
	private BufferedReader readRedHex,readGreenHex,readBlueHex,readSize,readShape;
	private String R= "",G="",B="";
	private JLabel clabel,lblBorder,lblSize,lblShape;
	private JButton btnBack;
	private JRadioButton rdRectangle,rdCircle;
	private JSlider slider;
	private PaintAppMainPage pamp;
	private File rFile = new File("C:/Users/kamal_000/Desktop/JavaLog/r.txt"); 
	private File gFile = new File("C:/Users/kamal_000/Desktop/JavaLog/g.txt");
	private File bFile = new File("C:/Users/kamal_000/Desktop/JavaLog/b.txt");
	private File sizeFile = new File("C:/Users/kamal_000/Desktop/JavaLog/size.txt");
	private File shapeFile = new File("C:/Users/kamal_000/Desktop/JavaLog/shape.txt");
	private PrintWriter filewriter;
	
//getters and setters for color and rgb
	public String getColor() {
		return color;
	}
	public String getR() {
		return r;
	}
	public String getG() {
		return g;
	}
	public String getB() {
		return b;
	}
	public int getValue(){
		return value;
	}
	public String getShapeName(){
		return shapeName;
	}
	
	public void setShapeName(String shapeName){
		this.shapeName = shapeName;
	}
	public void setR(String r){
		
		this.r = r;
	}
	public void setG(String g){
		
		this.g = g;
	}
	public void setB(String b){
		
		this.b = b;
	}
	public void setValue(int v){
		this.value = v;
	}
	public void setColor(String color) {
	if(!(color.equals(""))){
		//removes rgb characters from color string
		for(int x = 0; x<color.length(); x++){
			if(color.charAt(x) == 'r' ){
				color = color.replace("r", "");
			}else if(color.charAt(x) == 'g'){
				color = color.replace("g", "");
			}else if(color.charAt(x) == 'b'){
				color = color.replace("b", "");
			}
		}
		//trim unwanted part or substring only wanted part
		color = color.substring(15, color.length());
			//replaces all r,g,b and ='s
		color =	color.replaceAll("\\=+", "");
		color =	color.replaceAll("\\]+", "");
		color =	color.replaceAll("\\[+", "");
		color =	color.replaceAll("\\s+", "");
	}
		this.color = color;
		System.out.println("Setting the Color, Complete !: COLOR: " + this.color);
		
		if(!(color.equals(""))){
			System.out.println(" RGB in One String: "+ recurseRGB(this.color,this.color.length(),this.color.length(),1));

		}
	}
	
	public PaintAppPaintSelector() {
		//gets the value stored from the file and sets to the getters and setter
		try {
			readRedHex = new BufferedReader(new FileReader(rFile));
			readGreenHex = new BufferedReader(new FileReader(gFile));
			readBlueHex = new BufferedReader(new FileReader(bFile));
			readSize = new BufferedReader(new FileReader(sizeFile));
			readShape = new BufferedReader(new FileReader(shapeFile));
			
			while((GetRedHex = readRedHex.readLine())!= null){
				setR(GetRedHex);
			}
			while((GetGreenHex = readGreenHex.readLine())!= null){
				setG(GetGreenHex);

			}
			while((GetBlueHex = readBlueHex.readLine())!= null){
				setB(GetBlueHex);

			}
	
			while((GetSize = readSize.readLine())!= null){
				setValue(Integer.valueOf(GetSize));

			}
			while((GetShape = readShape.readLine())!= null){
				setShapeName(GetShape);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//frame stuff
		setSize(431, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		getContentPane().setLayout(null);
		setTitle("Properties Selector");
		
		clabel = new JLabel();
		clabel.setBounds(0,-20,431,450);
		Image img = new ImageIcon(this.getClass().getResource("/Paints(edited).png")).getImage();
		clabel.setIcon(new ImageIcon(img));
		
		//just for using x, y , width and height coordinates
		lblBorder = new JLabel();
		lblBorder.setBounds(115, 101, 276, 241);
		lblBorder.setText("");
		lblBorder.setVisible(false);
		
		btnBack = new JButton("<-- Back");
		btnBack.setFont(new Font("Constantia", Font.BOLD,16));
		btnBack.setBounds(2,2,100,30);
		btnBack.setActionCommand("back");
		btnBack.addActionListener(this);
		
		slider = new JSlider();
		slider.setValue(getValue());
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setBounds(10, 510, 411, 45);
		slider.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				setValue(slider.getValue());
				try{
					filewriter = new PrintWriter(sizeFile);
					filewriter.println(slider.getValue());
					filewriter.flush();
				}catch(IOException ex){
					ex.printStackTrace();
				}
			}
			
		});
		getContentPane().add(slider);
	
		
		lblSize = new JLabel("Select Size:(width==height)");
		lblSize.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 16));
		lblSize.setBounds(23, 471, 250, 26);
		getContentPane().add(lblSize);
		
		lblShape = new JLabel("Select Shape:");
		lblShape.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 16));
		lblShape.setBounds(23, 593, 116, 26);
		getContentPane().add(lblShape);
		
		rdRectangle = new JRadioButton("Rectangle");
		rdRectangle.setBounds(25, 630, 109, 23);
		getContentPane().add(rdRectangle);
	
		rdCircle = new JRadioButton("Circle");
		rdCircle.setBounds(150, 630, 109, 23);
		getContentPane().add(rdCircle);
		
		if(getShapeName().equals("Rectangle")){
			rdRectangle.setSelected(true);
		}else if(getShapeName().equals("Circle")){
			rdCircle.setSelected(true);
		}else {
			JOptionPane.showMessageDialog(null, "Error ! Invalid Shape Selection !","Error! ",JOptionPane.ERROR_MESSAGE);
		}
			
		
		rdRectangle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				rdCircle.setSelected(false);
				try{
					filewriter = new PrintWriter(shapeFile);
					filewriter.println("Rectangle");
					filewriter.flush();
				}catch(IOException ex){
					ex.printStackTrace();
				}
			}
		});
		
		rdCircle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				rdRectangle.setSelected(false);
				try{
					filewriter = new PrintWriter(shapeFile);
					filewriter.println("Circle");
					filewriter.flush();
				}catch(IOException ex){
					ex.printStackTrace();
				}
			}
		});
		
		btnBack = new JButton("<-- Back");
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnBack.setFont(new Font("Constantia", Font.BOLD, 16));
		btnBack.setBounds(2, 2, 100, 40);
		btnBack.setActionCommand("back");
		btnBack.addActionListener(this);
		getContentPane().add(btnBack);
		/*	
		btnMore = new JButton("More...");
		btnMore.setFont(new Font("Constantia", Font.BOLD,16));
		btnMore.setBounds(2,42,100,30);
		btnMore.setActionCommand("more");
		btnMore.addActionListener(this);
		*/
		
		addMouseListener(this);
		add(clabel);
		add(lblBorder);
		add(btnBack);
	//	add(btnMore);
		setVisible(true);
		
		
		}
	
	public String getShapeSelection(){
		String str;
		if(rdCircle.isSelected() == true){
			str = "Circle";
		}
		else {
			str = "Rectangle";
		}
		return str;
	}

	public String recurseRGB (String str,int itsLength, int counter, int c){
		if(counter != 0){
		
		if(str.charAt(itsLength-counter) !=',' && c == 1){
			R = R + String.valueOf(str.charAt(itsLength-counter));
		
		}else if(str.charAt(itsLength-counter) == ','){
			c++;
		
		}else if(str.charAt(itsLength-counter) !=',' && c==2 ){
			G = G + String.valueOf(str.charAt(itsLength-counter));
			
		}else if(str.charAt(itsLength-counter) == ','){
			c++;
		
		}else if(str.charAt(itsLength-counter) !=',' && c==3 ){
			B = B + String.valueOf(str.charAt(itsLength-counter));
		}else if(str.charAt(itsLength-counter) == ','){
			c++;
		}
		
		
		return recurseRGB(str,itsLength,counter-1,c);
		}
		
		setR(R);setG(G);setB(B);
		try {
			filewriter = new PrintWriter(rFile);
			filewriter.println(R);
			filewriter.flush();
		}catch(Exception ex){
			
		}
		try {
			filewriter = new PrintWriter(gFile);
			filewriter.println(G);
			filewriter.flush();
		}catch(Exception ex){
			
		}
		try {
			filewriter = new PrintWriter(bFile);
			filewriter.println(B);
			filewriter.flush();
		}catch(Exception ex){
			
		}
		return str;
	}
	
	public void resetProperty(){
		R = "";
		G = "";
		B = "";
		}
	
	//for testing
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaintAppPaintSelector r = new PaintAppPaintSelector();
	}*/

	
	
//mouse events
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		double cx = MouseInfo.getPointerInfo().getLocation().getX();
		double cy = MouseInfo.getPointerInfo().getLocation().getY();

		
		try {
			
			Robot r = new Robot();
			if(!((cx < lblBorder.getX() && cx < lblBorder.getY() && cx > lblBorder.getWidth() && cx > lblBorder.getHeight())
				&& (cy < lblBorder.getX() && cy < lblBorder.getY() && cy > lblBorder.getWidth() && cy > lblBorder.getHeight()))){
				this.setColor(r.getPixelColor((int)cx, (int)cy).toString());
			}
		
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Failed To Assign A Color !", "Error",JOptionPane.ERROR_MESSAGE);
		}
		//sets everything to null so you can use different color
		resetProperty();
		
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
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("back")){
		/*	System.out.println(getR() + " " + getG() + " " + getB());
			String r = getR(),g = getG(),b = getB();*/
		//	PaintAppMainPage pamp = new PaintAppMainPage();
			
	

			pamp = new PaintAppMainPage();
			pamp.propertiesManager(getR(),getG(),getB(),getValue(),getShapeSelection());
			dispose();
			pamp.setVisible(true);
		}
	}

}
