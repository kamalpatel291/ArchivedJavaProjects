/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author kamal
 */
public class Sudoku implements ActionListener {

    /**
     * @param args the command line arguments
     */
    private JTextField[][] boxes;
    private JFrame frame;
    private JButton btnCheck;
    private int[][] solvedArr;
    public Sudoku(int[][] solvedarr){
        solvedArr = solvedarr;
        initializeGraphics(); 
        initializeComponents();
        printArr(solvedArr);
        frame.setVisible(true);
    }
    public void initializeGraphics(){   
        frame = new JFrame();
        frame.setSize(600,650);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        boxes = new JTextField[9][9];
        int space = 5, size = 50;
        int x = 40, y = 25;
        for (int r = 0; r < boxes.length; r++) {
            for (int c = 0; c < boxes[r].length; c++) {
                boxes[r][c] = new JTextField();
                boxes[r][c].setFont(new Font("Constantia", Font.BOLD, 15));
                boxes[r][c].setBounds(x,y,size,size);
                frame.add(boxes[r][c]);
                if((c+1)%3 == 0){
                    x+= (space*2);
                }
                x+= size + space;
            }
            if((r+1)%3 == 0){
                y+= (space*2);
            }
            x = 40;
            y+= size + space;
        }
        
        btnCheck = new JButton("Check");
        btnCheck.setFont(new Font("Constantia", Font.BOLD, 15));
        btnCheck.setBounds(250,boxes[8][8].getY()+ size + 10,100,50);
        btnCheck.addActionListener(this);
        frame.add(btnCheck);
        
        
    }
   
    public void initializeComponents(){
        int[][] partialArr = new int[9][9];
        int randPer = (int) (Math.random()*10)+40;
        int filledBoxes = (int) (81 * (randPer/100.0));
        int length = 0;
        while (length != filledBoxes){
            int randr = (int) (Math.random()*9);
            int randc = (int) (Math.random()*9);
            
            if(partialArr[randr][randc] == 0){
                partialArr[randr][randc] = solvedArr[randr][randc];
                boxes[randr][randc].setText(String.valueOf(partialArr[randr][randc]));
                boxes[randr][randc].setEditable(false);
                length++;
            }
        }
    }

    public void printArr(int[][] arr){
        for (int r = 0; r < arr.length; r++) {
            System.out.print("[ ");
            for (int c = 0; c < arr[r].length; c++) {
                System.out.print(arr[r][c] + " ");
            }
            System.out.println("]");
        }
    }
    public boolean checkSudoku(){
        for(int r = 0; r  < 9; r ++){
            for (int i = 0; i < 8; i++) {
                for (int j = i+1; j < 9; j++) {
                    if(boxes[r][i].getText().equals(boxes[r][j].getText())){
                        return false;
                    }
                }

            }
        }
        //this i is different than above i 
        //same with j
        for(int c = 0; c < 9; c++){
            for (int i = 0; i < 8; i++) {
                for (int j = i+1; j < 9; j++) {
                    if(boxes[i][c].getText().equals(boxes[j][c].getText())){
                        return false;
                    }
                }
            }
        }
        int offset = 0;
        for(int rowAlg = 0; rowAlg < 9; rowAlg+=3){//for row groups
            for (int colAlg = 0; colAlg < 9; colAlg+=3) {//for col groups
                    JTextField txtelem = boxes[rowAlg][colAlg];
                    offset = 1;
                    for (int row = rowAlg; row < rowAlg+3; row++) {//row and col check
                        for (int col = offset+colAlg; col < colAlg+3; col++) {
                            if(txtelem.getText().equals(boxes[rowAlg][colAlg])){
                                return false;
                            }
                        }
                        offset = 0;
                    }
            }
        }
        
        return true;
   }
    public static void main(String[] args) {
        //Sudoku sudoku = new Sudoku();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        if(ac.equals("Check")){
            btnCheck.setEnabled(false);
            boolean answer = checkSudoku();
            if(answer){
                System.out.println("You Win!");
            }else{
                System.out.println("You Lose!");
            }
            btnCheck.setEnabled(true);

        }
    }
    
}
