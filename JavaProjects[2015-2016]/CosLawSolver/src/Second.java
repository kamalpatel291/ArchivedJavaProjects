import java.text.DecimalFormat;

import javax.swing.JTextField;



public class Second {
	public static void second(String inputr, JTextField textMissingSA, JTextField textSidea, JTextField textSideb, JTextField textSidec, JTextField textAngleA, JTextField textAngleB, JTextField textAngleC, JTextField textWhichSA) {
		//This Is Setting Value Into Double By Getting Value From JTextField
				double Sidea = Double.parseDouble(textSidea.getText());
				double Sideb = Double.parseDouble(textSideb.getText());
				double Sidec = Double.parseDouble(textSidec.getText());
				double AngleA = Double.parseDouble(textAngleA.getText());
				double AngleB = Double.parseDouble(textAngleB.getText());
				double AngleC = Double.parseDouble(textAngleC.getText());
			//This Does All The Math For Finding Missing Side From Given One Side and Two Angles
			if (textWhichSA.getText().equals("AngleA")) {
				if (Sidea  > 0 && Sideb > 0 && Sidec > 0 && AngleA == 0 && AngleB == 0 && AngleC == 0) {
					//Cos A = b+c-a / 2bc
					double answeranglea = ((Sideb+Sidec-Sidea)/(2*Sideb*Sidec));
					Math.toDegrees(answeranglea);
					DecimalFormat roundanglea = new DecimalFormat(inputr);
					String round1 = roundanglea.format(answeranglea);
					String s = String.valueOf(round1);
					textMissingSA.setText(s);
				}
			}else if (textWhichSA.getText().equals("AngleB")) {
					if (Sidea > 0 && Sideb > 0 && Sidec > 0 && AngleA == 0 && AngleB == 0 && AngleC == 0) {
					//saa  a/Aa = b/Ab
					double answerangleb = ((Sidea+Sidec-Sideb)/(2*Sidea*Sidec));
					Math.toDegrees(answerangleb);
					DecimalFormat roundangleb = new DecimalFormat(inputr);
					String round1 = roundangleb.format(answerangleb);
					String s = String.valueOf(round1);
					textMissingSA.setText(s);	
				}
			}else if (textWhichSA.getText().equals("AngleC")) {
					if (Sidea > 0 && Sideb > 0 && Sidec > 0 && AngleA == 0 && AngleB == 0 && AngleC == 0) {
					//saa a/Aa = c/Ac
					double answeranglec = ((Sidea+Sideb-Sidec)/(2*Sidea*Sideb));
					Math.toDegrees(answeranglec);
					DecimalFormat roundanglec = new DecimalFormat(inputr);
					String round1 = roundanglec.format(answeranglec);
					String s = String.valueOf(round1);
					textMissingSA.setText(s);
				}
			}	
			else {
					
				Third third = new Third();
				third.third(inputr, textMissingSA, Sidea, Sideb, Sidec, AngleA, AngleB, AngleC, textWhichSA);
			
				
				}
	}
}
