/**
 * Created by johnny on 24.09.17.
 */
public class Edge {

    private String id;
    private Vertex source;
    private Vertex destination;
    int weight;

    public Edge(String id, Vertex source, Vertex destination, int weight) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getId() {
        return id;
    }

    public Vertex getDestination() {
        return destination;
    }

    public Vertex getSource() {
        return source;
    }

    @Override
    public String toString() {
        return source + " <-> " + destination;
    }
}

