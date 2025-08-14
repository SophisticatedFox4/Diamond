import kareltherobot.*;
import java.util.Scanner;

public class Main implements Directions{
  public static void main(String[] args) {
    World.setVisible(true);// allows us to see the run
    World.setDelay(1);

    Scanner scn = new Scanner(System.in);

    // The line below creates a Robot that we will refer to as r.  
    // Find out what the numbers and direction do!

    System.out.print("Size: ");
    int size = scn.nextInt();

    System.out.print("Fill? ");
    boolean fill = scn.nextBoolean();

    int num = 0;

    if (size % 2 == 1) {
      num = size / 2 + 1;
    } else {
      num = size / 2;
    }

    World.setSize(2 * (size + 2 ), 2 * (size + 2));
    Robot a = new Robot(2, size + 2, North, infinity);
    
    if (fill == false) {
      for (int i = 0; i < 4; i++) {
        for (int j = 0; j < size; j++) {
          a.putBeeper();
          a.move();
          a.turnLeft();
          a.move();
          turnRight(a);
        }
        turnRight(a);
      }
    } else {
      for (int i = 0; i < num; i++) {
        for (int j = 0; j < 4; j++) {
          for (int k = 0; k < size - 2 * i; k++) {
            a.putBeeper();
            a.move();
            a.turnLeft();
            a.putBeeper();
            a.move();
            turnRight(a);
          }
          turnRight(a);
        }
        for (int l = 0; l < 2; l++) {
          a.move();
        }
      }
      a.putBeeper();
    }
  }
  public static void turnRight (Robot robot) {
    for (int i = 0; i < 3; i++) {
      robot.turnLeft();
    }
  }
}