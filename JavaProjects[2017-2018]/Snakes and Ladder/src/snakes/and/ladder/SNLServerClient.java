/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes.and.ladder;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author kamal
 */
public class SNLServerClient extends Thread{
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Socket connection;
    private List<SNLServerClient> clients;
    
    private String id;
    public boolean running;
    
    public SNLServerClient(List<SNLServerClient> clients,Socket clientS){
        connection = clientS;
        this.clients = clients;
        running = false;
        generateID();
    }
    
    @Override
    public void run(){
        setUpStreams(); 
        while(running){
            haveConversation();
        }
    }
    public void setUpStreams(){
        try {
            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input = new ObjectInputStream(connection.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(SNLServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    public void haveConversation(){
        String message = "Connection Succefull";
        int[] playerInfo;
        showMessage("\nCONSOLE - "+message);
        sendMessage(message);
        
   //     ableToType(true);
        do{
                try{
                    //[0] = x, [1] = y, [2] = players turn, [3] = winflag
                    //[2]--> 0-disable 1-enable      [3]---> 1-win
                    playerInfo = (int[])input.readObject();
                    
                    
                    for (int i = 0; i < clients.size(); i++) {
                        if(!clients.get(i).getID().equals(id)){
                            clients.get(i).sendMessageToClient(playerInfo);
                        }else{
                            playerInfo[2] = 0;
                            clients.get(i).sendMessageToClient(playerInfo);
                        }
                    }
                  //  showMessage("\n"+message);
                }catch(ClassNotFoundException cnfexception){
                    showMessage("\nCONSOLE - Cannot Interpret User Info!");
                }catch (IOException ex) {
                    try {
                        showMessage("\nCONSOLE - User_"+ getID() + " disconnected !");
                        //ableToType(false);
                        running = false;
                        this.join();
                    } catch (InterruptedException ex1) {
                        Logger.getLogger(SNLServerClient.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    
                }
            
        }while(!message.equals("END"));
    }
    private void generateID(){
        //5 letter id
        String id = "";
        for (int i = 0; i < 5; i++) {
            //creating random letter id from ascii values 65-122 inclusive
            char lett = (char) ((Math.random()*57)+65);
            id += String.valueOf(lett);
        }
        this.id = id;
    }
    public String getID(){
        return id;
    }
    
    public void sendMessageToClient(int[] info){
        try {
            output.writeObject(info);
            output.flush();
        } catch (IOException ex) {
            showMessage("\nCONSOLE - Unable to send message....Try Again!");
        }
    }
    
    public void sendMessage(String info){
        try {
            output.writeObject("SERVER - "+info);
            output.flush();
        } catch (IOException ex) {
            showMessage("\nCONSOLE - Unable to send message....Try Again!");
        }
    }
    public void showMessage(String msg){
        System.out.println(msg);
    }

    public void closeServer(){
        showMessage("\nCONSOLE - Closing the connection...");
        try{
            output.close();
            input.close();
            connection.close();
        }catch(IOException ioexception){
            ioexception.printStackTrace();
        }
        showMessage("Done!");
    }    
}
