import java.awt.*;
import java.util.*;
import java.util.List;

public class Day3CrossedWires {
    public static int getClosestIntersection(List<List<String>> paths) {
        List<String> wire0 = paths.get(0);
        List<String> wire1 = paths.get(1);

        Set positions = mapOutPath(wire0);
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

    public static int getShortestDistanceIntersection(List<List<String>> paths) {
        List<String> wire0 = paths.get(0);
        List<String> wire1 = paths.get(1);

        Map positions = mapOutPathShortestDistance(wire0);
        return findShortestIntersection(positions, wire1);
    }

    private static int findShortestIntersection(Map<Point, Integer> positions, List<String> wire1) {
        Integer minCollision = null;
        int x = 0;
        int y = 0;
        int steps = 0;

        for (String wirePosition : wire1) {
            String direction = wirePosition.substring(0, 1);
            Integer iterations = Integer.parseInt(wirePosition.substring(1));

            for (int i = 0; i < iterations; i++) {
                steps++;
                if (direction.equals("U")) {
                    y++;
                } else if (direction.equals("L")) {
                    x--;
                } else if (direction.equals("R")) {
                    x++;
                } else {
                    y--;
                }

                if (positions.containsKey(new Point(x, y))) {
                    int manhattanDistance = positions.get(new Point(x, y)) + steps;
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

    private static Map mapOutPathShortestDistance(List<String> wire0) {
        Map positions = new HashMap();
        int x = 0;
        int y = 0;
        int steps = 0;

        for (String wirePosition : wire0) {
            String direction = wirePosition.substring(0, 1);
            Integer iterations = Integer.parseInt(wirePosition.substring(1));

            for (int i = 0; i < iterations; i++) {
                steps ++;
                if (direction.equals("U")) {
                    y++;
                } else if (direction.equals("L")) {
                    x--;
                } else if (direction.equals("R")) {
                    x++;
                } else {
                    y--;
                }

                if (!positions.containsKey(new Point(x, y))) {
                    positions.put(new Point(x, y), steps);
                }
            }
        }

        return positions;
    }
}
