package games;

public class RockPaperScissorComp {

	private int number;
	private String choice;
public RockPaperScissorComp() {
	computer();
}
public String computer () {
	number = (int)(Math.random() * 3);
	
	switch(number) {
	case 0 : choice = "Paper";
	break;
	case 1 : choice = "Rock";
	break;
	case 2 : choice = "Scissor";
	break;
	default : System.out.println("Failed To Create Choice For Computer !! "+ number); 
	}
	return choice;
}

public String getChoice() {
	
	return choice;
}

}

