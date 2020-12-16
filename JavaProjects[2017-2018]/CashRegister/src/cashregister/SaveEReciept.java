/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashregister;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author kamal
 */
public class SaveEReciept implements ActionListener {
    private String reciept;
    private Scanner scan;
    private JFrame frame;
    private JButton btnBrowse, btnSave;
    private JLabel lblBrowse, lblName;
    private JTextField txtBrowse, txtName;
    public SaveEReciept(String reciept){
        this.reciept = reciept;
        
       frame = new JFrame("Save E-Reciept");
       frame.setSize(500,330);
       frame.setLocationRelativeTo(null);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.getContentPane().setLayout(null);
       
       lblBrowse = new JLabel();
       lblBrowse.setFont(new Font("Consolas", Font.BOLD, 15));
       lblBrowse.setText("Please Select the Directory: ");
       lblBrowse.setBounds(10, 5, 340, 50);
       frame.add(lblBrowse);
       
       txtBrowse = new JTextField();
       txtBrowse.setFont(new Font("Constantia", Font.PLAIN, 15));
       txtBrowse.setBounds(10, 55, 340, 50);
       txtBrowse.setEditable(false);
       txtBrowse.setBackground(Color.LIGHT_GRAY);
       txtBrowse.setForeground(Color.BLACK.darker());
       frame.add(txtBrowse);
       
       btnBrowse = new JButton("Browse");
       btnBrowse.setFont(new Font("Constantia", Font.BOLD, 15));
       btnBrowse.setBounds(370, 55, 100, 50);
       btnBrowse.addActionListener(this);
       frame.add(btnBrowse);
       
       lblName = new JLabel();
       lblName.setText("Please Enter a Name for the Reciept: ");
       lblName.setFont(new Font("Consolas", Font.BOLD, 15));
       lblName.setBounds(10, 110, 340, 50);
       frame.add(lblName);
       
       txtName = new JTextField();
       txtName.setFont(new Font("Constantia", Font.PLAIN, 15));
       txtName.setBounds(10, 160, 340, 50);
       frame.add(txtName);
       
       btnSave = new JButton("Save");
       btnSave.setFont(new Font("Constantia", Font.BOLD, 20));
       btnSave.setBounds(190,230,100,50);
       btnSave.addActionListener(this);
       frame.add(btnSave);
       
       frame.setVisible(true);
       
    }
    
    public static void main(String[] args) {
        new SaveEReciept("Hello");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        
        if(ac.equals("Browse")){
            JFileChooser jfc = new JFileChooser();
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int outputOpt= jfc.showDialog(null, "Okay");
            
            if(outputOpt == JFileChooser.APPROVE_OPTION){
                txtBrowse.setText(jfc.getSelectedFile().getAbsolutePath());
            }
            
        }else if(ac.equals("Save")){
            String dir = txtBrowse.getText();
            String name = txtName.getText();
            
            try {
               if(!dir.equals("") && !name.equals("")){
                   int counter = 0;

                   char[] letters = new char[(reciept.length())+(reciept.length()/46)];

                   for (int i = 0; i < reciept.length(); i++) {
                       letters[i] = reciept.charAt(i);
                       counter++;
                       if(counter == 46){
                           i++;
                           letters[i] = ','; 
                           counter = 0;
                       }
                   }
                   
                PrintWriter pw = new PrintWriter(new File(dir+"\\"+name+".txt"));
                   for (int i = 0; i < letters.length; i++) {
                      if(letters[i] != ','){
                          pw.print(letters[i]);
                      }else{
                          pw.println();
                      }                      
                   }
                pw.close();
                  JOptionPane.showMessageDialog(null, "E-Reciept Saved Successfuly", "Save Successful", JOptionPane.PLAIN_MESSAGE);
                  frame.dispose();
               }else{
                   JOptionPane.showMessageDialog(null, "Please Fill the Blanks !!", "Error:Fill the Blanks", JOptionPane.WARNING_MESSAGE);
               }    
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SaveEReciept.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
