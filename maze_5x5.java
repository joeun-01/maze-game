package maze;

public class maze_5x5 {
	public void maze_info() {
		Node[] n = new Node[13]; // 총 13개의 node
		for (int i = 0; i < n.length; i++) {
			n[i] = new Node();
			n[i].setData("n-" + i); // node 0번부터 12번까지 할당
		}

		/*
         * X = Walls
         * N0 => Start
         * N11 => Goal
         *
          
         X     X     X  -  9  -  12
                           |  
         0  -  1     X  -  8     X
               |           |    
         X     2  -  5  -  7     X
               |
         X     3     X     X     X
               |
         X     4  -  6  -  10 -  11 
         
         */
		
		// 각 node의 좌표 설정
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
		n[10].setXY(3, 2);
		n[11].setXY(4, 4);
		n[12].setXY(4, 0);

		int[][] coordinate = new int[5][5]; // 미로 배열로 나타내기

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				coordinate[i][j] = 1;
			}
		}

		for (int i = 0; i < 13; i++) {
			coordinate[n[i].getY()][n[i].getX()] = 0; // 길을 0으로 표시
		}

		for (int i = 0; i < 5; i++) { // 출력
			for (int j = 0; j < 5; j++) {
				System.out.print(coordinate[i][j] + " ");
			}
			System.out.println(" ");
		}

		// 각 node의 neighbor node에 대한 정보 입력 - 옆으로 이동하기 위함, 경로 표시
		n[0].addNeighbors(n[1]);
		n[1].addNeighbors(n[0], n[2]);
		n[2].addNeighbors(n[1], n[3], n[5]);
		n[3].addNeighbors(n[2], n[4]);
		n[4].addNeighbors(n[3], n[6]);
		n[5].addNeighbors(n[2], n[7]);
		n[6].addNeighbors(n[4], n[10]);
		n[7].addNeighbors(n[5], n[8]);
		n[8].addNeighbors(n[7], n[9]);
		n[9].addNeighbors(n[8], n[12]);
		n[10].addNeighbors(n[6], n[11]);
		n[11].addNeighbors(n[10]);
		n[12].addNeighbors(n[9]);

		new A_star_algorithm().search(n[0], n[11]); // 출발 node부터 도착 node까지의 최단 경로를 구함
	}
}
