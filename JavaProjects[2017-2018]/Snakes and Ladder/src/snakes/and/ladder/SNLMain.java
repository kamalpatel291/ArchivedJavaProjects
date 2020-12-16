/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes.and.ladder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author kamal
 */
public class SNLMain implements ActionListener{
    private JFrame frame;
    private JButton btnSend;
    private JTextArea txtWindow;
    private JTextField txtUserInput;
    
    //server stuff ---MAIN SERVER CLASS
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket server;
    private Socket connection;
    
    private List<SNLServerClient> clients;

        
    public SNLMain(){
        
        frame = new JFrame("Server");
        frame.setSize(520,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        
        txtWindow = new JTextArea();
        //using it in scroll pane
       // txtWindow.setBounds(0, 0, 500, 300);
        txtWindow.setFont(new Font("Times New Roman", Font.BOLD, 12));
        txtWindow.setEditable(false);
        
        JScrollPane jspWindow = new JScrollPane(txtWindow);
        jspWindow.setBounds(0, 0, 500, 400);
        frame.add(jspWindow);
        
        txtUserInput = new JTextField();
        //using it in scroll pane
        //txtUserInput.setBounds(0,320,500,100);
        txtUserInput.setFont(new Font("Times New Roman", Font.BOLD, 12));
        txtUserInput.addActionListener(this);
        txtUserInput.setEditable(false);
      
        
        JScrollPane jspInput = new JScrollPane(txtUserInput);
        jspInput.setBounds(0, 410, 390, 50);
        frame.add(jspInput);
        
        btnSend = new JButton("Send");
        btnSend.setBounds(400,410,100,50);
        btnSend.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnSend.setEnabled(false);
        btnSend.addActionListener(this);
        frame.add(btnSend);
        
        frame.setVisible(true);
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String ac = e.getActionCommand();
     
    }
    
    
    //--------------------------------------------------------------------------
    //                      Server Method starts here
    //--------------------------------------------------------------------------
    
    
    public void startServer(){
        try{
           server = new ServerSocket(5000,5);
           //showMessage("\nCONSOLE - Waiting for Connection...");
           Thread thr = new Thread(new Runnable(){
               @Override
               public void run(){
                   while(true){
                       checkThread();
                       try {
                           Thread.sleep(1000);
                       } catch (InterruptedException ex) {
                           Logger.getLogger(SNLServer.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   }
               }
           });
           thr.start();
           while(true){
               waitForConnection();
           }
        }catch (IOException ex) {
            closeServer();
        }
            
    }
    
    public void waitForConnection(){
        try {
            connection = server.accept();
           // showMessage("\nCONSOLE - Now Connected to "+connection.getInetAddress().getHostName());
            SNLServerClient sc = new SNLServerClient(clients,connection);
            sc.running = true;
            sc.start();
            clients.add(sc);
            
        } catch (IOException ex) {
            Logger.getLogger(SNLServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void checkThread(){
        for (int i = 0; i < clients.size(); i++) {
            if(!clients.get(i).running){
                clients.remove(i);
                System.out.println("Removed a Client...");
            }
        }
    }
    
    public void closeServer(){
       // showMessage("\nCONSOLE - Closing the connection...");
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).closeServer();
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SNLMain snl = new SNLMain();
    }
    
}
