package undirectedweightedgraphimplementation;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphOperations {
    StackUsingLinkList<Integer> stack = new StackUsingLinkList<Integer>();
    public void pushInStackValue(int index, int[][] graphMatrix) {
        for(int i=0;i<graphMatrix.length;i++) {
            if(i==index) {
                continue;
            }
            else {
                if(graphMatrix[index][i]!=0) {
                    stack.pushInStack(i);
                }
            }
        }
    }
    public boolean depthFirstSearchTraversal(int[][] graphMatrix) {
        int node=0;
        int[] visitedNode = new int[graphMatrix.length];
        int countOfNodeTraversed=0;
        for(int i=0;i<visitedNode.length;i++) {
            visitedNode[i]=0;
        }
        pushInStackValue(node, graphMatrix);
        visitedNode[0]=1;
        countOfNodeTraversed++;
        while(!stack.isStackEmpty()) {
            node=stack.popFromStack();
            if(visitedNode[node]!=1) {
                visitedNode[node]=1;
                pushInStackValue(node,graphMatrix);
                countOfNodeTraversed++;
            }
        }
        if(countOfNodeTraversed==graphMatrix.length && stack.isStackEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
    public ArrayList<ArrayList<Integer>> minimumSpanningTree(int[][] graphMatrix) {
        int node=0;
        int nodeWithMinimumWeight=0;
        int minimumWeight=10000;
        int index=-1;
        ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();
        int[] visitedNode = new int[graphMatrix.length];
        for(int i=0;i<graphMatrix.length;i++) {
            for(int j=0;j<graphMatrix.length;j++) {
                if(graphMatrix[i][j]==0) {
                    graphMatrix[i][j]=11000;
                }
            }
        }
        for(int i=0;i<visitedNode.length;i++) {
            visitedNode[i]=0;
        }
        for(int i=0;i<graphMatrix.length;i++) {
            for(int j=0;j<graphMatrix.length;j++) {
                if(graphMatrix[i][j]<minimumWeight) {
                    minimumWeight=graphMatrix[i][j];
                    index=i;
                    nodeWithMinimumWeight=j;
                }
            }
        }
        System.out.println(index);
        System.out.println(nodeWithMinimumWeight);
        visitedNode[index]=1;
        visitedNode[nodeWithMinimumWeight]=1;
        int edges=1;
        path.add(new ArrayList<Integer>(Arrays.asList(index,nodeWithMinimumWeight)));
        int vertex=graphMatrix.length;
        while(edges!=vertex-1) {
            nodeWithMinimumWeight=-1;
            minimumWeight=10000;
            for(int i=0;i<visitedNode.length;i++) {
                if(visitedNode[i]==1) {
                    for(int j=0;j<graphMatrix.length;j++) {
                        if(graphMatrix[i][j]<minimumWeight && visitedNode[j]==0) {
                            minimumWeight=graphMatrix[i][j];
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
    public int[] dijkstraPath(int[][] graphMatrix) {
        int node=0;
        int nodeWithMinimumWeight=0;
        int minimumWeight;
        int[] visitedNode = new int[graphMatrix.length];
        int[] predictNode = new int[graphMatrix.length];
        int[] distanceOfNode = new int[graphMatrix.length];
        for(int i=0;i<graphMatrix.length;i++) {
            for(int j=0;j<graphMatrix.length;j++) {
                if(graphMatrix[i][j]==0) {
                    graphMatrix[i][j]=10000;
                }
            }
        }
        for(int i=0;i<visitedNode.length;i++) {
            visitedNode[i]=0;
            predictNode[i]=0;
        }
        visitedNode[0]=1;
        distanceOfNode=graphMatrix[0];
        distanceOfNode[0]=0;
        for(int i=0;i<graphMatrix.length;i++) {
            minimumWeight=10000;
            for(int j=0;j<graphMatrix.length;j++) {
                if(minimumWeight>distanceOfNode[j] && visitedNode[j]!=1) {
                    minimumWeight=distanceOfNode[j];
                    nodeWithMinimumWeight=j;
                }
            }
            visitedNode[nodeWithMinimumWeight]=1;
            for (int j = 0; j<graphMatrix.length; j++)
            {
                if (visitedNode[j]!=1)
                {
                    if (minimumWeight+graphMatrix[nodeWithMinimumWeight][j] < distanceOfNode[j])
                    {
                        distanceOfNode[j] = minimumWeight+graphMatrix[nodeWithMinimumWeight][j];
                        predictNode[j]=nodeWithMinimumWeight;
                    }
 
                }
 
            }
        }
        return predictNode;
    }
}
