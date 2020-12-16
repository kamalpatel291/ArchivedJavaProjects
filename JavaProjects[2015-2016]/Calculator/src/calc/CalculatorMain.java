package calc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.Color;

public class CalculatorMain {

	private JFrame frmCalculator;
	private JTextField txtAnswer;
	private String s, t, f;
	private String previousNum, thisNum;
	private double sign; 
	//signm, signs, signp;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorMain window = new CalculatorMain();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculatorMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmCalculator.getContentPane().setForeground(Color.WHITE);
		frmCalculator.setResizable(false);
		frmCalculator.setTitle("Calculator");
		frmCalculator.setBounds(100, 100, 317, 304);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtAnswer = new JTextField();
		txtAnswer.setBackground(Color.GRAY);
		txtAnswer.setForeground(Color.WHITE);
		txtAnswer.setToolTipText("Your Answer Will be Displayed Here");
		txtAnswer.setFont(new Font("Cooper Black", Font.BOLD, 16));
		txtAnswer.setBounds(10, 6, 290, 78);
		txtAnswer.setEditable(false);
		txtAnswer.setColumns(10);
		
		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("Andalus", Font.BOLD, 13));
		btn7.setBounds(10, 124, 50, 23);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s =	s.valueOf(txtAnswer.getText());
				txtAnswer.setText(s + "7");
				
			}
		});
		
		JButton btn8 = new JButton("8");
		btn8.setFont(new Font("Andalus", Font.BOLD, 13));
		btn8.setBounds(70, 124, 50, 23);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				s =	s.valueOf(txtAnswer.getText());
				txtAnswer.setText(s + "8");			}
		});
		
		JButton btn9 = new JButton("9");
		btn9.setFont(new Font("Andalus", Font.BOLD, 13));
		btn9.setBounds(130, 124, 50, 23);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			s =	s.valueOf(txtAnswer.getText());
				txtAnswer.setText(s + "9");
			}
		});
		
		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("Andalus", Font.BOLD, 13));
		btn4.setBounds(10, 153, 50, 23);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			s = s.valueOf(txtAnswer.getText());	
				txtAnswer.setText(s + "4");
				
			}
		});
		
		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("Andalus", Font.BOLD, 13));
		btn5.setBounds(70, 153, 50, 23);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s =	s.valueOf(txtAnswer.getText());
				txtAnswer.setText(s + "5");
			}
		});
		
		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("Andalus", Font.BOLD, 13));
		btn6.setBounds(130, 153, 50, 23);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s =	s.valueOf(txtAnswer.getText());
				txtAnswer.setText(s + "6");
			}
		});
		
		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("Andalus", Font.BOLD, 13));
		btn1.setBounds(10, 182, 50, 23);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s =	s.valueOf(txtAnswer.getText());
				txtAnswer.setText(s + "1");
			}
		});
		
		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("Andalus", Font.BOLD, 13));
		btn2.setBounds(70, 182, 50, 23);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s =	s.valueOf(txtAnswer.getText());
				txtAnswer.setText(s + "2");
			}
		});
		
		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("Andalus", Font.BOLD, 13));
		btn3.setBounds(130, 182, 50, 23);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s =	s.valueOf(txtAnswer.getText());
				txtAnswer.setText(s + "3");
			}
		});
		
		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("Andalus", Font.BOLD, 14));
		btn0.setBounds(10, 211, 110, 23);
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s =	s.valueOf(txtAnswer.getText());
				txtAnswer.setText(s + "0");
			}
		});
		
		JButton btnDot = new JButton(".");
		btnDot.setFont(new Font("Cooper Black", Font.BOLD, 14));
		btnDot.setBounds(130, 211, 50, 23);
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s =	s.valueOf(txtAnswer.getText());
				txtAnswer.setText(s + ".");
			}
		});
		
		JButton btnDivide = new JButton("/");
		btnDivide.setFont(new Font("Andalus", Font.BOLD, 14));
		btnDivide.setBounds(190, 124, 50, 23);
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s =	s.valueOf(txtAnswer.getText());
				previousNum = s;
				sign = 1;
				txtAnswer.setText(s + " / ");
				f = f.valueOf(txtAnswer.getText());
			}
		});
		
		JButton btnMultiply = new JButton("x");
		btnMultiply.setFont(new Font("Andalus", Font.BOLD, 14));
		btnMultiply.setBounds(190, 153, 50, 23);
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s =	s.valueOf(txtAnswer.getText());
				previousNum = s;
				sign = 2;
				txtAnswer.setText(s + " x ");
				f = f.valueOf(txtAnswer.getText());
			}
		});
		
		JButton btnPlus = new JButton("+");
		btnPlus.setFont(new Font("Andalus", Font.BOLD, 14));
		btnPlus.setBounds(190, 211, 50, 23);
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s =	s.valueOf(txtAnswer.getText());
				previousNum = s;
				sign = 4;
				txtAnswer.setText(s + " + ");
				f = f.valueOf(txtAnswer.getText());
			}
		});
		
		JButton btnMinus = new JButton("-");
		btnMinus.setFont(new Font("Andalus", Font.BOLD, 14));
		btnMinus.setBounds(190, 182, 50, 23);
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s =	s.valueOf(txtAnswer.getText());
				previousNum = s;
				sign = 3;
				txtAnswer.setText(s + " - ");
				f = f.valueOf(txtAnswer.getText());
			}
		});
		
	
		
		frmCalculator.getContentPane().setLayout(null);
		frmCalculator.getContentPane().add(txtAnswer);
		frmCalculator.getContentPane().add(btn7);
		frmCalculator.getContentPane().add(btn8);
		frmCalculator.getContentPane().add(btn9);
		frmCalculator.getContentPane().add(btn4);
		frmCalculator.getContentPane().add(btn5);
		frmCalculator.getContentPane().add(btn6);
		frmCalculator.getContentPane().add(btn3);
		frmCalculator.getContentPane().add(btn2);
		frmCalculator.getContentPane().add(btn1);
		frmCalculator.getContentPane().add(btnDivide);
		frmCalculator.getContentPane().add(btnMultiply);
		frmCalculator.getContentPane().add(btnPlus);
		frmCalculator.getContentPane().add(btnMinus);
		frmCalculator.getContentPane().add(btn0);
		frmCalculator.getContentPane().add(btnDot);
		
		JButton btnBack = new JButton("<-");
		btnBack.setFont(new Font("Andalus", Font.BOLD, 12));
		btnBack.setBounds(10, 95, 50, 23);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
			}
		});
		frmCalculator.getContentPane().add(btnBack);
		
		JButton btnCE = new JButton("CE");
		btnCE.setFont(new Font("Andalus", Font.BOLD, 13));
		btnCE.setBounds(70, 95, 50, 23);
		btnCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmCalculator.getContentPane().add(btnCE);
		
		JButton btnC = new JButton("C");
		btnC.setFont(new Font("Andalus", Font.BOLD, 14));
		btnC.setBounds(130, 95, 50, 23);
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAnswer.setText("");
				f=""; previousNum=""; thisNum="";
				sign=0; 
				//signm=0; signp=0; signs=0;
			}
		});
		frmCalculator.getContentPane().add(btnC);
		
		JButton btnNothing = new JButton("");
		btnNothing.setBounds(250, 95, 50, 23);
		frmCalculator.getContentPane().add(btnNothing);
		
		JButton btnNegate = new JButton("-/+");
		btnNegate.setFont(new Font("Andalus", Font.BOLD, 11));
		btnNegate.setBounds(190, 95, 50, 23);
		btnNegate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int f1 = Integer.parseInt(f);
				int answer = Math.negateExact(f1);
				String fanswer = String.valueOf(answer);
				txtAnswer.setText(fanswer + s);
			}
		});
		frmCalculator.getContentPane().add(btnNegate);
		
		JButton btnSqrt = new JButton("Sqrt");
		btnSqrt.setFont(new Font("Andalus", Font.PLAIN, 10));
		btnSqrt.setBounds(250, 124, 50, 23);
		btnSqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				double answer1 = Double.parseDouble(s);
				double answer2 = Math.sqrt(answer1);
			
				txtAnswer.setText(String.valueOf(answer2));
			}
		});
		frmCalculator.getContentPane().add(btnSqrt);
		
		JButton btnPercent = new JButton("%");
		btnPercent.setFont(new Font("Andalus", Font.BOLD, 14));
		btnPercent.setBounds(250, 153, 50, 23);
		btnPercent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s = s.valueOf(txtAnswer.getText());
				previousNum = s;
				sign =5;
				txtAnswer.setText(s + " Mod ");
				f = f.valueOf(txtAnswer.getText());
			}
		});
		frmCalculator.getContentPane().add(btnPercent);
		
		JButton btnEqual = new JButton("=");
		btnEqual.setFont(new Font("Cooper Black", Font.BOLD, 14));
		btnEqual.setBounds(250, 182, 50, 52);
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t = String.valueOf(txtAnswer.getText());
				t = t.replace(f, "");
				thisNum = t;
				if (sign == 1) {
					
					double answer1 = Double.parseDouble(previousNum);
					double answer2 = Double.parseDouble(thisNum);
					double answer3 = answer1/answer2;
					
					txtAnswer.setText(String.valueOf(answer3));
				}else if (sign == 2 ){
				
					double answer1 = Double.parseDouble(previousNum);
					double answer2 = Double.parseDouble(thisNum);
					double answer3 = answer1*answer2;
					
					txtAnswer.setText(String.valueOf(answer3));
				}else if (sign == 3 ) {
					
					double answer1 = Double.parseDouble(previousNum);
					double answer2 = Double.parseDouble(thisNum);
					double answer3 = answer1-answer2;
					
					txtAnswer.setText(String.valueOf(answer3));
				}else if (sign ==4 ) {
					
					double answer1 = Double.parseDouble(previousNum);
					double answer2 = Double.parseDouble(thisNum);
					double answer3 = answer1 + answer2;
				
					txtAnswer.setText(String.valueOf(answer3));
				}else if (sign == 5 ){
					
					int answer1 = Integer.parseInt(previousNum);
					int answer2 = Integer.parseInt(thisNum);
					int answer3 = Math.floorMod(answer1, answer2);
					String answer4 = String.valueOf(answer3);
					double answer5 = Double.parseDouble(answer4);
					txtAnswer.setText(String.valueOf(answer5));
				}else {
					JOptionPane.showMessageDialog(null, "Please Enter Valid Information!!!", "Error!!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		frmCalculator.getContentPane().add(btnEqual);
	}
}
