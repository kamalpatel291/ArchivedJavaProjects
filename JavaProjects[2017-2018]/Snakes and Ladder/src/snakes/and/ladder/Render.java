/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes.and.ladder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author kamal
 */
public class Render extends JPanel{
    private int x,y;
    public void setXPos(int x){
       this.x = x;
    }
    public int getXPos(){
        return x;
    }
    public void setYPos(int y){
       this.y = y;
    }
    public int getYPos(){
        return y;
    }
    @Override
    public void paintComponent(Graphics g2){
        //g.setColor(Color.red);
        //g.fillRect(0,0,500,500);
        Graphics2D g = (Graphics2D)g2;
        Image img = new ImageIcon(this.getClass().getResource("/resources/board.png")).getImage();
        g.drawImage(img, 0, 0,600,600,null);
        Image imgp = new ImageIcon("C:/Users/kamal/Documents/NetBeansProjects/Snakes and Ladder/src/resources/Piece_2.png").getImage();
        g.drawImage(imgp, getXPos(),getYPos(), null);
       
    }
}
