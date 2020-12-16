import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EnglishToPigLatin extends JFrame {
 private JTextField piglatin, english;
 private JButton convert;
 private JLabel lblClose,lblMinimize,lblbackground,lblConvert;
 
 	public EnglishToPigLatin() {
		super("EN-PL Translator v1.0");
		setSize(800,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultLookAndFeelDecorated(true);
		getContentPane().setLayout(null);

		lblbackground = new JLabel("");
		lblbackground.setIcon(new ImageIcon(this.getClass().getResource("/BackgroundwithNames.jpg")));
		lblbackground.setBounds(0, 0, 800, 700);
		lblbackground.setCursor(new Cursor(Cursor.HAND_CURSOR));
		getContentPane().add(lblbackground);
		
		english = new JTextField();
		english.setBounds(5, 110, 773, 200);
		getContentPane().add(english);
		english.setColumns(10);
		
		piglatin = new JTextField();
		piglatin.setBounds(5, 370, 773, 200);
		getContentPane().add(piglatin);
		piglatin.setColumns(10);
		
		lblMinimize = new JLabel("");
		lblMinimize.setBounds(708, 0, 43, 45);
		getContentPane().add(lblMinimize);
		
		lblConvert = new JLabel("");
		lblConvert.setBounds(292, 609, 254, 91);
		getContentPane().add(lblConvert);
		lblConvert.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblConvert.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(!(english.getText().equals("")) && piglatin.getText().equals("")){
					convertToPigLating(english.getText());
	 			}else if (!(piglatin.getText().equals("")) && english.getText().equals("")){
	 			    convertToEnglish(piglatin.getText());
	 			}
				
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
		
		lblClose = new JLabel("");
		lblClose.setBounds(757, 0, 43, 45);
		getContentPane().add(lblClose);
		lblClose.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
				
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
				
		setVisible(true);
		
	}
 	
 	public void convertToPigLating(String str){
 	if(!(str.equals(""))){
 		
 		//removes special characters like .... or ??? or !!! that repeates more than one time
 				str = str.replaceAll("\\s+", " ");str = str.replaceAll("\\.+", ".");str = str.replaceAll("\\?+", "?");
 				str = str.replaceAll("\\!+", "!");str = str.replaceAll("\\,+", ",");
 		
 		//removes spaces after special characters for ex. ". " "? "  "?." = "? or ."
			//removes spaces after special characters
				str = str.replace(". ", ".");str = str.replace("? ", "?");str = str.replace("! ", "!");
				str = str.replace(", ", ",");
				str = str.replace(" .", ".");str = str.replace(" ?", "?");str = str.replace(" !", "!");
				str = str.replace(" ,", ",");str = str.replace(" :", ":");
				//removes more than one special characters
				str = str.replace(",.", ".");str = str.replace(".,", ".");str = str.replace(".?", "?");
				str = str.replace("?.", ".");str = str.replace(".!", "!");str = str.replace(".:", ".");
				str = str.replace(":.", ".");
				str = str.replace("!.", ".");str = str.replace(",?", "?");str = str.replace("?,", "?");
				str = str.replace(",!", "!");str = str.replace("!,", ",");str = str.replace("?!", "?");
				str = str.replace("!?", "?");str = str.replace("!:", "!");str = str.replace(":!", "!");
				str = str.replace("?:", "?");str = str.replace(":?", "?");str = str.replace(",:", ",");
				str = str.replace(":,", ":");
		
	
 		String [] strArray = str.split("\\s+");
 		String fullString="",backChar,ayStr = "ay", leftoverStr,firstCap;
 	
 		for (int x = 0; x<strArray.length; x++){
 		
 			leftoverStr = strArray[x].substring(1, strArray[x].length());
 			backChar = String.valueOf(strArray[x].charAt(0));
 			strArray[x] = leftoverStr + backChar + ayStr;
 			fullString = fullString + strArray[x] + " ";

 		}
 		
 		fullString = fullString.toLowerCase();
 		firstCap = String.valueOf(fullString.charAt(0)).toUpperCase();
 		fullString = firstCap + fullString.substring(1,fullString.length());

 		
 		piglatin.setText(fullString);
 	}else{
 		//error
 	}
 	
 	}
 	
 	public void convertToEnglish(String str){
 	if(!(str.equals(""))){
 		
 		//removes special characters like .... or ??? or !!! that repeates more than one time
 				str = str.replaceAll("\\s+", " ");str = str.replaceAll("\\.+", ".");str = str.replaceAll("\\?+", "?");
 				str = str.replaceAll("\\!+", "!");str = str.replaceAll("\\,+", ",");
 	
 		//removes spaces after special characters for ex. ". " "? "  "?." = "? or ."
 			//removes spaces after special characters
 				str = str.replace(". ", ".");str = str.replace("? ", "?");str = str.replace("! ", "!");
 				str = str.replace(", ", ",");
 				str = str.replace(" .", ".");str = str.replace(" ?", "?");str = str.replace(" !", "!");
 				str = str.replace(" ,", ",");str = str.replace(" :", ":");
 				//removes more than one special characters
 				str = str.replace(",.", ".");str = str.replace(".,", ".");str = str.replace(".?", "?");
 				str = str.replace("?.", ".");str = str.replace(".!", "!");str = str.replace(".:", ".");
 				str = str.replace(":.", ".");
 				str = str.replace("!.", ".");str = str.replace(",?", "?");str = str.replace("?,", "?");
 				str = str.replace(",!", "!");str = str.replace("!,", ",");str = str.replace("?!", "?");
 				str = str.replace("!?", "?");str = str.replace("!:", "!");str = str.replace(":!", "!");
 				str = str.replace("?:", "?");str = str.replace(":?", "?");str = str.replace(",:", ",");
 				str = str.replace(":,", ":");
 		
 				
 		String [] strArray = str.split("\\s+");
 	    String fullString = "", backChar= "", leftOver = "", firstCap;
 	    
 	    for (int x = 0; x < strArray.length; x++){
 	    	leftOver = strArray[x].substring(0,strArray[x].length()-2);
 	    	backChar = String.valueOf(strArray[x].charAt(strArray[x].length()-3));
 	    	strArray[x] = backChar + leftOver.substring(0, leftOver.length()-1);
 	    	fullString = fullString + strArray[x] + " ";
 	    }
 	  
 	 
 	    fullString = fullString.toLowerCase();
		firstCap = String.valueOf(fullString.charAt(0)).toUpperCase();
		fullString = firstCap + fullString.substring(1,fullString.length());
		
 	    english.setText(fullString);
 	    
 	}else {
 		//error
 	}
 	
 	}
 	
	public static void main(String[] args) {
		EnglishToPigLatin etpl = new EnglishToPigLatin();
	}
}
