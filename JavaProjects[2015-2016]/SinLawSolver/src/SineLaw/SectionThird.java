package SineLaw;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SectionThird {
	public static void sectionthird(String inputr, JTextField textMissingSA, double Sidea, double Sideb, double Sidec, double AngleA, double AngleB, double AngleC, JTextField textWhichSA){
		
		//This Does All The Math For Finding Missing Angle From Given Two Sides And One Angle
		if (Sidea  > 0 && Sideb > 0 && Sidec == 0 && AngleA > 0 && AngleB == 0 && AngleC == 0) {
			//ssa b/Ab = a/Aa
			double answerangleb =((Math.sin(Math.toRadians(AngleA))*Sideb)/Sidea);
			Math.toDegrees(answerangleb);
			DecimalFormat roundangleb = new DecimalFormat(inputr);
			String round1 = roundangleb.format(answerangleb);
			String s = String.valueOf(round1);
			textMissingSA.setText(s);
			
		}
	else	if (Sidea  > 0 && Sideb > 0 && Sidec == 0 && AngleA == 0 && AngleB > 0 && AngleC == 0) {
			//ssa b/Ab = a/Aa
			double answeranglea =((Math.sin(Math.toRadians(AngleB))*Sidea)/Sideb);
			Math.toDegrees(answeranglea);
			DecimalFormat roundanglea = new DecimalFormat(inputr);
			String round2 = roundanglea.format(answeranglea);
			String s = String.valueOf(round2);
			textMissingSA.setText(s);
		
		}
	else	if (Sidea  == 0 && Sideb > 0 && Sidec > 0 && AngleA == 0 && AngleB > 0 && AngleC == 0) {
			//ssa b/Ab = c/Ac
			double answeranglec =((Math.sin(Math.toRadians(AngleB))*Sidec)/Sideb);
			Math.toDegrees(answeranglec);
			DecimalFormat roundanglec = new DecimalFormat(inputr);
			String round3 = roundanglec.format(answeranglec);
			String s = String.valueOf(round3);
			textMissingSA.setText(s);
		
		}
	else	if (Sidea  == 0 && Sideb > 0 && Sidec > 0 && AngleA == 0 && AngleB == 0 && AngleC > 0) {
			//ssa b/Ab = c/Ac
			double answerangleb1 =((Math.sin(Math.toRadians(AngleC))*Sideb)/Sidec);
			Math.toDegrees(answerangleb1);
			DecimalFormat roundangleb1 = new DecimalFormat(inputr);
			String round4 = roundangleb1.format(answerangleb1);
			String s = String.valueOf(round4);
			textMissingSA.setText(s);
	
		}
	else	if (Sidea  > 0 && Sideb == 0 && Sidec > 0 && AngleA > 0 && AngleB == 0 && AngleC == 0) {
			//ssa a/Aa = c/Ac
			double answeranglec1 =((Math.sin(Math.toRadians(AngleA))*Sidec)/Sidea);
			Math.toDegrees(answeranglec1);
			DecimalFormat roundanglec1 = new DecimalFormat(inputr);
			String round5 = roundanglec1.format(answeranglec1);
			String s = String.valueOf(round5);
			textMissingSA.setText(s);
		}
	else	if (Sidea  > 0 && Sideb == 0 && Sidec > 0 && AngleA == 0 && AngleB == 0 && AngleC > 0) {
			//ssa a/Aa = c/Ac
			double answeranglea1 =((Math.sin(Math.toRadians(AngleC))*Sidea)/Sidec);
			Math.toDegrees(answeranglea1);
			DecimalFormat roundanglea1 = new DecimalFormat(inputr);
			String round6 = roundanglea1.format(answeranglea1);
			String s = String.valueOf(round6);
			textMissingSA.setText(s);
			
			}
	else {
		SectionFourth fourth = new SectionFourth();
		fourth.sectionfourth(inputr, textMissingSA, Sidea, Sideb, Sidec, AngleA, AngleB, AngleC, textWhichSA);
	}
		
	}
}
