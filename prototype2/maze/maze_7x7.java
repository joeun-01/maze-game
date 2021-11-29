package maze;

public class maze_7x7 {

	public int[][] maze_info() {
		Node[] n = new Node[26];
		for (int i = 0; i < n.length; i++) {
			n[i] = new Node();
			n[i].setData(i);  // assign node 1 ~ 26
		}
		
		/*
         * X = Walls
         * N0 => Start
         * N25 => Goal
         *
          
         X     X     X     10     X     X     X
                             
         0     X     6     X     14  - 19 -  22
         |                        |
         1     X     X     X     15    X	 X
         |                        |   
         2  -  4  -  7  -  11  - 16  - 20  - 23
         |           |            |
         3     X     8     X     17    X	 X
                                  |
         X     X     X     12  - 18 -  21 -  24
          				   |				  |			
         X     5  -  9  -  13     X    X	 25
         
         */

		// set node's coordinate
		n[0].setXY(0, 1);
		n[1].setXY(0, 2);
		n[2].setXY(0, 3);
		n[3].setXY(0, 4);
		n[4].setXY(1, 3);
		n[5].setXY(1, 6);
		n[6].setXY(2, 1);
		n[7].setXY(2, 3);
		n[8].setXY(2, 4);
		n[9].setXY(2, 6);
		n[10].setXY(3, 0);
		n[11].setXY(3, 3);
		n[12].setXY(3, 5);
		n[13].setXY(3, 6);
		n[14].setXY(4, 1);
		n[15].setXY(4, 2);
		n[16].setXY(4, 3);
		n[17].setXY(4, 4);
		n[18].setXY(4, 5);
		n[19].setXY(5, 1);
		n[20].setXY(5, 3);
		n[21].setXY(5, 5);
		n[22].setXY(6, 1);
		n[23].setXY(6, 3);
		n[24].setXY(6, 5);
		n[25].setXY(6, 6);

		int[][] coordinate = new int[7][7];  // show miro with array

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				coordinate[i][j] = 1;
			}
		}

		for (int i = 0; i < 26; i++) {
			coordinate[n[i].getY()][n[i].getX()] = 0;  // mark the way 0
		}
		
		coordinate[1][0] = 2;
		coordinate[6][6] = 3;

		// add neighbor node - to move and show path
		n[0].addNeighbors(n[1]);
		n[1].addNeighbors(n[0], n[2]);
		n[2].addNeighbors(n[1], n[3], n[4]);
		n[3].addNeighbors(n[2]);
		n[4].addNeighbors(n[2], n[7]);
		n[5].addNeighbors(n[9]);
		n[7].addNeighbors(n[4], n[8], n[11]);
		n[8].addNeighbors(n[7]);
		n[9].addNeighbors(n[5], n[13]);
		n[11].addNeighbors(n[7], n[16]);
		n[12].addNeighbors(n[13], n[18]);
		n[13].addNeighbors(n[9], n[12]);
		n[14].addNeighbors(n[15], n[19]);
		n[15].addNeighbors(n[14], n[16]);
		n[16].addNeighbors(n[11], n[15], n[17], n[20]);
		n[17].addNeighbors(n[16], n[18]);
		n[18].addNeighbors(n[12], n[17], n[21]);
		n[19].addNeighbors(n[14], n[22]);
		n[20].addNeighbors(n[16], n[23]);
		n[21].addNeighbors(n[18], n[24]);
		n[22].addNeighbors(n[19]);
		n[23].addNeighbors(n[20]);
		n[24].addNeighbors(n[21], n[25]);
		n[25].addNeighbors(n[24]);

		new A_star_algorithm().search(n[0], n[25], 7);  // find the shortest path from node 0 to 55
		
		return coordinate;
	}

}
