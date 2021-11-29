package maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
package maze;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class A_star_algorithm {

    private PriorityQueue<Node> openList;  // node to visit
    private ArrayList<Node> closedList;  // excluded node
    HashMap<Node, Integer> gMaps;  // current node's least cost
    HashMap<Node, Integer> fMaps;  // least cost of g(x) + h(x), h(x): estimated shortest distance from the current node to the dest node
    private int initialCapacity = 100;
    private int distanceBetweenNodes = 1;  // distance between nodes is 1

    public A_star_algorithm() {
        gMaps = new HashMap<Node, Integer>();
        fMaps = new HashMap<Node, Integer>();
        openList = new PriorityQueue<Node>(initialCapacity, new fCompare());
        closedList = new ArrayList<Node>();
    }

    public void search(Node start, Node end, int size) {  // find the shortest path from start to end
        openList.clear();  // initialization
        closedList.clear();

        gMaps.put(start, 0);  // put start node
        openList.add(start);  // search start with start node

        while (!openList.isEmpty()) {  // until openlist is empty
            Node current = openList.element();  // put current node into openlist
            if (current.equals(end)) {  // if current node is end node, search end
                System.out.println("Goal Reached");
                printPath(current, size);  // backtracking
                return;
            }
            closedList.add(openList.poll());  // eliminate the visited node and put into closelist
            ArrayList<Node> neighbors = current.getNeighbors();  // get neighbor node

            for (Node neighbor : neighbors) {
                int gScore = gMaps.get(current) + distanceBetweenNodes;  // adds the distance to the current node and next node
                int fScore = gScore + h(neighbor, current);  // add the estimated distance when go to neighbor node

                if (closedList.contains(neighbor)) {

                    if (gMaps.get(neighbor) == null) {
                        gMaps.put(neighbor, gScore);
                    }
                    if (fMaps.get(neighbor) == null) {
                        fMaps.put(neighbor, fScore);
                    }

                    if (fScore >= fMaps.get(neighbor)) {
                        continue;
                    }
                }
                if (!openList.contains(neighbor) || fScore < fMaps.get(neighbor)) {
                    neighbor.setParent(current);
                    gMaps.put(neighbor, gScore);
                    fMaps.put(neighbor, fScore);
                    if (!openList.contains(neighbor)) {
                        openList.add(neighbor);

                    }
                }
            }
        }
        System.out.println("FAIL");
    }

    private int h(Node node, Node goal) {  // heuristic function
        int x = node.getX() - goal.getX();
        int y = node.getY() - goal.getY();
        return x * x + y * y;
    }

    private int[][] printPath(Node node, int size) {  // backtracking
    	int[][] path = new int[size][size];  // find the final path
    	
    	for(int i = 0; i < size; i++) {
    		for(int j = 0; j < size; j++) {
    			path[i][j] = 1;
    		}
    	}
    	
    	path[node.getY()][node.getX()] = 0;
        //System.out.println(node.getData());

        while (node.getParent() != null) {
            node = node.getParent();
            path[node.getY()][node.getX()] = 0;
            //System.out.println(node.getData());
        }
        
        /*
        for(int i = 0; i < size; i++) {
    		for(int j = 0; j < size; j++) {
    			System.out.print(path[i][j] + " ");
    		}
    		System.out.println();
    	}
        */
        
        return path;
    }

    class fCompare implements Comparator<Node> {  // compare the distance

        public int compare(Node o1, Node o2) {
            if (fMaps.get(o1) < fMaps.get(o2)) {
                return -1;
            } else if (fMaps.get(o1) > fMaps.get(o2)) {
                return 1;
            } else {
                return 1;
            }
        }
    }
}
