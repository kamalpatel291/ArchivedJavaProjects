package games;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Sudoku {
	
	public Sudoku() {
		// TODO Auto-generated constructor stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader read = new BufferedReader(new FileReader("C:/Users/kamal_000/Desktop/JavaLog/hi.txt"));
			String s;
			String s2,s3,s4,s5;
			while((s=read.readLine()) != null){
				String [] parts = s.split(" ");
				s2 = parts[0];
				s3 = parts[1];
				System.out.println(s2 + s3);
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
