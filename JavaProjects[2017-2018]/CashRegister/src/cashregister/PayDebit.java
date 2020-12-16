/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashregister;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 *
 * @author kamal
 */
public class PayDebit implements ActionListener, KeyListener {
    private JFrame frame;
    private JTextField txtInput,txtCashBack;
    private JLabel lblConfirm;
    private JButton btnYes, btnNo,btnInc,btnDec;
    private int step = 1;
    private boolean cashback = false;
    private ArrayList<BackRoom> storage;
    private ArrayList<Item> items;
    public PayDebit(ArrayList<BackRoom> storage, ArrayList<Item> items){
        this.storage = storage;
        this.items = items;
        
        frame = new JFrame("Pay Method-Debit");
        frame.setSize(510,200);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lblConfirm = new JLabel("Please Confirm the purchase?");
        lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
        lblConfirm.setFont(new Font("Constantia",Font.BOLD,20));
        lblConfirm.setBounds(100,20,300,50);
        frame.add(lblConfirm);
        
        txtInput = new JTextField();
        txtInput.addKeyListener(this);
        txtInput.setBounds(100, 20, 300, 50);
        txtInput.setVisible(false);
        frame.add(txtInput);
        
        btnYes = new JButton("Yes");
        btnYes.setBounds(150, 80, 75, 40);
        btnYes.setFont(new Font("Constantia",Font.BOLD,22));
        btnYes.addActionListener(this);
        frame.add(btnYes);
        
        btnNo = new JButton("No");
        btnNo.setBounds(300,80,75,40);
        btnNo.setFont(new Font("Constantia",Font.BOLD,22));
        btnNo.addActionListener(this);
        frame.add(btnNo);
        
        txtCashBack = new JTextField("0");
        txtCashBack.setEnabled(false);
        txtCashBack.setBounds(100, 20, 200, 50);
        txtCashBack.setVisible(false);
        frame.add(txtCashBack);
        
        btnInc = new JButton("+");
        btnInc.setBounds(360, 25, 40, 40);
        btnInc.setMargin(new Insets(0,0,0,0));
        btnInc.setFont(new Font("Constantia",Font.BOLD,15));
        btnInc.addActionListener(this);
        btnInc.setVisible(false);
        frame.add(btnInc);
        
        btnDec = new JButton("-");
        btnDec.setBounds(310,25,40,40);
        btnDec.setMargin(new Insets(0,0,0,0));
        btnDec.setFont(new Font("Constantia",Font.BOLD,15));
        btnDec.addActionListener(this);
        btnDec.setEnabled(false);
        btnDec.setVisible(false);
        frame.add(btnDec);
        
        frame.setVisible(true);
        
        
    }
    public void scene2(){
        lblConfirm.setVisible(false);
        txtCashBack.setVisible(true);
        btnInc.setVisible(true);
        btnDec.setVisible(true);
    }
    public void scene3(){
        txtInput.setVisible(true);
        txtCashBack.setVisible(false);
        btnInc.setVisible(false);
        btnDec.setVisible(false);
    }
//    public static void main(String[] args) {
//        PayDebit pd = new PayDebit();
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        
        if(ac.equals("Yes")){
           switch(step){
               case 1:{
                   scene2();
                   step++;
                   break;
               }
               case 2:{
                   step++;
                   scene3();
                   break;
               }
               case 3:{
                   if(txtInput.getText().length() == 9){
                       if(cashback){
                           CashDrawer cd = new CashDrawer(Double.parseDouble(txtCashBack.getText()),storage,items);
                       }else{
                           CashRegister cr = new CashRegister("Successful",storage, items);
                       }
                       frame.dispose();
                   }else{
                       CashRegister cr = new CashRegister("Unsuccessful",storage, items);
                       frame.dispose();
                   }
                   break;
               }
           }
        }else if(ac.equals("No")){
            
        }else if(ac.equals("+") && step == 2){
            cashback = true;
            btnDec.setEnabled(true);
            int value = Integer.parseInt(txtCashBack.getText());
            //NumberFormat nf = NumberFormat.getCurrencyInstance();
            value += 20;
            txtCashBack.setText(String.valueOf(value));
            
        }else if(ac.equals("-") && step == 2){
           int value = Integer.parseInt(txtCashBack.getText());
           value -= 20;
           txtCashBack.setText(String.valueOf(value));
           if(value == 0){
               btnDec.setEnabled(false);
               cashback = false;
           }
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
       char key = e.getKeyChar();
       if(txtInput.getText().length()==9){
           e.consume();
       }
       else if(!Character.isDigit(key)){
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
