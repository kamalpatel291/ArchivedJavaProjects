import java.util.Scanner;


public class FirstSection {

	public static void firstsection () {
	Scanner s1 = new Scanner(System.in);
	System.out.println(" \t Enter Side a (0 = null)");
	int Sidea = s1.nextInt();
	
	Scanner s2 = new Scanner(System.in);
	System.out.println(" \t Enter Side b (0 = null)");
	int Sideb = s2.nextInt();

	Scanner s3 = new Scanner(System.in);
	System.out.println(" \t Enter Side c (0 = null)");
	int Sidec = s3.nextInt();
	
	Scanner a1 = new Scanner(System.in);
	System.out.println(" \t Enter Angle A (0 = null)");
	int AngleA = a1.nextInt();
	
	Scanner a2 = new Scanner(System.in);
	System.out.println(" \t Enter Angle B (0 = null");
	int AngleB = a2.nextInt();
	
	Scanner a3 = new Scanner(System.in);
	System.out.println(" \t Enter Angle C (0 = null)");
	int AngleC = a3.nextInt();
	
	if ((Sidea == 0 && Sideb == 0 && Sidec == 0 && AngleA == 0 && AngleB == 0 && AngleC == 0)) {
		System.out.println("Please Enter Valid Numbers for Solving Triangle !!!");
		firstsection();
	}
	
	
	Scanner WhatToFind = new Scanner(System.in);
	System.out.println(" \t What Angle/side you need to find? (Sidea,Sideb,Sidec,AngleA,AngleB or AngleC)");
	String whattofind = WhatToFind.nextLine();
	
	
	if (whattofind.equals("Sidea") || whattofind.equals("Sideb") || whattofind.equals("Sidec") || 
	whattofind.equals("AngleA") || whattofind.equals("AngleB") || whattofind.equals("AngleC"))
	{
		String NameInput = whattofind;
		SecondSection second = new SecondSection();
		second.secondsection(NameInput, Sidea, Sideb, Sidec, AngleA, AngleB, AngleC);
	
	}else{
		System.out.println("Error !! Try Filling Data Again");
		firstsection();
}
}}