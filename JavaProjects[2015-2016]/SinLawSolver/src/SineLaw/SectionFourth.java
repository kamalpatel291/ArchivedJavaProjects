package SineLaw;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SectionFourth {

	public static void sectionfourth(String inputr, JTextField textMissingSA, double Sidea, double Sideb, double Sidec, double AngleA, double AngleB, double AngleC, JTextField textWhichSA) {
		
	//This Does All The Math Work For Finding Missing Side Given From Two Angles and One Sides
		if (Sidea > 0 && Sideb == 0 && Sidec == 0 && AngleA == 0 && AngleB > 0 && AngleC > 0) {
			if (textWhichSA.getText().equals("Sideb")) {
				AngleA = 180-(AngleB+AngleC);
				double answersideb = ((Math.sin(Math.toRadians(AngleB))*Sidea)/(Math.sin(Math.toRadians(AngleA))));
				DecimalFormat roundsideb = new DecimalFormat(inputr);
				String round1 = roundsideb.format(answersideb);
				String sanswerSideb = String.valueOf(round1);
				textMissingSA.setText(sanswerSideb);
			}else if (textWhichSA.getText().equals("Sidec")){
				AngleA = 180-(AngleB+AngleC);
				double answersidec = ((Math.sin(Math.toRadians(AngleC))*Sidea)/(Math.sin(Math.toRadians(AngleA))));
				DecimalFormat roundsidec = new DecimalFormat(inputr);
				String round2 = roundsidec.format(answersidec);
				String sanswerSidec = String.valueOf(round2);
				textMissingSA.setText(sanswerSidec);
			}	
		} 
		else if (Sidea == 0 && Sideb > 0 && Sidec == 0 && AngleA > 0 && AngleB == 0 && AngleC > 0) {
			if (textWhichSA.getText().equals("Sidea")) {
				AngleB = 180-(AngleA+AngleC);
			    double answersidea = ((Math.sin(Math.toRadians(AngleA))*Sideb)/(Math.sin(Math.toRadians(AngleB))));
			    DecimalFormat roundsidea = new DecimalFormat(inputr);
				String round3 = roundsidea.format(answersidea);
			    String sanswerSidea = String.valueOf(round3);
				textMissingSA.setText(sanswerSidea);
				
			}else if (textWhichSA.getText().equals("Sidec")){
				AngleB = 180-(AngleA+AngleB);
				double answersidec1 = ((Math.sin(Math.toRadians(AngleC))*Sideb)/(Math.sin(Math.toRadians(AngleB))));
				DecimalFormat roundsidec1 = new DecimalFormat(inputr);
				String round4 = roundsidec1.format(answersidec1);
				String sanswerSidec1 = String.valueOf(round4);
				textMissingSA.setText(sanswerSidec1);
			}
		}
		else if (Sidea == 0 && Sideb == 0 && Sidec > 0 && AngleA > 0 && AngleB > 0 && AngleC == 0) {
			if (textWhichSA.getText().equals("Sidea")) {
				 AngleC = 180-(AngleA+AngleB);
				 double answersidea1 = ((Math.sin(Math.toRadians(AngleA))*Sidec)/(Math.sin(Math.toRadians(AngleC))));
				 DecimalFormat roundsidea1 = new DecimalFormat(inputr);
				 String round5 = roundsidea1.format(answersidea1);
				 String sanswerSidea1 = String.valueOf(round5);
				 textMissingSA.setText(sanswerSidea1);
					
			}else if (textWhichSA.getText().equals("Sideb")){
				AngleC = 180-(AngleA+AngleB);
				double answersideb1 = ((Math.sin(Math.toRadians(AngleB))*Sidec)/(Math.sin(Math.toRadians(AngleC))));
				DecimalFormat roundsideb1 = new DecimalFormat(inputr);
				String round6 = roundsideb1.format(answersideb1);
				String sanswerSideb1 = String.valueOf(round6);
				textMissingSA.setText(sanswerSideb1);
			}
		}	else{
			SectionFifth fifth = new SectionFifth();
			fifth.sectionfifth(inputr, textMissingSA, Sidea, Sideb, Sidec, AngleA, AngleB, AngleC, textWhichSA);
		}
	}

}
