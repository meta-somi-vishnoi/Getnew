package undirectedweightedgraphimplementation;

import java.util.ArrayList;

public class GraphUsingEdgeListImplementation {
    public ArrayList<ArrayList<Integer>> graphEdgeList;
    GraphEdgeListOperations operationOnGraph = new GraphEdgeListOperations();
    GraphUsingEdgeListImplementation(ArrayList<ArrayList<Integer>> graph) {
        graphEdgeList = graph;
    }
    
    public boolean isConnected() {
        return operationOnGraph.depthFirstSearchTraversal(graphEdgeList);
    }
    public ArrayList<Integer> reachable(int node) {
        ArrayList<Integer> connectedNodes = new ArrayList<Integer>();
        for(int i=0;i<graphEdgeList.get(node).size();i++) {
            connectedNodes.add(graphEdgeList.get(node).get(i));
        }
        return connectedNodes;
    }
    public ArrayList<ArrayList<Integer>> minimumSpanningTree() {
        return operationOnGraph.minimumSpanningTree(graphEdgeList);
    }
    public ArrayList<ArrayList<Integer>> shortestPath(int startNode, int endNode) {
        return operationOnGraph.dijkstraPath(graphEdgeList);       
    }
}
