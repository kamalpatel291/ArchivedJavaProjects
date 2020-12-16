/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashregister;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author kamal
 */
public class PayMethod implements ActionListener {
    private JFrame frame;
    private JButton btnCash,btnDebit;
    private double cost;
    private ArrayList<BackRoom> storage;
    private ArrayList<Item> items;
    public PayMethod(double cost, ArrayList<BackRoom> storage, ArrayList<Item> items){
        this.cost = cost;
        this.storage = storage;
        this.items = items;
        
        frame = new JFrame("Pay Method");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(270, 110);
        frame.getContentPane().setLayout(null);
        
        btnCash = new JButton("Cash");
        btnCash.setBounds(10,10,110,50);
        btnCash.addActionListener(this);
        frame.add(btnCash);
        
        btnDebit = new JButton("Debit");
        btnDebit.setBounds(130,10,110,50);
        btnDebit.addActionListener(this);
        frame.add(btnDebit);
        
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        ArrayList<BackRoom> storage = new ArrayList<BackRoom>();
        ArrayList<Item> ites = new ArrayList<Item>();
        PayMethod py = new PayMethod(20.05,storage,ites);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String ac = e.getActionCommand();
        
        if(ac.equals("Cash")){
            PayCash pc = new PayCash(cost,storage,items);
            frame.dispose();
        }else if(ac.equals("Debit")){
            PayDebit pd = new PayDebit(storage,items);
            frame.dispose();
        }
        
    }
}
