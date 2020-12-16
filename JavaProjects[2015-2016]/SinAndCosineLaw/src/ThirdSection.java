
public class ThirdSection {

	public static void thirdsection(String NameInput, int Sidea, int Sideb, int Sidec, int AngleA, int AngleB, int AngleC) {
		//side angle angle
		//side side angle
		
		//Side Side Angle
		if (Sidea  > 0 && Sideb > 0 && Sidec == 0 && AngleA > 0 && AngleB == 0 && AngleC == 0) {
			//ssa b/Ab = a/Aa
			double answerangleb =((Math.sin(Math.toRadians(AngleA))*Sideb)/Sidea);
			Math.toDegrees(answerangleb);
			System.out.println(NameInput+" = "+Math.round(answerangleb));
			
		}
	else	if (Sidea  > 0 && Sideb > 0 && Sidec == 0 && AngleA == 0 && AngleB > 0 && AngleC == 0) {
			//ssa b/Ab = a/Aa
			double answeranglea =((Math.sin(Math.toRadians(AngleB))*Sidea)/Sideb);
			Math.toDegrees(answeranglea);
			System.out.println(NameInput+" = "+Math.round(answeranglea));
		
		}
	else	if (Sidea  == 0 && Sideb > 0 && Sidec > 0 && AngleA == 0 && AngleB > 0 && AngleC == 0) {
			//ssa b/Ab = c/Ac
			double answeranglec =((Math.sin(Math.toRadians(AngleB))*Sidec)/Sideb);
			Math.toDegrees(answeranglec);
			System.out.println(NameInput+" = "+Math.round(answeranglec));
		
		}
	else	if (Sidea  == 0 && Sideb > 0 && Sidec > 0 && AngleA == 0 && AngleB == 0 && AngleC > 0) {
			//ssa b/Ab = c/Ac
			double answerangleb1 =((Math.sin(Math.toRadians(AngleC))*Sideb)/Sidec);
			Math.toDegrees(answerangleb1);
			System.out.println(NameInput+" = "+Math.round(answerangleb1));
	
		}
	else	if (Sidea  > 0 && Sideb == 0 && Sidec > 0 && AngleA > 0 && AngleB == 0 && AngleC == 0) {
			//ssa a/Aa = c/Ac
			double answeranglec1 =((Math.sin(Math.toRadians(AngleA))*Sidec)/Sidea);
			Math.toDegrees(answeranglec1);
			System.out.println(NameInput+" = "+Math.round(answeranglec1));
		}
	else	if (Sidea  > 0 && Sideb == 0 && Sidec > 0 && AngleA == 0 && AngleB == 0 && AngleC > 0) {
			//ssa a/Aa = c/Ac
			double answeranglea1 =((Math.sin(Math.toRadians(AngleC))*Sidea)/Sidec);
			Math.toDegrees(answeranglea1);
			System.out.println(NameInput+" = "+Math.round(answeranglea1));
			
			}
		FourthSection fourth = new FourthSection();
		fourth.fourthsection(NameInput, Sidea, Sideb, Sidec, AngleA, AngleB, AngleC);
		
		
	
		
		
		
	
	
	
	
	
	
	
	
	
		
	}

}
