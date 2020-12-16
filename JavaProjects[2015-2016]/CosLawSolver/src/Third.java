import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Third {
	public static void third(String inputr, JTextField textMissingSA, double Sidea, double Sideb, double Sidec, double AngleA, double AngleB, double AngleC, JTextField textWhichSA){
		if (Sidea == 0 && Sideb > 0 && Sidec > 0 && AngleA > 0 && AngleB == 0 && AngleC == 0) {
			//saa a/Aa = c/Ac
			double answersidea = Math.sqrt((Sideb*Sideb) + (Sidec*Sidec) - 2*Sideb*Sidec*Math.cos(Math.toRadians(AngleA)));
			DecimalFormat roundanglec = new DecimalFormat(inputr);
			String round1 = roundanglec.format(answersidea);
			String s = String.valueOf(round1);
			textMissingSA.setText(s);
		}
		else if (Sidea > 0 && Sideb == 0 && Sidec > 0 && AngleA == 0 && AngleB > 0 && AngleC == 0) {
			//saa a/Aa = c/Ac
			double answersideb = Math.sqrt((Sidea*Sidea) + (Sidec*Sidec) - 2*Sidea*Sidec*Math.cos(Math.toRadians(AngleB)));
			DecimalFormat roundanglec = new DecimalFormat(inputr);
			String round1 = roundanglec.format(answersideb);
			String s = String.valueOf(round1);
			textMissingSA.setText(s);
		}
		else if (Sidea > 0 && Sideb > 0 && Sidec == 0 && AngleA == 0 && AngleB == 0 && AngleC > 0) {
			//saa a/Aa = c/Ac
			double answersidec = Math.sqrt((Sidea*Sidea) + (Sideb*Sideb) - 2*Sidea*Sideb*Math.cos(Math.toRadians(AngleC)));
			DecimalFormat roundanglec = new DecimalFormat(inputr);
			String round1 = roundanglec.format(answersidec);
			String s = String.valueOf(round1);
			textMissingSA.setText(s);
		}
		else {
			JOptionPane.showMessageDialog(null, "Sorry !! This Triangle Has No Solution Or Invalid Information", "Error!!", JOptionPane.ERROR_MESSAGE);
		}
	}
}
