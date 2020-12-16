/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapplication;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.*;
import java.util.List;

/**
 *
 * @author kamal
 */
public class Server implements ActionListener{
    private JFrame frame;
    private JTextField txtUserInput;
    private JTextArea txtWindow;
    private JButton btnSend;
    
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket server;
    private Socket connection;
    
    private List<ServerClient> clients;
    public Server(){
        clients = new ArrayList<ServerClient>();
        
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
    public void startServer(){
        try{
           server = new ServerSocket(5000,5);
           showMessage("\nCONSOLE - Waiting for Connection...");
           Thread thr = new Thread(new Runnable(){
               @Override
               public void run(){
                   while(true){
                       checkThread();
                       try {
                           Thread.sleep(1000);
                       } catch (InterruptedException ex) {
                           Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
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
            ableToType(true);
            showMessage("\nCONSOLE - Now Connected to "+connection.getInetAddress().getHostName());
            ServerClient sc = new ServerClient(clients,connection,txtUserInput, btnSend, txtWindow);
            sc.running = true;
            sc.start();
            clients.add(sc);
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void checkThread(){
        if(clients.isEmpty()){
            ableToType(false);
        }else{
            ableToType(true);
        }
        for (int i = 0; i < clients.size(); i++) {
            if(!clients.get(i).running){
                clients.remove(i);
                System.out.println("Removed a Client...");
            }
        }
    }
//    public void setUpStreams(){
//        try {
//            output = new ObjectOutputStream(connection.getOutputStream());
//            output.flush();
//            input = new ObjectInputStream(connection.getInputStream());
//            showMessage("\nCONSOLE - Streams setup succefull");
//        } catch (IOException ex) {
//            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    public void haveConversation(){
//        String message = "Connection Succefull";
//        sendMessage(message);
//        ableToType(true);
//        do{
//           for(int x =0; x < clients.size(); x++){
//                try{
//                    message = (String)clients.get(x).getOutputObject().;
//                    showMessage("\n"+message);
//                }catch(ClassNotFoundException cnfexception){
//                    showMessage("\nCONSOLE - Cannot Interpret User Info!");
//                }catch (IOException ex) {
//                    showMessage("\nCONSOLE - Something went wrong !");
//                    ableToType(false);
//                    return;
//                }
//           }
//            
//        }while(!message.equals("END"));
//    }
    public void ableToType(boolean flag){
        SwingUtilities.invokeLater(
                new Runnable(){
                    public void run(){
                        txtUserInput.setEditable(flag);
                        btnSend.setEnabled(flag);
                    }
                }
        );
    }
    
//    public void sendMessage(String msg){
//        try {
//            output.writeObject("SERVER - "+msg);
//            output.flush();
//            showMessage("\nSERVER - " + msg);
//        } catch (IOException ex) {
//            showMessage("\nCONSOLE - Unable to send message....Try Again!");
//        }
//    }
    public void showMessage(String msg){
        SwingUtilities.invokeLater(
                new Runnable(){
                    public void run(){
                        txtWindow.append(msg);
                    }
                }
        );
    }
    public void closeServer(){
        showMessage("\nCONSOLE - Closing the connection...");
        ableToType(false);
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).closeServer();
        }
        
    }

  
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Send")){
            if(!txtUserInput.getText().equals("")){
               showMessage("\nSERVER - " + txtUserInput.getText());
               for(int x = 0; x < clients.size(); x++){
                clients.get(x).sendMessage(txtUserInput.getText()); 
               }
                txtUserInput.setText("");
            }
        }else{
            if(!txtUserInput.getText().equals("")){
               showMessage("\nSERVER - " + txtUserInput.getText());
               for(int x = 0; x < clients.size(); x++){
                clients.get(x).sendMessage(e.getActionCommand()); 
               }
                txtUserInput.setText("");
            }
        }
    }
    
}
