import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import org.junit.Test;
import util.AocFileReader;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day6OrbitsTest {
    @Test
    public void testConvertMapToOrbitsSampleData() {
        List<String> mockOrbitMap = AocFileReader.readFile("src/main/resources/Day6DataSample.txt");

        MutableGraph<String> expectedDirectedOrbitGraph = GraphBuilder.directed().build();
        expectedDirectedOrbitGraph.addNode("COM");
        expectedDirectedOrbitGraph.addNode("B");
        expectedDirectedOrbitGraph.addNode("C");
        expectedDirectedOrbitGraph.addNode("D");
        expectedDirectedOrbitGraph.addNode("E");
        expectedDirectedOrbitGraph.addNode("F");
        expectedDirectedOrbitGraph.addNode("G");
        expectedDirectedOrbitGraph.addNode("H");
        expectedDirectedOrbitGraph.addNode("I");
        expectedDirectedOrbitGraph.addNode("J");
        expectedDirectedOrbitGraph.addNode("K");
        expectedDirectedOrbitGraph.addNode("L");
        expectedDirectedOrbitGraph.addNode("YOU");
        expectedDirectedOrbitGraph.addNode("SAN");
        expectedDirectedOrbitGraph.putEdge("COM", "B");
        expectedDirectedOrbitGraph.putEdge("B", "C");
        expectedDirectedOrbitGraph.putEdge("C", "D");
        expectedDirectedOrbitGraph.putEdge("D", "E");
        expectedDirectedOrbitGraph.putEdge("E", "F");
        expectedDirectedOrbitGraph.putEdge("B", "G");
        expectedDirectedOrbitGraph.putEdge("G", "H");
        expectedDirectedOrbitGraph.putEdge("D", "I");
        expectedDirectedOrbitGraph.putEdge("E", "J");
        expectedDirectedOrbitGraph.putEdge("J", "K");
        expectedDirectedOrbitGraph.putEdge("K", "L");
        expectedDirectedOrbitGraph.putEdge("K", "YOU");
        expectedDirectedOrbitGraph.putEdge("I", "SAN");

        assertEquals(expectedDirectedOrbitGraph, Day6Orbits.convertMapToOrbit(mockOrbitMap));
    }

    @Test
    public void testChecksumSample() {
        List<String> mockOrbitMap = AocFileReader.readFile("src/main/resources/Day6DataSample.txt");

        assertEquals(54, Day6Orbits.checksum(mockOrbitMap));
    }

    @Test
    public void testChecksum() {
        List<String> mockOrbitMap = AocFileReader.readFile("src/main/resources/Day6Data.txt");

        assertEquals(245089, Day6Orbits.checksum(mockOrbitMap));
    }

    @Test
    public void testGetMinimumOrbitalTransfersSample() {
        List<String> mockOrbitMap = AocFileReader.readFile("src/main/resources/Day6DataSample.txt");

        assertEquals(4, Day6Orbits.getMinimumOrbitalTransfers(mockOrbitMap, "YOU", "SAN"));
    }

    @Test
    public void testGetMinimumOrbitalTransfers() {
        List<String> mockOrbitMap = AocFileReader.readFile("src/main/resources/Day6Data.txt");

        assertEquals(511, Day6Orbits.getMinimumOrbitalTransfers(mockOrbitMap, "YOU", "SAN"));
    }
}
