package SineLaw;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SectionFirst {
	public static void sectionfirst(JTextField textMissingSA, JTextField textSidea, JTextField textSideb, JTextField textSidec, JTextField textAngleA, JTextField textAngleB, JTextField textAngleC, JTextField textWhichSA, JTextField textRound){
		String inputr = "";
		if (textRound.getText().equals("")){
			inputr = "0.00";
		}else if (Double.parseDouble(textRound.getText()) == 0) {
			inputr = textRound.getText();
		}
	
		if(textSidea.getText().equals("") && textSideb.getText().equals("") && textSidec.getText().equals("")&&
		   textAngleA.getText().equals("") && textAngleB.getText().equals("") && textAngleC.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Please Enter Valid Information !!!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	else	if ((Double.parseDouble(textSidea.getText()) == 0 && Double.parseDouble(textSideb.getText()) == 0 && Double.parseDouble(textSidec.getText()) == 0 &&
			Double.parseDouble(textAngleA.getText()) == 0 && Double.parseDouble(textAngleB.getText()) == 0 && Double.parseDouble(textAngleC.getText()) == 0)
			|| (Double.parseDouble(textSidea.getText()) > 0 && Double.parseDouble(textSideb.getText()) > 0 && Double.parseDouble(textSidec.getText()) > 0 &&
				Double.parseDouble(textAngleA.getText()) > 0 && Double.parseDouble(textAngleB.getText()) > 0 && Double.parseDouble(textAngleC.getText()) > 0)){
			
		JOptionPane.showMessageDialog(null, "Please Enter Valid Information !!!", "Error", JOptionPane.ERROR_MESSAGE);
			
		} else {
			SectionSecond second = new SectionSecond();
			second.sectionsecond(inputr, textMissingSA, textSidea, textSideb, textSidec, textAngleA, textAngleB,  textAngleC, textWhichSA);
		}
		
		
		
	}
}
