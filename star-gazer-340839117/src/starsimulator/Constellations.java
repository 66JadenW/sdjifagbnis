/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package starsimulator;

/**
 *
 * @author menot
 */
public class Constellations {

    private String name;
    private String[] stars;

    public Constellations(String name, String[] stars) {
        this.name = name;
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public String[] getStars() {
        return stars;
    }
}
