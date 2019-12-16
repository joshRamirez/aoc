import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;
import com.google.common.graph.Traverser;

import java.util.*;

public class Day6Orbits {
    public static int checksum(List<String> orbitMap) {
        MutableGraph<String> orbits = convertMapToOrbit(orbitMap);
        return calculateOrbits(orbits);
    }

    private static Integer calculateOrbits(MutableGraph<String> orbitsGraph) {
        List<String> orbits = new LinkedList<>();
        Map<String, Integer> bodyOrbits = new HashMap<>();
        Iterator orbitsIterator = Traverser.forGraph(orbitsGraph).depthFirstPostOrder(orbitsGraph.nodes()).iterator();
        Object root = null;

        while (orbitsIterator.hasNext()) {
            root = orbitsIterator.next();
        }

        Traverser.forGraph(orbitsGraph).depthFirstPreOrder((String) root).forEach(it -> orbits.add(it));
        return calculateOrbits(orbitsGraph, orbits, bodyOrbits, null, -1);
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
