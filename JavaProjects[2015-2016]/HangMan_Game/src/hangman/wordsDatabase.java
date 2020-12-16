package hangman;

import java.io.BufferedReader;
import java.util.*;

public class wordsDatabase {
	private ArrayList <String> dictionary = new ArrayList <String>();
	private String word;
	public wordsDatabase() {
		
		dictionaryMaker();
	}
	
	public void dictionaryMaker(){
		dictionary.add("Elephant");
		dictionary.add("HangMan");
		dictionary.add("Apple");
		dictionary.add("Ball");
		dictionary.add("Cat");
		dictionary.add("Dog");
	}
	
	public String getWord(int num){
		if (num >= 0){
		word = dictionary.get(num);
		
		return word;
		
		}
		
		return "";
	}
	

}
