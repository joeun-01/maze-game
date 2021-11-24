package algorithms_maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class A_star_algorithm {

    private PriorityQueue<Node> openList;  // ������ �湮�ؾ��� node
    private ArrayList<Node> closedList;  // ���ܽ�Ų node
    HashMap<Node, Integer> gMaps;  // ���� node������ �ִܰŸ�(���)
    HashMap<Node, Integer> fMaps;  // g(x) + h(x)�� �ִܰŸ�, �̶� h(x)�� ���� node���� ��ǥ node�� ���� ���� �ִܰŸ�
    private int initialCapacity = 100;
    private int distanceBetweenNodes = 1;  // node���� �Ÿ��� 1

    public A_star_algorithm() {
        gMaps = new HashMap<Node, Integer>();
        fMaps = new HashMap<Node, Integer>();
        openList = new PriorityQueue<Node>(initialCapacity, new fCompare());
        closedList = new ArrayList<Node>();
    }

    public void search(Node start, Node end) {  // start���� end������ �ִ� ��� ���ϱ�
        openList.clear();  // openlist, closedlist �ʱ�ȭ
        closedList.clear();

        gMaps.put(start, 0);  // ������ �Է�
        openList.add(start);  // openlist�� �������� �־������ν� neighbor node�� ���� �ִܰ�� Ž�� ����

        while (!openList.isEmpty()) {  // �� �� �ִ� ��� node�� ������ ������ = openlist�� empty�� �� ������
            Node current = openList.element();  // ���� node�� openlist�� �־���
            if (current.equals(end)) {  // ���� node�� end node�̸� search ����
                System.out.println("Goal Reached");
                printPath(current);  // current node���� backtracking
                return;
            }
            closedList.add(openList.poll());  // ����� node(arraylist�� �� �� node)�� openlist���� ���ְ� closedlist�� �־��ش�
            ArrayList<Node> neighbors = current.getNeighbors();  // neighbor node get

            for (Node neighbor : neighbors) {
                int gScore = gMaps.get(current) + distanceBetweenNodes;  // ���� node������ �Ÿ��� ���� node������ �Ÿ��� ������
                int fScore = gScore + h(neighbor, current);  // neighbor node�� ���� ���� ���� �Ÿ��� ������?

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

    private int h(Node node, Node goal) {  // �޸���ƽ �Լ�
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

    class fCompare implements Comparator<Node> {  // ���� ���� �� �ִܰ������ ��

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