package algorithms_maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class A_star_algorithm {

    private PriorityQueue<Node> openList;  // 앞으로 방문해야할 node
    private ArrayList<Node> closedList;  // 제외시킨 node
    HashMap<Node, Integer> gMaps;  // 현재 node까지의 최단거리(비용)
    HashMap<Node, Integer> fMaps;  // g(x) + h(x)인 최단거리, 이때 h(x)는 현재 node에서 목표 node로 가는 추정 최단거리
    private int initialCapacity = 100;
    private int distanceBetweenNodes = 1;  // node간의 거리는 1

    public A_star_algorithm() {
        gMaps = new HashMap<Node, Integer>();
        fMaps = new HashMap<Node, Integer>();
        openList = new PriorityQueue<Node>(initialCapacity, new fCompare());
        closedList = new ArrayList<Node>();
    }

    public void search(Node start, Node end) {  // start부터 end까지의 최단 경로 구하기
        openList.clear();  // openlist, closedlist 초기화
        closedList.clear();

        gMaps.put(start, 0);  // 시작점 입력
        openList.add(start);  // openlist에 시작점을 넣어줌으로써 neighbor node로 가며 최단경로 탐색 시작

        while (!openList.isEmpty()) {  // 갈 수 있는 모든 node를 지나갈 때까지 = openlist가 empty가 될 때까지
            Node current = openList.element();  // 현재 node를 openlist에 넣어줌
            if (current.equals(end)) {  // 현재 node가 end node이면 search 종료
                System.out.println("Goal Reached");
                printPath(current);  // current node부터 backtracking
                return;
            }
            closedList.add(openList.poll());  // 방분한 node(arraylist의 맨 앞 node)를 openlist에서 빼주고 closedlist에 넣어준다
            ArrayList<Node> neighbors = current.getNeighbors();  // neighbor node get

            for (Node neighbor : neighbors) {
                int gScore = gMaps.get(current) + distanceBetweenNodes;  // 현재 node까지의 거리와 다음 node까지의 거리를 더해줌
                int fScore = gScore + h(neighbor, current);  // neighbor node로 갔을 때의 예상 거리를 더해줌?

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

    private int h(Node node, Node goal) {  // 휴리스틱 함수
        int x = node.getX() - goal.getX();
        int y = node.getY() - goal.getY();
        return x * x + y * y;
    }

    private void printPath(Node node) {  // backtracking
        System.out.println(node.getData());

        while (node.getParent() != null) {
            node = node.getParent();
            System.out.println(node.getData());
        }
    }

    class fCompare implements Comparator<Node> {  // 어디로 가는 게 최단경로인지 비교

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