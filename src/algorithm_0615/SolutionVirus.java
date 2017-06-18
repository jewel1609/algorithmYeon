package algorithm_0615;

import java.io.FileInputStream;
import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class SolutionVirus {
	static int Answer;

	private static int map[][];
	private static int visit[][];
	private static int n; // 세로
	private static int m; // 가로
	private static int maxSurvive = 0;

	public static void main(String args[]) throws Exception {
		/*
		 * The method below means that the program will read from input.txt,
		 * instead of standard(keyboard) input. To test your program, you may
		 * save input data in input.txt file, and call below method to read from
		 * the file when using nextInt() method. You may remove the comment
		 * symbols(//) in the below statement and use it. But before submission,
		 * you must remove the freopen function or rewrite comment symbols(//).
		 */

		/*
		 * Make new scanner from standard input System.in, and read data.
		 */
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {

			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			 * Implement your algorithm here. The answer to the case will be
			 * stored in variable Answer.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
			// Answer = 0;

			// 2차원 배열의 지도가 주어진다.

			n = sc.nextInt();
			m = sc.nextInt();


			map = new int[n][m];
			visit = new int[n][m];
			int countZero = 0;
			// map make
			for (int i = 0; i < n; i++) {

				for (int j = 0; j < m; j++) {

					map[i][j] = sc.nextInt();
					visit[i][j] = map[i][j];
					if ( map[i][j] == 0) {
						countZero++;
					}

				}

			}
			
			combination( visit, 0, countZero, 3, 0 );
			
			
			
			

			
			// Print the answer to standard output(screen).
			System.out.println("Case #" + (test_case + 1));
			System.out.println(maxSurvive);
		}
	}


	private static void combination(int[][] visit, int index, int n, int r, int target) {
		// TODO Auto-generated method stub
		
		//벽을 다세웠을 때 
		if ( r == 0 ) {
			//바이러스 퍼뜨리기 
			playVirus();
			if ( maxSurvive < countZero() ) {
				maxSurvive = countZero();
			}
			//visit 초기화 
			resetVisit();
		}
		else if ( target == n ) return;
		else {
			
			
			
			
			
		}
		
		
		
	}


	private static void resetVisit() {
		// TODO Auto-generated method stub
		for ( int i = 0; i < n; i ++ ) {
			for ( int j = 0; j < m; j ++ ) {
				visit[i][j] = map[i][j];
			}
		}
	}


	private static int countZero() {
		// TODO Auto-generated method stub
		int countSurvive = 0;
		for ( int i = 0; i < n; i ++ ) {
			for ( int j = 0; j < m; j ++ ) {
				if ( map[i][j] == 0 ) {
					countSurvive++;
				}
			}
		}
		return countSurvive;
	}


	private static void playVirus() {
		// TODO Auto-generated method stub
		for ( int i = 0; i < n; i ++ ) {
			for ( int j = 0; j < m; j ++ ) {
				virusDFS(i, j);
			}
		}
	}


	private static void virusDFS(int i, int j) {
		// TODO Auto-generated method stub

		// possible move Up
		if (i - 1 >= 0 && visit[i - 1][j] == 0) {
			visit[i - 1][j] = 2;
			virusDFS(i - 1, j);
		}

		// possible move Down
		if (i + 1 < n && visit[i + 1][j] == 0) {
			visit[i + 1][j] = 2;
			virusDFS(i + 1, j);
		}

		// possible move Left
		if (j - 1 >= 0 && visit[i][j - 1] == 0) {
			visit[i][j - 1] = 2;
			virusDFS(i, j - 1);
		}

		// possible move Right
		if (j + 1 < m && visit[i][j + 1] == 0) {
			visit[i][j + 1] = 2;
			virusDFS(i, j + 1);
		}

	}
}