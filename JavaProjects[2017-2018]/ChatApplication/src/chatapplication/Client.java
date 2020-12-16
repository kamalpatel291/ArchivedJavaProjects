/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapplication;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author kamal
 */
public class Client implements ActionListener{
    private JFrame frame;
    private JTextField txtUserInput;
    private JTextArea txtWindow;
    private JButton btnSend;
    
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket server;
    private Socket connection;
    
    private String ip;
    private final int MAX_TRIES = 10;
    private int tries = 0;
    public Client(String host){
        ip = host;
        
        frame = new JFrame("Client");
        frame.setSize(520,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.addWindowListener(new WindowListener(){
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                closeClient();
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
            
        });
        
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
        btnSend.addActionListener(this);
        btnSend.setEnabled(false);
        frame.add(btnSend);
        
        frame.setVisible(true);
        
    }
    public void startClient(){
        try{   
            connectToServer();
            setUpStreams();
            clearChatArea();
            haveConversation();
        }catch(Exception ex){
            closeClient();
        }
        //after clients disconnect or want to disconnect
        //works if server is disconnected
        closeClient();
    }
    public void reconnect(){
        if(tries < MAX_TRIES){
            tries++;
            try {
                showMessage("\nCONSOLE - Connection failed...Trying Again...");
                Thread.sleep(1000);
                connection = new Socket(InetAddress.getByName(ip),5000);
                showMessage("\nCONSOLE - Now Connected to "+ connection.getInetAddress().getHostName());
                
            } catch (IOException ex) {
                reconnect();
            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            showMessage("\nCONSOLE - Could not connect to "+ ip);
            showMessage("\nCONSOLE - Max Tries Limit Exceeded....");
        }
    }
    public void clearChatArea(){
        txtWindow.setText("");
    }
    public void connectToServer(){
        try {
            showMessage("\nCONSOLE - Attempting to connect...");
            connection = new Socket(InetAddress.getByName(ip),5000);
            showMessage("\nCONSOLE - Now Connected to "+ connection.getInetAddress().getHostName());
        } catch (IOException ex) {
            reconnect();
        }
    }
    public void setUpStreams(){
        try {
            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input = new ObjectInputStream(connection.getInputStream());
            showMessage("\nCONSOLE - Streams setup succefull");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void haveConversation(){
        String message = "";
        ableToType(true);
        do{
            try{
                message = (String)input.readObject();
                showMessage("\n"+message);
                
            }catch(ClassNotFoundException cnfexception){
                showMessage("\nCONSOLE - Cannot Interpret User Info!");
            }catch (IOException ex) {
                showMessage("\nCONSOLE - Server Disconnected !");
                ableToType(false);
                return;
            }
        }while(!message.equals("SERVER - END"));
    }
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
    
    public void sendMessage(String msg){
        try {
            output.writeObject("CLIENT - "+msg);
            output.flush();
            showMessage("\nCLIENT - " + msg);
        } catch (IOException ex) {
            showMessage("\nCONSOLE - Unable to send message....Try Again!");
        }
    }
    public void showMessage(String msg){
        SwingUtilities.invokeLater(
                new Runnable(){
                    public void run(){
                        txtWindow.append(msg);
                    }
                }
        );
    }
    public void closeClient(){
        showMessage("\nCONSOLE - Closing the connection...");
        ableToType(false);
        try{
            output.close();
            input.close();
            connection.close();
        }catch(IOException ioexception){
            ioexception.printStackTrace();
        }
        showMessage("Done!");
    }

  
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Send")){
            if(!txtUserInput.getText().equals("")){
               sendMessage(txtUserInput.getText()); 
               txtUserInput.setText("");
            }
        }else{
            if(!txtUserInput.getText().equals("")){
               sendMessage(e.getActionCommand());
               txtUserInput.setText("");
            }
        }
    }
    
    public static void main(String[] args) {
        Client c = new Client("localhost");
        c.startClient();
    }
}
