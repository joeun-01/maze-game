package maze;

public class maze_5x5 {
	public int[][] maze_info() {
		Node[] n = new Node[12];
		for (int i = 0; i < n.length; i++) {
			n[i] = new Node();  // create node
			n[i].setData(i);  // assign node 1 ~ 12
		}

		/*
         * X = Walls
         * N0 => Start
         * N11 => Goal
         *
          
         X     X     X     9     X
                           |  
         0  -  1     X  -  8     X
               |           |    
         X     2  -  5  -  7     X
               |
         X     3     X     X     X
               |
         X     4  -  6  -  10 -  11 
         
         */
		
		// set node's coordinate
		n[0].setXY(0, 1);
		n[1].setXY(1, 1);
		n[2].setXY(1, 2);
		n[3].setXY(1, 3);
		n[4].setXY(1, 4);
		n[5].setXY(2, 2);
		n[6].setXY(2, 4);
		n[7].setXY(3, 2);
		n[8].setXY(3, 1);
		n[9].setXY(3, 0);
		n[10].setXY(3, 4);
		n[11].setXY(4, 4);

		int[][] coordinate = new int[5][5];  // show miro with array

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				coordinate[i][j] = 1;
			}
		}

		for (int i = 0; i < 12; i++) {
			coordinate[n[i].getY()][n[i].getX()] = 0;  // mark the way 0
		}
		
		coordinate[1][0] = 2;
		coordinate[4][4] = 3;

		// add neighbor node - to move and show path
		n[0].addNeighbors(n[1]);
		n[1].addNeighbors(n[0], n[2]);
		n[2].addNeighbors(n[1], n[3], n[5]);
		n[3].addNeighbors(n[2], n[4]);
		n[4].addNeighbors(n[3], n[6]);
		n[5].addNeighbors(n[2], n[7]);
		n[6].addNeighbors(n[4], n[10]);
		n[7].addNeighbors(n[5], n[8]);
		n[8].addNeighbors(n[7], n[9]);
		n[9].addNeighbors(n[8]);
		n[10].addNeighbors(n[6], n[11]);
		n[11].addNeighbors(n[10]);

		new A_star_algorithm().search(n[0], n[11], 5);  // find the shortest path from node 0 to 55
		
		return coordinate;
		
	}
}
