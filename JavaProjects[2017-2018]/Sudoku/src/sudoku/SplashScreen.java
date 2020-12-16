/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author kamal
 */
public class SplashScreen {
    private JFrame frame;
    private JLabel lblWait, lblInfo;
    private JProgressBar jpbLoading;
    private Thread loadingThread;
    private DaemonThread myThread;
    public SplashScreen(){
        frame = new JFrame();
        frame.setSize(600,450);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
        
        lblWait = new JLabel("Please Wait....");
        lblWait.setFont(new Font("Constantia", Font.BOLD,20));
        lblWait.setHorizontalAlignment(SwingConstants.CENTER);
        lblWait.setBounds(150,150,300,50);
        frame.add(lblWait);
        
        lblInfo = new JLabel("Initializing Components...");
        lblInfo.setFont(new Font("Constantia", Font.PLAIN,15));
        lblInfo.setBounds(50,260,300,50);
        frame.add(lblInfo);
        
        jpbLoading = new JProgressBar();
        jpbLoading.setBounds(50,300,500,60);
        frame.add(jpbLoading);
        
        
        frame.setVisible(true);
        startInitializing();
        initializeSudoku();

    }
    
    class DaemonThread implements Runnable{
        public boolean runnable = false;
        @Override
        public void run() {
            int n = 0;
            while(runnable){
                if(n > 99){
                    n = 0;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                jpbLoading.setValue(n);
                n++;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
         
    }
    public void startInitializing(){
        myThread = new DaemonThread();
        loadingThread = new Thread(myThread);
        loadingThread.start();
        myThread.runnable = true;
    }
    public void initializeSudoku(){
        int[][] solvedboxes = new int[9][9];
        int r = 0, c = 0;
        int length = 0;
        int tries = 0;
        do{
          int rnum = (int)(Math.random() * 9)+1;
          if(partialCheck(solvedboxes,r,c,rnum)){
                solvedboxes[r][c] = rnum;
                length++;
                tries = 0;
                c++;
            if(c == 9){
                r++;
                c = 0;
            }
          }
          if(tries > 30){
              solvedboxes = new int[9][9];
              r = 0;
              c = 0;
              length = 0;
              tries = 0;
          }
          tries++;
          
        }while(length < 81);
        
        System.out.println("Finished Creating..");
        loadingThread.stop();
        myThread.runnable = false;
        Sudoku s = new Sudoku(solvedboxes);
        frame.dispose();
    }
    
    public boolean partialCheck(int[][] refarr, int r, int c, int rnum){
        for (int i = 0; i < c; i++) {
            if(refarr[r][i] == rnum){
                return false;
            }
        }
        for (int j = 0; j < r; j++) {
            if(refarr[j][c] == rnum){
                return false;
            }
        }
        int rowAlg = findAlg(r);
        int colAlg = findAlg(c);
        for (int row = rowAlg; row < rowAlg+3; row++) {
            for (int col = colAlg; col < colAlg+3; col++) {
                if(refarr[row][col] == rnum){
                    return false;
                }
            }
        }
        return true;
    }
    public int findAlg(int num){
        if(num == 0 || num == 1 || num == 2){
            return 0;
        }else if(num == 3 || num == 4 || num == 5){
            return 3;
        }else{
            return 6;
        }
    }
    public static void main(String[] args) {
        SplashScreen ss = new SplashScreen();
    }
}
