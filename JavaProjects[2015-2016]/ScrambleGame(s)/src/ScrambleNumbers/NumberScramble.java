package ScrambleNumbers;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class NumberScramble {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("0");
		lbl1.setBounds(10, 65, 46, 96);
		frame.getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("0");
		lbl2.setBounds(74, 65, 46, 96);
		frame.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("0");
		lbl3.setBounds(139, 65, 46, 96);
		frame.getContentPane().add(lbl3);
		
		int num;
		int numb;
		int numbe;
		String num2;
		String numb2;
		String numbe2;
		for (int x = 0; x < 1000; x++){
			num = (int) (Math.random() * 10);
			numb = (int) (Math.random() * 10);
			numbe = (int) (Math.random() * 10);
			num2 = String.valueOf(num);
			numb2 = String.valueOf(numb);
			numbe2 = String.valueOf(numbe);
			lbl1.setText(num2);
			lbl2.setText(numb2);
			lbl3.setText(numbe2);
			try {
				Thread.sleep(500);
			}catch(Exception ex) {
				
			}

	}

}
}
