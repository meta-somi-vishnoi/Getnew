package undirectedweightedgraphimplementation;

import java.util.ArrayList;

/**
 *
 * @author vishn_000
 */
interface Graph {

    public boolean isConnected();

    public ArrayList<Integer> reachable(int node);

    public ArrayList<ArrayList<Integer>> minimumSpanningTree();

    public ArrayList<ArrayList<Integer>> shortestPath(int startNode, int endNode);
}
