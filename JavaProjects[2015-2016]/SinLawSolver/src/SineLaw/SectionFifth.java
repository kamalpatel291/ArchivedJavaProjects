package SineLaw;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SectionFifth {
	public static void sectionfifth(String inputr, JTextField textMissingSA, double Sidea, double Sideb, double Sidec, double AngleA, double AngleB, double AngleC, JTextField textWhichSA) {
		if (Sidea > 0 && Sideb > 0 && Sidec > 0 && AngleA > 0 && AngleB == 0 && AngleC == 0) {
			if (textWhichSA.getText().equals("AngleB")) {
				
				double answerangleb = ((Math.sin(Math.toRadians(AngleA))*Sideb)/Sidea);
				Math.toDegrees(answerangleb);
				DecimalFormat roundsideb = new DecimalFormat(inputr);
				String round1 = roundsideb.format(answerangleb);
				String sanswerSideb = String.valueOf(round1);
				textMissingSA.setText(sanswerSideb);
			}else if (textWhichSA.getText().equals("AngleC")){
				
				double answeranglec = ((Math.sin(Math.toRadians(AngleA))*Sidec)/Sidea);
				Math.toDegrees(answeranglec);
				DecimalFormat roundsidec = new DecimalFormat(inputr);
				String round2 = roundsidec.format(answeranglec);
				String sanswerSidec = String.valueOf(round2);
				textMissingSA.setText(sanswerSidec);
			}	
		}
		else if (Sidea > 0 && Sideb > 0 && Sidec > 0 && AngleA == 0 && AngleB > 0 && AngleC == 0) {
			if (textWhichSA.getText().equals("AngleA")) {	
				double answeranglea = ((Math.sin(Math.toRadians(AngleB))*Sidea)/Sideb);
				Math.toDegrees(answeranglea);
				DecimalFormat roundsideb = new DecimalFormat(inputr);
				String round1 = roundsideb.format(answeranglea);
				String sanswerSideb = String.valueOf(round1);
				textMissingSA.setText(sanswerSideb);
			}else if (textWhichSA.getText().equals("AngleC")){
				
				double answeranglec1 = ((Math.sin(Math.toRadians(AngleC))*Sidec)/Sideb);
				DecimalFormat roundsidec = new DecimalFormat(inputr);
				String round2 = roundsidec.format(answeranglec1);
				String sanswerSidec = String.valueOf(round2);
				textMissingSA.setText(sanswerSidec);
			}
			
		}
		else if (Sidea > 0 && Sideb > 0 && Sidec > 0 && AngleA == 0 && AngleB == 0 && AngleC > 0) {
			if (textWhichSA.getText().equals("AngleA")) {	
				double answeranglea1 = ((Math.sin(Math.toRadians(AngleC))*Sidea)/Sidec);
				DecimalFormat roundsideb = new DecimalFormat(inputr);
				String round1 = roundsideb.format(answeranglea1);
				String sanswerSideb = String.valueOf(round1);
				textMissingSA.setText(sanswerSideb);
			}else if (textWhichSA.getText().equals("AngleB")){
				
				double answerangleb1 = ((Math.sin(Math.toRadians(AngleC))*Sideb)/Sidec);
				DecimalFormat roundsidec = new DecimalFormat(inputr);
				String round2 = roundsidec.format(answerangleb1);
				String sanswerSidec = String.valueOf(round2);
				textMissingSA.setText(sanswerSidec);
			}
		}
		else if (Sidea > 0 && Sideb == 0 && Sidec == 0 && AngleA > 0 && AngleB > 0 && AngleC > 0) {
			if (textWhichSA.getText().equals("Sideb")) {
				
				double answersideb = ((Math.sin(Math.toRadians(AngleB))*Sidea)/(Math.sin(Math.toRadians(AngleA))));
				DecimalFormat roundsideb = new DecimalFormat(inputr);
				String round1 = roundsideb.format(answersideb);
				String sanswerSideb = String.valueOf(round1);
				textMissingSA.setText(sanswerSideb);
			}else if (textWhichSA.getText().equals("Sidec")){
				
				double answersidec = ((Math.sin(Math.toRadians(AngleC))*Sidea)/(Math.sin(Math.toRadians(AngleA))));
				DecimalFormat roundsidec = new DecimalFormat(inputr);
				String round2 = roundsidec.format(answersidec);
				String sanswerSidec = String.valueOf(round2);
				textMissingSA.setText(sanswerSidec);
			}	
		}
		else if (Sidea == 0 && Sideb > 0 && Sidec == 0 && AngleA > 0 && AngleB > 0 && AngleC > 0) {
			if (textWhichSA.getText().equals("Sidea")) {
				
				double answersidea = ((Math.sin(Math.toRadians(AngleA))*Sideb)/(Math.sin(Math.toRadians(AngleB))));
				DecimalFormat roundsideb = new DecimalFormat(inputr);
				String round1 = roundsideb.format(answersidea);
				String sanswerSideb = String.valueOf(round1);
				textMissingSA.setText(sanswerSideb);
			}else if (textWhichSA.getText().equals("Sidec")){
				
				double answersidec1 = ((Math.sin(Math.toRadians(AngleC))*Sideb)/(Math.sin(Math.toRadians(AngleB))));
				DecimalFormat roundsidec = new DecimalFormat(inputr);
				String round2 = roundsidec.format(answersidec1);
				String sanswerSidec = String.valueOf(round2);
				textMissingSA.setText(sanswerSidec);
		}
		else if (Sidea == 0 && Sideb == 0 && Sidec > 0 && AngleA > 0 && AngleB > 0 && AngleC > 0) {
			if (textWhichSA.getText().equals("Sidea")) {
				
				double answersidea1 = ((Math.sin(Math.toRadians(AngleA))*Sidec)/(Math.sin(Math.toRadians(AngleC))));
				DecimalFormat roundsideb = new DecimalFormat(inputr);
				String round1 = roundsideb.format(answersidea1);
				String sanswerSideb = String.valueOf(round1);
				textMissingSA.setText(sanswerSideb);
			}else if (textWhichSA.getText().equals("Sideb")){
				
				double answersideb1 = ((Math.sin(Math.toRadians(AngleB))*Sidec)/(Math.sin(Math.toRadians(AngleC))));
				DecimalFormat roundsidec = new DecimalFormat(inputr);
				String round2 = roundsidec.format(answersideb1);
				String sanswerSidec = String.valueOf(round2);
				textMissingSA.setText(sanswerSidec);
				} else {
					JOptionPane.showMessageDialog(null, "Sorry !! This Triangle Has No Solution Or Invalid Information", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}	
}