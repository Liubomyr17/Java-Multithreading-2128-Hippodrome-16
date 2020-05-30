package com.company;

/*

2113 Hippodrome 16

Now that's all.
Add a call to the printWinner method at the end of the main method.
Launch and admire your first computer game :)

Requirements:
1. The printWinner method must be called in the main method after the run method.
________________________________________
Hippodrome (15)
Add a winner definition.
In the Hippodrome class, we will do two methods:
public Horse getWinner () and public void printWinner ()
The getWinner method should return the horse that has run the longest distance.
The printWinner method displays the name of the winner in the form: Winner is <name>!
Example:
Winner is Lucky!


 */

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List horses) {
        this.horses = horses;
    }

    public void move() {
        horses.forEach(Horse::move);
    }

    public void print() {
        for (Horse horse : this.horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            this.move();
            this.print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Horse getWinner(){
        double maxDistance = 0.0;
        for (Horse horse : this.horses){
            if (horse.getDistance()>maxDistance){
                maxDistance = horse.getDistance();
            }
        }
        Horse horse = null;
        for (Horse hors : this.horses){
            if (hors.getDistance()==maxDistance){
                horse = hors;
                break;
            }
        }
        return horse;
    }

    public void printWinner(){
        Horse horse = getWinner();
        System.out.println("Winner is " + horse.getName() + "!");
    }


    public static void main(String[] args) {
        List<Horse> horseList = new ArrayList<>();
        horseList.add(new Horse("Horse1", 3, 0));
        horseList.add(new Horse("Horse2", 3, 0));
        horseList.add(new Horse("Horse3", 3, 0));
        game = new Hippodrome(horseList);
        game.run();
        game.printWinner();
    }
}
