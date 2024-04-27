/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package starsimulator;

/**
 *
 * @author Jaden Wickens
 */
public class Star implements Comparable<Star> {

    private double xPos;
    private double yPos;
    private double zPos;
    private int HDNumber;
    private double magnitude;
    private int hNumber;
    private String[] name;
    private final double RESIZER = 3.5;

    public Star(double xPos, double yPos, double zPos, int HDNumber, double magnitude, int hNumber, String[] name) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.zPos = zPos;
        this.HDNumber = HDNumber;
        this.magnitude = magnitude;
        this.hNumber = hNumber;
        for (String x:name){
            x = x.trim();
        }
        this.name = name;
    }
   public Star( String name) {
       this.name = new String[1];
        this.name[0] = name;
    }
    public double getXPos() {
        return xPos;
    }

    public double getYPos() {
        return yPos;
    }
    
    public int getAdjustedXPos(int halfWidth) {
        int adjustedXPos = (int)(xPos*halfWidth)+halfWidth;
        return adjustedXPos;
    }

    public int getAdjustedYPos(int halfHeight) {
        int adjustedYPos = (int)(yPos*halfHeight)+halfHeight;
        return adjustedYPos;
    }

    public double getZPos() {
        return zPos;
    }

    public int getHDNumber() {
        return HDNumber;
    }

    public double getMag() {
        return magnitude;
    }
    public int getAdjustedMag() {
        int adjustedMag = (int)((7+magnitude)/RESIZER);
        return adjustedMag;
    }


    public int getHNumber() {
        return hNumber;
    }

    public String[] getName() {
        return name;
    }
    

    @Override
    public int compareTo(Star o) {
        return this.name[0].compareTo(o.getName()[0]);
    }
}
