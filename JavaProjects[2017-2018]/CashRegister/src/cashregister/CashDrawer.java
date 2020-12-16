/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashregister;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author kamal
 */
public class CashDrawer implements ActionListener{
    private double owedPrice;
    private JFrame frame;
    private JButton[][] btnDollars;
    private JLabel lblChange,lblAmtSelected;
    private JButton btnDec,btnClose;
    private JTextField txtAmt;
    private ArrayList<Double> prevVal;
    private double amtSel;
    private ArrayList<BackRoom> storage;
    private ArrayList<Item> items;
    public CashDrawer(double price,ArrayList<BackRoom> storage, ArrayList<Item> items){
        owedPrice = price;
        prevVal = new ArrayList<Double>();
        amtSel = 0;
        this.storage = storage;
        this.items = items;
        initializeGraphics();
    }
    public void initializeGraphics(){
        frame = new JFrame("Cash Drawer-Open");
        frame.setSize(575,570);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        
        lblChange = new JLabel();
        lblChange.setFont(new Font("Constantia",Font.BOLD,20));
        lblChange.setText("Change: " + owedPrice);
        lblChange.setBounds(50, 0, 200, 40);
        frame.add(lblChange);
        
        lblAmtSelected = new JLabel();
        lblAmtSelected.setFont(new Font("Constantia",Font.BOLD,20));
        lblAmtSelected.setText("Amount Selected: ");
        lblAmtSelected.setBounds(230, 0, 175, 40);
        frame.add(lblAmtSelected);
        
        txtAmt = new JTextField("0");
        txtAmt.setEnabled(false);
        txtAmt.setHorizontalAlignment(SwingConstants.CENTER);
        txtAmt.setFont(new Font("Consolas",Font.PLAIN,15));
        txtAmt.setBounds(410,0,50,40);
        frame.add(txtAmt);
        
        btnDec = new JButton();
        btnDec.setFont(new Font("Consolas",Font.PLAIN,40));
        btnDec.setMargin(new Insets(0,0,0,0));
        btnDec.setText("-");
        btnDec.setEnabled(false);
        btnDec.setBounds(465, 0, 50, 40);
        btnDec.addActionListener(this);
        frame.add(btnDec);
        
        btnDollars = new JButton[2][5];
        int x = 10, y = 50;
        int counter = 0;
        double[] names = {5,10,20,50,100,0.05,0.10,0.25,1,2};
        for (int i = 0; i < btnDollars.length; i++) {
            
            for (int j = 0; j < btnDollars[i].length; j++) {
                btnDollars[i][j] = new JButton("$"+names[counter]);
                btnDollars[i][j].setBounds(x,y,100,200);
                btnDollars[i][j].addActionListener(this);
                frame.add(btnDollars[i][j]);
                
                counter++;
                x+= 100 + 10;
            }
            y+= 200 + 10;
            x = 10;
        }
        
        btnClose = new JButton("Close Drawer");
        btnClose.setFont(new Font("Constantia",Font.PLAIN,20));
        btnClose.setBounds(185,btnDollars[1][4].getY()+210,205,50);
        btnClose.addActionListener(this);
        frame.add(btnClose);
        
        
        frame.setVisible(true);
        
    }
    
    public void updateAmtTextBox(){
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CANADA);
        String str = nf.format(amtSel);
        txtAmt.setText(str);
    }
//    public static void main(String[] args) {
//        CashDrawer cd = new CashDrawer(12.50);
//    }
    @Override
    public void actionPerformed(ActionEvent e) {
       String ac = e.getActionCommand();
       NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CANADA);
       
        if(ac.equals("-")){
           if(amtSel != 0){
               String tot = nf.format(amtSel - prevVal.remove(prevVal.size()-1));
               tot = tot.replace("$", "");
               tot = tot.replaceAll(",", "");
               amtSel = Double.parseDouble(tot);
                if(amtSel == 0.0){
                    btnDec.setEnabled(false);
                }
             updateAmtTextBox();
           }
        }else if(ac.equalsIgnoreCase("close drawer")){
           if(amtSel == owedPrice){
               frame.dispose();
             
             CashRegister cr = new CashRegister("CashDrawer-Closed",storage, items);
               
             
           }else{
              JOptionPane.showMessageDialog(null, "Please Select Right Change to Owe !!!","Warning: Amount Error",JOptionPane.WARNING_MESSAGE);
           }
        }else{
            ac = ac.replace("$", "");
            double amt = Double.parseDouble(ac);
            prevVal.add(amt);
            
            String tot = nf.format(amtSel + amt);
            tot = tot.replace("$","");
            tot = tot.replaceAll(",","");
            
            amtSel = Double.parseDouble(tot);
                if(amtSel > 0){
                  btnDec.setEnabled(true);
                }
            updateAmtTextBox();
       }
       
    }
    
    
}
