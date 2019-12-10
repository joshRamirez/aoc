import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day3CrossedWiresTest {
    @Test
    public void testGetClosestWires() {
        List<List<String>> mockLists = new ArrayList();
        List<String> mockList0 = Arrays.asList("R75,D30,R83,U83,L12,D49,R71,U7,L72".split(","));
        List<String> mockList1 = Arrays.asList("U62,R66,U55,R34,D71,R55,D58,R83".split(","));
        mockLists.add(mockList0);
        mockLists.add(mockList1);
        assertEquals(159, Day3CrossedWires.getClosestIntersection(mockLists));
    }

    @Test
    public void testGetClosestWires2() {
        List<List<String>> mockPaths = new ArrayList();
        List<String> mockPath0 = Arrays.asList("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51".split(","));
        List<String> mockPath1 = Arrays.asList("U98,R91,D20,R16,D67,R40,U7,R15,U6,R7".split(","));
        mockPaths.add(mockPath0);
        mockPaths.add(mockPath1);
        assertEquals(135, Day3CrossedWires.getClosestIntersection(mockPaths));
    }

    @Test
    public void testClosestWiresPart1() {
        List<List<String>> paths = AocFileReader.readList("src/main/resources/Day3Data.txt");
        assertEquals(709, Day3CrossedWires.getClosestIntersection(paths));
    }

    @Test
    public void testGetShortestWires() {
        List<List<String>> mockLists = new ArrayList();
        List<String> mockList0 = Arrays.asList("R75,D30,R83,U83,L12,D49,R71,U7,L72".split(","));
        List<String> mockList1 = Arrays.asList("U62,R66,U55,R34,D71,R55,D58,R83".split(","));
        mockLists.add(mockList0);
        mockLists.add(mockList1);
        assertEquals(610, Day3CrossedWires.getShortestDistanceIntersection(mockLists));
    }

    @Test
    public void testGetShortestWires2() {
        List<List<String>> mockPaths = new ArrayList();
        List<String> mockPath0 = Arrays.asList("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51".split(","));
        List<String> mockPath1 = Arrays.asList("U98,R91,D20,R16,D67,R40,U7,R15,U6,R7".split(","));
        mockPaths.add(mockPath0);
        mockPaths.add(mockPath1);
        assertEquals(410, Day3CrossedWires.getShortestDistanceIntersection(mockPaths));
    }

    @Test
    public void testShortestWiresPart2() {
        List<List<String>> paths = AocFileReader.readList("src/main/resources/Day3Data.txt");
        assertEquals(13836, Day3CrossedWires.getShortestDistanceIntersection(paths));
    }
}
