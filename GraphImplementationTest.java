package graphoperations;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class GraphImplementationTest {

    GraphImplementation graph;

    @Test
    public void testIsConnected() {
        graph = new GraphImplementation(new int[][]{{0, 5, 9, 0, 7, 0}, {5, 0, 8, 3, 0, 0}, {9, 8, 0, 1, 2, 0},
            {0, 3, 1, 0, 4, 12}, {7, 0, 2, 4, 0, 6}, {0, 0, 0, 12, 6, 0}});
        assertEquals(true, graph.isConnected());
    }

    @Test
    public void testIsConnectedTrue() {
        graph = new GraphImplementation(new int[][]{{0, 5, 9, 0, 7, 0}, {5, 0, 8, 3, 0, 0}, {0, 8, 0, 0, 2, 0}, 
            {0, 3, 1, 0, 4, 12}, {7, 0, 2, 4, 0, 6}, {0, 0, 0, 12, 6, 0}});
        assertEquals(true, graph.isConnected());
    }

    @Test
    public void testIsConnectedFalse() {
        graph = new GraphImplementation(new int[][]{{0, 0, 9, 0, 7, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 2, 0}, 
            {0, 0, 1, 0, 4, 12}, {7, 0, 2, 4, 0, 6}, {0, 0, 0, 12, 6, 0}});
        assertEquals(false, graph.isConnected());
    }

    @Test
    public void testReachableFromNode4() {
        graph = new GraphImplementation(new int[][]{{0, 5, 9, 0, 7, 0}, {5, 0, 8, 3, 0, 0}, {9, 8, 0, 1, 2, 0}, 
            {0, 3, 1, 0, 4, 12}, {7, 0, 2, 4, 0, 6}, {0, 0, 0, 12, 6, 0}});
        assertEquals(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 5)), graph.reachable(4));
    }

    @Test
    public void testReachableFromNode0() {
        graph = new GraphImplementation(new int[][]{{0, 0, 9, 0, 7, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 2, 0}, 
            {0, 0, 1, 0, 4, 12}, {7, 0, 2, 4, 0, 6}, {0, 0, 0, 12, 6, 0}});
        assertEquals(new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5)), graph.reachable(0));
    }

    @Test
    public void testMinimumSpanningTreeWithreturningPath() {
        graph = new GraphImplementation(new int[][]{{0, 5, 9, 0, 7, 0}, {5, 0, 8, 3, 0, 0}, {9, 8, 0, 1, 2, 0}, 
            {0, 3, 1, 0, 4, 12}, {7, 0, 2, 4, 0, 6}, {0, 0, 0, 12, 6, 0}});
        ArrayList<ArrayList<Integer>> expectedlistOfPath = new ArrayList<ArrayList<Integer>>();
        expectedlistOfPath.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
        expectedlistOfPath.add(new ArrayList<Integer>(Arrays.asList(2, 4)));
        expectedlistOfPath.add(new ArrayList<Integer>(Arrays.asList(3, 1)));
        expectedlistOfPath.add(new ArrayList<Integer>(Arrays.asList(1, 0)));
        expectedlistOfPath.add(new ArrayList<Integer>(Arrays.asList(4, 5)));
        ArrayList<ArrayList<Integer>> listOfNodesTraversed = graph.minimumSpanningTree();
        for (int i = 0; i < listOfNodesTraversed.size(); i++) {
            assertEquals(listOfNodesTraversed.get(i), expectedlistOfPath.get(i));
        }
    }

    @Test
    public void testShortestPathReturningShortestPath() {
        graph = new GraphImplementation(new int[][]{{0, 5, 9, 0, 7, 0}, {5, 0, 8, 3, 0, 0}, {9, 8, 0, 1, 2, 0}, 
            {0, 3, 1, 0, 4, 12}, {7, 0, 2, 4, 0, 6}, {0, 0, 0, 12, 6, 0}});
        ArrayList<ArrayList<Integer>> expectedlistOfPath = new ArrayList<ArrayList<Integer>>();
        expectedlistOfPath.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
        expectedlistOfPath.add(new ArrayList<Integer>(Arrays.asList(0, 4)));
        expectedlistOfPath.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
        expectedlistOfPath.add(new ArrayList<Integer>(Arrays.asList(0, 2)));
        expectedlistOfPath.add(new ArrayList<Integer>(Arrays.asList(4, 5)));
        ArrayList<ArrayList<Integer>> listOfNodesTraversed = graph.shortestPath(0, 5);
        for (int i = 0; i < listOfNodesTraversed.size(); i++) {
            assertEquals(listOfNodesTraversed.get(i), expectedlistOfPath.get(i));
        }
    }
}
