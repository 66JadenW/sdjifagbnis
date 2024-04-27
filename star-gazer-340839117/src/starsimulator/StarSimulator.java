/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package starsimulator;

import java.io.*;
import java.util.*;

/**
 *
 * @author michael.roy-diclemen
 */
public class StarSimulator {

    private static ArrayList<Star> stars = new ArrayList<Star>();
    private static boolean starsIsFull = false;
    private static ArrayList<Star> namedStars = new ArrayList<Star>();
    private static boolean namedStarsIsFull = false;
    private static ArrayList<Constellations> constellationsList = new ArrayList<Constellations>();
    private static boolean constellationsListIsFull = false;
    private static final File STARS_FILE = new File("stars.txt");
    private static final File CONSTELLATIONS_FILE = new File("constellations.txt");
    private static final String DELIMITER = " ";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    }

    public static ArrayList<Star> getStars() {
        if (!starsIsFull) {
            try {
                Scanner s = new Scanner(STARS_FILE);
                //While the text file has a next line, turn that next line into a string.
                while (s.hasNext()) {
                    stars.add(new Star(s.nextDouble(), s.nextDouble(), s.nextDouble(), s.nextInt(), s.nextDouble(), s.nextInt(), s.nextLine().split(";")));
                }
            } catch (IOException e) {
                System.out.println("Error Reading From File");
            }
            starsIsFull = true;
        }
        return stars;
    }

    public static ArrayList<Star> getNamedStars() {
        if (!starsIsFull) {
            ArrayList<Star> temp1 = getStars();
            for (Star x : temp1) {
                if (!x.getName()[0].equals("")) {
                    //if (x.getName()[0] != "") {
                    for (String y : x.getName()) {
                        String[] temp2 = new String[]{y};
                        namedStars.add(new Star(x.getXPos(), x.getYPos(), x.getZPos(), x.getHDNumber(), x.getMag(), x.getHNumber(), temp2));
                    }
                }
            }
            Collections.sort(namedStars);
            namedStarsIsFull = true;
        }
        return namedStars;
    }

    public static int findStar(String starName) {
        ArrayList<Star> test = getNamedStars();
        int i = 3;
        if (i > 2)
        return Collections.binarySearch(test, new Star(starName.trim()));
        else return 7;
    }

    public static ArrayList<Constellations> getConstilations() {
        if (!constellationsListIsFull) {
            try {
                //open new scanner from the UserInfo file
                Scanner s = new Scanner(CONSTELLATIONS_FILE);
                //while the file has a next line
                while (s.hasNext()) {
                    String line = s.nextLine();
                    String[] parts = line.split(",");
                    String name = parts[0];
                    String[] starNames = Arrays.copyOfRange(parts, 1, parts.length);
                    Constellations constellation = new Constellations(name, starNames);
                    constellationsList.add(constellation);

//                    System.out.println(line);
//                    ArrayList<String> temp = new ArrayList<>(Arrays.asList(line.split(",")));
//                    String name = temp.get(0);
//                    System.out.println(name);
//                    temp.remove(0);
//                    Constellations constellation = new Constellations(name, temp.toArray(new String[temp.size()])); // Convert ArrayList<String> to String[]
//                    constellationsList.add(constellation); // Add constellation to the list
                }
                s.close();
            } catch (IOException e) {
                System.out.println("Error Reading File");
            }
            constellationsListIsFull = true;
        }
        //System.out.println(constellationsList);
        return constellationsList;
    }

}
