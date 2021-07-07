package graphoperations;

import java.util.ArrayList;

public class GraphUsingEdgeListImplementation implements Graph {

    public ArrayList<GraphNode> graphEdgeList;
    GraphEdgeListOperations operationOnGraph = new GraphEdgeListOperations();

    GraphUsingEdgeListImplementation(ArrayList<GraphNode> graph) {
        graphEdgeList = graph;
    }

    public boolean isConnected() {
        int[] visitedNode = operationOnGraph.depthFirstSearchTraversal(graphEdgeList);
        int countOfNodeTraversed = 0;
        for (int i = 0; i < visitedNode.length; i++) {
            if (visitedNode[i] == 1) {
                countOfNodeTraversed++;
            }
        }
        if (countOfNodeTraversed == graphEdgeList.size()) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Integer> reachable(int node) {
        ArrayList<Integer> connectedNodes = new ArrayList<Integer>();
        if (isConnected()) {
            for (int i = 0; i < graphEdgeList.size(); i++) {
                if (i == node) {
                    continue;
                } else {
                    connectedNodes.add(i);
                }
            }
        } else {
            int[] visitedNode = operationOnGraph.depthFirstSearchTraversal(graphEdgeList);
            for (int i = 0; i < graphEdgeList.size(); i++) {
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
        return operationOnGraph.minimumSpanningTree(graphEdgeList);
    }

    public ArrayList<ArrayList<Integer>> shortestPath(int startNode, int endNode) {
        return operationOnGraph.dijkstraPath(graphEdgeList, startNode, endNode);
    }
}
