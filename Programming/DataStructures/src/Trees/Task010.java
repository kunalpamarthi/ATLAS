// Task010: Display graph edges.

package Trees;

class Graph{
    static class Edge{
        int src, destination;

        public Edge(int src, int destination){
            this.src = src;
            this.destination = destination;
        }
    }
    int vertices, edges;
    Edge[] edge;

    public Graph(int vertices, int edges){
        this.vertices = vertices;
        this.edges = edges;
        edge = new Edge[edges];

        for (int i = 0; i < edges; i++) {
            edge[i] = new Edge(0, 0);
        }
    }

    public void addEdge(int index, int src, int destination){
        if (index >= 0 && index < edges){
            edge[index].src = src;
            edge[index].destination = destination;
        }
    }

    public void display(){
        for (int i = 0; i < edges; i++) {
            System.out.println("Edge "+(i+1)+": "+
                    edge[i].src+" -> "+edge[i].destination);
        }
    }
}

public class Task010 {
    public static void main(String[] args) {
        int vertices = 5, edges = 7;
        Graph graph = new Graph(vertices, edges);
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 1, 3);
        graph.addEdge(2, 1, 4);
        graph.addEdge(3, 2, 4);
        graph.addEdge(4, 2, 5);
        graph.addEdge(5, 3, 4);
        graph.addEdge(6, 3, 5);
        graph.display();
    }
}
