package us.slemjet.leetcode.medium.tasks_1001_1050;

/**
 * 1041. Robot Bounded In Circle
 */
public class RobotBoundedInCircle {

    /**
     * Runtime: 34.81%
     * Memory Usage: 11.56%
     */
    public boolean isRobotBounded(String instructions) {

        int x = 0, y = 0;
        // Directions - Up, Right, Down, Left new int[][]{new int[]{0, 1}, new int[]{1, 0}, new int[]{0, -1}, new int[]{-1, 0}}
        int currDirection = 0;

        for (char command : instructions.toCharArray()) {
            if (command == 'G') {
                // Directions - Up, Right, Down, Left new int[][]{new int[]{0, 1}, new int[]{1, 0}, new int[]{0, -1}, new int[]{-1, 0}}
                y += currDirection == 0 ? 1 : currDirection == 2 ? -1 : 0;
                x += currDirection == 1 ? 1 : currDirection == 3 ? -1 : 0;
            } else if (command == 'L') {
                // Rotate to the left (counter-clockwise) decrements directions index
                currDirection = currDirection == 0 ? 3 : currDirection - 1;
            } else if (command == 'R') {
                // Rotate to the right (clockwise) increments directions index
                currDirection = currDirection == 3 ? 0 : currDirection + 1;
            }
        }

        // If still facing Up (original destination) and has moved can move indefinitely in a loop of commands
        return currDirection != 0 || y == 0 && x == 0;
    }
}
