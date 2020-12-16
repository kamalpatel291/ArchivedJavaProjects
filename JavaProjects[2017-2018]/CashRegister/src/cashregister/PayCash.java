/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashregister;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author kamal
 */
public class PayCash implements ActionListener, KeyListener{
    private JFrame frame;
    private JLabel lblAmount, lblAmtDue, lblAmt;
    private JTextField txtInput;
    private JButton btnSubmit;
    private double cost;
    private ArrayList<BackRoom> storage;
    private ArrayList<Item> items;
    public PayCash(double cost, ArrayList<BackRoom> storage, ArrayList<Item> items){
        
        this.cost = cost;
        this.storage = storage;
        this.items = items;
        
        frame = new JFrame("Pay Method-Cash");
        frame.setSize(320,250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        lblAmount = new JLabel("Enter Amount: ");
        lblAmount.setBounds(10,20,150,50);
        frame.add(lblAmount);
        
        lblAmtDue = new JLabel("Amount Due:");
        lblAmtDue.setFont(new Font("Constantia", Font.BOLD,15));
        lblAmtDue.setBounds(180,20, 100, 50);
        frame.add(lblAmtDue);
        
        lblAmt = new JLabel("$"+this.cost);
        lblAmt.setFont(new Font("Constantia", Font.BOLD,20));
        lblAmt.setHorizontalAlignment(SwingConstants.CENTER);
        lblAmt.setBounds(180,45, 100, 50);
        frame.add(lblAmt);
        
        txtInput = new JTextField();
        txtInput.setBounds(10,75,150,50);
        txtInput.addKeyListener(this);
        frame.add(txtInput);
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(35,135,100,50);
        btnSubmit.addActionListener(this);
        frame.add(btnSubmit);
        
        frame.setVisible(true);
    }
    public double minusNum(double number){
        double num = number * 100;
        int wholeNum = (int) num;
        int remainder = wholeNum % 10;
        if(remainder == 1 || remainder == 2){
            return (remainder/100.0);
        }else if(remainder == 3 || remainder == 4){
            return ((remainder-5)/100.0);
        }else if(remainder == 6 || remainder == 7){
            return ((remainder - 5)/100.0);
        }else if(remainder == 8 || remainder == 9){
            return ((remainder - 10)/100.0);
        }
        
        return 0;
    }
    
//    public static void main(String[] args) {
//        ArrayList<BackRoom> storage = new ArrayList<BackRoom>();
//        ArrayList<Item> ites = new ArrayList<Item>();
//        new PayCash(20.05,storage,ites);
//    }
    @Override
    public void actionPerformed(ActionEvent e) {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        
        cost -= minusNum(cost);
        String fcost = nf.format(cost);
        fcost = fcost.replace("$", "");
        fcost = fcost.replaceAll(",", "");
        cost = Double.parseDouble(fcost);
        System.out.println("minuNum: " + minusNum(cost));
        System.out.println("Cost: " + cost);
        
        double input = Double.parseDouble(txtInput.getText());
        input -= minusNum(input);
        String finput = nf.format(input);
        finput = finput.replace("$", "");
        finput = finput.replaceAll(",", "");
        input = Double.parseDouble(finput);
        System.out.println("minusNum: " + minusNum(input));
        System.out.println("Input: " + input);
        
        
        if(input>cost && input >= 0.05){
           double change = input - cost;
            System.out.println(change);
           
           String formatChange = nf.format(change);
           formatChange = formatChange.replace("$", "");
           formatChange = formatChange.replaceAll(",", "");
           
           CashDrawer cd = new CashDrawer(Double.parseDouble(formatChange),storage,items);
        }else if(input == cost || input < 0.05){
           CashRegister cr = new CashRegister("Successful",storage, items);
        }else if(input < cost){
            JOptionPane.showMessageDialog(null, "Please Give Valid Money !!", "Error:Less Money", JOptionPane.WARNING_MESSAGE);
        }
        frame.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char key = e.getKeyChar();
        if((!Character.isDigit(key)) && key!='.'){
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
