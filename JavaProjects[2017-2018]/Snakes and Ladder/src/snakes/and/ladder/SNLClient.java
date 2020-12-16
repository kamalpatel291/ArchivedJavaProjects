/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes.and.ladder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author kamal
 */
public class SNLClient implements ActionListener{
    
    private final int HEIGHT = 650, WIDTH = 730;
    private JFrame frame;
    private JButton btnRoll;
    private Render render;
    private int playerXPos,playerYPos;
    //flags for advantage places and disadvantage places
    private boolean isAdv = false, isDisadv = false;
    //horizontal bar height(for y)= -  and vertical bar height(for x)  = |
    //this 10 in Ver grid height is (initial board offset + grid height)
    private final int STEP = 54, GRID_HEIGHT = 3, BRD_OFFSET_HEIGHT = 6;
    //                                      this 11 in y is initial board offset
    private int x,y,rollNum;
    //arr for advantage places like ladders
    //numbers in array represent x positions
    private HashMap <Integer,Integer> advPlaces;
    //arr for disadvantage places like snakes
    //numbers in array represent x positions
    private HashMap <Integer, Integer> disadvPlaces;
    
    //server stuff
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket server;
    private Socket connection;
    
    private String ip;
    private final int MAX_TRIES = 10;
    private int tries = 0;
    
        public SNLClient(){
        x = 17+ GRID_HEIGHT + BRD_OFFSET_HEIGHT;
        //6 spaces from x and 8 spaces from y so +2
        y = (585-(17+BRD_OFFSET_HEIGHT + GRID_HEIGHT) + 2);
        

        setPlayerXPos(1);
        setPlayerYPos(0);
        setRollNum(0);
        
        initializeHashMapPlaces();
        
        frame = new JFrame("Painting");
        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        btnRoll = new JButton("Roll");
        btnRoll.setBounds(625,300,100,50);
        btnRoll.addActionListener(this);
        btnRoll.setFont(new Font("Constantia", Font.BOLD, 15));
        frame.add(btnRoll);
        
        render = new Render();
        render.setXPos(x);
        render.setYPos(y);
        
//        JPanel pnlBoard = new JPanel();
//        pnlBoard.setBounds(0,0,600, 650);
//        pnlBoard.add(render);
//        
        frame.add(render);
        
        frame.setVisible(true);
       
    }
    public void initializeHashMapPlaces(){
        advPlaces = new HashMap <Integer, Integer>();
        disadvPlaces = new HashMap <Integer, Integer>();
        advPlaces.put(4, 14);
        advPlaces.put(9, 31);
        advPlaces.put(1, 38);
        advPlaces.put(28, 84);
        advPlaces.put(21, 42);
        advPlaces.put(51, 67);
        advPlaces.put(80, 100);
        advPlaces.put(71, 91);
        
        disadvPlaces.put(17, 7);
        disadvPlaces.put(54, 34);
        disadvPlaces.put(62, 19);
        disadvPlaces.put(64, 60);
        disadvPlaces.put(87, 24);
        disadvPlaces.put(93, 73);
        disadvPlaces.put(95, 75);
        disadvPlaces.put(98, 79);
        
    }
    public void rollDie(){
        Random rand = new Random();
        int num = rand.nextInt(6)+1;
        setRollNum(num);
    }
    public boolean isAdvDisAdvPlace(int pos){
        return (advPlaces.containsKey(pos) || disadvPlaces.containsKey(pos));
    }
    public int checkAdvDisadvPlaces(int pos){
       int newPos = 0;
       if(advPlaces.containsKey(pos)){
           newPos = advPlaces.get(pos);
           System.out.println("New Pos: " + newPos);
           isAdv = true;
           isDisadv = false;
       }else if(disadvPlaces.containsKey(pos)){
           newPos = disadvPlaces.get(pos);
           System.out.println("New Pos: " + newPos);
           isDisadv = true;
           isAdv = true;
       }
       
       
        return newPos;
    }
    public void setRollNum(int num){
        rollNum = num;
    }
    public int getRollNum(){
        return rollNum;
    }
    
    public void setPlayerXPos(int pos){
        playerXPos = pos;
    }
    
    public int getPlayerXPos(){
        return playerXPos;
    }
    public void setPlayerYPos(int pos){
        playerYPos = pos;
    }
    
