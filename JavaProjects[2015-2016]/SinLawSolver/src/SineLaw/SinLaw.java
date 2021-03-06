package SineLaw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.DropMode;

public class SinLaw {

	private JFrame frmSinLawSolver;
	private JTextField textSidea;
	private JTextField textSideb;
	private JTextField textSidec;
	private JTextField textAngleA;
	private JTextField textAngleB;
	private JTextField textAngleC;
	private JTextField textMissingSA;
	private JTextField textWhichSA;
	private JTextField textRound;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinLaw window = new SinLaw();
					window.frmSinLawSolver.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SinLaw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSinLawSolver = new JFrame();
		frmSinLawSolver.setBackground(Color.WHITE);
		frmSinLawSolver.getContentPane().setFont(new Font("Cooper Black", Font.PLAIN, 14));
		frmSinLawSolver.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmSinLawSolver.setFont(new Font("Cooper Black", Font.PLAIN, 16));
		frmSinLawSolver.setTitle("Sin Law Solver");
		frmSinLawSolver.setBounds(100, 100, 655, 435);
		frmSinLawSolver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSinLawSolver.getContentPane().setLayout(null);
		
		JLabel lblSidea = new JLabel("Sidea");
		lblSidea.setFont(new Font("Cooper Black", Font.PLAIN, 14));
		lblSidea.setBounds(10, 11, 62, 14);
		frmSinLawSolver.getContentPane().add(lblSidea);
		
		JLabel lblSideb = new JLabel("Sideb");
		lblSideb.setFont(new Font("Cooper Black", Font.PLAIN, 14));
		lblSideb.setBounds(10, 36, 62, 14);
		frmSinLawSolver.getContentPane().add(lblSideb);
		
		JLabel lblSidec = new JLabel("Sidec");
		lblSidec.setFont(new Font("Cooper Black", Font.PLAIN, 14));
		lblSidec.setBounds(10, 61, 62, 14);
		frmSinLawSolver.getContentPane().add(lblSidec);
		
		JLabel lblAngleA = new JLabel("AngleA");
		lblAngleA.setFont(new Font("Cooper Black", Font.PLAIN, 14));
		lblAngleA.setBounds(10, 107, 62, 14);
		frmSinLawSolver.getContentPane().add(lblAngleA);
		
		JLabel lblAngleB = new JLabel("AngleB");
		lblAngleB.setFont(new Font("Cooper Black", Font.PLAIN, 14));
		lblAngleB.setBounds(10, 132, 62, 14);
		frmSinLawSolver.getContentPane().add(lblAngleB);
		
		JLabel lblAngleC = new JLabel("AngleC");
		lblAngleC.setFont(new Font("Cooper Black", Font.PLAIN, 14));
		lblAngleC.setBounds(10, 157, 62, 14);
		frmSinLawSolver.getContentPane().add(lblAngleC);
		
		textSidea = new JTextField("0");
		textSidea.setFont(new Font("Consolas", Font.BOLD, 14));
		textSidea.setBounds(106, 8, 86, 20);
		frmSinLawSolver.getContentPane().add(textSidea);
		textSidea.setColumns(10);
		
		
		textSideb = new JTextField("0");
		textSideb.setFont(new Font("Consolas", Font.BOLD, 14));
		textSideb.setBounds(106, 33, 86, 20);
		frmSinLawSolver.getContentPane().add(textSideb);
		textSideb.setColumns(10);
		
		
		textSidec = new JTextField("0");
		textSidec.setFont(new Font("Consolas", Font.BOLD, 14));
		textSidec.setBounds(106, 58, 86, 20);
		frmSinLawSolver.getContentPane().add(textSidec);
		textSidec.setColumns(10);
		
		
		textAngleA = new JTextField("0");
		textAngleA.setFont(new Font("Consolas", Font.BOLD, 14));
		textAngleA.setBounds(106, 104, 86, 20);
		frmSinLawSolver.getContentPane().add(textAngleA);
		textAngleA.setColumns(10);
		
		
		textAngleB = new JTextField("0");
		textAngleB.setFont(new Font("Consolas", Font.BOLD, 14));
		textAngleB.setBounds(106, 129, 86, 20);
		frmSinLawSolver.getContentPane().add(textAngleB);
		textAngleB.setColumns(10);
		
		
		textAngleC = new JTextField("0");
		textAngleC.setFont(new Font("Consolas", Font.PLAIN, 14));
		textAngleC.setBounds(106, 154, 86, 20);
		frmSinLawSolver.getContentPane().add(textAngleC);
		textAngleC.setColumns(10);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setForeground(Color.WHITE);
		btnCalculate.setBackground(Color.BLACK);
		btnCalculate.setFont(new Font("Cooper Black", Font.BOLD, 16));
		btnCalculate.setBounds(224, 344, 182, 23);
		frmSinLawSolver.getContentPane().add(btnCalculate);
		btnCalculate.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				SectionFirst s = new SectionFirst();
				s.sectionfirst(textMissingSA, textSidea, textSideb, textSidec, textAngleA, textAngleB, textAngleC, textWhichSA, textRound);
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
		});
		
		JLabel label = new JLabel("");
		label.setBounds(359, 49, 200, 200);
		Image triangle = new ImageIcon(this.getClass().getResource("/Triangle.png")).getImage();
		label.setIcon(new ImageIcon(triangle));
		frmSinLawSolver.getContentPane().add(label);
		
		textMissingSA = new JTextField();
		textMissingSA.setEditable(false);
		textMissingSA.setToolTipText("The Angle/Side You're Finding Will Be Displayed Here");
		textMissingSA.setFont(new Font("Cooper Black", Font.BOLD, 14));
		textMissingSA.setBounds(10, 310, 266, 23);
		frmSinLawSolver.getContentPane().add(textMissingSA);
		textMissingSA.setColumns(10);
		
		textWhichSA = new JTextField();
		textWhichSA.setFont(new Font("Consolas", Font.BOLD, 14));
		textWhichSA.setToolTipText("Enter Angle/Side You Want To Find");
		textWhichSA.setBounds(10, 197, 266, 23);
		frmSinLawSolver.getContentPane().add(textWhichSA);
		textWhichSA.setColumns(10);
		
		JLabel lblWichSA = new JLabel("Which Angle/Side You Want To Find?");
		lblWichSA.setFont(new Font("Consolas", Font.BOLD, 12));
		lblWichSA.setBounds(10, 182, 298, 14);
		frmSinLawSolver.getContentPane().add(lblWichSA);
		
		textRound = new JTextField();
		textRound.setToolTipText("Please Enter in Decimal Format (For eg. 0.00)");
		textRound.setFont(new Font("Consolas", Font.BOLD, 14));
		textRound.setBounds(10, 260, 266, 23);
		frmSinLawSolver.getContentPane().add(textRound);
		textRound.setColumns(10);
		
		JLabel lblRoundQ = new JLabel("<HTML>How Many Decimal Places You Want To Round?(Optional)(Default = 2)<HTML>");
		lblRoundQ.setFont(new Font("Consolas", Font.BOLD, 12));
		lblRoundQ.setBounds(10, 219, 266, 41);
		frmSinLawSolver.getContentPane().add(lblRoundQ);
		
		JLabel lblYourAnswer = new JLabel("Your Answer Will Be Displayed Here:");
		lblYourAnswer.setFont(new Font("Consolas", Font.BOLD, 12));
		lblYourAnswer.setBounds(10, 294, 266, 14);
		frmSinLawSolver.getContentPane().add(lblYourAnswer);
		
		
	}
}
