/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashregister;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author kamal
 */
public class CashRegister implements ActionListener {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private JButton[][] btns;
    private JButton btnPay, btnEnter, btnClear;
    private JTextArea txtInput;
    private ArrayList<Item> items;
    private ArrayList<BackRoom> storage;
    private int index;
    /**
     * @param args the command line arguments
     */
    public CashRegister(){
        frame = new JFrame("Cash_Register_v1.0");
        frame.setSize(550,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        
        items = new ArrayList<Item>();
        index = 0;
        initiateStorage();
        
        btnClear = new JButton("CE");
        btnClear.setBounds(470,45,50,50);
        btnClear.setActionCommand("Clear");
        btnClear.addActionListener(this);
        frame.add(btnClear);
        
        btnEnter = new JButton("^");
        btnEnter.setBounds(470,100,50,100);
        btnEnter.setActionCommand("Enter");
        btnEnter.addActionListener(this);
        frame.add(btnEnter);
        
        btnPay = new JButton("Pay");
        btnPay.setFont(new Font("Constantia", Font.BOLD,30));
        btnPay.setBounds(0, 405, 295, 50);
        btnPay.addActionListener(this);
        frame.add(btnPay);
        
        txtInput = new JTextArea();
        txtInput.setBounds(305,0,215,40);
        txtInput.setBackground(Color.LIGHT_GRAY);
        txtInput.setForeground(Color.BLACK);
        txtInput.setEditable(false);
        txtInput.setFont(new Font("Constantia",Font.PLAIN,15));
        frame.add(txtInput);
        
        btns = new JButton[4][3];
        int number = 0;
        int x = 305, y = 210;
        for(int r = 0; r < btns.length; r++){
            for (int c = 0; c < btns[r].length; c++) {
                if(c < 2 && r == 0){
                   btns[r][c] = new JButton("");
                   btns[r][c].setActionCommand("null");
                   btns[r][c].setBounds(x, y, 50, 50);
                   frame.add(btns[r][c]);
                }else{
                   btns[r][c] = new JButton(String.valueOf(number));
                   btns[r][c].setName("btn"+number);
                   btns[r][c].setActionCommand(String.valueOf(number));
                   btns[r][c].setBounds(x, y, 50, 50);
                   btns[r][c].addActionListener(this);
                   frame.add(btns[r][c]);
                   number++;
                }
                x += (50+ 5);
                
            }
            y-= (50+5);
            x = 305;
        }
        
        
        Object [] columns = {"Qty","Name","Price"};
	model = new DefaultTableModel();
		
	table = new JTable();
        model.setColumnIdentifiers(columns);    
	table.setModel(model);
//        table.setColumnSelectionAllowed(false);
//        table.setCellSelectionEnabled(false);
        table.setEnabled(false);
        table.setFont(new Font("Constantia",Font.BOLD,20));
	table.setRowHeight(32);
	table.enable(false);
	table.getColumnModel().getColumn(0).setPreferredWidth(20);
	table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(75);
	JScrollPane scroll = new JScrollPane();
	scroll.setBounds(0, 0, 295, 400);
	scroll.setViewportView(table);
        frame.add(scroll);
        
        frame.setVisible(true);
        
    }
    public CashRegister(String output, ArrayList<BackRoom> strg, ArrayList<Item> itms){
        if(!(output.equals("Unsuccessful"))){
            PrintReciept pr = new PrintReciept(strg, itms);
        }  

    }
    public void initiateStorage(){
       try{
        storage = new ArrayList<BackRoom>();
        Scanner s = new Scanner(new File("src/cashregister/items.txt"));
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CANADA);
        int number = 2000;
        while(s.hasNext()){
            double price = (Math.random() * 10)+1;
            String fprice = nf.format(price);
            fprice = fprice.replace("$", "");
            fprice = fprice.replaceAll(",", "");
            storage.add(new BackRoom(s.nextLine(),String.valueOf(number),Double.parseDouble(fprice)));
            number++;
        }
       }catch(FileNotFoundException ex){
           System.out.println("ERROR: File Not Found !");
       }
       
    }
    public boolean isAdded(String word){
        for (int i = 0; i < items.size(); i++) {
           if(items.get(i).getName().equals(word)){
            return true;   
           }
        }
        
        return false;
    }
    public void checkAdded(String word){
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getName().equals(word)){
                items.get(i).updateQty();
            }
        }
    }
    public void clearRows(){
        //table rows works as arraylist indexes
        //shifting left if one index is removed
        while(table.getRowCount() > 0){
            model.removeRow(0);
        }
    }
    public void updateTable(){
        clearRows();

        for (int i = 0; i < items.size(); i++) {
            int qty = items.get(i).getQty();
            String name = items.get(i).getName();
            double price = items.get(i).getPrice();
            NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CANADA);
            String fprice = nf.format(price);
            model.addRow(new Object[]{qty,name,fprice});
        }
    }
    
    public boolean isIdValid(int in){
        if(in >= storage.size() || in < 0){
            return false;
        }
        return true;
    }
    
    
    public void clearTransaction(){
        clearRows();
    }
    public static void main(String[] args){
        // TODO code application logic here
       CashRegister cr = new CashRegister();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        if(ac.equals("Enter")){
         String id = txtInput.getText();
         if(!id.equals("")){   
                int index = Integer.valueOf(id)-2000;
            if(isIdValid(index)){
            
                String name = storage.get(index).getName();
                double price = storage.get(index).getPrice();
                txtInput.setText("");

                   if(!isAdded(name)){
                      items.add(new Item(name,price));
                   }else{
                       checkAdded(name);
                   }


                updateTable();
            }else{
               txtInput.setText("Cannot Find The Item <Clear>");
            }
         }else{
             txtInput.setText("Cannot Find The Item <Clear>");
         }
         
        }else if(ac.equals("Clear")){
         txtInput.setText("");
        }else if(ac.equals("Pay")){
            double sum = 0;
            for (int i = 0; i < items.size(); i++) {
                sum += items.get(i).getPrice();
            }
            NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CANADA);
            String total = nf.format(sum);
            int option = JOptionPane.showConfirmDialog(null, "You total order is " + total + ". Would you like to purchase?", "Confirm Purchase", JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.YES_OPTION){
                total = total.replace("$", "");
                total = total.replaceAll(",","");
                
                PayMethod pm = new PayMethod(Double.parseDouble(total),storage, items);
                
            }
        }else{
          if(!txtInput.getText().equals("Cannot Find The Item <Clear>")){
              txtInput.append(ac);
          }
        }
        
    }
    
}
