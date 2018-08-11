package undirectedweightedgraphimplementation;

class GraphNode {

    int nodeNumber;
    int weight;
    GraphNode next;

    GraphNode(int nodeNumber, int weight, GraphNode next) {
        this.nodeNumber = nodeNumber;
        this.weight = weight;
        this.next = next;
    }
}
