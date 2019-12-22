import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import com.google.common.graph.Traverser;

import java.util.*;

public class Day6Orbits {
    public static int checksum(List<String> orbitMap) {
        MutableGraph<String> orbitsGraph = convertMapToOrbit(orbitMap);
        return calculateOrbits(orbitsGraph);
    }

    public static int getMinimumOrbitalTransfers(List<String> orbitMap, String start, String end) {
        MutableGraph<String> orbitsGraph = convertMapToOrbit(orbitMap);
        Integer[] distance = new Integer[1];
        calculateMinimumOrbitalTransfers(orbitsGraph, start, end, 0, new HashSet<>(), distance);
        return distance[0];
    }

    private static void calculateMinimumOrbitalTransfers(MutableGraph<String> orbitsGraph, String current, String end, Integer count, Set<String> visited, Integer[] distance) {
        if (current.equals(end)) {
            // remove start and end nodes
            distance[0] = count - 2;
        }

        visited.add(current);
        if (!orbitsGraph.predecessors(current).isEmpty() || !orbitsGraph.successors(current).isEmpty()) {
            for (String node : orbitsGraph.adjacentNodes(current)) {
                if (!visited.contains(node)) {
                    calculateMinimumOrbitalTransfers(orbitsGraph, node, end, count + 1, visited, distance);
                }
            }
        }
    }

    private static Integer calculateOrbits(MutableGraph<String> orbitsGraph) {
        List<String> orbits = getOrbits(orbitsGraph);
        Map<String, Integer> bodyOrbits = new HashMap<>();

        return calculateOrbits(orbitsGraph, orbits, bodyOrbits, null, -1);
    }

    private static List<String> getOrbits(MutableGraph<String> orbitsGraph) {
        List<String> orbits = new LinkedList<>();
        Object root = getRoot(orbitsGraph);
        Traverser.forGraph(orbitsGraph).depthFirstPreOrder((String) root).forEach(it -> orbits.add(it));

        return orbits;
    }

    private static Object getRoot(MutableGraph<String> orbitsGraph) {
        Iterator orbitsIterator = Traverser.forGraph(orbitsGraph).depthFirstPostOrder(orbitsGraph.nodes()).iterator();
        Object root = null;

        while (orbitsIterator.hasNext()) {
            root = orbitsIterator.next();
        }

        return root;
    }

    private static Integer calculateOrbits(MutableGraph<String> orbitsGraph, List<String> orbits, Map<String, Integer> bodyOrbits, String previousOrbit, Integer totalOrbits) {
        if (orbits.size() == 0) {
            return totalOrbits + 1;
        }

        String currentOrbit = orbits.remove(0);
        Set<String> predecessors = orbitsGraph.predecessors(currentOrbit);

        if (previousOrbit == null || predecessors.contains(previousOrbit)) {
            Integer newTotalOrbits = totalOrbits + 1;
            bodyOrbits.put(currentOrbit, newTotalOrbits);
            return totalOrbits + calculateOrbits(orbitsGraph, orbits, bodyOrbits, currentOrbit, newTotalOrbits);
        } else {
            Integer newTotalOrbits = bodyOrbits.get(predecessors.toArray()[0]) + 1;
            bodyOrbits.put(currentOrbit, newTotalOrbits);
            return bodyOrbits.get(previousOrbit) + calculateOrbits(orbitsGraph, orbits, bodyOrbits, currentOrbit, newTotalOrbits);
        }
    }

    public static MutableGraph<String> convertMapToOrbit(List<String> orbitMap) {
        MutableGraph<String> directedOrbitGraph = GraphBuilder.directed().build();

        for (String orbit : orbitMap) {
            String[] split = orbit.split("\\)");
            String body = split[0];
            String object = split[1];
            directedOrbitGraph.addNode(body);
            directedOrbitGraph.addNode(object);

            directedOrbitGraph.putEdge(body, object);
        }

        return directedOrbitGraph;
    }
}
