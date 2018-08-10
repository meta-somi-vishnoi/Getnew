package undirectedweightedgraphimplementation;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphOperations {

    StackUsingLinkList<Integer> stack = new StackUsingLinkList<Integer>();

    public void pushInStackValue(int index, int[][] graphMatrix) {
        for (int i = 0; i < graphMatrix.length; i++) {
            if (i == index) {
                continue;
            } else if (graphMatrix[index][i] != 0) {
                stack.pushInStack(i);
            }
        }
    }

    public int[] depthFirstSearchTraversal(int[][] graphMatrix) {
        int node = 0;
        int[] visitedNode = new int[graphMatrix.length];
        for (int i = 0; i < visitedNode.length; i++) {
            visitedNode[i] = 0;
        }
        pushInStackValue(node, graphMatrix);
        visitedNode[0] = 1;
        while (!stack.isStackEmpty()) {
            node = stack.popFromStack();
            if (visitedNode[node] != 1) {
                visitedNode[node] = 1;
                pushInStackValue(node, graphMatrix);
            }
        }
        return visitedNode;
    }

    public ArrayList<ArrayList<Integer>> minimumSpanningTree(int[][] graphMatrix) {
        int node = 0;
        int nodeWithMinimumWeight = 0;
        int minimumWeight = 10000;
        int index = -1;
        ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();
        int[] visitedNode = new int[graphMatrix.length];
        for (int i = 0; i < graphMatrix.length; i++) {
            for (int j = 0; j < graphMatrix.length; j++) {
                if (graphMatrix[i][j] == 0) {
                    graphMatrix[i][j] = 11000;
                }
            }
        }
        for (int i = 0; i < visitedNode.length; i++) {
            visitedNode[i] = 0;
        }
        for (int i = 0; i < graphMatrix.length; i++) {
            for (int j = 0; j < graphMatrix.length; j++) {
                if (graphMatrix[i][j] < minimumWeight) {
                    minimumWeight = graphMatrix[i][j];
                    index = i;
                    nodeWithMinimumWeight = j;
                }
            }
        }
        System.out.println(index);
        System.out.println(nodeWithMinimumWeight);
        visitedNode[index] = 1;
        visitedNode[nodeWithMinimumWeight] = 1;
        int edges = 1;
        path.add(new ArrayList<Integer>(Arrays.asList(index, nodeWithMinimumWeight)));
        int vertex = graphMatrix.length;
        while (edges != vertex - 1) {
            nodeWithMinimumWeight = -1;
            minimumWeight = 10000;
            for (int i = 0; i < visitedNode.length; i++) {
                if (visitedNode[i] == 1) {
                    for (int j = 0; j < graphMatrix.length; j++) {
                        if (graphMatrix[i][j] < minimumWeight && visitedNode[j] == 0) {
                            minimumWeight = graphMatrix[i][j];
                            index = i;
                            nodeWithMinimumWeight = j;
                        }
                    }
                }
            }
            visitedNode[nodeWithMinimumWeight] = 1;
            edges++;
            path.add(new ArrayList<Integer>(Arrays.asList(index, nodeWithMinimumWeight)));
        }
        return path;
    }

    public ArrayList<ArrayList<Integer>> dijkstraPath(int[][] graphMatrix, int startNode, int endNode) {
        int nodeWithMinimumWeight = 0;
        int minimumWeight;
        ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();
        int[] visitedNode = new int[graphMatrix.length];
        int[] distanceNode = new int[graphMatrix.length];
        for (int i = 0; i < visitedNode.length; i++) {
            visitedNode[i] = 0;
            distanceNode[i] = 100000;
        }
        for (int i = 0; i < graphMatrix.length; i++) {
            for (int j = 0; j < graphMatrix.length; j++) {
                if (graphMatrix[i][j] == 0) {
                    graphMatrix[i][j] = 11000;
                }
            }
        }
        visitedNode[startNode] = 1;
        distanceNode[startNode] = 0;
        int index = -1;
        int vertex = 1;
        while (nodeWithMinimumWeight != endNode) {
            nodeWithMinimumWeight = -1;
            minimumWeight = 10000;
            for (int i = 0; i < visitedNode.length; i++) {
                if (visitedNode[i] == 1) {
                    for (int j = 0; j < graphMatrix.length; j++) {
                        if (distanceNode[i] + graphMatrix[i][j] < minimumWeight && visitedNode[j] == 0) {
                            minimumWeight = distanceNode[i] + graphMatrix[i][j];
                            index = i;
                            nodeWithMinimumWeight = j;
                        }
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
