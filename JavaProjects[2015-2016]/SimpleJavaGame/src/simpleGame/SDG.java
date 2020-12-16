package simpleGame;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SDG{
	private int x;
	private int y;
	private static boolean win = false;
	private static Random rand = new Random();

	
	
	public static void main(String[] args ){
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 400, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultLookAndFeelDecorated(true);
		frame.setLayout(null);
		
		JButton btnmiddle = new JButton("");
		btnmiddle.setBounds(213, 203, 37, 58);
		frame.add(btnmiddle);
		
		JButton btnlast = new JButton("");
		btnlast.setBounds(306, 231, 37, 30);
		frame.add(btnlast);
		
		JButton btnfirst = new JButton("");
		btnfirst.setBounds(120, 145, 37, 116);
		frame.add(btnfirst);
		
		
		
		/*JButton txtS = new JButton ("");
		txtS.setVisible(true);
		txtS.setBounds(5, 5, 30, 30);
		txtS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				win = true;
				JOptionPane.showMessageDialog(null, "You WIN !!");
			}
		});*/
	//	frame.add(txtS);
		Loop(btnfirst, btnmiddle, btnlast, frame);
		
	}

	public static void Loop( JButton btnfirst, JButton btnmiddle, JButton btnlast, JFrame frame) {
		/*do {
			int x = rand.nextInt(frame.getWidth());
			System.out.println(x);
			int y = rand.nextInt(frame.getHeight());
			System.out.println(y);
			txtS.setBounds(x, y, 30, 30);
			try{
				Thread.sleep(1000);
			}catch (Exception e) {
				System.out.println("ERROR!");
			}
		}while (win == false);*/
		Random rand = new Random();
		int x = 0;
		while(x<5){
		btnfirst.setBounds(btnfirst.getX()-5, btnfirst.getY(), btnfirst.getWidth(), 50 + rand.nextInt(50));
		btnmiddle.setBounds(btnmiddle.getX()-5, btnmiddle.getY(), btnmiddle.getWidth(), 40 + rand.nextInt(40));
		btnlast.setBounds(btnlast.getX()-5, btnlast.getY(), btnlast.getWidth(), 30 + rand.nextInt(30));
		
		if (btnfirst.getX() == frame.getX()-btnfirst.getWidth()) {
			btnfirst.setBounds(180, 105, 37,120);
			
		}else if (btnmiddle.getX() == frame.getX()-btnmiddle.getWidth()) {
			btnmiddle.setBounds(173, 163, 37, 120);
			
		}else if (btnlast.getX() == frame.getX()-btnlast.getWidth()) {
			btnlast.setBounds(276, 181,37, 120);
			
		}
		try {
			Thread.sleep(500); 
		}catch(Exception e) {
			
		}
	}
	}
}
