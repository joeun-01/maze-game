package maze;

public class maze_10x10 {
	public int[][] maze_info() {
		Node[] n = new Node[56];
		for (int i = 0; i < n.length; i++) {
			n[i] = new Node();
			n[i].setData(i);  // 1번부터 56번까지 할당
		}

		/*
		 * X = Walls N0 => Start N55 => Goal
		 * 
		 * 0 X 11 - 20 - 23 - 31 - 33 X X X | | | | 1 X 12 X 24 X 34 X 45 - 53 | | | | |
		 * 2 - 9 - 13 X 25 X 35 X 46 X | | | X X X X 26 X 36 X 47 X | | | 3 - 10 - 14 -
		 * 21 - 27 X 37 - 42 - 48 - 54 | | | 4 X 15 X X X 38 X X X | | | 5 X 16 X 28 -
		 * 32 - 39 - 43 - 49 X | | | | 6 X 17 X 29 X X X 50 X | | | 7 X 18 X X X 40 X 51
		 * X | | | | 8 - X 19 - 22 - 30 X 41 - 44 - 52 - 55
		 * 
		 */

		// 각 node의 좌표 설정
		n[0].setXY(0, 0);
		n[1].setXY(0, 1);
		n[2].setXY(0, 2);
		n[3].setXY(0, 4);
		n[4].setXY(0, 5);
		n[5].setXY(0, 6);
		n[6].setXY(0, 7);
		n[7].setXY(0, 8);
		n[8].setXY(0, 9);

		n[9].setXY(1, 2);
		n[10].setXY(1, 4);

		n[11].setXY(2, 0);
		n[12].setXY(2, 1);
		n[13].setXY(2, 2);
		n[14].setXY(2, 4);
		n[15].setXY(2, 5);
		n[16].setXY(2, 6);
		n[17].setXY(2, 7);
		n[18].setXY(2, 8);
		n[19].setXY(2, 9);

		n[20].setXY(3, 0);
		n[21].setXY(3, 4);
		n[22].setXY(3, 9);

		n[23].setXY(4, 0);
		n[24].setXY(4, 1);
		n[25].setXY(4, 2);
		n[26].setXY(4, 3);
		n[27].setXY(4, 4);
		n[28].setXY(4, 6);
		n[29].setXY(4, 7);
		n[30].setXY(4, 9);

		n[31].setXY(5, 0);
		n[32].setXY(5, 6);

		n[33].setXY(6, 0);
		n[34].setXY(6, 1);
		n[35].setXY(6, 2);
		n[36].setXY(6, 3);
		n[37].setXY(6, 4);
		n[38].setXY(6, 5);
		n[39].setXY(6, 6);
		n[40].setXY(6, 8);
		n[41].setXY(6, 9);

		n[42].setXY(7, 4);
		n[43].setXY(7, 6);
		n[44].setXY(7, 9);

		n[45].setXY(8, 1);
		n[46].setXY(8, 2);
		n[47].setXY(8, 3);
		n[48].setXY(8, 4);
		n[49].setXY(8, 6);
		n[50].setXY(8, 7);
		n[51].setXY(8, 8);
		n[52].setXY(8, 9);

		n[53].setXY(9, 1);
		n[54].setXY(9, 4);
		n[55].setXY(9, 9);

		int[][] coordinate = new int[10][10]; // 미로 배열로 나타내기

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				coordinate[i][j] = 1;
			}
		}

		for (int i = 0; i < 56; i++) {
			coordinate[n[i].getY()][n[i].getX()] = 0; // 길을 0으로 표시
		}

		coordinate[0][0] = 2;
		coordinate[9][9] = 3;
		
		/*
		for (int i = 0; i < 10; i++) { // 출력
			for (int j = 0; j < 10; j++) {
				System.out.print(coordinate[i][j] + " ");
			}
			System.out.println(" ");
		}
		*/

		// 각 node의 neighbor node에 대한 정보 입력 - 옆으로 이동하기 위함, 경로 표시
		n[0].addNeighbors(n[1]);
		n[1].addNeighbors(n[0], n[2]);
		n[2].addNeighbors(n[1], n[9]);
		n[3].addNeighbors(n[4], n[10]);
		n[4].addNeighbors(n[3], n[5]);
		n[5].addNeighbors(n[4], n[6]);
		n[6].addNeighbors(n[5], n[7]);
		n[7].addNeighbors(n[6], n[8]);
		n[8].addNeighbors(n[7]);
		n[9].addNeighbors(n[2], n[13]);
		n[10].addNeighbors(n[3], n[14]);
		n[11].addNeighbors(n[12], n[20]);
		n[12].addNeighbors(n[11], n[13]);
		n[13].addNeighbors(n[9], n[12]);
		n[14].addNeighbors(n[10], n[15], n[21]);
		n[15].addNeighbors(n[14], n[16]);
		n[16].addNeighbors(n[15], n[17]);
		n[17].addNeighbors(n[16], n[18]);
		n[18].addNeighbors(n[17], n[19]);
		n[19].addNeighbors(n[18], n[22]);
		n[20].addNeighbors(n[11], n[23]);
		n[21].addNeighbors(n[14], n[27]);
		n[22].addNeighbors(n[19], n[30]);
		n[23].addNeighbors(n[20], n[24], n[31]);
		n[24].addNeighbors(n[23], n[25]);
		n[25].addNeighbors(n[24], n[26]);
		n[26].addNeighbors(n[25], n[27]);
		n[27].addNeighbors(n[21], n[26]);
		n[28].addNeighbors(n[29], n[32]);
		n[29].addNeighbors(n[28]);
		n[30].addNeighbors(n[22]);
		n[31].addNeighbors(n[23], n[33]);
		n[32].addNeighbors(n[28], n[39]);
		n[33].addNeighbors(n[31], n[34]);
		n[34].addNeighbors(n[33], n[35]);
		n[35].addNeighbors(n[34], n[36]);
		n[36].addNeighbors(n[35], n[37]);
		n[37].addNeighbors(n[36], n[38], n[42]);
		n[38].addNeighbors(n[37], n[39]);
		n[39].addNeighbors(n[32], n[38], n[43]);
		n[40].addNeighbors(n[41]);
		n[41].addNeighbors(n[40], n[44]);
		n[42].addNeighbors(n[37], n[48]);
		n[43].addNeighbors(n[39], n[49]);
		n[44].addNeighbors(n[41], n[52]);
		n[45].addNeighbors(n[46], n[53]);
		n[46].addNeighbors(n[45], n[47]);
		n[47].addNeighbors(n[46], n[48]);
		n[48].addNeighbors(n[42], n[47], n[54]);
		n[49].addNeighbors(n[43], n[50]);
		n[50].addNeighbors(n[49], n[51]);
		n[51].addNeighbors(n[50], n[52]);
		n[52].addNeighbors(n[44], n[51], n[55]);
		n[53].addNeighbors(n[45]);
		n[54].addNeighbors(n[48]);
		n[55].addNeighbors(n[52]);

		new A_star_algorithm().search(n[0], n[55], 10); // 출발 node부터 도착 node까지의 최단 경로를 구함
		
		return coordinate;

	}
}
