package SineLaw;

import java.text.DecimalFormat;

import javax.swing.JTextField;

public class SectionSecond {
	public static void sectionsecond(String inputr, JTextField textMissingSA, JTextField textSidea, JTextField textSideb, JTextField textSidec, JTextField textAngleA, JTextField textAngleB, JTextField textAngleC, JTextField textWhichSA) {
		//This Is Setting Value Into Double By Getting Value From JTextField
		double Sidea = Double.parseDouble(textSidea.getText());
		double Sideb = Double.parseDouble(textSideb.getText());
		double Sidec = Double.parseDouble(textSidec.getText());
		double AngleA = Double.parseDouble(textAngleA.getText());
		double AngleB = Double.parseDouble(textAngleB.getText());
		double AngleC = Double.parseDouble(textAngleC.getText());
	//This Does All The Math For Finding Missing Side From Given One Side and Two Angles
		
		if (Sidea  == 0 && Sideb > 0 && Sidec == 0 && AngleA > 0 && AngleB > 0 && AngleC == 0) {
			//saa b/Ab = a/Aa
			double answersidea = ((Math.sin(Math.toRadians(AngleA))*Sideb)/(Math.sin(Math.toRadians(AngleB))));
			DecimalFormat roundsidea = new DecimalFormat(inputr);
			String round1 = roundsidea.format(answersidea);
			String s = String.valueOf(round1);
			textMissingSA.setText(s);
		}
	else	if (Sidea > 0 && Sideb == 0 && Sidec == 0 && AngleA > 0 && AngleB > 0 && AngleC == 0) {
			//saa  a/Aa = b/Ab
			double answersideb = ((Math.sin(Math.toRadians(AngleB))*Sidea)/(Math.sin(Math.toRadians(AngleA))));
			DecimalFormat roundsideb = new DecimalFormat(inputr);
			String round2 = roundsideb.format(answersideb);
			String s = String.valueOf(round2);
			textMissingSA.setText(s);	
		}	
	else	if (Sidea > 0 && Sideb == 0 && Sidec == 0 && AngleA > 0 && AngleB == 0 && AngleC > 0) {
			//saa a/Aa = c/Ac
			double answersidec = ((Math.sin(Math.toRadians(AngleC))*Sidea)/(Math.sin(Math.toRadians(AngleA))));
			DecimalFormat roundsidec= new DecimalFormat(inputr);
			String round3 = roundsidec.format(answersidec);
			String s = String.valueOf(round3);
			textMissingSA.setText(s);
		}
	else	if (Sidea == 0 && Sideb == 0 && Sidec > 0 && AngleA > 0 && AngleB == 0 && AngleC > 0) {
			//saa c/Ac = a/Aa
			double answersidea1 = ((Math.sin(Math.toRadians(AngleA))*Sidec)/(Math.sin(Math.toRadians(AngleC))));
			DecimalFormat roundsidea1 = new DecimalFormat(inputr);
			String round4 = roundsidea1.format(answersidea1);
			String s = String.valueOf(round4);
			textMissingSA.setText(s);
		}
	else	if (Sidea == 0 && Sideb == 0 && Sidec > 0 && AngleA == 0 && AngleB > 0 && AngleC > 0) {
			//saa c/Ac = b/Ab
			double answersideb1 = ((Math.sin(Math.toRadians(AngleB))*Sidec)/(Math.sin(Math.toRadians(AngleC))));
			DecimalFormat roundsideb1 = new DecimalFormat(inputr);
			String round5 = roundsideb1.format(answersideb1);
			String s = String.valueOf(round5);
			textMissingSA.setText(s);
		}
	else	if (Sidea == 0 && Sideb > 0 && Sidec == 0 && AngleA == 0 && AngleB > 0 && AngleC > 0) {
			//saa b/Ab = c/Ac
			double answersidec1 = ((Math.sin(Math.toRadians(AngleC))*Sideb)/(Math.sin(Math.toRadians(AngleB))));
			DecimalFormat roundsidec1 = new DecimalFormat(inputr);
			String round6 = roundsidec1.format(answersidec1);
			String s = String.valueOf(round6);
			textMissingSA.setText(s);
			
		}else {
			
		SectionThird third = new SectionThird();
		third.sectionthird(inputr, textMissingSA, Sidea, Sideb, Sidec, AngleA, AngleB, AngleC, textWhichSA);
	
		
		}
	
	
	
	}
		
	}

