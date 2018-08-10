package undirectedweightedgraphimplementation;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphEdgeListOperations {
    StackUsingLinkList<Integer> stack = new StackUsingLinkList<Integer>();
    public void pushInStackValue(int index, ArrayList<Integer> listOfEdges) {
        for(int i=0;i<listOfEdges.size();i++) {
            stack.pushInStack(listOfEdges.get(i));
        }
    }
    public boolean depthFirstSearchTraversal(ArrayList<ArrayList<Integer>> graphEdgeList) {
        int node=0;
        int[] visitedNode = new int[graphEdgeList.size()];
        int countOfNodeTraversed=0;
        for(int i=0;i<visitedNode.length;i++) {
            visitedNode[i]=0;
        }
        if(graphEdgeList.get(0).size()==0) {
            return false;
        }
        pushInStackValue(node, graphEdgeList.get(node));
        visitedNode[0]=1;
        countOfNodeTraversed++;
        while(!stack.isStackEmpty()) {
            node=stack.popFromStack();
            if(visitedNode[node]!=1) {
                visitedNode[node]=1;
                if(graphEdgeList.get(node).size()==0) {
                    return false;
                }
                pushInStackValue(node,graphEdgeList.get(node));
                countOfNodeTraversed++;
            }
        }
        if(countOfNodeTraversed==graphEdgeList.size()) {
            return true;
        }
        else {
            return false;
        }
    }
    public ArrayList<ArrayList<Integer>> minimumSpanningTree(ArrayList<ArrayList<Integer>> graphEdgeList) {
        int node=0;
        int nodeWithMinimumWeight=0;
        int minimumWeight;
        ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();
        int[] visitedNode = new int[graphEdgeList.size()];
        for(int i=0;i<visitedNode.length;i++) {
            visitedNode[i]=0;
        }
        visitedNode[0]=1;
        int edges=0;
        int index=-1;
        int vertex=graphEdgeList.size();
        while(edges!=vertex-1) {
            nodeWithMinimumWeight=-1;
            minimumWeight=10000;
            for(int i=0;i<visitedNode.length;i++) {
                if(visitedNode[i]==1) {
                    for(int j=0;j<graphEdgeList.get(i).size();j++) {
                        if(graphEdgeList.get(i).get(j)<minimumWeight && visitedNode[j]==0) {
                            minimumWeight=graphEdgeList.get(i).get(j);
                            index=i;
                            nodeWithMinimumWeight=j;
                        }
                    }
                }
            }
            visitedNode[nodeWithMinimumWeight]=1;
            edges++;
            path.add(new ArrayList<Integer>(Arrays.asList(index,nodeWithMinimumWeight)));
        }
        return path;
    }
    public ArrayList<ArrayList<Integer>> dijkstraPath(ArrayList<ArrayList<Integer>> graphEdgeList) {
        int nodeWithMinimumWeight=0;
        int minimumWeight;
        ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();
        int[] visitedNode = new int[graphEdgeList.size()];
        int[] distanceNode = new int[graphEdgeList.size()];
        for(int i=0;i<visitedNode.length;i++) {
            visitedNode[i]=0;
            distanceNode[i]=100000;
        }
        visitedNode[0]=1;
        distanceNode[0]=0;
        int index=-1;
        int vertex=0;
        while(vertex!=graphEdgeList.size()) {
            nodeWithMinimumWeight=-1;
            minimumWeight=10000;
            for(int i=0;i<visitedNode.length;i++) {
                if(visitedNode[i]==1) {
                    for(int j=0;j<graphEdgeList.get(i).size();j++) {
                        if(distanceNode[i]+graphEdgeList.get(i).get(j)<minimumWeight && visitedNode[j]==0) {
                            minimumWeight=distanceNode[i]+graphEdgeList.get(i).get(j);
                            index=i;
                            nodeWithMinimumWeight=j;
                        }
                    }
                }
            }
            visitedNode[nodeWithMinimumWeight]=1;
            distanceNode[nodeWithMinimumWeight]=minimumWeight;
            vertex++;
            path.add(new ArrayList<Integer>(Arrays.asList(index,nodeWithMinimumWeight)));
        }
        return path;
    }
}
