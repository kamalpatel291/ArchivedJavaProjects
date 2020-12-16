package robotMouseClass;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class RobotMouseClass {

	public RobotMouseClass() throws AWTException, IOException {
		Robot r = new Robot();
		
		
		double cx= MouseInfo.getPointerInfo().getLocation().getX();
		double cy = MouseInfo.getPointerInfo().getLocation().getY();
		
		
		r.mouseMove(200, 200);
		System.out.println(r.getPixelColor((int)cx,(int)cy));

		/*try {
			Desktop.getDesktop().browse(new URI("www.google.com"));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
		
	}

	public static void main(String[] args) throws AWTException, IOException {
		RobotMouseClass rmc = new RobotMouseClass();
	}

}
