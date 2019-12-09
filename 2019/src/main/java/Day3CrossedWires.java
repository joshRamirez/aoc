import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day3CrossedWires {
    public static int getClosestCross(List<List<String>> paths) {
        List<String> wire0 = paths.get(0);
        List<String> wire1 = paths.get(1);

        Set positions = new HashSet();
        positions = mapOutPath(wire0);
        return findSmallestCollision(positions, wire1);
    }

    private static int findSmallestCollision(Set positions, List<String> wire1) {
        Integer minCollision = null;
        int x = 0;
        int y = 0;

        for (String wirePosition : wire1) {
            String direction = wirePosition.substring(0, 1);
            Integer iterations = Integer.parseInt(wirePosition.substring(1));

            for (int i = 0; i < iterations; i++) {
                if (direction.equals("U")) {
                    y++;
                } else if (direction.equals("L")) {
                    x--;
                } else if (direction.equals("R")) {
                    x++;
                } else {
                    y--;
                }

                if (positions.contains(new Point(x, y))) {
                    int manhattanDistance = Math.abs(x) + Math.abs(y);
                    if (null != minCollision) {
                        minCollision = Math.min(minCollision, manhattanDistance);
                    } else {
                        minCollision = manhattanDistance;
                    }
                }
            }
        }

        return minCollision;
    }

    private static Set mapOutPath(List<String> wire0) {
        Set positions = new HashSet();
        int x = 0;
        int y = 0;

        for (String wirePosition : wire0) {
            String direction = wirePosition.substring(0, 1);
            Integer iterations = Integer.parseInt(wirePosition.substring(1));

            for (int i = 0; i < iterations; i++) {
                if (direction.equals("U")) {
                    y++;
                } else if (direction.equals("L")) {
                    x--;
                } else if (direction.equals("R")) {
                    x++;
                } else {
                    y--;
                }


                positions.add(new Point(x, y));
            }
        }

        return positions;
    }
}
