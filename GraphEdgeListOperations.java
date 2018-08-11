package undirectedweightedgraphimplementation;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphEdgeListOperations {

    StackUsingLinkList<Integer> stack = new StackUsingLinkList<Integer>();

    public void pushInStackValue(int index, GraphNode listOfNodes) {
        while (listOfNodes != null) {
            stack.pushInStack(listOfNodes.nodeNumber);
            listOfNodes = listOfNodes.next;
        }
    }

    public int[] depthFirstSearchTraversal(ArrayList<GraphNode> graphEdgeList) {
        int node = 0;
        int[] visitedNode = new int[graphEdgeList.size()];
        for (int i = 0; i < visitedNode.length; i++) {
            visitedNode[i] = 0;
        }
        pushInStackValue(node, graphEdgeList.get(node));
        visitedNode[0] = 1;
        while (!stack.isStackEmpty()) {
            node = stack.popFromStack();
            if (visitedNode[node] != 1) {
                visitedNode[node] = 1;
                pushInStackValue(node, graphEdgeList.get(node));
            }
        }
        return visitedNode;
    }

    public ArrayList<ArrayList<Integer>> minimumSpanningTree(ArrayList<GraphNode> graphEdgeList) {
        int node = 0;
        int nodeWithMinimumWeight = 0;
        int minimumWeight;
        ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();
        int[] visitedNode = new int[graphEdgeList.size()];
        for (int i = 0; i < visitedNode.length; i++) {
            visitedNode[i] = 0;
        }
        visitedNode[0] = 1;
        int edges = 0;
        int index = -1;
        int vertex = graphEdgeList.size();
        while (edges != vertex - 1) {
            nodeWithMinimumWeight = -1;
            minimumWeight = 10000;
            for (int i = 0; i < visitedNode.length; i++) {
                if (visitedNode[i] == 1) {
                    // for(int j=0;j<graphEdgeList.get(i).size();j++) {
                    GraphNode current = graphEdgeList.get(i);
                    while (current != null) {
                        if (current.weight < minimumWeight && visitedNode[current.nodeNumber] == 0) {
                            minimumWeight = current.weight;
                            index = i;
                            nodeWithMinimumWeight = current.nodeNumber;
                        }
                        current = current.next;
                    }
                }
            }
            visitedNode[nodeWithMinimumWeight] = 1;
            edges++;
            path.add(new ArrayList<Integer>(Arrays.asList(index, nodeWithMinimumWeight)));
        }
        return path;
    }

    public ArrayList<ArrayList<Integer>> dijkstraPath(ArrayList<GraphNode> graphEdgeList, int startNode, int endNode) {
        int nodeWithMinimumWeight = 0;
        int minimumWeight;
        ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();
        int[] visitedNode = new int[graphEdgeList.size()];
        int[] distanceNode = new int[graphEdgeList.size()];
        for (int i = 0; i < visitedNode.length; i++) {
            visitedNode[i] = 0;
            distanceNode[i] = 100000;
        }
        visitedNode[startNode] = 1;
        distanceNode[startNode] = 0;
        int index = -1;
        int vertex = 1;
        while (vertex != endNode) {
            nodeWithMinimumWeight = -1;
            minimumWeight = 10000;
            for (int i = 0; i < visitedNode.length; i++) {
                if (visitedNode[i] == 1) {
                    // for(int j=0;j<graphEdgeList.get(i).size();j++) {
                    GraphNode current = graphEdgeList.get(i);
                    while (current != null) {
                        if (distanceNode[i] + current.weight < minimumWeight && visitedNode[current.nodeNumber] == 0) {
                            minimumWeight = distanceNode[i] + current.weight;
                            index = i;
                            nodeWithMinimumWeight = current.nodeNumber;
                        }
                        current = current.next;
                    }
                }
            }
            visitedNode[nodeWithMinimumWeight] = 1;
            distanceNode[nodeWithMinimumWeight] = minimumWeight;
            vertex++;
            path.add(new ArrayList<Integer>(Arrays.asList(index, nodeWithMinimumWeight)));
        }
        return path;
    }
}