    public int getPlayerYPos(){
        return playerYPos;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String ac = e.getActionCommand();
        if(ac.equals("Roll")){
            rollDie();
            System.out.print("Rolled: "+ getRollNum());
              //due to uneven squares and uneven piece have to add +2
              if(getPlayerYPos()%2 != 0){
                  x -= (STEP + GRID_HEIGHT + 2)* getRollNum();
              }else{
                  x += (STEP + GRID_HEIGHT + 2)* getRollNum();
              }
                setPlayerXPos(getPlayerXPos()+getRollNum());
            System.out.println(" Pos: " + getPlayerXPos());
            
            if(x > 600){
                setPlayerYPos(getPlayerYPos()+1);
                
                //initial x pos if went from (10 to 11)
                x = 17 + GRID_HEIGHT + BRD_OFFSET_HEIGHT;
                int refXPos = getPlayerXPos()%10;
                
                //if more than initial x pos (10 to 15) then
                //we add initial x pos + rest
                //that means 4 * jump
                x += (STEP + GRID_HEIGHT) * (refXPos - 1);
                //setting x from right to left
                x = ((HEIGHT - 50 - 17) - x);
              
                y -= (STEP + GRID_HEIGHT + 2);
            }else if(x < 0){
                setPlayerYPos(getPlayerYPos()+1);
                
                //initial x pos if went from (10 to 11)
                x = 17 + GRID_HEIGHT + BRD_OFFSET_HEIGHT;
                int refXPos = getPlayerXPos()%10;
                
                //if more than initial x pos (10 to 15) then
                //we add initial x pos + rest
                //that means 4 * jump
                x += (STEP + GRID_HEIGHT) * (refXPos-1);
                
                y-= (STEP + GRID_HEIGHT + 2);
            
            }else if ( y < 0){
                x = 17+ GRID_HEIGHT + BRD_OFFSET_HEIGHT;
                y = (580 - (17 + BRD_OFFSET_HEIGHT + GRID_HEIGHT)+1);
            }
            if(isAdvDisAdvPlace(getPlayerXPos())){
               x = 17 + GRID_HEIGHT + BRD_OFFSET_HEIGHT;
               //-1 because counting itself when counting spaces 
               int newPos = checkAdvDisadvPlaces(getPlayerXPos()) ;
               
               int refXPos = newPos % 10;
               int yPos = newPos/10;
               
               
               if(yPos % 2 == 1){
                 refXPos = 10 - refXPos;
               }else if (yPos %2 == 0){
                 refXPos--;
               }
               x +=(STEP + GRID_HEIGHT) * (refXPos);

               
               
               if(isAdv){
                    y -= (STEP + GRID_HEIGHT + 2) * (yPos-getPlayerYPos());
               }else if(isDisadv){
                    y += (STEP + GRID_HEIGHT + 2) * (yPos-getPlayerYPos());
    
               }
               setPlayerXPos(newPos);
               setPlayerYPos(yPos);
               
               System.out.println("New X: " + x);
                System.out.println("New Y: " + y);

            }
            //uneven squares therefore add +2
            //y = y - (STEP + GRID_HEIGHT + 2) * getPlayerYPos();
            render.setXPos(x);
            render.setYPos(y);
            render.repaint();
        
      
        }
    }
    
    
    //--------------------------------------------------------------------------
    //                              Server Stuff
    //--------------------------------------------------------------------------
    public void startClient(){
        try{   
            connectToServer();
            setUpStreams();
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
                Logger.getLogger(SNLClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            showMessage("\nCONSOLE - Could not connect to "+ ip);
            showMessage("\nCONSOLE - Max Tries Limit Exceeded....");
        }
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
            Logger.getLogger(SNLMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void haveConversation(){
        int[] playerInfo = new int[4];
        
        do{
            try{
                playerInfo = (int[])input.readObject();
                
            }catch(ClassNotFoundException cnfexception){
                showMessage("\nCONSOLE - Cannot Interpret User Info!");
            }catch (IOException ex) {
                showMessage("\nCONSOLE - Server Disconnected !");
                return;
            }
        }while(playerInfo[3] != 1);
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
                        System.out.println(msg);
                    }
                }
        );
    }
    public void closeClient(){
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
