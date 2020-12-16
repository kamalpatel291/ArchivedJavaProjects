/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timecalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author kamal
 */
public class TimeCalculatorGUI implements ActionListener{
    private JFrame frame;
    private JTextField txtAnswer;
    private JComboBox[] selections;
    public TimeCalculatorGUI (){
        frame = new JFrame("Time Calculator");
        frame.setSize(310,210);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
    
        selections = new JComboBox[6];
        int y = 20, x = 90;
        int size = 50;
        for(int i = 0; i < 6; i++){
            String choices = "";
          switch(i){
              case 0: choices = "1 2 3 4 5 6 7 8 9 10 11 12";
              size = 50;
              break;
              case 1: choices = "0 5 10 15 20 25 30 35 40 45 50 55";
              size = 50;
              break;
              case 2: choices = "Choose AM PM";
              size = 70;
              break;
              case 3: choices = "1 2 3 4 5 6 7 8 9 10 11 12";
              size = 50;
              break;
              case 4: choices = "0 5 10 15 20 25 30 35 40 45 50 55";
              size = 50;
              break;
              case 5: choices = "Choose AM PM";
              size = 70;
              break;
          }
        selections[i] = new JComboBox(choices.split(" "));
        selections[i].setActionCommand("selection"+i);
        selections[i].setSelectedItem(0);
        selections[i].addActionListener(this);
        selections[i].setBounds(x, y, size, 30);
        frame.add(selections[i]);
            if(i == 2 ){
                y+= 30 + 20;
                x = 90;
            }else if(i == 1 || i == 4){
                x+= size + 5;
            }else{
                x+= size + 5;
            }
        }
        
        JLabel lblTimeOne = new JLabel();
        lblTimeOne.setBounds(20, 20, 70, 30);
        lblTimeOne.setText("Time 1: ");
        frame.add(lblTimeOne);
        
        JLabel lblTimeTwo = new JLabel();
        lblTimeTwo.setBounds(20,70,70,30);
        lblTimeTwo.setText("Time 2: ");
        frame.add(lblTimeTwo);
        
        txtAnswer = new JTextField();
        txtAnswer.setEditable(false);
        txtAnswer.setBounds(130, 120, 140, 30);
        frame.add(txtAnswer);
        
        JButton btnCalc = new JButton();
        btnCalc.setBounds(20, 120, 100, 30);
        btnCalc.setText("Calculate");
        btnCalc.setActionCommand("calc");
        btnCalc.addActionListener(this);
        frame.add(btnCalc);
        
        frame.setVisible(true);
    
    }
    public static void main(String[] args) {
        TimeCalculatorGUI tcg = new TimeCalculatorGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        if(ac.equals("calc")){
                int time1Hour = Integer.parseInt((String)selections[0].getSelectedItem());
                int time1Min = Integer.parseInt((String)selections[1].getSelectedItem());
                int time2Hour = Integer.parseInt((String)selections[3].getSelectedItem());
                int time2Min = Integer.parseInt((String)selections[4].getSelectedItem());
                String choose = (String)selections[2].getSelectedItem();
                String choose2 = (String)selections[5].getSelectedItem();
            if(choose.equals("Choose") && choose2.equals("Choose")){
                TimeCalculator tc = new TimeCalculator(time1Hour,time1Min,time2Hour,time2Min);
                int minutes = tc.calculateMinutesDifference();
                int hour = minutes / 60;
                int min = minutes % 60;
                txtAnswer.setText(hour + " hour(s) " + min + " minute(s)" );
            }else{
                 TimeCalculator tc = new TimeCalculator(time1Hour,time1Min,time2Hour,time2Min,choose,choose2);
                int minutes = tc.calculateMinutesDifference();
                int hour = minutes / 60;
                int min = minutes % 60;
                txtAnswer.setText(hour + " hour(s) " + min + " minute(s)" );
            }
            
        }
    }
}
