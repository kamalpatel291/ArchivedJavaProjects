/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashregister;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kamal
 */
public class test {
    public static void main(String[] args) {
        System.out.printf("=\t%-20s%s\t=","Beetroots","$2.50");
        System.out.println("");
        System.out.printf("=\t%-20s%s\t=","BeetrootsRed","$2.50");
        System.out.println("");
        System.out.printf("=\t%-20s%s\t=","BeetrootsRedBlue","$2.50");
        System.out.println("");
        System.out.printf("=\t%-20s%s\t=","Asian Pears","$2.50");
        System.out.println("");
        System.out.printf("=\t%-20s%5s\t=","","");
        System.out.println("");
        System.out.printf("=\t%15s%10s\t=","Total","$2.50");
        
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("E yyyy-MM-dd  HH:mm:ss");
        System.out.println(sdf.format(date));
    }
    
  
}
