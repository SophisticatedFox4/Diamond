import kareltherobot.*;
import java.util.Scanner;

public class Main implements Directions{
  public static void main(String[] args) {
    World.setVisible(true);// allows us to see the run
    World.setDelay(1);

    Scanner scn = new Scanner(System.in);

    // The line below creates a Robot that we will refer to as r.  
    // Find out what the numbers and direction do!

    System.out.print("Octagon? ");
    boolean octagon = scn.nextBoolean();

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

    World.setSize((octagon == true) ? 3 * size : 2 * (size + 2), (octagon == true) ? 3 * size : 2 * (size + 2));
    Robot a = new Robot(2, (octagon == true) ? 2 * size : size + 2, North, infinity);
    
    if (octagon == false) {
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
    } else {
      if (fill == false) {
        a.turnLeft();
        for (int i = 0; i < 4; i++) {
          for (int j = 0; j < size - 1; j++) {
            a.move();
            a.putBeeper();
          }
          turnRight(a);
          for (int j = 0; j < size - 1; j++) {
            a.move();
            a.turnLeft();
            a.move();
            a.putBeeper();
            turnRight(a);
          }
        }
      } else {
        for (int i = 0; i < size; i++) {
          a.turnLeft();
          for (int j = 0; j < 4; j++) {
            for (int k = 0; k < size - 1 - i / 2; k++) {
              a.move();
              a.putBeeper();
            }
            turnRight(a);
            for (int k = 0; k < size - 1 - i; k++) {
              a.move();
              a.turnLeft();
              a.move();
              a.putBeeper();
              turnRight(a);
            }
          }
          turnRight(a);
          a.move();
        }
      }
    }
  }

  public static void turnRight (Robot robot) {
    for (int i = 0; i < 3; i++) {
      robot.turnLeft();
    }
  }
}