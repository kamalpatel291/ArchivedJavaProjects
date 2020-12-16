import java.util.Scanner;


public class FourthSection {
	
	//Never Add answer's (e.g double answersidea) parameters to any section else it will override

	
		public static void fourthsection(String NameInput, int Sidea, int Sideb, int Sidec, int AngleA, int AngleB, int AngleC) {
			// Angle Side Angle
			// ASA
				if (Sidea > 0 && Sideb == 0 && Sidec == 0 && AngleA == 0 && AngleB > 0 && AngleC > 0) {
					if (NameInput.equals("Sideb")) {
						AngleA = 180-(AngleB+AngleC);
						double answersideb = ((Math.sin(Math.toRadians(AngleB))*Sidea)/(Math.sin(Math.toRadians(AngleA))));
						System.out.println(NameInput+" = "+Math.round(answersideb));
					}else if (NameInput.equals("Sidec")){
						AngleA = 180-(AngleB+AngleC);
						double answersidec = ((Math.sin(Math.toRadians(AngleC))*Sidea)/(Math.sin(Math.toRadians(AngleA))));
						System.out.println(NameInput+" = "+Math.round(answersidec));
					}	
				} 
				else if (Sidea == 0 && Sideb > 0 && Sidec == 0 && AngleA > 0 && AngleB == 0 && AngleC > 0) {
					if (NameInput.equals("Sidea")) {
						AngleB = 180-(AngleA+AngleC);
					    double answersidea = ((Math.sin(Math.toRadians(AngleA))*Sideb)/(Math.sin(Math.toRadians(AngleB))));
					    System.out.println(NameInput+" = "+Math.round(answersidea));
					}else if (NameInput.equals("Sidec")){
						AngleB = 180-(AngleA+AngleB);
						double answersidec1 = ((Math.sin(Math.toRadians(AngleC))*Sideb)/(Math.sin(Math.toRadians(AngleB))));
						System.out.println(NameInput+" = "+Math.round(answersidec1));
					}
				}
				else if (Sidea == 0 && Sideb == 0 && Sidec > 0 && AngleA > 0 && AngleB > 0 && AngleC == 0) {
					if (NameInput.equals("Sidea")) {
						 AngleC = 180-(AngleA+AngleB);
						 double answersidea1 = ((Math.sin(Math.toRadians(AngleA))*Sidec)/(Math.sin(Math.toRadians(AngleC))));
						 System.out.println(NameInput+" = "+Math.round(answersidea1));
					}else if (NameInput.equals("Sideb")){
						AngleC = 180-(AngleA+AngleB);
						double answersideb1 = ((Math.sin(Math.toRadians(AngleB))*Sidec)/(Math.sin(Math.toRadians(AngleC))));
						System.out.println(NameInput+" = "+Math.round(answersideb1));
					}
				}	else{
					System.out.println("Sorry !! This Triangle Has No Solution Or Entered Wrong Values");
				}
					
				System.out.println("Would you like to try SINLAW SOLVER again ?(Yes/No)");
				 Scanner again = new Scanner(System.in);
				 String againinput = again.nextLine();
				 if (againinput.equals("Yes") || againinput.equals("yes")) {
					FirstSection first = new FirstSection();
					 first.firstsection();
				 }else{
					 System.out.println("System: Thanks For Trying SINLAW SOLVER !!, \n \t Have Great Day :)");
				 }	
					
					
					
					
					
 }
}				
			
		












