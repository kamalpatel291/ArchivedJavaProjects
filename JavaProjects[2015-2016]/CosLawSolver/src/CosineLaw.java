import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;

public class CosineLaw {

	private JFrame frmCosineLawSolver;
	private JTextField textSidea;
	private JTextField textSideb;
	private JTextField textSidec;
	private JTextField textAngleA;
	private JTextField textAngleB;
	private JTextField textAngleC;
	private JTextField textWhichSA;
	private JTextField textRound;
	private JTextField textMissingSA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CosineLaw window = new CosineLaw();
					window.frmCosineLawSolver.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CosineLaw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCosineLawSolver = new JFrame();
		frmCosineLawSolver.setTitle("Cosine Law Solver");
		frmCosineLawSolver.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmCosineLawSolver.setBounds(100, 100, 655, 435);
		frmCosineLawSolver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCosineLawSolver.getContentPane().setLayout(null);
		
		JLabel lblSidea = new JLabel("Sidea");
		lblSidea.setFont(new Font("Cooper Black", Font.PLAIN, 14));
		lblSidea.setBounds(10, 11, 62, 14);
		frmCosineLawSolver.getContentPane().add(lblSidea);
		
		JLabel lblSideb = new JLabel("Sideb");
		lblSideb.setFont(new Font("Cooper Black", Font.PLAIN, 14));
		lblSideb.setBounds(10, 36, 62, 14);
		frmCosineLawSolver.getContentPane().add(lblSideb);
		
		JLabel lblSidec = new JLabel("Sidec");
		lblSidec.setFont(new Font("Cooper Black", Font.PLAIN, 14));
		lblSidec.setBounds(10, 61, 62, 14);
		frmCosineLawSolver.getContentPane().add(lblSidec);
		
		JLabel lblAngleA = new JLabel("AngleA");
		lblAngleA.setFont(new Font("Cooper Black", Font.PLAIN, 14));
		lblAngleA.setBounds(10, 102, 62, 14);
		frmCosineLawSolver.getContentPane().add(lblAngleA);
		
		JLabel lblAngleB = new JLabel("AngleB");
		lblAngleB.setFont(new Font("Cooper Black", Font.PLAIN, 14));
		lblAngleB.setBounds(10, 127, 62, 14);
		frmCosineLawSolver.getContentPane().add(lblAngleB);
		
		JLabel lblAngleC = new JLabel("AngleC");
		lblAngleC.setFont(new Font("Cooper Black", Font.PLAIN, 14));
		lblAngleC.setBounds(10, 152, 62, 14);
		frmCosineLawSolver.getContentPane().add(lblAngleC);
		
		textSidea = new JTextField("0");
		textSidea.setFont(new Font("Consolas", Font.BOLD, 14));
		textSidea.setBounds(106, 9, 86, 20);
		frmCosineLawSolver.getContentPane().add(textSidea);
		textSidea.setColumns(10);
		
		textSideb = new JTextField("0");
		textSideb.setFont(new Font("Consolas", Font.BOLD, 14));
		textSideb.setBounds(106, 34, 86, 20);
		frmCosineLawSolver.getContentPane().add(textSideb);
		textSideb.setColumns(10);
		
		textSidec = new JTextField("0");
		textSidec.setFont(new Font("Consolas", Font.BOLD, 14));
		textSidec.setBounds(106, 58, 86, 20);
		frmCosineLawSolver.getContentPane().add(textSidec);
		textSidec.setColumns(10);
		
		textAngleA = new JTextField("0");
		textAngleA.setFont(new Font("Consolas", Font.BOLD, 14));
		textAngleA.setBounds(106, 100, 86, 20);
		frmCosineLawSolver.getContentPane().add(textAngleA);
		textAngleA.setColumns(10);
		
		textAngleB = new JTextField("0");
		textAngleB.setFont(new Font("Consolas", Font.BOLD, 14));
		textAngleB.setBounds(106, 125, 86, 20);
		frmCosineLawSolver.getContentPane().add(textAngleB);
		textAngleB.setColumns(10);
		
		textAngleC = new JTextField("0");
		textAngleC.setFont(new Font("Consolas", Font.BOLD, 14));
		textAngleC.setBounds(106, 154, 86, 20);
		frmCosineLawSolver.getContentPane().add(textAngleC);
		textAngleC.setColumns(10);
		
		JLabel lblWhichSA = new JLabel("Which Angle/Side You Want To Find?");
		lblWhichSA.setFont(new Font("Consolas", Font.BOLD, 12));
		lblWhichSA.setBounds(10, 182, 298, 14);
		frmCosineLawSolver.getContentPane().add(lblWhichSA);
		
		textWhichSA = new JTextField();
		textWhichSA.setFont(new Font("Consolas", Font.BOLD, 14));
		textWhichSA.setBounds(10, 197, 266, 23);
		frmCosineLawSolver.getContentPane().add(textWhichSA);
		textWhichSA.setColumns(10);
		
		JLabel lblRoundQ = new JLabel("<HTML>How Many Decimal Places You Want To Round?(Optional)(Default = 2)");
		lblRoundQ.setFont(new Font("Consolas", Font.BOLD, 12));
		lblRoundQ.setBounds(10, 219, 266, 41);
		frmCosineLawSolver.getContentPane().add(lblRoundQ);
		
		textRound = new JTextField();
		textRound.setFont(new Font("Consolas", Font.BOLD, 14));
		textRound.setBounds(10, 260, 266, 23);
		frmCosineLawSolver.getContentPane().add(textRound);
		textRound.setColumns(10);
		
		JLabel lblYourAnswer = new JLabel("Your Answer Will Be Displayed Here:");
		lblYourAnswer.setFont(new Font("Consolas", Font.BOLD, 12));
		lblYourAnswer.setBounds(10, 294, 266, 14);
		frmCosineLawSolver.getContentPane().add(lblYourAnswer);
		
		textMissingSA = new JTextField();
		textMissingSA.setFont(new Font("Cooper Black", Font.BOLD, 14));
		textMissingSA.setEditable(false);
		textMissingSA.setBounds(10, 310, 266, 23);
		frmCosineLawSolver.getContentPane().add(textMissingSA);
		textMissingSA.setColumns(10);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBackground(Color.BLACK);
		btnCalculate.setForeground(Color.WHITE);
		btnCalculate.setFont(new Font("Cooper Black", Font.BOLD, 16));
		btnCalculate.setBounds(224, 344, 182, 23);
		frmCosineLawSolver.getContentPane().add(btnCalculate);
		btnCalculate.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				First first = new First();
				first.first(textMissingSA, textSidea, textSideb, textSidec, textAngleA, textAngleB, textAngleC, textWhichSA, textRound);
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
		frmCosineLawSolver.getContentPane().add(label);
	}
}
