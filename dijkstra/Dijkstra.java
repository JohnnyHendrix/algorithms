/**
 * Created by johnny on 24.09.17.
 */
public class Dijkstra {

    private final List<Vertex> vertices;
    private final List<Edge> edges;
    private Set<Vertex> visitedNodes;
    private Set<Vertex> unvisitedNodes;
    private Map<Vertex, Integer> distance;
    private Map<Vertex, Vertex> predecessors;

    /**
     * Constructor takes graph and initializes the lists of vertices and edges.
     *
     * @param graph
     */
    public Dijkstra(Graph graph) {
        this.vertices = new ArrayList<>(graph.getVertices());
        this.edges = new ArrayList<>(graph.getEdges());
    }

    public Map<Vertex, Vertex> shortestPath(Vertex startNode) {
        initialize(startNode);
        while (unvisitedNodes.size() > 0) {
            Vertex v = minimumDistance();
            visitedNodes.add(v);
            unvisitedNodes.remove(v);
            List<Vertex> neighbours = getNeighbours(v);
            for (Vertex neighbour : neighbours) {
                int alt = distance.get(v) + distanceBetween(v, neighbour);
                if (alt < distance.get(neighbour)) {
                    distance.put(neighbour, alt);
                    predecessors.put(neighbour, v);
                    unvisitedNodes.add(neighbour);
                }
            }

        }
        return predecessors;
    }

    private void initialize(Vertex startNode) {
        visitedNodes = new HashSet<>();
        unvisitedNodes = new HashSet<>();
        distance = new HashMap<>();
        predecessors = new HashMap<>();
        for (Vertex v : vertices) {
            if (v != startNode) {
                distance.put(v, Integer.MAX_VALUE);
                predecessors.put(v, null);
            }
        }
        distance.put(startNode, 0);
    }

    private int distanceBetween(Vertex source, Vertex target) {
        for (Edge edge : this.edges) {
            if (edge.getSource().equals(source) && edge.getDestination().equals(target)) {
                return edge.getWeight();
            }
        }

        throw new RuntimeException("Edge between the vertex" + source.getName() + " and "
                + target.getName() + " was not found.");
    }


    private List<Vertex> getNeighbours(Vertex vertex) {
        List<Vertex> neighbours = new ArrayList<>();
        for (Edge edge : this.edges) {
            if (edge.getSource().equals(vertex) && !visitedNodes.contains(edge.getDestination())) {
                neighbours.add(edge.getDestination());
            }
        }
        return neighbours;
    }

    private Vertex minimumDistance() {
        Vertex minimum = null;
        for (Vertex v : unvisitedNodes) {
            if (minimum == null) {
                minimum = v;
            } else {
                if (distance.get(v) < distance.get(minimum)) {
                    minimum = v;
                }
            }
        }
        return minimum;
    }
}
