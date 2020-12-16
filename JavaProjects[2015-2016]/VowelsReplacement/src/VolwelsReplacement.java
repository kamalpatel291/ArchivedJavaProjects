
public class VolwelsReplacement {

	public VolwelsReplacement() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String str = "Bread";
		String fullstr = "";
		String fullstr2 = "";
		char a = 'a',e = 'e',i = 'i' ,o = 'o',u = 'u';
		for (int x = 0; x<str.length();x++){
			if(str.charAt(x) == a ||str.charAt(x) == e ||str.charAt(x) == i || str.charAt(x) == o || str.charAt(x) == u ){
				fullstr  = fullstr + String.valueOf(str.charAt(x));
			}else{
				fullstr2 = fullstr2 + String.valueOf(str.charAt(x));
			}
		}
		
		System.out.println(fullstr+fullstr2);
	}

}
