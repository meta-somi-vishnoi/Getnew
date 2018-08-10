package undirectedweightedgraphimplementation;

import java.util.ArrayList;

public class GraphImplementation implements Graph {

    public int[][] graphMatrix;

    GraphOperations operationOnGraph = new GraphOperations();

    GraphImplementation(int[][] graph) {
        graphMatrix = graph;
    }

    public boolean isConnected() {
        int[] visitedNode = operationOnGraph.depthFirstSearchTraversal(graphMatrix);
        int countOfNodeTraversed = 0;
        for (int i = 0; i < visitedNode.length; i++) {
            if (visitedNode[i] == 1) {
                countOfNodeTraversed++;
            }
        }
        if (countOfNodeTraversed == graphMatrix.length) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Integer> reachable(int node) {
        ArrayList<Integer> connectedNodes = new ArrayList<Integer>();
        if (isConnected()) {
            for (int i = 0; i < graphMatrix.length; i++) {
                if (i == node) {
                    continue;
                } else {
                    connectedNodes.add(i);
                }
            }
        } else {
            int[] visitedNode = operationOnGraph.depthFirstSearchTraversal(graphMatrix);
            for (int i = 0; i < graphMatrix.length; i++) {
                if (i == node) {
                    continue;
                } else if (visitedNode[i] == 1) {
                    connectedNodes.add(i);
                }
            }
        }
        return connectedNodes;
    }

    public ArrayList<ArrayList<Integer>> minimumSpanningTree() {
        return operationOnGraph.minimumSpanningTree(graphMatrix);
    }

    public ArrayList<ArrayList<Integer>> shortestPath(int startNode, int endNode) {
        return operationOnGraph.dijkstraPath(graphMatrix, startNode, endNode);
    }
}
