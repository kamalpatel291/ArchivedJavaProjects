/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashregister;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author kamal
 */
public class PrintReciept implements ActionListener, WindowListener{
    private JFrame frame;
    private JScrollPane scrollbar;
    private JTextArea txtReciept;
    private ArrayList<BackRoom> storage;
    private ArrayList<Item> items;
    private JButton btnClose, btnSave, btnEmail;
    public PrintReciept(ArrayList<BackRoom> storage, ArrayList<Item> items){
        this.storage = storage;
        this.items = items;
        
        JFrame frame = new JFrame("Reciept");
        frame.setSize(390, 705);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.addWindowListener(this);

        txtReciept = new JTextArea();
        txtReciept.setLineWrap(true);
        txtReciept.setWrapStyleWord(true);
        txtReciept.setEditable(false);
        txtReciept.setFont(new Font("Consolas",Font.BOLD,15));
        
        scrollbar = new JScrollPane(txtReciept);
        scrollbar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollbar.setBounds(0, 0, frame.getWidth(),600);
        frame.add(scrollbar);
        
        btnClose = new JButton("Close");
        btnClose.setBounds(10,605,180,55);
        btnClose.addActionListener(this);
        frame.add(btnClose);
        
        btnSave = new JButton("Save");
        btnSave.setBounds(210,605,155,25);
        btnSave.addActionListener(this);
        frame.add(btnSave);
        
        btnEmail = new JButton("Email");
        btnEmail.setBounds(210,635,155,25);
        frame.add(btnEmail);
        
        frame.setVisible(true);
        txtReciept.setText(writeReciept());
       // toString();
    }
    public String findSum(){
        double sum = 0;
        for (int i = 0; i < items.size(); i++) {
            sum+= items.get(i).getPrice();
        }
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CANADA);
        String fsum = nf.format(sum);
        return fsum;  
    }
    public String writeReciept(){
        // for mart centre, 17 char left and 18 char right (including spaces)
        // for reciept, 19 char left and 20 char right (including spaces)
        // length = 46 chars
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("E yyyy-MM-dd  HH:mm:ss");
        String str = "==============================================";
        str+="\n================ Mart Centre =================";
        str+="\n==============================================";
        str+="\n-----------------= Reciept =------------------";
        str+="\n          ==========================          ";
        str+="\n---------| "+ sdf.format(date) + " |---------";
        str+="\n          ==========================          ";
        str+="\n";
        for (int i = 0; i < items.size(); i++) {
            str += String.format("=       %-20s%-10s       =", items.get(i).getName(),"$" +items.get(i).getPrice());
            str +="\n";
        }
        str += "=                                            =";
        str += "\n";
        str += String.format("=       %20s%10s       =","Total",findSum());
        return str;
    }
    public String toString(){
        System.out.println(storage.size());
        System.out.println(items.size());
        System.out.println("Storage: ");
        for(BackRoom sto:storage){
         System.out.println("Name: "+ sto.getName() + "Price: " + sto.getPrice());
        }
        System.out.println("Items: ");
        for(Item itm:items){
         System.out.println("Name: " + itm.getName() + "Price: " + itm.getPrice());
        }
         return "";    
    }
    public static void main(String[] args) {
        ArrayList<BackRoom> storage = new ArrayList<BackRoom>();
        ArrayList<Item> items = new ArrayList<Item>();
        new PrintReciept(storage,items);
    }
    public void reset(){
        Window[] windows = Window.getWindows();
            for (Window win : windows) {
                if(win instanceof JFrame){
                    win.dispose();
                }
            }
             new CashRegister(); 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        
        if(ac.equals("Close")){
          reset();  
        }else if(ac.equals("Save")){
            SaveEReciept ser = new SaveEReciept(writeReciept());
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        reset();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

   

}
