import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RockPaperScissorPlayer extends JPanel{
	private JTextArea output;
	private JButton rock, paper, scissor;
	private JLabel labelWinLose;
	private static JFrame frame;
	private String outputText, playerName;
	private int winCountComputer, winCountPlayer;
	private RockPaperScissorComputer comp;
	private JScrollPane scroll;
	private final int WIDTH = 450, HEIGHT = 400;
	public static RockPaperScissorPlayer player;
	
	
	
	public RockPaperScissorPlayer() {
		
	playerName = "Player1";
	outputText = "";	
		frame = new JFrame();
		//frame.setResizable(false);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultLookAndFeelDecorated(true);
		frame.getContentPane().setLayout(null);

		output = new JTextArea();
		output.setText("Welcome To Rock Paper Scissor Game !! \n" + "First To Win the 10 Rounds Wins The Match !! ");
		output.setFont(new Font("Consolas", Font.BOLD, 14));
		output.setBounds(0,0,390,300);
		output.setEditable(false);
		
		scroll = new JScrollPane(output, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 0, 440, 300);
		
		rock = new JButton("Rock");
		rock.setBounds(5, 300, 100, 50);
		rock.setActionCommand("rock");
		
		paper = new JButton("Paper");
		paper.setBounds(175, 300, 100, 50);
		paper.setActionCommand("paper");
		
		scissor = new JButton("Scissor");
		scissor.setBounds(330, 300, 100, 50);
		scissor.setActionCommand("scissor");
		
		labelWinLose = new JLabel();
		labelWinLose.setFont(new Font("Consolas", Font.BOLD, 20));
		labelWinLose.setBounds(175,200,100, 20);
		labelWinLose.setText("hello");
		labelWinLose.setVisible(true);
		
		frame.getContentPane().add(scroll);
	//	frame.add(output);
		frame.add(rock);
		frame.add(paper);
		frame.add(scissor);
		frame.add(labelWinLose);
		frame.setVisible(true);
		
		
	comp = new RockPaperScissorComputer();	
		
	rock.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		//	labelWinLose.setVisible(false);
		//	labelWinLose.setText("");
			
			String computerChoice = comp.computer();
			String playerChoice = rock.getText();
		
			outputText = outputText + "\n" + playerName + " picked " + playerChoice + "\n";
			outputText = outputText + "Computer picked " + computerChoice + "\n";
		//	renderer.repaint();
			RockPaperScissorMethod(computerChoice,playerChoice, outputText);
			
		}
	});
	
	paper.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		//	labelWinLose.setVisible(false);
		//	labelWinLose.setText("");
			
			String computerChoice = comp.computer();
			String playerChoice = paper.getText();
		
			outputText = outputText + "\n" + playerName + " picked " + playerChoice + "\n";
			outputText = outputText + "Computer picked " + computerChoice + "\n";
		//	renderer.repaint();
			RockPaperScissorMethod(computerChoice,playerChoice, outputText);
			
		}
	});
	
	scissor.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//labelWinLose.setVisible(false);
		//	labelWinLose.setText("");
			
			String computerChoice = comp.computer();
			String playerChoice = scissor.getText();
		
			outputText = outputText + "\n" + playerName + " picked " + playerChoice + "\n";
			outputText = outputText + "Computer picked " + computerChoice + "\n";
		//.repaint();
			RockPaperScissorMethod(computerChoice,playerChoice, outputText);
		
		}
	});
		
	}
	
	
	public void RockPaperScissorMethod(String compChoice, String playerChoice, String text) {
	
		if (winCountPlayer <= 10 || winCountComputer <= 10) {
		if (compChoice.equals(playerChoice)) {
			outputText = text + "Nobody Won This Round, This Round Is Draw !! \n";
			output.setText(outputText);
			
		}else if (compChoice.equals("Rock") && playerChoice.equals("Scissor") || compChoice.equals("Paper") && playerChoice.equals("Rock") || 
				compChoice.equals("Scissor") && playerChoice.equals("Paper")){
			outputText = text + "Computer Won This Round !! Better Luck Next Time !! \n ";
			output.setText(outputText);
			winCountComputer += 1;
			
		}else {
			outputText = text +  "Congratulation !! You Won This Round !! \n";
			output.setText(outputText);
			winCountPlayer += 1;
		}
		
		} else {
			 if (winCountPlayer > winCountComputer){
			//	renderer.repaint();
				labelWinLose.setVisible(true);
				labelWinLose.setText("Player Wins !!!");
			 }else {
				labelWinLose.setVisible(true);
				labelWinLose.setText("Computer Wins !!!");
			//	renderer.repaint();
			 }
		 }
	
	
	}
	
	/*public void repaint2(Graphics g){
		System.out.println("WorksP");

		g.setFont(new Font("Consolas", Font.BOLD,20));
		g.setColor(Color.RED);
		g.drawString("Computer Won !!", 200, 200);
		System.out.println("WorksC");
	}
*/	public static void main(String[] args) {
		// TODO Auto-generated method 
		
	    RockPaperScissorPlayer player = new RockPaperScissorPlayer();
	}

}
