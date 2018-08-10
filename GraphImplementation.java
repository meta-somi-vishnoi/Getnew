package undirectedweightedgraphimplementation;

import java.util.ArrayList;

public class GraphImplementation {
    public int[][] graphMatrix;
    GraphOperations operationOnGraph = new GraphOperations();
    GraphImplementation(int[][] graph) {
        graphMatrix = graph;
    }
    
    public boolean isConnected() {
        return operationOnGraph.depthFirstSearchTraversal(graphMatrix);
    }
    public ArrayList<Integer> reachable(int node) {
        ArrayList<Integer> connectedNodes = new ArrayList<Integer>();
        for(int i=0;i<graphMatrix.length;i++) {
            if(i==node) {
                continue;
            }
            else {
                if(graphMatrix[node][i]!=0) {
                    connectedNodes.add(i);
                }
            }
        }
        return connectedNodes;
    }
    public ArrayList<ArrayList<Integer>> minimumSpanningTree() {
        return operationOnGraph.minimumSpanningTree(graphMatrix);
    }
    public int[] shortestPath(int startNode, int endNode) {
        return operationOnGraph.dijkstraPath(graphMatrix);       
    }
}
