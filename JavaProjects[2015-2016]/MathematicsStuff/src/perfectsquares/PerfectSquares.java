package perfectsquares;

import java.io.*;
import java.util.Scanner;

public class PerfectSquares {
	private PrintWriter printwrite;
	public PerfectSquares() {
		System.out.println("Enter A Number: ");
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();

		printwritemethod(number);
	}
	public void printwritemethod(int num){
		
		File file = new File("C:/Users/kamal_000/Desktop/JavaLog/PerfectSquares.txt");
		
		try{
			printwrite = new PrintWriter(file);
			for(int x = 0; x<70;x++){
				printwrite.print("-");	
			}
			printwrite.println();
			printwrite.print(" Perfect Squares    |");
			printwrite.print("    Perfect Cubes     |");
			printwrite.println("\t"+"Perfect Fourthroots  |");
			for(int x = 0; x<70;x++){
				printwrite.print("-");	
			}
			printwrite.println();
			for(int x = 1; x <= num; x++){
		
			printwrite.print("\t"+x*x + "\t    |");
			printwrite.print("\t\t"+x*x*x + "\t   |");
			printwrite.println("\t       "+x*x*x*x+"\t     |");
			}
			printwrite.close();
			System.out.println("Writing Perfect Squares Comeplete !");
		}catch(Exception ex){
			System.out.print("Error ! Failed To Create A File !");
		}
		
	}

	public static void main(String[] args) {
		PerfectSquares sq = new PerfectSquares();
	}

}
