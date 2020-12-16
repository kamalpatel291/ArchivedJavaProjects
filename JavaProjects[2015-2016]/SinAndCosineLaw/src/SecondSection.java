
public class SecondSection {

	public static void secondsection(String NameInput, int Sidea, int Sideb, int Sidec, int AngleA, int AngleB, int AngleC) {
		// side angle angle
		// side side angle
		
		//Side Angle Angle
		if (Sidea  == 0 && Sideb > 0 && Sidec == 0 && AngleA > 0 && AngleB > 0 && AngleC == 0) {
			//saa b/Ab = a/Aa
			double answersidea = ((Math.sin(Math.toRadians(AngleA))*Sideb)/(Math.sin(Math.toRadians(AngleB))));
			System.out.println(NameInput+" = "+Math.round(answersidea));
		}
	else	if (Sidea > 0 && Sideb == 0 && Sidec == 0 && AngleA > 0 && AngleB > 0 && AngleC == 0) {
			//saa  a/Aa = b/Ab
			double answersideb = ((Math.sin(Math.toRadians(AngleB))*Sidea)/(Math.sin(Math.toRadians(AngleA))));
				System.out.println(NameInput+" = "+Math.round(answersideb));
		}	
	else	if (Sidea > 0 && Sideb == 0 && Sidec == 0 && AngleA > 0 && AngleB == 0 && AngleC > 0) {
			//saa a/Aa = c/Ac
			double answersidec = ((Math.sin(Math.toRadians(AngleC))*Sidea)/(Math.sin(Math.toRadians(AngleA))));
			System.out.println(NameInput+" = "+Math.round(answersidec));
		}
	else	if (Sidea == 0 && Sideb == 0 && Sidec > 0 && AngleA > 0 && AngleB == 0 && AngleC > 0) {
			//saa c/Ac = a/Aa
			double answersidea1 = ((Math.sin(Math.toRadians(AngleA))*Sidec)/(Math.sin(Math.toRadians(AngleC))));
			System.out.println(NameInput+" = "+Math.round(answersidea1));
		}
	else	if (Sidea == 0 && Sideb == 0 && Sidec > 0 && AngleA == 0 && AngleB > 0 && AngleC > 0) {
			//saa c/Ac = b/Ab
			double answersideb1 = ((Math.sin(Math.toRadians(AngleB))*Sidec)/(Math.sin(Math.toRadians(AngleC))));
			System.out.println(NameInput+" = "+Math.round(answersideb1));
		}
	else	if (Sidea == 0 && Sideb > 0 && Sidec == 0 && AngleA == 0 && AngleB > 0 && AngleC > 0) {
			//saa b/Ab = c/Ac
			double answersidec1 = ((Math.sin(Math.toRadians(AngleC))*Sideb)/(Math.sin(Math.toRadians(AngleB))));
			System.out.println(NameInput+" = "+Math.round(answersidec1));
			
		}
			
		ThirdSection third = new ThirdSection();
		third.thirdsection(NameInput, Sidea, Sideb, Sidec, AngleA, AngleB, AngleC);
	
		
	
	
	
	
	}

}
