package maze;

import java.util.ArrayList;
import java.util.Arrays;

class Node {

	private Node parent;
	private ArrayList<Node> neighbors; // neighbor node
	private int x; // x 좌표
	private int y; // y 좌표
	private Object data;

	public Node() {
		neighbors = new ArrayList<Node>(); // node를 만들면서 해당 node의 neighbor node에 대한 정보를 담을 수 있도록 해줌
		data = new Object();
	}

	public Node(int x, int y) {
		this();
		this.x = x;
		this.y = y;
	}

	public Node(Node parent) {
		this();
		this.parent = parent;
	}

	public Node(Node parent, int x, int y) {
		this();
		this.parent = parent;
		this.x = x;
		this.y = y;
	}

	public ArrayList<Node> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(ArrayList<Node> neighbors) {
		this.neighbors = neighbors;
	}

	public void addNeighbor(Node node) { // 해당 node의 neighbor node들을 추가
		this.neighbors.add(node);
	}

	public void addNeighbors(Node... node) {
		this.neighbors.addAll(Arrays.asList(node));
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) { // x값 설정
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) { // y값 설정
		this.y = y;
	}

	public void setXY(int x, int y) { // 각 node의 좌표 설정
		this.x = x;
		this.y = y;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean equals(Node n) {
		return this.x == n.x && this.y == n.y;
	}
}
