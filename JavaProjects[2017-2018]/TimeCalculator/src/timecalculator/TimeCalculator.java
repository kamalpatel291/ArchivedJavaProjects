/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timecalculator;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author kamal
 */
public class TimeCalculator {
    private int startH, startM, endH,endM;
    private int diffMin;
    private String hourStart,hourEnd;
    public TimeCalculator(int startHour,int startMin, int endHour, int endMin){
        setStartH(startHour);
        setStartM(startMin);
        setEndH(endHour);
        setEndM(endMin);
        setHourStart("");
        setHourEnd("");
        diffMin = 0;
    }
    
    public TimeCalculator(int startHour,int startMin, int endHour, int endMin, String hourStart, String hourEnd){
        setStartH(startHour);
        setStartM(startMin);
        setEndH(endHour);
        setEndM(endMin);
        setHourStart(hourStart);
        setHourEnd(hourEnd);
        diffMin = 0;
    }
    
    public int calculateMinutesDifference(){
        int sMin = 0, eMin = 0;
        if((getHourStart().equals("") && getHourEnd().equals("")) || (getHourStart().equalsIgnoreCase(getHourEnd()))){
            sMin = (getStartH() * 60) + getStartM();
            eMin = (getEndH() * 60) + getEndM();
            diffMin = eMin-sMin;
        }else{
            sMin = (getStartH() * 60) + getStartM();
            eMin = (getEndH() * 60) + getEndM();
            diffMin = (12 * 60) - (sMin - eMin);
        }
        return diffMin;
    }
    
    public String toString(){
        return diffMin/60 + "::" + diffMin%60;
    }
    
    public static void main(String[] args) {
        TimeCalculator t = new TimeCalculator(8,30,7,15,"AM","PM");
        t.calculateMinutesDifference();
        System.out.println(t);
    }
    /**
     * @return the startH
     */
    public int getStartH() {
        return startH;
    }

    /**
     * @param startH the startH to set
     */
    public void setStartH(int startH) {
        this.startH = startH;
    }

    /**
     * @return the startM
     */
    public int getStartM() {
        return startM;
    }

    /**
     * @param startM the startM to set
     */
    public void setStartM(int startM) {
        this.startM = startM;
    }

    /**
     * @return the endH
     */
    public int getEndH() {
        return endH;
    }

    /**
     * @param endH the endH to set
     */
    public void setEndH(int endH) {
        this.endH = endH;
    }

    /**
     * @return the endM
     */
    public int getEndM() {
        return endM;
    }

    /**
     * @param endM the endM to set
     */
    public void setEndM(int endM) {
        this.endM = endM;
    }

    /**
     * @return the hourStart
     */
    public String getHourStart() {
        return hourStart;
    }

    /**
     * @param hourStart the hourStart to set
     */
    public void setHourStart(String hourStart) {
        this.hourStart = hourStart;
    }

    /**
     * @return the hourEnd
     */
    public String getHourEnd() {
        return hourEnd;
    }

    /**
     * @param hourEnd the hourEnd to set
     */
    public void setHourEnd(String hourEnd) {
        this.hourEnd = hourEnd;
    }
}
