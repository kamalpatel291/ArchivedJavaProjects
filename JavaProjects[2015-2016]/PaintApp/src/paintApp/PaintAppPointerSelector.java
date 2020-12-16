package paintApp;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PaintAppPointerSelector extends JFrame implements ActionListener{
	private JSlider slider;
	private JLabel lblSize, lblShape;
	private JRadioButton rdRectangle,rdCircle;
	private JButton btnBack;
	private int psize;
	private PaintAppPaintSelector colorS;
	public PaintAppPointerSelector() {
		setSize(450,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		getContentPane().setLayout(null);
		
		
		
		slider = new JSlider();
		slider.setValue(5);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setBounds(10, 48, 414, 45);
		getContentPane().add(slider);
	
		
		lblSize = new JLabel("Select Size:(width==height)");
		lblSize.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 16));
		lblSize.setBounds(23, 11, 250, 26);
		getContentPane().add(lblSize);
		
		lblShape = new JLabel("Select Shape:");
		lblShape.setFont(new Font("Constantia", Font.BOLD | Font.ITALIC, 16));
		lblShape.setBounds(23, 133, 116, 26);
		getContentPane().add(lblShape);
		
		rdRectangle = new JRadioButton("Rectangle");
		rdRectangle.setBounds(25, 170, 109, 23);
		getContentPane().add(rdRectangle);
		
		rdCircle = new JRadioButton("Circle");
		rdCircle.setBounds(150, 170, 109, 23);
		getContentPane().add(rdCircle);
		
		rdRectangle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				rdCircle.setSelected(false);
			}
		});
		
		rdCircle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				rdRectangle.setSelected(false);
			}
		});
		
		btnBack = new JButton("<-- Back");
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnBack.setFont(new Font("Constantia", Font.BOLD, 16));
		btnBack.setBounds(175, 222, 109, 26);
		btnBack.setActionCommand("back");
		btnBack.addActionListener(this);
		getContentPane().add(btnBack);
		
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

	
	//for testing
	/*public static void main(String[] args) {

		PaintAppPointerSelector paps = new PaintAppPointerSelector();
	}*/
	
	@Override
	public void actionPerformed(ActionEvent e){
		/*if(e.getActionCommand().equals("back")){
			
		PaintAppMainPage pamp = new PaintAppMainPage();
		pamp.shapeAndSizeManager(slider.getValue(), getShapeSelection());
		dispose();
		}*/
	}

}
