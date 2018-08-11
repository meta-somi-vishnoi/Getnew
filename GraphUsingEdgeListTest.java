package undirectedweightedgraphimplementation;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class GraphUsingEdgeListImplementationTest {

    GraphUsingEdgeListImplementation graph;

    @Before
    public void test() {
        GraphNode top = null, last;
        ArrayList<GraphNode> list = new ArrayList<GraphNode>();
        last = new GraphNode(4, 7, null);
        top = last;
        last = new GraphNode(2, 9, top);
        top = last;
        last = new GraphNode(1, 5, top);
        list.add(last);
        last = new GraphNode(3, 3, null);
        top = last;
        last = new GraphNode(2, 8, top);
        top = last;
        last = new GraphNode(0, 5, top);
        list.add(last);
        last = new GraphNode(4, 2, null);
        top = last;
        last = new GraphNode(3, 1, top);
        top = last;
        last = new GraphNode(1, 8, top);
        top = last;
        last = new GraphNode(0, 9, top);
        list.add(last);
        last = new GraphNode(5, 12, null);
        top = last;
        last = new GraphNode(4, 4, top);
        top = last;
        last = new GraphNode(2, 1, top);
        top = last;
        last = new GraphNode(1, 3, top);
        list.add(last);
        last = new GraphNode(5, 6, null);
        top = last;
        last = new GraphNode(3, 4, top);
        top = last;
        last = new GraphNode(2, 2, top);
        top = last;
        last = new GraphNode(0, 7, top);
        list.add(last);
        last = new GraphNode(4, 6, null);
        top = last;
        last = new GraphNode(3, 12, top);
        list.add(last);
        graph = new GraphUsingEdgeListImplementation(list);
    }

    @Test
    public void testIsConnectedTrue() {
        assertEquals(true, graph.isConnected());
    }

    @Test
    public void testIsConnectedFalse() {
        assertNotEquals(false, graph.isConnected());
    }

    @Test
    public void testReachableFromNode4() {
        assertEquals(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 5)), graph.reachable(4));
    }

    @Test
    public void testMinimumSpanningTree() {
        ArrayList<ArrayList<Integer>> expectedlistOfPath = new ArrayList<ArrayList<Integer>>();
        expectedlistOfPath.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
        expectedlistOfPath.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
        expectedlistOfPath.add(new ArrayList<Integer>(Arrays.asList(3, 2)));
        expectedlistOfPath.add(new ArrayList<Integer>(Arrays.asList(2, 4)));
        expectedlistOfPath.add(new ArrayList<Integer>(Arrays.asList(4, 5)));
        ArrayList<ArrayList<Integer>> listOfNodesTraversed = graph.minimumSpanningTree();
        for (int i = 0; i < listOfNodesTraversed.size(); i++) {
            assertEquals(listOfNodesTraversed.get(i), expectedlistOfPath.get(i));
        }
    }

    @Test
    public void testShortestPath() {
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
