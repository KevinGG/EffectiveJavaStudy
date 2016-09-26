package my.question.recursion;

import utility.CustomRandom;

public class RobotJump {
  private Robot robot = new Robot();

  public void jump1StairUp() {
    if (!robot.jump()) {
      jump1StairUp();
      jump1StairUp();
    }
  }

  private static class Robot {
    int diff = 0;

    boolean jump() {
      boolean result = new CustomRandom().oneInTwo();
      System.out.println(result ? ++diff : --diff);
      return result;
    }
  }

  public static void main(String[] argv) {
    new RobotJump().jump1StairUp();
  }
}
